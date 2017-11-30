package com.example.stayaboard.presentation.screens.notes_list;

import com.example.stayaboard.data.models.NoteItem;
import com.example.stayaboard.domain.interactors.GetAllNotesUseCase;
import com.example.stayaboard.domain.interactors.GetNoteByPositionUseCase;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Scheduler;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class NotesListPresenter implements NotesListContract.Presenter {

    NotesListContract.View mView;

    GetAllNotesUseCase mGetAllNotesUseCase;
    GetNoteByPositionUseCase mGetNoteByPositionUseCase;

    private final Scheduler threadScheduler;
    private final Scheduler postExecutionScheduler;


    @Inject
    public NotesListPresenter(GetAllNotesUseCase getAllNotesUseCase,
                              GetNoteByPositionUseCase getNoteByPositionUseCase,
                              @Named("Thread") Scheduler threadScheduler,
                              @Named("PostExecution") Scheduler postExecutionScheduler) {
        mGetAllNotesUseCase = getAllNotesUseCase;
        mGetNoteByPositionUseCase = getNoteByPositionUseCase;
        this.threadScheduler = threadScheduler;
        this.postExecutionScheduler = postExecutionScheduler;

    }

    @Override
    public void attachView(NotesListContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void handleItemClick(NoteItem noteItem) {

    }

    @Override
    public void loadData() {
        mGetAllNotesUseCase.execute();
    }
}
