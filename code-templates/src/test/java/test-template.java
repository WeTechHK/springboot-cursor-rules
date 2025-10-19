package com.example.user.service;

import com.example.user.dao.entity.UserEntity;
import com.example.user.dao.mapper.UserMapper;
import com.example.user.service.impl.UserServiceImpl;
import com.example.user.vo.request.CreateUserRequest;
import com.example.user.vo.response.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * 用户服务测试类
 * 
 * @author 开发者姓名
 * @since 1.0.0
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    private UserEntity testUser;
    private CreateUserRequest createRequest;

    @BeforeEach
    void setUp() {
        // 初始化测试数据
        testUser = new UserEntity()
                .setId(1L)
                .setUsername("testuser")
                .setEmail("test@example.com")
                .setPhone("13800138000")
                .setStatus(1)
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now())
                .setCreateBy("system")
                .setUpdateBy("system")
                .setDeleted(0)
                .setVersion(1);

        createRequest = new CreateUserRequest()
                .setUsername("newuser")
                .setEmail("new@example.com")
                .setPhone("13900139000")
                .setPassword("password123")
                .setStatus(1);
    }

    @Test
    void testCreateUser_Success() {
        // Given
        when(userMapper.insert(any(UserEntity.class))).thenReturn(1);

        // When
        UserResponse result = userService.createUser(createRequest);

        // Then
        assertNotNull(result);
        assertEquals(createRequest.getUsername(), result.getUsername());
        assertEquals(createRequest.getEmail(), result.getEmail());
        verify(userMapper, times(1)).insert(any(UserEntity.class));
    }

    @Test
    void testGetUserById_Success() {
        // Given
        when(userMapper.selectById(1L)).thenReturn(testUser);

        // When
        UserResponse result = userService.getUserById(1L);

        // Then
        assertNotNull(result);
        assertEquals(testUser.getId(), result.getId());
        assertEquals(testUser.getUsername(), result.getUsername());
        verify(userMapper, times(1)).selectById(1L);
    }

    @Test
    void testGetUserById_NotFound() {
        // Given
        when(userMapper.selectById(anyLong())).thenReturn(null);

        // When & Then
        assertThrows(RuntimeException.class, () -> userService.getUserById(999L));
        verify(userMapper, times(1)).selectById(999L);
    }

    @Test
    void testGetAllUsers_Success() {
        // Given
        List<UserEntity> userList = Arrays.asList(testUser);
        when(userMapper.selectList(any())).thenReturn(userList);

        // When
        List<UserResponse> result = userService.getAllUsers();

        // Then
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(testUser.getUsername(), result.get(0).getUsername());
        verify(userMapper, times(1)).selectList(any());
    }

    @Test
    void testUpdateUser_Success() {
        // Given
        when(userMapper.selectById(1L)).thenReturn(testUser);
        when(userMapper.updateById(any(UserEntity.class))).thenReturn(1);

        // When
        UserResponse result = userService.updateUser(1L, createRequest);

        // Then
        assertNotNull(result);
        verify(userMapper, times(1)).selectById(1L);
        verify(userMapper, times(1)).updateById(any(UserEntity.class));
    }

    @Test
    void testDeleteUser_Success() {
        // Given
        when(userMapper.selectById(1L)).thenReturn(testUser);
        when(userMapper.deleteById(1L)).thenReturn(1);

        // When
        boolean result = userService.deleteUser(1L);

        // Then
        assertTrue(result);
        verify(userMapper, times(1)).selectById(1L);
        verify(userMapper, times(1)).deleteById(1L);
    }
}
