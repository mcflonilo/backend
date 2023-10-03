package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.servlet.ServletHolder;

import java.util.EnumSet;

import static jakarta.servlet.DispatcherType.REQUEST;


public class CatServer {
    private final Server server = new Server(8181);

    public void start() throws Exception {
        var resource = Resource.newClassPathResource("/webapp/index.html");
        var handler = new WebAppContext(resource, "/");
        handler.addServlet(new ServletHolder(new ApiServlet()),"/api");
        handler.addServlet(new ServletHolder(new LoginServlet()),"/login");
        handler.addServlet(new ServletHolder(new ImageServlet()),"/images/*");
        handler.addFilter(new FilterHolder(new CatFilter()),"/api", EnumSet.of(REQUEST));
        server.setHandler(handler);

        server.start();
    }

}