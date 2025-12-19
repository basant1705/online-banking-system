package com.bank.dao;

import com.bank.model.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserDAOTest {
    private UserDAO userDAO;

    @Before
    public void setUp() {
        userDAO = new UserDAO();
    }

    @Test
    public void testSaveUser() {
        User user = new User("Alice", "alice@example.com", "securepassword");
        userDAO.saveUser(user);

        User fetchedUser = userDAO.findUserByEmail("alice@example.com");
        assertNotNull(fetchedUser);
        assertEquals("Alice", fetchedUser.getName());
        assertEquals("alice@example.com", fetchedUser.getEmail());
    }

    @Test
    public void testFindUserByEmailNotFound() {
        User user = userDAO.findUserByEmail("nonexistent@example.com");
        assertNull(user);
    }
}
