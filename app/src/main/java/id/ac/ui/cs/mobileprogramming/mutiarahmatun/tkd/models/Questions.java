package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Questions {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String enContent;

    private String enOptionA;

    private String enOptionB;

    private String enOptionC;

    private String enOptionD;

    private String idContent;

    private String idOptionA;

    private String idOptionB;

    private String idOptionC;

    private String idOptionD;

    private String answer;

    public Questions(String enContent, String enOptionA, String enOptionB, String enOptionC, String enOptionD,
                    String idContent, String idOptionA, String idOptionB, String idOptionC, String idOptionD,
                    String answer){
        this.enContent = enContent;
        this.enOptionA = enOptionA;
        this.enOptionB = enOptionB;
        this.enOptionC = enOptionC;
        this.enOptionD = enOptionD;
        this.idContent = idContent;
        this.idOptionA = idOptionA;
        this.idOptionB = idOptionB;
        this.idOptionC = idOptionC;
        this.idOptionD = idOptionD;
        this.answer = answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public String getEnContent() {
        return enContent;
    }

    public String getEnOptionA() {
        return enOptionA;
    }

    public String getEnOptionB() {
        return enOptionB;
    }

    public String getEnOptionC() {
        return enOptionC;
    }

    public String getEnOptionD() {
        return enOptionD;
    }

    public String getIdContent() {
        return idContent;
    }

    public String getIdOptionA() {
        return idOptionA;
    }

    public String getIdOptionB() {
        return idOptionB;
    }

    public String getIdOptionC() {
        return idOptionC;
    }

    public String getIdOptionD() {
        return idOptionD;
    }
}
