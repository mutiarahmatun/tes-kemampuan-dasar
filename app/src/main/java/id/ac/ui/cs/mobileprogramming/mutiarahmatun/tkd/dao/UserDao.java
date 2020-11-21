package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models.User;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * from user ORDER BY score DESC")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * from user ORDER BY score DESC LIMIT 1")
    User getFirstRank();
}
