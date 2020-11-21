package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view;


import androidx.lifecycle.MutableLiveData;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import android.app.Application;

public class UserView extends AndroidViewModel {
    private MutableLiveData<Integer> poin;
    private MutableLiveData<String> name;

    public UserView (@NonNull Application apps) {
        super(apps);
    }

    public void addPoin(Integer poin) {
        if (this.poin == null) {
            this.poin = new MutableLiveData<>();
        }

        if (this.poin.getValue() == null){
            this.poin.setValue(poin);
            return;
        }
        
        this.poin.setValue(this.poin.getValue() + poin);
    }

    public MutableLiveData<Integer> getPoin() {
        if (poin == null) {
            poin = new MutableLiveData<>();
        }
        return poin;
    }

    public void setName(String name) {
        if (this.name == null) {
            this.name = new MutableLiveData<>();
        }
        this.name.setValue(name);
    }

    public MutableLiveData<String> getName() {
        if (name == null) {
            name = new MutableLiveData<>();
        }
        return name;
    }
}
