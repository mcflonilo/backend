package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.servlet.ServletHolder;


public class CatServer {
    private final Server server = new Server(8181);

    public void start() throws Exception {
        var resource = Resource.newClassPathResource("/webapp");
        var handler = new WebAppContext(resource, "/");
        handler.addServlet(new ServletHolder(new ApiServlet()),"/api");

        server.setHandler(handler);

        server.start();
    }

}