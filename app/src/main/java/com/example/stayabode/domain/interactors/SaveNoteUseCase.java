package com.example.stayabode.domain.interactors;

import com.example.stayabode.data.models.NoteItem;
import com.example.stayabode.data.source.NotesRepository;
import com.example.stayabode.domain.interactors.base_use_cases.BaseUseCaseNoReturn;

import javax.inject.Inject;

/**
 * Created by Prakhar on 12/2/2017.
 */

public class SaveNoteUseCase extends BaseUseCaseNoReturn<SaveNoteUseCase.RequestValues> {

    public NotesRepository mNotesRepository;

    @Inject
    public SaveNoteUseCase(NotesRepository notesRepository) {
        mNotesRepository = notesRepository;
    }


    @Override
    public void execute(SaveNoteUseCase.RequestValues requestValues) {
        mNotesRepository.saveNote(requestValues.noteItem);
    }

    public static final class RequestValues {
        NoteItem noteItem;

        public RequestValues(NoteItem noteItem) {
            this.noteItem = noteItem;
        }
    }
}
