package com.example.stayabode.presentation.screens.new_note;

import android.text.TextUtils;

import com.example.stayabode.data.models.NoteItem;
import com.example.stayabode.data.source.NotesRepository;
import com.example.stayabode.domain.interactors.SaveNoteUseCase;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Scheduler;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class NewNotePresenter implements NewNoteContract.Presenter {

    NewNoteContract.View mView;

    SaveNoteUseCase mSaveNoteUseCase;


    private final Scheduler threadScheduler;
    private final Scheduler postExecutionScheduler;

    @Inject
    public NewNotePresenter(@Named("Thread") Scheduler threadScheduler,
                            @Named("PostExecution") Scheduler postExecutionScheduler,
                            SaveNoteUseCase saveNoteUseCase) {
        this.threadScheduler = threadScheduler;
        this.postExecutionScheduler = postExecutionScheduler;
        mSaveNoteUseCase = saveNoteUseCase;
    }

    public void attachView(NewNoteContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }


    @Override
    public void handleAddNewButtonClicked(String noteBody) {
        if (!TextUtils.isEmpty(noteBody)) {
            NoteItem noteItem = new NoteItem();
            noteItem.setNoteTitle("Title");
            noteItem.setNoteBody(noteBody);
            noteItem.setCurrentTime(System.currentTimeMillis());
            mSaveNoteUseCase.execute(new SaveNoteUseCase.RequestValues(noteItem));
            mView.doWhenNoteItemIsSuccesfullyAdded();
        } else {
            mView.doForEmptyNoteBody();
        }
    }
}
