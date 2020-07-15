package com.gogabot.graphql.db;

import com.gogabot.graphql.model.User;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDB {
    List<User> users = Lists.newArrayList(
            new User(1, "Jack", "Smith", 25),
            new User(2, "Sophie", "Miller", 23),
            new User(3, "Thomas", "Johnson", 29),
            new User(4, "Joshua", "Brown", 18),
            new User(5, "Jessica", "Williams", 20),
            new User(6, "Emily", "Williams", 24),
            new User(7, "Jacob", "Evans", 27),
            new User(8, "Daniel", "Jones", 22),
            new User(9, "Ethan", "Davies", 25),
            new User(10, "Emily", "Taylor", 22)
    );

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserById(int id) {
        return users.stream()
                .filter(user -> user.id == id)
                .findFirst();
    }

    public List<User> getUsersYoungerThan(int age) {
        return users.stream()
                .filter(user -> user.age < age)
                .collect(Collectors.toList());
    }

    public User deleteUser(int id) {
        User user = users.get(id);
        users.remove(id);
        return user;
    }


}
