package com.example.backend_utvikling;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HTTPClient {
    public final int statuscode;
    public final Map<String, String> headers = new HashMap<>();
    public final String status;
    public final String body;

    public HTTPClient(String host, int port, String url){
        try(Socket socket = new Socket(host, port)){

            String request = String.format("GET %s HTTP/1.1\r\nhost: %s \r\n\r\n", url, host);
            socket.getOutputStream().write(request.getBytes());

            String[] statusLine = readLine(socket).split(" ", 3);
            statuscode = Integer.parseInt(statusLine[1]);
            status = statusLine[2];

            String headerLine;
            while (!(headerLine = readLine(socket)).isEmpty()){
                String[] headerParts = headerLine.split(" *: *", 2);
                headers.put(headerParts[0], headerParts[1]);
            }

            StringBuilder body = new StringBuilder();
            for (int i = 0; i < getContentLength(); i++) {
                body.append((char) socket.getInputStream().read());
            }
            this.body = body.toString();

        }
        catch (IOException e){
            throw new RuntimeException();
        }


    }

    private int getContentLength() {
        return Integer.parseInt(headers.get("Content-Length"));
    }

    private String readLine(Socket socket) throws IOException {
        StringBuilder line = new StringBuilder();
        int c;
        while ((c = socket.getInputStream().read()) != '\r') {
            line.append((char) c);
            System.out.println((char) c);
        }
        System.out.println("stopped");

        c = socket.getInputStream().read();
        if (c != '\n') {
            throw new IllegalStateException("Invalid http header - \\r not followed by \\n");
        }
        return line.toString();
    }
}
