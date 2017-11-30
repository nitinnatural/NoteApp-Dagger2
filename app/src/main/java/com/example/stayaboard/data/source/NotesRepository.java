package com.example.stayaboard.data.source;

import android.content.SharedPreferences;

import com.example.stayaboard.data.models.NoteItem;
import com.example.stayaboard.presentation.di.AppScope;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Prakhar on 11/30/2017.
 */
@AppScope
public class NotesRepository implements NotesDataSource {

    @Inject
    SharedPreferences mSharedPreferences;

    @Inject
    public NotesRepository(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    @Override
    public Observable<List<String>> getAllNotes() {
        return null;
    }

    @Override
    public Observable<String> getNoteByPosition(int position) {
        return null;
    }

    @Override
    public void saveNote(NoteItem noteItem) {

    }
}
