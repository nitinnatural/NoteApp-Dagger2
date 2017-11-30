package com.example.stayaboard.presentation;


public interface BasePresenter<T extends BaseView> {

    void attachView(T view);
    void detachView();
    
}
