package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Medal.class,
        parentColumns = "id",
        childColumns = "medalId",
        onDelete = ForeignKey.CASCADE))

public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int score;
    private int medalId;

    public User(String name, int score, int medalId) {
        this.name = name;
        this.score = score;
        this.medalId = medalId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getMedalId() {
        return medalId;
    }

    public int getId() {
        return id;
    }
}
