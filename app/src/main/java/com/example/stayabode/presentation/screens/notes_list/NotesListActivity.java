package com.example.stayabode.presentation.screens.notes_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stayabode.R;
import com.example.stayabode.common.Constants;
import com.example.stayabode.data.models.NoteItem;
import com.example.stayabode.data.models.NoteItemList;
import com.example.stayabode.presentation.StayAbodeApplication;
import com.example.stayabode.presentation.screens.edit_note.EditNoteActivity;
import com.example.stayabode.presentation.screens.new_note.NewNoteActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class NotesListActivity extends AppCompatActivity implements NotesListContract.View, View.OnClickListener {


    @BindView(R.id.iv_back)
    ImageButton ivBackButton;

    @BindView(R.id.tv_title)
    TextView tvToolbarTitle;

    @Inject
    NotesListPresenter mNotesListPresenter;

    List<NoteItem> NotesList;

    NotesListAdapter mAdapterNotesList;

    @BindView(R.id.rv_notes_list)
    RecyclerView rvNotesList;

    @BindView(R.id.tv_btn_add_from_empty_layout)
    TextView btnAddFromEmptyLayout;

    @BindView(R.id.fab)
    FloatingActionButton fabAddNote;

    @BindView(R.id.view_empty_notes_list)
    View viewEmptyNotesList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        ButterKnife.bind(this);

        StayAbodeApplication.getAppComponent().inject(this);

        setViewsAndClickListeners();

    }

    private void setViewsAndClickListeners() {
        tvToolbarTitle.setText("Notes");
        ivBackButton.setVisibility(View.GONE);
        fabAddNote.setOnClickListener(this);
        btnAddFromEmptyLayout.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mNotesListPresenter.attachView(this);
        mNotesListPresenter.loadData();
    }


    @Override
    public void toggleEmptyNotesList(boolean active) {
        if (active) {
            // hide keyboard
            // Check if no view has focus:
            View view = getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }


            rvNotesList.setVisibility(View.GONE);
            viewEmptyNotesList.setVisibility(View.VISIBLE);
        } else {
            rvNotesList.setVisibility(View.VISIBLE);
            viewEmptyNotesList.setVisibility(View.GONE);
        }
    }


    @Override
    public void loadDataIntoAdapter(NoteItemList noteItemList) {
        NotesList = noteItemList.getList();
        mAdapterNotesList = new NotesListAdapter(this, NotesList,
                new NotesListAdapter.NotesListAdapterListener() {

                    @Override
                    public void onItemClick(String noteBody, int position) {
                        mNotesListPresenter.handleItemClick(noteBody, position);
                    }

                });

        rvNotesList.setAdapter(mAdapterNotesList);
        rvNotesList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void moveToEditNoteScreen(String noteBody, int position) {
        Intent intent = new Intent(NotesListActivity.this, EditNoteActivity.class);
        intent.putExtra(Constants.KEY_NOTE_BODY, noteBody);
        intent.putExtra(Constants.KEY_NOTE_POSITION, position);
        startActivity(intent);
    }


    @Override
    public void showError(String msg) {
        Toast.makeText(NotesListActivity.this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        mNotesListPresenter.detachView();
        super.onStop();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                Intent intent = new Intent(NotesListActivity.this, NewNoteActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_btn_add_from_empty_layout:
                intent = new Intent(NotesListActivity.this, NewNoteActivity.class);
                startActivity(intent);
                break;
            default:
                intent = new Intent(NotesListActivity.this, NewNoteActivity.class);
                startActivity(intent);
                break;
        }
    }
}
