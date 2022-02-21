package com.novoda.merlin;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class PingTask {

    private final Ping ping;
    private final EndpointPinger.PingerCallback pingerCallback;

    private final Executor executor = Executors.newSingleThreadExecutor();
    //private final Handler handler = new Handler(Looper.getMainLooper());

    public PingTask(Ping ping, EndpointPinger.PingerCallback pingerCallback) {
        this.ping = ping;
        this.pingerCallback = pingerCallback;
    }

    public void execute() {
        executor.execute(() -> {
            if (ping.doSynchronousPing()) {
                pingerCallback.onSuccess();
            } else {
                pingerCallback.onFailure();
            }
        });
    }
}
