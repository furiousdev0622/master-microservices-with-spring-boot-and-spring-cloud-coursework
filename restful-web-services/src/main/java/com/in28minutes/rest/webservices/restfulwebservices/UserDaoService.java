package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
    }

    public static List<User> getUsers() {
        return users;
    }

    public User getUser(int id) {
        Optional<User> user =  users.stream().filter(e -> e.getId() == id).findFirst();
        return user.isPresent() ? user.get() : null;
    }

    public void deleteById(int id) {
        users.removeIf(e -> e.getId() == id);
    }

    public User saveUser(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
