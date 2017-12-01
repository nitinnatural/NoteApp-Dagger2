package com.example.stayaboard.presentation.screens.edit_note;

import com.example.stayaboard.presentation.BasePresenter;
import com.example.stayaboard.presentation.BaseView;

/**
 * Created by Prakhar on 11/30/2017.
 */

public interface EditNoteContract {
    interface View extends BaseView {

        void doWhenNoteIsNotChanged();
    }

    interface Presenter extends BasePresenter<EditNoteContract.View> {

        void handleEditDoneButtonClicked(boolean isNoteChanged, int position, String noteBody);
    }
}
