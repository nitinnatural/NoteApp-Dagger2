package com.example.stayaboard.presentation.screens.notes_list;

import com.example.stayaboard.data.models.NoteItemList;
import com.example.stayaboard.presentation.BasePresenter;
import com.example.stayaboard.presentation.BaseView;

/**
 * Created by Prakhar on 11/30/2017.
 */

public interface NotesListContract {

    interface View extends BaseView {
        void toggleEmptyNotesList(boolean active);

        void loadDataIntoAdapter(NoteItemList noteItemList);

        void moveToEditNoteScreen(String noteBody, int position);
    }

    interface Presenter extends BasePresenter<View> {

        void handleItemClick(String noteBody, int position);

        void loadData();
    }
}
