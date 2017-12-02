package com.example.stayabode.domain.interactors;

import com.example.stayabode.data.models.NoteItem;
import com.example.stayabode.data.source.NotesRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class GetNoteByPositionUseCase extends BaseUseCase<GetNoteByPositionUseCase.RequestValues, NoteItem> {

    public NotesRepository mNotesRepository;

    @Inject
    public GetNoteByPositionUseCase(NotesRepository notesRepository) {
        mNotesRepository = notesRepository;
    }

    @Override
    public rx.Observable<NoteItem> execute(GetNoteByPositionUseCase.RequestValues requestValues) {
        return mNotesRepository.getNoteByPosition(requestValues.position);
    }


    public static final class RequestValues {

        int position;
        public RequestValues(int position) {
            this.position = position;
        }
    }
}
