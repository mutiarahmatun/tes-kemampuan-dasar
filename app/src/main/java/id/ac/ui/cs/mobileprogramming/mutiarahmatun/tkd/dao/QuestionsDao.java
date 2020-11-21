package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models.Questions;

@Dao
public interface QuestionsDao {
    @Insert
    void insert(Questions questions);

    @Update
    void update(Questions questions);

    @Delete
    void delete(Questions questions);

    @Query("SELECT * FROM questions")
    List<Questions> getAllQuestions();
}
