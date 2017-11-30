package com.example.stayaboard.presentation.screens.new_note;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.stayaboard.R;
import com.example.stayaboard.presentation.BaseView;
import com.example.stayaboard.presentation.StayAboardApplication;
import com.example.stayaboard.presentation.screens.notes_list.NotesListActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class NewNoteActivity extends AppCompatActivity implements NewNoteContract.View {


   @Inject
   NewNotePresenter mNewNotePresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        ButterKnife.bind(this);

        StayAboardApplication.getAppComponent().inject(this);

    }


    @Override
    protected void onStart() {
        super.onStart();
        mNewNotePresenter.attachView(this);
    }


    @Override
    public void showError(String msg) {
        Toast.makeText(NewNoteActivity.this, msg, Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onStop() {
        mNewNotePresenter.detachView();
        super.onStop();
    }
}
