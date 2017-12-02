package com.example.stayabode.presentation.screens.notes_list;

import com.example.stayabode.domain.interactors.GetAllNotesUseCase;
import com.example.stayabode.domain.interactors.GetNoteByPositionUseCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import rx.schedulers.Schedulers;

import static org.mockito.Mockito.verify;

/**
 * Created by Prakhar on 12/2/2017.
 */

public class NotesListPresenterTest {


    @Mock
    private NotesListContract.View mView;
    @Mock
    private GetAllNotesUseCase mGetAllNotesUseCase;
    @Mock
    private GetNoteByPositionUseCase mGetNoteByPositionUseCase;

    private NotesListPresenter mNotesListPresenter;

    @Before
    public void setupNotesListPresenter() throws Exception {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);


        // Get a reference to the class under test
        mNotesListPresenter = new NotesListPresenter(mGetAllNotesUseCase,
                mGetNoteByPositionUseCase,
                Schedulers.immediate(),
                Schedulers.immediate());
        mNotesListPresenter.attachView(mView);
    }



    @Test
    public void tapOnLocateMe_GpsSettingsNotAvailable_ShowAutoLocateError() {
        //before

        //call
      /*  mLocationSelectPresenter.handleAutoLocateClicked();

        verify(perpuleLocationManager).getNewGPSLocation(mLocationAvailableListenerCaptor.capture());
        mLocationAvailableListenerCaptor.getValue().onLocationNotFound();
*/
        //verify
  /*      verify(mView).showAutoLocateError();*/

    }


}
