package com.example.stayaboard.presentation.screens.new_note;

import com.example.stayaboard.presentation.screens.notes_list.NotesListContract;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Scheduler;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class NewNotePresenter implements NewNoteContract.Presenter{

    NewNoteContract.View mView;


    private final Scheduler threadScheduler;
    private final Scheduler postExecutionScheduler;

    @Inject
    public NewNotePresenter(@Named("Thread") Scheduler threadScheduler,
            @Named("PostExecution") Scheduler postExecutionScheduler){

        this.threadScheduler = threadScheduler;
        this.postExecutionScheduler = postExecutionScheduler;
    }

    public void attachView(NewNoteContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }


}
