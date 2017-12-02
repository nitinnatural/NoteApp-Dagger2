package com.example.stayabode.presentation.screens.new_note;

import com.example.stayabode.domain.interactors.SaveNoteUseCase;
import com.example.stayabode.presentation.screens.edit_note.EditNotePresenter;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by Prakhar on 12/2/2017.
 */

public class NewNotePresenterTest {

    @Mock
    private NewNoteContract.View mView;

    @Mock
    private SaveNoteUseCase mSaveNoteUseCase;

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

}
