package com.labsystems.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.labsystems.client.labsystemsService;

public class labsystemsServiceImpl extends RemoteServiceServlet implements labsystemsService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}