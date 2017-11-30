package com.example.stayaboard.presentation;

/**
 * Created by Prakhar on 11/30/2017.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);
    void detachView();
    
}
