package com.example.stayabode.presentation.screens.new_note;

import com.example.stayabode.data.models.NoteItem;
import com.example.stayabode.presentation.BasePresenter;
import com.example.stayabode.presentation.BaseView;
import com.example.stayabode.presentation.screens.notes_list.NotesListContract;

/**
 * Created by Prakhar on 11/30/2017.
 */

public interface NewNoteContract {
    interface View  extends BaseView {

        void doForEmptyNoteBody();

        void doWhenNoteItemIsSuccesfullyAdded();
    }

    interface Presenter extends BasePresenter<NewNoteContract.View> {


        void handleAddNewButtonClicked(String noteBody);
    }
}
