package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NoteView extends ViewModel {
    private MutableLiveData<String> note;
    private MutableLiveData<String> fullNote;

    public void setNote(String note) {
        if (this.note == null) {
            this.note = new MutableLiveData<>();
        }
        this.note.setValue(note);
    }

    public MutableLiveData<String> getNote() {
        if (note == null) {
            note = new MutableLiveData<>();
        }
        return note;
    }

    public void addToFullNote(String note) {
        if (this.fullNote == null) {
            this.fullNote = new MutableLiveData<>();
            this.fullNote.setValue("");
        }
        this.fullNote.setValue(this.fullNote.getValue() + note + "\n\n");
    }

    public MutableLiveData<String> getFullNote() {
        if (fullNote == null) {
            fullNote = new MutableLiveData<>();
        }
        return fullNote;
    }
}
