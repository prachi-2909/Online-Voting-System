package com.voting.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.voting.utils.DatabaseUtil;
import com.voting.models.User;

public class UserServiceTest {
    @Test
    public void testAddUser() {
        User user = new User("testUser", "password");
        DatabaseUtil.addUser(user);
        assertNotNull(DatabaseUtil.getUser("testUser"));
    }
}
