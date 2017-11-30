package com.example.stayaboard.presentation.screens.notes_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stayaboard.R;
import com.example.stayaboard.data.models.NoteItem;
import com.example.stayaboard.presentation.StayAboardApplication;
import com.example.stayaboard.presentation.screens.new_note.NewNoteActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class NotesListActivity extends AppCompatActivity implements NotesListContract.View, View.OnClickListener {

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
    View viewEmptyShoppingList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        ButterKnife.bind(this);

        StayAboardApplication.getAppComponent().inject(this);

        setOnClickListeners();

    }

    private void setOnClickListeners() {
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
            viewEmptyShoppingList.setVisibility(View.VISIBLE);
        } else {
            rvNotesList.setVisibility(View.VISIBLE);
            viewEmptyShoppingList.setVisibility(View.GONE);
        }
    }


    @Override
    public void loadNotesList() {
        mAdapterNotesList = new NotesListAdapter(this, NotesList,
                new NotesListAdapter.NotesListAdapterListener() {

                    @Override
                    public void onItemClick(NoteItem noteItem) {
                        mNotesListPresenter.handleItemClick(noteItem);
                    }

                });

        rvNotesList.setAdapter(mAdapterNotesList);
        rvNotesList.setLayoutManager(new LinearLayoutManager(this));
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
