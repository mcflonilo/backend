package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Collectors;

public class LoginServlet extends HttpServlet {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<!DOCTYPE html> <html lang=\"en\" xmlns=\"http://www.w3.org/1999/html\"> " +
                "<head> <meta charset=\"UTF-8\"> <title>Title</title> </head> " +
                "<body> " +
                "<input>input her sånn</input> <a href=\"http://localhost:8181/api\">link</a>" +
                "</body> " +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var body = req.getReader().lines().collect(Collectors.joining());
        var user = objectMapper.readValue(body,User.class);
        var users = userRepository.getUsers();
        if (Objects.equals(users.get(user.userName()), user.userPassword())){
            resp.addCookie(new Cookie("authorized","true"));
            System.out.println("cookie added");
        }else System.out.println("cookie not added");
    }
}
