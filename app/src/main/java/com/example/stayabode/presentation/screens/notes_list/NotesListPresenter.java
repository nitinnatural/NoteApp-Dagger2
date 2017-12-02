package com.example.stayabode.presentation.screens.notes_list;

import android.util.Log;

import com.example.stayabode.data.models.NoteItem;
import com.example.stayabode.data.models.NoteItemList;
import com.example.stayabode.domain.interactors.GetAllNotesUseCase;
import com.example.stayabode.domain.interactors.GetNoteByPositionUseCase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Scheduler;
import rx.Subscriber;

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
    public void handleItemClick(String noteBody, int position) {
        mView.moveToEditNoteScreen(noteBody, position);
    }

    @Override
    public void loadData() {
        mGetAllNotesUseCase.execute()
                .subscribeOn(threadScheduler)
                .observeOn(postExecutionScheduler)
                .subscribe(new Subscriber<NoteItemList>() {
                    @Override
                    public void onCompleted() {
                        Log.d("tag","completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("tag",e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(NoteItemList noteItemList) {
                        if (mView == null) return;
                        if (noteItemList.getList() != null && noteItemList.getList().size() > 0) {
                            mView.toggleEmptyNotesList(false);
                            mView.loadDataIntoAdapter(noteItemList);
                        } else {
                            mView.toggleEmptyNotesList(true);
                        }
                    }
                });

    }
}
