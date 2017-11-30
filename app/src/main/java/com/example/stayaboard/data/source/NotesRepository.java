package com.example.stayaboard.data.source;

import android.content.SharedPreferences;

import com.example.stayaboard.common.Constants;
import com.example.stayaboard.data.models.NoteItem;
import com.example.stayaboard.data.models.NoteItemList;
import com.example.stayaboard.presentation.di.AppScope;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Prakhar on 11/30/2017.
 */
@AppScope
public class NotesRepository implements NotesDataSource {


    @Inject
    SharedPreferences mSharedPreferences;

    NoteItemList mNoteItemList;


    @Inject
    public NotesRepository(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
        mNoteItemList = new NoteItemList();
    }


    public void saveNotesIntoPreference(NoteItem noteItem) {

        mNoteItemList = getSavedNotesFromSharedPreference();
        mNoteItemList.getList().add(noteItem);

        String json = mNoteItemList == null ? null : new Gson().toJson(mNoteItemList);
        SharedPreferences.Editor prefEditor = mSharedPreferences.edit();
        prefEditor.putString(Constants.CUSTOM_NOTES_LIST_OBJECT, json);
        prefEditor.commit();
    }

    public NoteItemList getSavedNotesFromSharedPreference() {
        String json = null;
        Type fooType = new TypeToken<NoteItemList>() {
        }.getType();
        if (mSharedPreferences.contains(Constants.CUSTOM_NOTES_LIST_OBJECT)) {
            json = mSharedPreferences.getString(Constants.CUSTOM_NOTES_LIST_OBJECT, null);
        }
        return json == null ? null : (NoteItemList) new Gson().fromJson(json, fooType);
    }

    @Override
    public Observable<NoteItemList> getAllNotes() {
        return Observable.just(mNoteItemList);
    }

    @Override
    public Observable<NoteItem> getNoteByPosition(int position) {
        return Observable.just(mNoteItemList.getList().get(position));
    }

    @Override
    public void saveNote(NoteItem noteItem) {
        saveNotesIntoPreference(noteItem);
    }
}
