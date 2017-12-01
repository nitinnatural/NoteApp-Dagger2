package com.example.stayaboard.presentation.screens.edit_note;

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
import com.example.stayaboard.presentation.StayAboardApplication;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class EditNoteActivity extends AppCompatActivity implements EditNoteContract.View, View.OnClickListener {


    @BindView(R.id.iv_back)
    ImageButton ivBackButton;

    @BindView(R.id.tv_title)
    TextView tvToolbarTitle;

    @BindView(R.id.et_edit_note)
    EditText etEditNote;

    @BindView(R.id.tv_edit_done)
    TextView tvDone;

    @Inject
    EditNotePresenter mEditNotePresenter;

    int position;
    String mSavedNoteBody;

    private boolean isNoteChanged;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        ButterKnife.bind(this);

        StayAboardApplication.getAppComponent().inject(this);


        setViewsAndClickListners();
    }


    private void setViewsAndClickListners() {
        ivBackButton.setOnClickListener(this);
        tvDone.setOnClickListener(this);
        tvToolbarTitle.setText("Edit Note");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mEditNotePresenter.attachView(this);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(EditNoteActivity.this, msg, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.tv_edit_done:
                mEditNotePresenter.handleEditDoneButtonClicked(isNoteChanged,position,etEditNote.getText().toString());
                break;
        }
    }

    @Override
    public void doWhenNoteIsNotChanged() {
        Toast.makeText(EditNoteActivity.this, "Note Text has not been changed! Please edit text before saving.",
                Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        mEditNotePresenter.detachView();
        super.onStop();
    }
}
