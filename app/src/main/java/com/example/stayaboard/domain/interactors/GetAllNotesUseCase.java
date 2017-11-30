package com.example.stayaboard.domain.interactors;

import com.example.stayaboard.data.models.NoteItemList;
import com.example.stayaboard.data.source.NotesRepository;

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