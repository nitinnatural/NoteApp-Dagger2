package com.example.stayaboard.domain.interactors;

import com.example.stayaboard.data.source.NotesRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class GetAllNotesUseCase extends BaseUseCaseNoRequest<List<String>> {

    public NotesRepository mNotesRepository;

    @Inject
    public GetAllNotesUseCase(NotesRepository notesRepository) {
        mNotesRepository = notesRepository;
    }

    @Override
    public rx.Observable<List<String>> execute() {
        return mNotesRepository.getAllNotes();
    }

}