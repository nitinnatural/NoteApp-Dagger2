package com.example.stayaboard.data.source;

import com.example.stayaboard.data.models.NoteItem;
import com.example.stayaboard.presentation.StayAboardApplication;

import java.util.List;

import rx.Observable;

/**
 * Created by Prakhar on 11/30/2017.
 */

public interface NotesDataSource {

    public void saveNote(NoteItem noteItem);
    public Observable<String> getNoteByPosition(int position);
    public Observable<List<String>> getAllNotes();

}
