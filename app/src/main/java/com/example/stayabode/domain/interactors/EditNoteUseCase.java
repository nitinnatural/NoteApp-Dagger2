package com.example.stayabode.domain.interactors;

import com.example.stayabode.data.source.NotesRepository;
import com.example.stayabode.domain.interactors.base_use_cases.BaseUseCase;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Prakhar on 12/2/2017.
 */

public class EditNoteUseCase extends BaseUseCase<EditNoteUseCase.RequestValues,Boolean> {

    public NotesRepository mNotesRepository;

    @Inject
    public EditNoteUseCase(NotesRepository notesRepository) {
        mNotesRepository = notesRepository;
    }


    @Override
    public Observable<Boolean> execute(RequestValues requestValues) {
        return mNotesRepository.editNote(requestValues.noteBody,requestValues.position);
    }

    public static final class RequestValues {
        String noteBody;
        int position;

        public RequestValues(String noteBody, int position) {

            this.noteBody = noteBody;
            this.position = position;
        }
    }
}

