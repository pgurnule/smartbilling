package com.billbook.api;

import retrofit2.Response;

/**
 * Created by sanesh on 3/9/16.
 */
public interface RequestNotifier {
    public void notifySuccess(Response<?> response);

    public void notifyError(Throwable error);
}
