package com.example.stayaboard.presentation.screens.notes_list;

import com.example.stayaboard.data.models.NoteItem;
import com.example.stayaboard.presentation.BasePresenter;
import com.example.stayaboard.presentation.BaseView;

/**
 * Created by Prakhar on 11/30/2017.
 */

public interface NotesListContract {

    interface View  extends BaseView {
        void toggleEmptyNotesList(boolean active);
        void loadNotesList();
    }

    interface Presenter extends BasePresenter<View> {

        void handleItemClick(NoteItem noteItem);

        void loadData();
    }
}
