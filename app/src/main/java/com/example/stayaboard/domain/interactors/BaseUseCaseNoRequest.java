package com.example.stayaboard.domain.interactors;

import rx.Observable;

/**
 * Created by Prakhar on 11/30/2017.
 */

public abstract class BaseUseCaseNoRequest<RESPONSE_DATA> {

    public abstract Observable<RESPONSE_DATA> execute();

}