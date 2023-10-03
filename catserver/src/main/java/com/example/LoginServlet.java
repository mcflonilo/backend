package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.w3c.dom.events.Event;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Collectors;


public class LoginServlet extends HttpServlet {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        File file = new File("D:\\Users\\lmoph\\OneDrive\\Skrivebord\\github repos\\backend\\catserver\\src\\main\\resources\\webapp\\login.html");
        FileReader fileReader = new FileReader(file);
        while (fileReader.ready()){
            resp.getWriter().write(fileReader.read());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("userName") != null){
            if (req.getParameter("userName").equals("jason") && req.getParameter("userPassword").equals("pass")){
                resp.addCookie(new Cookie("authorized","true"));
                System.out.println("cookie added");
                return;
            }
        }
        var body = req.getReader().lines().collect(Collectors.joining());
        var user = objectMapper.readValue(body,User.class);
        var users = userRepository.getUsers();

        if (Objects.equals(users.get(user.userName()), user.userPassword())){
            resp.addCookie(new Cookie("authorized","true"));
            System.out.println("cookie added");
        }else System.out.println("cookie not added");
    }
}
