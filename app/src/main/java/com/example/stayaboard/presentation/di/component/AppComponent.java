package com.example.stayaboard.presentation.di.component;

import com.example.stayaboard.data.source.NotesRepository;
import com.example.stayaboard.presentation.StayAboardApplication;
import com.example.stayaboard.presentation.di.AppScope;
import com.example.stayaboard.presentation.di.modules.AppModule;
import com.example.stayaboard.presentation.screens.edit_note.EditNoteActivity;
import com.example.stayaboard.presentation.screens.new_note.NewNoteActivity;
import com.example.stayaboard.presentation.screens.notes_list.NotesListActivity;

import dagger.Component;

/**
 * Created by Prakhar on 11/30/2017.
 */
@AppScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(StayAboardApplication perpuleApplication);

    void inject(NotesListActivity notesListActivity);

    void inject(NewNoteActivity newNoteActivity);

    void inject(EditNoteActivity editNoteActivity);

}
