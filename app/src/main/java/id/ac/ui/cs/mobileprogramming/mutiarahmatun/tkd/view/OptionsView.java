package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OptionsView extends ViewModel {

    public static final String OPTION_A = "A";
    public static final String OPTION_B = "B";
    public static final String OPTION_C = "C";
    public static final String OPTION_D = "D";

    private MutableLiveData<String> optionChecked;

    public void setOptionChecked(String optionChecked) {
        if (this.optionChecked == null) {
            this.optionChecked = new MutableLiveData<>();
        }
        this.optionChecked.setValue(optionChecked);
    }

    public MutableLiveData<String> getOptionChecked() {
        if (optionChecked == null) {
            optionChecked = new MutableLiveData<>();
        }
        return optionChecked;
    }

}
