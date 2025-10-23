#!/bin/bash
#
# 规则文件引用验证脚本
# 验证所有规则文件的引用是否符合分层原则
#
# 使用方法:
#   ./validate-refs.sh              # 验证所有文件
#   ./validate-refs.sh <file.mdc>   # 验证特定文件
#

set -euo pipefail

RULES_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$RULES_DIR"

# 颜色定义
GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo "== 规则文件引用验证 =="
echo "===================="
echo

# 提取 frontmatter 字段的函数
get_frontmatter_field() {
    local file=$1
    local field=$2
    sed -n '/^---$/,/^---$/p' "$file" | grep "^${field}:" | sed "s/^${field}: *//" || true
}

# 检查单个文件
check_file() {
    local file=$1
    local relpath="${file#./}"
    
    # 提取元数据
    local layer=$(get_frontmatter_field "$file" "layer")
    local allowed=$(get_frontmatter_field "$file" "allowedReferences")
    
    # 检查是否有必要字段
    if [ -z "$layer" ]; then
        echo -e "${RED}[错误] 缺少 layer 字段: $relpath${NC}"
        echo "FAILED"
        return
    fi
    
    if [ -z "$allowed" ]; then
        echo -e "${RED}[错误] 缺少 allowedReferences 字段: $relpath${NC}"
        echo "FAILED"
        return
    fi
    
    # 提取文件中的所有引用
    local refs=$(grep -o '[0-9][0-9]-[a-z-]*/[a-z-]*\.mdc' "$file" 2>/dev/null | sort -u || true)
    
    if [ -z "$refs" ]; then
        echo -e "${GREEN}[通过] $relpath${NC} (无引用)"
        echo "PASSED"
        return
    fi
    
    # 检查每个引用
    local has_violation=0
    local violations=""
    local violation_count=0
    
    while IFS= read -r ref; do
        # 提取引用的层级
        local ref_layer=""
        if [[ $ref == 00-* ]]; then
            ref_layer="L0"
        elif [[ $ref == 01-* ]]; then
            ref_layer="L1"
        elif [[ $ref == 02-* ]]; then
            ref_layer="L2"
        elif [[ $ref == 03-* ]]; then
            ref_layer="L3"
        elif [[ $ref == 04-* ]]; then
            ref_layer="L4"
        fi
        
        # 检查是否在允许范围内
        if [[ ! "$allowed" =~ $ref_layer ]]; then
            has_violation=1
            ((violation_count++))
            violations+="   → 引用了 $ref (层级:$ref_layer，不在允许范围内)\n"
        fi
    done <<< "$refs"
    
    if [ $has_violation -eq 1 ]; then
        echo -e "${RED}[违规] $relpath${NC}"
        echo -e "   当前层级: $layer"
        echo -e "   允许引用: $allowed"
        echo -e "$violations"
        echo "FAILED:$violation_count"
    else
        echo -e "${GREEN}[通过] $relpath${NC}"
        echo "PASSED"
    fi
}

# 主逻辑
total_files=0
passed_files=0
failed_files=0
total_violations=0

if [ $# -eq 0 ]; then
    # 验证所有文件
    files=($(find . -name "*.mdc" -type f | sort))
    
    for file in "${files[@]}"; do
        ((total_files++))
        output=$(check_file "$file")
        result=$(echo "$output" | tail -1)
        
        # 只在有违规或错误时显示详细输出
        if [[ $result == FAILED* ]]; then
            echo "$output" | grep -v "^FAILED"
            ((failed_files++))
            if [[ $result == FAILED:* ]]; then
                count="${result#FAILED:}"
                ((total_violations+=count))
            fi
        elif [[ $result == "PASSED" ]]; then
            ((passed_files++))
        fi
    done
else
    # 验证指定文件
    if [ ! -f "$1" ]; then
        echo -e "${RED}错误: 文件不存在: $1${NC}"
        exit 1
    fi
    
    ((total_files++))
    output=$(check_file "$1")
    result=$(echo "$output" | tail -1)
    
    # 显示完整输出
    echo "$output" | grep -v "^FAILED\|^PASSED"
    
    if [[ $result == "PASSED" ]]; then
        ((passed_files++))
    elif [[ $result == FAILED* ]]; then
        ((failed_files++))
        if [[ $result == FAILED:* ]]; then
            count="${result#FAILED:}"
            ((total_violations+=count))
        fi
    fi
fi

# 输出总结
echo
echo "===================="
echo "== 验证总结 =="
echo "===================="
echo -e "总文件数: ${total_files}"
echo -e "${GREEN}通过: ${passed_files}${NC}"
if [ $failed_files -gt 0 ]; then
    echo -e "${RED}失败: ${failed_files}${NC}"
    echo -e "${RED}违规引用数: ${total_violations}${NC}"
else
    echo -e "失败: 0"
fi
echo

if [ $failed_files -gt 0 ]; then
    echo -e "${YELLOW}[警告] 发现违规引用，请修复后再提交！${NC}"
    exit 1
else
    echo -e "${GREEN}[成功] 所有文件验证通过！${NC}"
    exit 0
fi
