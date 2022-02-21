package com.novoda.merlin;

class EndpointPinger {

    private final Endpoint endpoint;
    private final PingTaskFactory pingTaskFactory;

    EndpointPinger(Endpoint endpoint, PingTaskFactory pingTaskFactory) {
        this.endpoint = endpoint;
        this.pingTaskFactory = pingTaskFactory;
    }

    static EndpointPinger withCustomEndpointAndValidation(Endpoint endpoint, ResponseCodeValidator validator) {
        PingTaskFactory pingTaskFactory = new PingTaskFactory(new ResponseCodeFetcher(), validator);
        return new EndpointPinger(endpoint, pingTaskFactory);
    }

    void ping(PingerCallback pingerCallback) {
        PingTask pingTask = pingTaskFactory.create(endpoint, pingerCallback);
        pingTask.execute();
    }

    void noNetworkToPing(PingerCallback pingerCallback) {
        pingerCallback.onFailure();
    }

    interface PingerCallback {

        void onSuccess();

        void onFailure();

    }

    static class ResponseCodeFetcher {

        public int from(Endpoint endpoint) {
            return MerlinRequest.head(endpoint).getResponseCode();
        }

    }

}
