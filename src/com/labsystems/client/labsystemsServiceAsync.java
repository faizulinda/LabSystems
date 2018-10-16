package com.labsystems.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface labsystemsServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
