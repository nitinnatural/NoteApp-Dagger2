package com.example.stayabode.domain.interactors;

import com.example.stayabode.data.models.NoteItemList;
import com.example.stayabode.data.source.NotesRepository;
import com.example.stayabode.domain.interactors.base_use_cases.BaseUseCaseNoRequest;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class GetAllNotesUseCase extends BaseUseCaseNoRequest<NoteItemList> {

    public NotesRepository mNotesRepository;

    @Inject
    public GetAllNotesUseCase(NotesRepository notesRepository) {
        mNotesRepository = notesRepository;
    }

    @Override
    public Observable<NoteItemList> execute() {
        return mNotesRepository.getAllNotes();
    }

}