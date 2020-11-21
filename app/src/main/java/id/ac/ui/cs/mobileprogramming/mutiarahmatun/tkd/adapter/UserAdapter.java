package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models.User;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.databinding.LeaderboardItemBinding;
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;

    public UserAdapter() {
        this.userList = new ArrayList<>();
    }

    public void setUsers(List<User> users) {
        this.userList = users;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return userList != null ? userList.size() : 0;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        LeaderboardItemBinding itemBinding = LeaderboardItemBinding.inflate(layoutInflater, parent, false);
        return new UserViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.bind(user);
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        private LeaderboardItemBinding binding;

        public UserViewHolder(LeaderboardItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(User user) {
            binding.setUser(user);
            binding.executePendingBindings();
        }
    }
}
