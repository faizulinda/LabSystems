package com.labsystems.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("labsystemsService")
public interface labsystemsService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use labsystemsService.App.getInstance() to access static instance of labsystemsServiceAsync
     */
    public static class App {
        private static labsystemsServiceAsync ourInstance = GWT.create(labsystemsService.class);

        public static synchronized labsystemsServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
