package com.example.stayabode.domain.interactors;

import rx.Observable;

/**
 * Created by Prakhar on 11/30/2017.
 */


public abstract class BaseUseCase<REQUEST_DATA, RESPONSE_DATA> {

    public abstract Observable<RESPONSE_DATA> execute(REQUEST_DATA requestData);

}
