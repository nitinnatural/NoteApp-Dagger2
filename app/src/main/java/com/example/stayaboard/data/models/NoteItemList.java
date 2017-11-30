package com.example.stayaboard.data.models;

import java.util.ArrayList;

/**
 * Created by Prakhar on 12/1/2017.
 */

public class NoteItemList {
    public ArrayList<NoteItem> getList() {
        return list;
    }

    public void setList(ArrayList<NoteItem> list) {
        this.list = list;
    }

    public ArrayList<NoteItem> list;
}
