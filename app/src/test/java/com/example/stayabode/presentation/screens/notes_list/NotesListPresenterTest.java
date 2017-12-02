package com.example.stayabode.presentation.screens.notes_list;

import com.example.stayabode.data.models.NoteItem;
import com.example.stayabode.data.models.NoteItemList;
import com.example.stayabode.domain.interactors.EditNoteUseCase;
import com.example.stayabode.domain.interactors.GetAllNotesUseCase;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import rx.Observable;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Prakhar on 12/2/2017.
 */

public class NotesListPresenterTest {


    @Mock
    private NotesListContract.View mView;
    @Mock
    private GetAllNotesUseCase mGetAllNotesUseCase;

    private NotesListPresenter mNotesListPresenter;

    @Before
    public void setupNotesListPresenter() throws Exception {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);


        // Get a reference to the class under test
        mNotesListPresenter = new NotesListPresenter(mGetAllNotesUseCase,
                Schedulers.immediate(),
                Schedulers.immediate());
        mNotesListPresenter.attachView(mView);
    }


    @Test
    public void loadingData_ListObjectNull_ShowLayoutForEmptyList() {
        //before

        when(mGetAllNotesUseCase.execute()).thenReturn(Observable.<NoteItemList>just(null));


        //call
        mNotesListPresenter.loadData();


        //verify
        verify(mView).toggleEmptyNotesList(true);

    }

    @Test
    public void loadingData_ListObjectNotNull_AndListSizeGreaterThanZero_ShowLayoutForEmptyList() {
        //before
        ArrayList<String> demoList = new ArrayList<>();
        demoList.add("lorem ipsum 1");
        demoList.add("loren ipsum 2");
        NoteItemList noteItemList = new NoteItemList(demoList);
        when(mGetAllNotesUseCase.execute()).thenReturn(Observable.just(noteItemList));

        //call
        mNotesListPresenter.loadData();

        //verify
        verify(mView).toggleEmptyNotesList(false);

    }

}
