package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ListIterator;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models.Questions;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.repositori.QuestionRepository;

public class QuestionView extends AndroidViewModel {

    private MutableLiveData<String> currentEnQuestion;
    private MutableLiveData<String> currentEnQuestionOptionA;
    private MutableLiveData<String> currentEnQuestionOptionB;
    private MutableLiveData<String> currentEnQuestionOptionC;
    private MutableLiveData<String> currentEnQuestionOptionD;
    private MutableLiveData<String> currentIdQuestion;
    private MutableLiveData<String> currentIdQuestionOptionA;
    private MutableLiveData<String> currentIdQuestionOptionB;
    private MutableLiveData<String> currentIdQuestionOptionC;
    private MutableLiveData<String> currentIdQuestionOptionD;
    private String currentAnswer;
    private ListIterator<Questions> questionsIterator;
    private Boolean questionRunsOut;

    public QuestionView(@NonNull Application application) {
        super(application);
        QuestionRepository questionRepository = new QuestionRepository(application);
        questionsIterator = questionRepository.getAllQuestions().listIterator();
        questionRunsOut = false;
        nextQuestion();
    }

    private void setCurrentEnQuestion(String currentEnQuestion) {
        if (this.currentEnQuestion == null) {
            this.currentEnQuestion = new MutableLiveData<>();
        }
        this.currentEnQuestion.setValue(currentEnQuestion);
    }

    private void setCurrentEnQuestionOptionA(String optionA) {
        if (this.currentEnQuestionOptionA == null) {
            this.currentEnQuestionOptionA = new MutableLiveData<>();
        }
        this.currentEnQuestionOptionA.setValue(optionA);
    }

    private void setCurrentEnQuestionOptionB(String optionB) {
        if (this.currentEnQuestionOptionB == null) {
            this.currentEnQuestionOptionB = new MutableLiveData<>();
        }
        this.currentEnQuestionOptionB.setValue(optionB);
    }

    private void setCurrentEnQuestionOptionC(String optionC) {
        if (this.currentEnQuestionOptionC == null) {
            this.currentEnQuestionOptionC = new MutableLiveData<>();
        }
        this.currentEnQuestionOptionC.setValue(optionC);
    }

    private void setCurrentEnQuestionOptionD(String optionD) {
        if (this.currentEnQuestionOptionD == null) {
            this.currentEnQuestionOptionD = new MutableLiveData<>();
        }
        this.currentEnQuestionOptionD.setValue(optionD);
    }

    private void setCurrentIdQuestion(String currentIdQuestion) {
        if (this.currentIdQuestion == null) {
            this.currentIdQuestion = new MutableLiveData<>();
        }
        this.currentIdQuestion.setValue(currentIdQuestion);
    }

    private void setCurrentIdQuestionOptionA(String optionA) {
        if (this.currentIdQuestionOptionA == null) {
            this.currentIdQuestionOptionA = new MutableLiveData<>();
        }
        this.currentIdQuestionOptionA.setValue(optionA);
    }

    private void setCurrentIdQuestionOptionB(String optionB) {
        if (this.currentIdQuestionOptionB == null) {
            this.currentIdQuestionOptionB = new MutableLiveData<>();
        }
        this.currentIdQuestionOptionB.setValue(optionB);
    }

    private void setCurrentIdQuestionOptionC(String optionC) {
        if (this.currentIdQuestionOptionC == null) {
            this.currentIdQuestionOptionC = new MutableLiveData<>();
        }
        this.currentIdQuestionOptionC.setValue(optionC);
    }

    private void setCurrentIdQuestionOptionD(String optionD) {
        if (this.currentIdQuestionOptionD == null) {
            this.currentIdQuestionOptionD = new MutableLiveData<>();
        }
        this.currentIdQuestionOptionD.setValue(optionD);
    }

    private void setCurrentAnswer(String currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    private void setQuestionRunsOut(Boolean questionRunsOut) {
        this.questionRunsOut = questionRunsOut;
    }

    public MutableLiveData<String> getCurrentEnQuestion() {
        if (currentEnQuestion == null) {
            currentEnQuestion = new MutableLiveData<>();
        }
        return currentEnQuestion;
    }

    public MutableLiveData<String> getCurrentEnQuestionOptionA() {
        if (currentEnQuestionOptionA == null) {
            currentEnQuestionOptionA = new MutableLiveData<>();
        }
        return currentEnQuestionOptionA;
    }

    public MutableLiveData<String> getCurrentEnQuestionOptionB() {
        if (currentEnQuestionOptionB == null) {
            currentEnQuestionOptionB = new MutableLiveData<>();
        }
        return currentEnQuestionOptionB;
    }

    public MutableLiveData<String> getCurrentEnQuestionOptionC() {
        if (currentEnQuestionOptionC == null) {
            currentEnQuestionOptionC = new MutableLiveData<>();
        }
        return currentEnQuestionOptionC;
    }

    public MutableLiveData<String> getCurrentEnQuestionOptionD() {
        if (currentEnQuestionOptionD == null) {
            currentEnQuestionOptionD = new MutableLiveData<>();
        }
        return currentEnQuestionOptionD;
    }

    public MutableLiveData<String> getCurrentIdQuestion() {
        if (currentIdQuestion == null) {
            currentIdQuestion = new MutableLiveData<>();
        }
        return currentIdQuestion;
    }

    public MutableLiveData<String> getCurrentIdQuestionOptionA() {
        if (currentIdQuestionOptionA == null) {
            currentIdQuestionOptionA = new MutableLiveData<>();
        }
        return currentIdQuestionOptionA;
    }

    public MutableLiveData<String> getCurrentIdQuestionOptionB() {
        if (currentIdQuestionOptionB == null) {
            currentIdQuestionOptionB = new MutableLiveData<>();
        }
        return currentIdQuestionOptionB;
    }

    public MutableLiveData<String> getCurrentIdQuestionOptionC() {
        if (currentIdQuestionOptionC == null) {
            currentIdQuestionOptionC = new MutableLiveData<>();
        }
        return currentIdQuestionOptionC;
    }

    public MutableLiveData<String> getCurrentIdQuestionOptionD() {
        if (currentIdQuestionOptionD == null) {
            currentIdQuestionOptionD = new MutableLiveData<>();
        }
        return currentIdQuestionOptionD;
    }

    public String getCurrentAnswer() {
        return currentAnswer;
    }

    public void nextQuestion() {
        if (questionsIterator.hasNext()) {
            Questions question = questionsIterator.next();
            setCurrentEnQuestion(question.getEnContent());
            setCurrentEnQuestionOptionA(question.getEnOptionA());
            setCurrentEnQuestionOptionB(question.getEnOptionB());
            setCurrentEnQuestionOptionC(question.getEnOptionC());
            setCurrentEnQuestionOptionD(question.getEnOptionD());
            setCurrentIdQuestion(question.getIdContent());
            setCurrentIdQuestionOptionA(question.getIdOptionA());
            setCurrentIdQuestionOptionB(question.getIdOptionB());
            setCurrentIdQuestionOptionC(question.getIdOptionC());
            setCurrentIdQuestionOptionD(question.getIdOptionD());
            setCurrentAnswer(question.getAnswer());
            if (!questionsIterator.hasNext()){
                setQuestionRunsOut(true);
            }
        }
    }

    public Boolean isQuestionRunsOut() {
        return questionRunsOut;
    }
}
