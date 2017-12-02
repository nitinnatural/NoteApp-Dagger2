package com.example.stayaboard.data.source;

import com.example.stayaboard.data.models.NoteItem;
import com.example.stayaboard.data.models.NoteItemList;

import rx.Observable;

/**
 * Created by Prakhar on 11/30/2017.
 */

public interface NotesDataSource {

    public void saveNote(NoteItem noteItem);
    public Observable<Boolean> editNote(String noteBody, int position);
    public Observable<NoteItem> getNoteByPosition(int position);
    public Observable<NoteItemList> getAllNotes();

}
