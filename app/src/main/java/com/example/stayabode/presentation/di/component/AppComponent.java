package com.example.stayabode.presentation.di.component;

import com.example.stayabode.data.source.NotesRepository;
import com.example.stayabode.presentation.StayAbodeApplication;
import com.example.stayabode.presentation.di.AppScope;
import com.example.stayabode.presentation.di.modules.AppModule;
import com.example.stayabode.presentation.screens.edit_note.EditNoteActivity;
import com.example.stayabode.presentation.screens.new_note.NewNoteActivity;
import com.example.stayabode.presentation.screens.notes_list.NotesListActivity;

import dagger.Component;

/**
 * Created by Prakhar on 11/30/2017.
 */
@AppScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(StayAbodeApplication perpuleApplication);

    void inject(NotesListActivity notesListActivity);

    void inject(NewNoteActivity newNoteActivity);

    void inject(EditNoteActivity editNoteActivity);

}
