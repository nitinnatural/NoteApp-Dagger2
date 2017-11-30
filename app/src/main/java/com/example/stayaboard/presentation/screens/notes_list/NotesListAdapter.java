package com.example.stayaboard.presentation.screens.notes_list;

/**
 * Created by Prakhar on 11/30/2017.
 */

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.stayaboard.R;
import com.example.stayaboard.data.models.NoteItem;
import java.util.List;


public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.Holder> {

    private Context mContext;
    private List<NoteItem> mNotesList;
    private NotesListAdapterListener mListener;
    

    public NotesListAdapter(Context c, List<NoteItem> shoppingList, NotesListAdapterListener listener) {
        this.mContext = c;
        this.mNotesList = shoppingList;
        this.mListener = listener;

    }

    @Override
    public NotesListAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_note_list_item, parent, false);
        return new Holder(v);

    }

    @Override
    public void onBindViewHolder(Holder h, final int position) {
        NoteItem item = mNotesList.get(position);



    }


    public interface NotesListAdapterListener {
        void onItemClick(NoteItem shoppingItem);
    }


    public class Holder extends RecyclerView.ViewHolder {

        AppCompatRadioButton cbDone;
        EditText etNotesItem;
        ImageView ivRemoveItem;
        FrameLayout btnDone;
        

        public Holder(View v) {
            super(v);


     
        }

    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mNotesList.size();
    }

    public Boolean isNotesListItemNotEmpty(String itemName) {
        if (itemName != null && itemName.replaceAll("\\s", "").length() > 0)
            return true;
        else
            return false;
    }

}