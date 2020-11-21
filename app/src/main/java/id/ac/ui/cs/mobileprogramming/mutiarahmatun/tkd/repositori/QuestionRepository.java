package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.repositori;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.dao.QuestionsDao;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.database.TKDDatabase;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models.Questions;

public class QuestionRepository {

    private QuestionsDao questionsDao;

    public QuestionRepository(Application apps) {
        TKDDatabase database = TKDDatabase.getDatabase(apps);
        questionsDao = database.questionsDao();
    }

    public void insert(Questions questions) {
        new InsertQuestionAsyncTask(questionsDao).execute(questions);
    }

    public void update(Questions questions) {
        new UpdateQuestionAsyncTask(questionsDao).execute(questions);
    }

    public void delete(Questions questions) {
        new DeleteQuestionAsyncTask(questionsDao).execute(questions);
    }

    private static class InsertQuestionAsyncTask extends AsyncTask<Questions, Void, Void> {
        private QuestionsDao questionsDao;

        private InsertQuestionAsyncTask(QuestionsDao questionDao) {
            this.questionsDao = questionDao;
        }

        @Override
        protected Void doInBackground(Questions... questions) {
            questionsDao.insert(questions[0]);
            return null;
        }
    }

    private static class UpdateQuestionAsyncTask extends AsyncTask<Questions, Void, Void> {
        private QuestionsDao questionsDao;

        private UpdateQuestionAsyncTask(QuestionsDao questionsDao) {
            this.questionsDao = questionsDao;
        }

        @Override
        protected Void doInBackground(Questions... questions) {
            questionsDao.update(questions[0]);
            return null;
        }
    }

    private static class DeleteQuestionAsyncTask extends AsyncTask<Questions, Void, Void> {
        private QuestionsDao questionsDao;

        private DeleteQuestionAsyncTask(QuestionsDao questionsDao) {
            this.questionsDao = questionsDao;
        }

        @Override
        protected Void doInBackground(Questions... questions) {
            questionsDao.delete(questions[0]);
            return null;
        }
    }

    public List<Questions> getAllQuestions() {
        return questionsDao.getAllQuestions();
    }

}
