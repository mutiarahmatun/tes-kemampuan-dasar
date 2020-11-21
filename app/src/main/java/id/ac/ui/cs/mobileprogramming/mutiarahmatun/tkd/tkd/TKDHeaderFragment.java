package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.tkd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TKDHeaderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TKDHeaderFragment extends Fragment {

    public static TKDHeaderFragment newInstance() {
        return new TKDHeaderFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tkd_header, container, false);
    }
}