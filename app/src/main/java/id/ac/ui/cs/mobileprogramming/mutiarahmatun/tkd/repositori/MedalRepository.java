package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.repositori;

import android.app.Application;
import android.os.AsyncTask;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.dao.MedalDao;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.database.TKDDatabase;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models.Medal;

public class MedalRepository {
    private MedalDao medalDao;

    public MedalRepository(Application apps) {
        TKDDatabase database = TKDDatabase.getDatabase(apps);
        medalDao = database.medalDao();
    }

    public void insert(Medal medal) {
        new InsertMedalAsyncTask(medalDao).execute(medal);
    }

    public void update(Medal medal) {
        new UpdateMedalAsyncTask(medalDao).execute(medal);
    }

    public void delete(Medal medal) {
        new DeleteMedalAsyncTask(medalDao).execute(medal);
    }

    public Medal getFirstMedalLessThanScore(int score){
        return medalDao.getFirstMedalLessThanScore(score);
    }

    private static class InsertMedalAsyncTask extends AsyncTask<Medal, Void, Void> {
        private MedalDao medalDao;

        private InsertMedalAsyncTask(MedalDao medalDao) {
            this.medalDao = medalDao;
        }

        @Override
        protected Void doInBackground(Medal... medals) {
            medalDao.insert(medals[0]);
            return null;
        }
    }

    private static class UpdateMedalAsyncTask extends AsyncTask<Medal, Void, Void> {
        private MedalDao medalDao;

        private UpdateMedalAsyncTask(MedalDao medalDao) {
            this.medalDao = medalDao;
        }

        @Override
        protected Void doInBackground(Medal... medals) {
            medalDao.update(medals[0]);
            return null;
        }
    }

    private static class DeleteMedalAsyncTask extends AsyncTask<Medal, Void, Void> {
        private MedalDao medalDao;

        private DeleteMedalAsyncTask(MedalDao medalDao) {
            this.medalDao = medalDao;
        }

        @Override
        protected Void doInBackground(Medal... medals) {
            medalDao.delete(medals[0]);
            return null;
        }
    }
}
