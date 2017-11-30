package com.example.stayaboard.data.models;

/**
 * Created by Prakhar on 11/30/2017.
 */

public class NoteItem {

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteBody() {
        return noteBody;
    }

    public void setNoteBody(String noteBody) {
        this.noteBody = noteBody;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    String noteTitle;
    String noteBody;
    long currentTime;

}
