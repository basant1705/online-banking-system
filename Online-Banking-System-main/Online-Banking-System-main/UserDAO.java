package com.bank.dao;

import com.bank.model.User;

public class UserDAO {
    public void saveUser(User user) {
        // Simulating database interaction.
        System.out.println("User saved: " + user.getName());
    }
}
