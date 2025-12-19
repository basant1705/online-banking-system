package com.bank.service;

import com.bank.dao.UserDAO;
import com.bank.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserDAO mockUserDAO;
    private UserService userService;

    @Before
    public void setUp() {
        mockUserDAO = mock(UserDAO.class);
        userService = new UserService(mockUserDAO);
    }

    @Test
    public void testRegisterUser() {
        User user = new User("Bob", "bob@example.com", "password123");

        doNothing().when(mockUserDAO).saveUser(user);
        userService.registerUser(user);

        verify(mockUserDAO, times(1)).saveUser(user);
    }

    @Test
    public void testGetUserByEmail() {
        User user = new User("Charlie", "charlie@example.com", "password456");

        when(mockUserDAO.findUserByEmail("charlie@example.com")).thenReturn(user);
        User fetchedUser = userService.getUserByEmail("charlie@example.com");

        assertNotNull(fetchedUser);
        assertEquals("Charlie", fetchedUser.getName());
        assertEquals("charlie@example.com", fetchedUser.getEmail());
    }
}
