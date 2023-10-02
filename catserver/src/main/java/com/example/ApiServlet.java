package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.stream.Collectors;

public class ApiServlet extends HttpServlet {
    String img = "Cat_August_2010-4.jpg";

    private static final Logger logger = LoggerFactory.getLogger(ApiServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        logger.info("request got!");

        CatRepository.getCats().forEach(cat -> {
            try {
                resp.getWriter().write("<html><body><H2>"+cat.name+ " the "+ cat.breed + " cat </H2>" +
                        "<img src="+img+">" +
                        "</body></html>");

                System.out.println(cat);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        var payload = req.getReader().lines().collect(Collectors.joining());
        var cat = new ObjectMapper().readValue(payload, Cat.class);
        CatRepository.addCat(cat);
    }

    record Cat(
            String name,
            String breed
    ){

    }
}
