package com.example.stayabode.domain.interactors.base_use_cases;

import rx.Observable;

/**
 * Created by Prakhar on 11/30/2017.
 */

public abstract class BaseUseCaseNoRequest<RESPONSE_DATA> {

    public abstract Observable<RESPONSE_DATA> execute();

}