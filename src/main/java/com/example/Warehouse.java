package com.example;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Warehouse {

    private static Warehouse instance;
    private final Set<User> users = ConcurrentHashMap.newKeySet();

    private Warehouse() {}

    public static synchronized Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Set<User> getUsers() {
        return users;
    }
}
