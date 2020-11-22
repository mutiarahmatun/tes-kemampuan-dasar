package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import android.app.Application;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.R;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models.User;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.repositori.MedalRepository;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.repositori.UserRepository;

public class UserView extends AndroidViewModel {
    private MutableLiveData<Integer> poin;
    private MutableLiveData<String> name;
    private UserRepository userRepository;
    private MedalRepository medalRepository;

    public UserView (@NonNull Application apps) {
        super(apps);
        userRepository = new UserRepository(apps);
        medalRepository = new MedalRepository(apps);
        addPoin(0);
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

    public void saveData() {
        String name = this.name.getValue().equals("") ?
                getApplication().getResources().getString(R.string.anonymous) : this.name.getValue();
        userRepository.insert(new User(name, this.poin.getValue(),
                medalRepository.getFirstMedalLessThanScore(this.poin.getValue()).getId()));
    }

    public LiveData<List<User>> getAllUsers() {
        return userRepository.getAllUsers();
    }

}
