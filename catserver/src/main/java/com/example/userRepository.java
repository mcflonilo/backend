package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class userRepository {
    private static Map<String,String> users = Map.of("jason","pass");

    public userRepository() {
        users.put("jason", "pass");
        users.put("bob", "pass");
    }


    public static Map<String, String> getUsers() {
        return users;
    }
}
