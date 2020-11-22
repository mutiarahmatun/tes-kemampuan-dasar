package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.adapter.UserAdapter;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.databinding.FragmentLeaderboardBinding;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models.User;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.UserView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeaderboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeaderboardFragment extends Fragment {

    private FragmentLeaderboardBinding leaderboard;

    public static LeaderboardFragment newInstance() {
        return new LeaderboardFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        leaderboard = FragmentLeaderboardBinding.inflate(inflater, container, false);
        setUpRecyclerView();
        return leaderboard.getRoot();
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = leaderboard.rvUserList;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        final UserAdapter adapter = new UserAdapter();
        recyclerView.setAdapter(adapter);

        UserView userView= ViewModelProviders.of(getActivity()).get(UserView.class);
        userView.getAllUsers().observe(getActivity(), new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                adapter.setUsers(users);
            }
        });
    }
}