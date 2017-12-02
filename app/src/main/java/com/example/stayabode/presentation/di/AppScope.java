package com.example.stayabode.presentation.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;
import javax.inject.Singleton;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Created by Prakhar on 11/30/2017.
 */
@Scope
@Retention(RUNTIME)
@Singleton
public @interface AppScope {
}