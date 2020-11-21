package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.tkd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.databinding.FragmentPermissionExplanationBinding;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.interfaces.PermissionExplanationInterface;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PermissionExplanationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PermissionExplanationFragment extends Fragment implements PermissionExplanationInterface {


    public static PermissionExplanationFragment newInstance() {
        return new PermissionExplanationFragment();
    }

    @Override
    public void back() {
        TKDActivity tkdActivity = (TKDActivity) getActivity();
        tkdActivity.back();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentPermissionExplanationBinding binding =
                FragmentPermissionExplanationBinding.inflate(inflater, container, false);
        binding.setPermissionExplanationInterface(this);
        return binding.getRoot();
    }
}