package com.yehuizhang.rest.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Ava", new Date()));
        users.add(new User(++usersCount, "Britney", new Date()));
        users.add(new User(++usersCount, "Chloe", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    private User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }
}
