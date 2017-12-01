package com.example.stayaboard.presentation.screens.edit_note;

import com.example.stayaboard.data.source.NotesRepository;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Scheduler;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class EditNotePresenter implements EditNoteContract.Presenter {

    EditNoteContract.View mView;

    NotesRepository mNotesRepository;

    private final Scheduler threadScheduler;
    private final Scheduler postExecutionScheduler;

    @Inject
    public EditNotePresenter(@Named("Thread") Scheduler threadScheduler,
                             @Named("PostExecution") Scheduler postExecutionScheduler,
                             NotesRepository notesRepository) {
        mNotesRepository = notesRepository;
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

    @Override
    public void handleEditDoneButtonClicked(boolean isNoteChanged, int position, String noteBody) {
        if (isNoteChanged) {

        } else {
            mView.doWhenNoteIsNotChanged();
        }
    }
}
