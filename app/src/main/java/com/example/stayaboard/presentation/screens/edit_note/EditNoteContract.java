package com.example.stayaboard.presentation.screens.edit_note;

import com.example.stayaboard.presentation.BasePresenter;
import com.example.stayaboard.presentation.BaseView;

/**
 * Created by Prakhar on 11/30/2017.
 */

public interface EditNoteContract {
    interface View extends BaseView {

        void doWhenNoteIsNotChanged();

        void doWhenNoteIsChanged();
    }

    interface Presenter extends BasePresenter<EditNoteContract.View> {

        void handleEditDoneButtonClicked(int position, String noteBody);
    }
}
