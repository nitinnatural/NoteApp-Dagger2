package com.example.stayabode.presentation.screens.new_note;

import android.text.TextUtils;

import com.example.stayabode.domain.interactors.SaveNoteUseCase;
import com.example.stayabode.presentation.screens.edit_note.EditNotePresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Scheduler;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.verify;

/**
 * Created by Prakhar on 12/2/2017.
 */

public class NewNotePresenterTest {

    @Mock
    private NewNoteContract.View mView;

    @Mock
    private SaveNoteUseCase mSaveNoteUseCase;

    @Mock
    TextUtils textUtils;
    private NewNotePresenter mNewNotePresenter;


    @Before
    public void setupNewNotePresenter() throws Exception {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mNewNotePresenter = new NewNotePresenter(Schedulers.immediate(),
                Schedulers.immediate(),
                mSaveNoteUseCase);
        mNewNotePresenter.attachView(mView);
    }


    @Test
    public void tapOnAddNoteButton_BodyIsEmpty_ShowEmptyBodyErrorMessage() {
        //before
        String noteBody = "";

        //call
        mNewNotePresenter.handleAddNewButtonClicked(noteBody);

        //verify
        verify(mView).doForEmptyNoteBody();

    }


    @Test
    public void tapOnAddNoteButton_BodyIsNotEmpty_ShowNoteSavedMesaage() {
        //before
        String noteBody = "random lorem ipsum";

        //call
        mNewNotePresenter.handleAddNewButtonClicked(noteBody);

        //verify
        verify(mView).doWhenNoteItemIsSuccesfullyAdded();

    }
}
