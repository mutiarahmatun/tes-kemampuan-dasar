package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models.Medal;

@Dao
public interface MedalDao {

    @Insert
    void insert(Medal medal);

    @Update
    void update(Medal medal);

    @Delete
    void delete(Medal medal);

    @Query("SELECT * FROM medal WHERE minScore<=:score ORDER BY minScore DESC")
    Medal getFirstMedalLessThanScore(int score);

}
