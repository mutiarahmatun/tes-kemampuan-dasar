package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TimerView extends ViewModel {
    
    private MutableLiveData<Integer> time;
    private MutableLiveData<Boolean> timerFinished;

    public void setTime(Integer time) {
        if (this.time == null) {
            this.time = new MutableLiveData<>();
        }
        this.time.setValue(time);
    }

    public MutableLiveData<Integer> getTime() {
        if (time == null) {
            time = new MutableLiveData<>();
        }
        return time;
    }

    public void setTimerFinished(Boolean timerFinished) {
        if (this.timerFinished == null) {
            this.timerFinished = new MutableLiveData<>();
        }
        this.timerFinished.setValue(timerFinished);
    }

    public MutableLiveData<Boolean> getTimerFinished() {
        if (timerFinished == null){
            timerFinished = new MutableLiveData<>();
        }
        return timerFinished;
    }
}
