package com.example.stayaboard.presentation.screens.edit_note;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Scheduler;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class EditNotePresenter implements EditNoteContract.Presenter {

    EditNoteContract.View mView;


    private final Scheduler threadScheduler;
    private final Scheduler postExecutionScheduler;

    @Inject
    public EditNotePresenter(@Named("Thread") Scheduler threadScheduler,
                            @Named("PostExecution") Scheduler postExecutionScheduler){

        this.threadScheduler = threadScheduler;
        this.postExecutionScheduler = postExecutionScheduler;
    }

    public void attachView(EditNoteContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
