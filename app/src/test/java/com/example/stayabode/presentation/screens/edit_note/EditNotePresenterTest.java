package com.example.stayabode.presentation.screens.edit_note;

import com.example.stayabode.domain.interactors.EditNoteUseCase;
import com.example.stayabode.presentation.screens.notes_list.NotesListPresenter;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Prakhar on 12/2/2017.
 */

public class EditNotePresenterTest {


    @Mock
    private EditNoteContract.View mView;

    @Mock
    private EditNoteUseCase mEditNoteUseCase;


    private EditNotePresenter mEditNotePresenter;


    @Before
    public void setupEditNotePresenter() throws Exception {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mEditNotePresenter = new EditNotePresenter(Schedulers.immediate(),
                Schedulers.immediate(),
                mEditNoteUseCase);
        mEditNotePresenter.attachView(mView);
    }


    @Test
    public void tapOnEditDoneButton_successfullyEdited_showSuccessfullySavedMessageInToast() {

        //before
        int position = 1;
        String noteBody = "loren ipsum";

        when(mEditNoteUseCase.execute(any(EditNoteUseCase.RequestValues.class)))
                .thenReturn(Observable.just(true));

        //call
        mEditNotePresenter.handleEditDoneButtonClicked(position,noteBody);

        //Verify
        verify(mView).doWhenNoteIsChanged();

    }




    @Test
    public void tapOnEditDoneButton_CannotBeEdited_showErrorMessageInToast() {

        //before
        int position = 1;
        String noteBody = "loren ipsum";

        when(mEditNoteUseCase.execute(any(EditNoteUseCase.RequestValues.class)))
                .thenReturn(Observable.just(false));

        //call
        mEditNotePresenter.handleEditDoneButtonClicked(position,noteBody);

        //Verify
        verify(mView).doWhenNoteIsNotChanged();

    }
}
