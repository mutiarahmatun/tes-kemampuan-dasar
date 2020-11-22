package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.tkd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.databinding.FragmentTkdResultBinding;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.interfaces.TKDResultInterface;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.UserView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TKDResultFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TKDResultFragment extends Fragment implements TKDResultInterface {

    private UserView userView;

    public static TKDResultFragment newInstance() {
        return new TKDResultFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TKDActivity tkdActivity = (TKDActivity) getActivity();
        tkdActivity.stopTimer();
        userView = ViewModelProviders.of(getActivity()).get(UserView.class);
        if (savedInstanceState == null) {
            userView.saveData();
        }
    }

    @Override
    public void home(){
        getActivity().finish();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTkdResultBinding binding =
                FragmentTkdResultBinding.inflate(inflater, container, false);
        binding.setTKDResultInterface(this);
        binding.setUserView(userView);
        return binding.getRoot();
    }
}