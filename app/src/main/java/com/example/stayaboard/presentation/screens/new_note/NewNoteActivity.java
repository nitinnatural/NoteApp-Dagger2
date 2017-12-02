package com.example.stayaboard.presentation.screens.new_note;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stayaboard.R;
import com.example.stayaboard.data.models.NoteItem;
import com.example.stayaboard.data.source.NotesRepository;
import com.example.stayaboard.presentation.StayAboardApplication;
import com.example.stayaboard.presentation.screens.notes_list.NotesListActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class NewNoteActivity extends AppCompatActivity implements NewNoteContract.View, View.OnClickListener {


    @BindView(R.id.iv_back)
    ImageButton ivBackButton;

    @BindView(R.id.tv_title)
    TextView tvToolbarTitle;

    @BindView(R.id.et_new_note)
    EditText etNewNote;

    @BindView(R.id.tv_add_note)
    TextView tvAddNote;


    @Inject
    NewNotePresenter mNewNotePresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        ButterKnife.bind(this);

        StayAboardApplication.getAppComponent().inject(this);

        setViewsAndClickListners();
    }

    private void setViewsAndClickListners() {
        ivBackButton.setOnClickListener(this);
        tvAddNote.setOnClickListener(this);
        tvToolbarTitle.setText("New Note");
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.tv_add_note:
                mNewNotePresenter.handleAddNewButtonClicked(etNewNote.getText().toString());
                break;
        }
    }


    @Override
    public void doForEmptyNoteBody() {
        Toast.makeText(NewNoteActivity.this, "Message cannot be empty!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void doWhenNoteItemIsSuccesfullyAdded() {
        Toast.makeText(NewNoteActivity.this, "Note Successfully Added!", Toast.LENGTH_LONG).show();
        goToNotesListActivity();
    }

    private void goToNotesListActivity() {
        Intent intent = new Intent(NewNoteActivity.this, NotesListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        mNewNotePresenter.detachView();
        super.onStop();
    }

}
