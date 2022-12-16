package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        User user =  users.stream().filter(e -> e.getId() == id).findFirst().get();
        if (user == null){
            throw new UserNotFoundException("id: " + id);
        }
        return user;
    }

    public User saveUser(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}
