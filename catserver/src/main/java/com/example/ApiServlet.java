package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class ApiServlet extends HttpServlet {
    String img = "images/Cat_August_2010-4.jpg";

    private static final Logger logger = LoggerFactory.getLogger(ApiServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("request got!");
        resp.setContentType("text/html");
        File file = new File("D:\\Users\\lmoph\\OneDrive\\Skrivebord\\github repos\\backend\\catserver\\src\\main\\resources\\webapp\\index.html");
        FileReader fileReader = new FileReader(file);
        while (fileReader.ready()){
            resp.getWriter().write(fileReader.read());
        }

        CatRepository.getCats().forEach(cat -> {
            try {
                resp.getWriter().write("<html><body><H2>"+cat.name+ " the "+ cat.breed + " cat </H2>" +
                        "<img src="+img+" width=\"250\" height=\"250\">" +
                        "</body></html>");

                System.out.println(cat);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("post request received!");
        var payload = req.getReader().lines().collect(Collectors.joining());
        var cat = new ObjectMapper().readValue(payload, Cat.class);
        CatRepository.addCat(cat);
        resp.getWriter().write("cat added");
    }

    record Cat(
            String name,
            String breed
    ){

    }
}
