package com.example.stayaboard.presentation.screens.new_note;

import com.example.stayaboard.data.models.NoteItem;
import com.example.stayaboard.presentation.BasePresenter;
import com.example.stayaboard.presentation.BaseView;
import com.example.stayaboard.presentation.screens.notes_list.NotesListContract;

/**
 * Created by Prakhar on 11/30/2017.
 */

public interface NewNoteContract {
    interface View  extends BaseView {

    }

    interface Presenter extends BasePresenter<NewNoteContract.View> {


    }
}
