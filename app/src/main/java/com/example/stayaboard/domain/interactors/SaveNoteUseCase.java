package com.example.stayaboard.domain.interactors;

import com.example.stayaboard.data.models.NoteItem;
import com.example.stayaboard.data.source.NotesRepository;

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
