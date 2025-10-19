package com.example.user.dao.mapper;

import com.example.user.dao.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户数据访问层
 * 
 * @author 开发者姓名
 * @since 1.0.0
 */
@Mapper
public interface UserMapper {

    /**
     * 插入用户
     * 
     * @param user 用户信息
     * @return 影响行数
     */
    @Insert("INSERT INTO t_user (username, password, email, phone, status, " +
            "create_time, update_time, create_by, update_by, deleted, version) " +
            "VALUES (#{username}, #{password}, #{email}, #{phone}, #{status}, " +
            "#{createTime}, #{updateTime}, #{createBy}, #{updateBy}, #{deleted}, #{version})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserEntity user);

    /**
     * 根据ID删除用户（逻辑删除）
     * 
     * @param id 用户ID
     * @return 影响行数
     */
    @Update("UPDATE t_user SET deleted = 1, update_time = NOW() WHERE id = #{id} AND deleted = 0")
    int deleteById(@Param("id") Long id);

    /**
     * 更新用户信息
     * 
     * @param user 用户信息
     * @return 影响行数
     */
    @Update("UPDATE t_user SET username = #{username}, password = #{password}, " +
            "email = #{email}, phone = #{phone}, status = #{status}, " +
            "update_time = #{updateTime}, update_by = #{updateBy}, version = version + 1 " +
            "WHERE id = #{id} AND deleted = 0 AND version = #{version}")
    int updateById(UserEntity user);

    /**
     * 根据ID查询用户
     * 
     * @param id 用户ID
     * @return 用户信息
     */
    @Select("SELECT id, username, password, email, phone, status, " +
            "create_time, update_time, create_by, update_by, deleted, version " +
            "FROM t_user WHERE id = #{id} AND deleted = 0")
    @Results({
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "updateTime", column = "update_time"),
        @Result(property = "createBy", column = "create_by"),
        @Result(property = "updateBy", column = "update_by")
    })
    UserEntity selectById(@Param("id") Long id);

    /**
     * 查询所有用户
     * 
     * @return 用户列表
     */
    @Select("SELECT id, username, password, email, phone, status, " +
            "create_time, update_time, create_by, update_by, deleted, version " +
            "FROM t_user WHERE deleted = 0 ORDER BY create_time DESC")
    @Results({
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "updateTime", column = "update_time"),
        @Result(property = "createBy", column = "create_by"),
        @Result(property = "updateBy", column = "update_by")
    })
    List<UserEntity> selectAll();

    /**
     * 根据用户名查询用户
     * 
     * @param username 用户名
     * @return 用户信息
     */
    @Select("SELECT id, username, password, email, phone, status, " +
            "create_time, update_time, create_by, update_by, deleted, version " +
            "FROM t_user WHERE username = #{username} AND deleted = 0")
    @Results({
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "updateTime", column = "update_time"),
        @Result(property = "createBy", column = "create_by"),
        @Result(property = "updateBy", column = "update_by")
    })
    UserEntity selectByUsername(@Param("username") String username);

    /**
     * 根据邮箱查询用户
     * 
     * @param email 邮箱
     * @return 用户信息
     */
    @Select("SELECT id, username, password, email, phone, status, " +
            "create_time, update_time, create_by, update_by, deleted, version " +
            "FROM t_user WHERE email = #{email} AND deleted = 0")
    @Results({
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "updateTime", column = "update_time"),
        @Result(property = "createBy", column = "create_by"),
        @Result(property = "updateBy", column = "update_by")
    })
    UserEntity selectByEmail(@Param("email") String email);

    /**
     * 根据状态查询用户列表
     * 
     * @param status 状态
     * @return 用户列表
     */
    @Select("SELECT id, username, password, email, phone, status, " +
            "create_time, update_time, create_by, update_by, deleted, version " +
            "FROM t_user WHERE status = #{status} AND deleted = 0 ORDER BY create_time DESC")
    @Results({
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "updateTime", column = "update_time"),
        @Result(property = "createBy", column = "create_by"),
        @Result(property = "updateBy", column = "update_by")
    })
    List<UserEntity> selectByStatus(@Param("status") Integer status);

    /**
     * 批量查询用户
     * 
     * @param ids 用户ID列表
     * @return 用户列表
     */
    @Select("<script>" +
            "SELECT id, username, password, email, phone, status, " +
            "create_time, update_time, create_by, update_by, deleted, version " +
            "FROM t_user WHERE id IN " +
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            " AND deleted = 0 ORDER BY create_time DESC" +
            "</script>")
    @Results({
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "updateTime", column = "update_time"),
        @Result(property = "createBy", column = "create_by"),
        @Result(property = "updateBy", column = "update_by")
    })
    List<UserEntity> selectByIds(@Param("ids") List<Long> ids);

    /**
     * 分页查询用户
     * 
     * @param offset 偏移量
     * @param limit 限制数量
     * @return 用户列表
     */
    @Select("SELECT id, username, password, email, phone, status, " +
            "create_time, update_time, create_by, update_by, deleted, version " +
            "FROM t_user WHERE deleted = 0 ORDER BY create_time DESC LIMIT #{offset}, #{limit}")
    @Results({
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "updateTime", column = "update_time"),
        @Result(property = "createBy", column = "create_by"),
        @Result(property = "updateBy", column = "update_by")
    })
    List<UserEntity> selectByPage(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 统计用户总数
     * 
     * @return 用户总数
     */
    @Select("SELECT COUNT(*) FROM t_user WHERE deleted = 0")
    long countAll();
}
