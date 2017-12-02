package com.example.stayabode.presentation.screens.notes_list;

/**
 * Created by Prakhar on 11/30/2017.
 */

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stayabode.R;
import com.example.stayabode.data.models.NoteItem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.Holder> {

    private Context mContext;
    private List<NoteItem> mNotesList;
    private NotesListAdapterListener mListener;


    public NotesListAdapter(Context c, List<NoteItem> notesList, NotesListAdapterListener listener) {
        this.mContext = c;
        this.mNotesList = notesList;
        this.mListener = listener;

    }

    @Override
    public NotesListAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_note_list_item, parent, false);
        return new Holder(v);

    }

    @Override
    public void onBindViewHolder(Holder h, final int position) {
        final NoteItem item = mNotesList.get(position);

        h.tvTitle.setText(item.getNoteTitle());
        h.tvTime.setText(convertMilliSecondsToFormattedDate(item.getCurrentTime()));
        h.tvContent.setText(item.getNoteBody());

        h.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(item.getNoteBody(), position);
            }
        });
    }


    public interface NotesListAdapterListener {
        void onItemClick(String noteBody, int position);
    }


    public class Holder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvTime, tvContent;
        CardView container;

        public Holder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tv_title);
            tvTime = v.findViewById(R.id.tv_time);
            tvContent = v.findViewById(R.id.tv_content);
            container = v.findViewById(R.id.cardview_note_container);
        }

    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        if (mNotesList != null)
            return mNotesList.size();
        else return 0;
    }

    public Boolean isNotesListItemNotEmpty(String itemName) {
        if (itemName != null && itemName.replaceAll("\\s", "").length() > 0)
            return true;
        else
            return false;
    }


    public static String convertMilliSecondsToFormattedDate(long milliSeconds) {
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return simpleDateFormat.format(calendar.getTime());
    }
}

