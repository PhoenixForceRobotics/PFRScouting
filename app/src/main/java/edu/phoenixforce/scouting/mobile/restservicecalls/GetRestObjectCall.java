package edu.phoenixforce.scouting.mobile.restservicecalls;

public abstract class GetRestObjectCall<T> extends GetRestCall<T> {

    public GetRestObjectCall(IObjectResponseHandler<T> handler) {
        super(handler);
    }

    @Override
    protected RestCallResponseHandler<T> getRestCallHandler(Class<T> templateClass, IResponseHandler<T> handler) {
        return new RestObjectCallResponseHandler<T>(templateClass, ((IObjectResponseHandler) handler));
    }
}