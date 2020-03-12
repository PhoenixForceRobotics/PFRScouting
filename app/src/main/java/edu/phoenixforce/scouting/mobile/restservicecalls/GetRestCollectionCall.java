package edu.phoenixforce.scouting.mobile.restservicecalls;

public abstract class GetRestCollectionCall<T> extends GetRestCall<T> {

    public GetRestCollectionCall(ICollectionResponseHandler<T> handler) {
        super(handler);
    }


    @Override
    protected RestCallResponseHandler<T> getRestCallHandler(Class<T> templateClass, IResponseHandler<T> handler) {
        return new RestCollectionCallResponseHandler<T>(templateClass, (ICollectionResponseHandler) handler);
    }
}