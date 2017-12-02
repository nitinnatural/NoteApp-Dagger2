package com.example.stayabode.data.source;

import android.content.SharedPreferences;

import com.example.stayabode.common.Constants;
import com.example.stayabode.data.models.NoteItem;
import com.example.stayabode.data.models.NoteItemList;
import com.example.stayabode.presentation.di.AppScope;
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
    }


    public void saveNoteIntoPreference(NoteItem noteItem) {

        if (mNoteItemList == null) {
            mNoteItemList = new NoteItemList(getSavedNotesFromSharedPreference());
        }
        mNoteItemList.getList().add(noteItem);

        String json = mNoteItemList == null ? null : new Gson().toJson(mNoteItemList);
        SharedPreferences.Editor prefEditor = mSharedPreferences.edit();
        prefEditor.putString(Constants.CUSTOM_NOTES_LIST_OBJECT, json);
        prefEditor.commit();
    }

    public void saveNotesListIntoPreference(NoteItemList noteItemList) {
        String json = noteItemList == null ? null : new Gson().toJson(noteItemList);
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
        if (mNoteItemList == null) {
            mNoteItemList = new NoteItemList(getSavedNotesFromSharedPreference());
        }
        return Observable.just(mNoteItemList);
    }

    @Override
    public Observable<NoteItem> getNoteByPosition(int position) {
        return Observable.just(mNoteItemList.getList().get(position));
    }

    @Override
    public void saveNote(NoteItem noteItem) {
        saveNoteIntoPreference(noteItem);
    }

    public Observable<Boolean> editNote(String noteBody, int position) {
        //edited
        if (mNoteItemList.getList().get(position).getNoteBody().equalsIgnoreCase(noteBody) == false) {
            mNoteItemList.getList().get(position).setNoteBody(noteBody);
            SharedPreferences.Editor prefEditor = mSharedPreferences.edit();
            prefEditor.clear();

            saveNotesListIntoPreference(mNoteItemList);

            return Observable.just(true);
        } else {//not edited
            return Observable.just(false);
        }
    }

}
