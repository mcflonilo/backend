package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class ApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CatRepository.getCats().forEach(cat -> {
            try {
                resp.getWriter().write("<HTML><H2>"+cat+"</H2></HTML>");

                System.out.println(cat);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, String[]> params = req.getParameterMap();
        String resultSet =
                params.entrySet()
                        .stream()
                        .map(e -> e.getKey() + "=" + String.join(", ", e.getValue()))
                        .collect(Collectors.joining(" "));


        System.out.println("params  "+params.get("catname")[0]);
        CatRepository.addCat(resultSet);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
