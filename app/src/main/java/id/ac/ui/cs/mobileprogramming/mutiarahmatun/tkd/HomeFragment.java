package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.interfaces.HomeInterface;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.databinding.FragmentHomeBinding;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.UserView;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProviders;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements HomeInterface{

    private UserView userView;
    private static final int GENERATE_NAME_LENGTH = 10;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentHomeBinding binding = FragmentHomeBinding.inflate(inflater, container, false);
        userView = ViewModelProviders.of(getActivity()).get(UserView.class);
        binding.setUserView(userView);
        binding.setLifecycleOwner(getActivity());
        binding.setHomeInterface(this);
        
        return binding.getRoot();
    }

    public void showLeaderboard() {

        getFragmentManager().beginTransaction()
                .replace(R.id.activityMain, LeaderboardFragment.newInstance())
                .addToBackStack(null)
                .commit();

    }

    public void exit() {
        getActivity().finish();
    }

    public void start() {
        Intent intent = new Intent(getActivity(), TKDActivity.class);
        intent.putExtra("username", userView.getName().getValue());
        startActivity(intent);
    }

    public void generateName(){
        String name = generateName(GENERATE_NAME_LENGTH);
        if (name.equals(userView.getName().getValue())){
            name = generateName(GENERATE_NAME_LENGTH + 10);
        }
        userView.setName(name);
    }

    public native String generateName(int length);
}