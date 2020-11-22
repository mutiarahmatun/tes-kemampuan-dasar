package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.tkd;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.databinding.FragmentTkdHeaderBinding;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.TimerView;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.UserView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TKDHeaderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TKDHeaderFragment extends Fragment {

    private TimerView timerView;
    private UserView userView;

    public static TKDHeaderFragment newInstance() {
        return new TKDHeaderFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);

        TKDActivity tkdActivity = (TKDActivity) getActivity();
        tkdActivity.startTimer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTkdHeaderBinding binding = FragmentTkdHeaderBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        timerView = ViewModelProviders.of(getActivity()).get(TimerView.class);
        binding.setTimerView(timerView);
        userView = ViewModelProviders.of(getActivity()).get(UserView.class);
        binding.setUserView(userView);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onDestroy() {
        TKDActivity tkdActivity= (TKDActivity) getActivity();
        tkdActivity.stopTimer();
        super.onDestroy();
    }
}