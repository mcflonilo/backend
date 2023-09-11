package com.example.backend_utvikling;
import java.io.IOException;
import java.net.Socket;

public class HTTPClient {

    public HTTPClient(String host, int port, String url){
        try(Socket socket = new Socket(host, port)){

            String request = String.format("GET %s HTTP/1.1\r\nhost: %s \r\n\r\n", url, host);
            socket.getOutputStream().write(request.getBytes());

        }
        catch (IOException e){
            throw new RuntimeException();
        }


    }
}
