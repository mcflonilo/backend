package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ImageServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ImageServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(String.valueOf(req.getRequestURI()));
        File file = new File("D:\\Users\\lmoph\\OneDrive\\Skrivebord\\github repos\\backend\\catserver\\src\\main\\resources\\webapp\\images\\Cat_August_2010-4.jpg");
        BufferedImage image = ImageIO.read(file);
        ImageIO.write(image, "PNG", resp.getOutputStream());
    }
    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletContext sc = getServletContext();
        try (InputStream is = sc.getResourceAsStream("D:\\Users\\lmoph\\OneDrive\\Skrivebord\\github repos\\backend\\catserver\\src\\main\\resources\\webapp\\images\\Cat_August_2010-4.jpg")) {
            // it is the responsibility of the container to close output stream
            OutputStream os = response.getOutputStream();
            if (is == null) {
                response.setContentType("text/plain");
                logger.info("Failed to send image");
            } else {
                response.setContentType("image/jpeg");
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
        }
    }*/
}
