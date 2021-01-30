package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.R;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.dao.MedalDao;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.dao.QuestionsDao;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.dao.UserDao;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models.Medal;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models.Questions;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.models.User;

@Database(entities = {Medal.class, Questions.class, User.class}, version = 1)
public abstract class TKDDatabase extends RoomDatabase {

    private static TKDDatabase database;

    public abstract MedalDao medalDao();
    public abstract QuestionsDao questionsDao();
    public abstract UserDao userDao();

    public static synchronized TKDDatabase getDatabase(Context context){
        if (database == null){
            database = Room.databaseBuilder(context.getApplicationContext(),
                    TKDDatabase.class, "tkd_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .allowMainThreadQueries()
                    .build();
        }
        return database;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(database).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private MedalDao medalDao;
        private QuestionsDao questionDao;

        private PopulateDbAsyncTask(TKDDatabase db) {
            medalDao = db.medalDao();
            questionDao = db.questionsDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //Populate Medal
           medalDao.insert(new Medal("Gold", R.drawable.medal_gold, 1800));
           medalDao.insert(new Medal("Silver", R.drawable.medal_silver,800));
           medalDao.insert(new Medal("Bronze", R.drawable.medal_bronze,0));

            //Populate Question and Option
            questionDao.insert(
                    new Questions(
                            "If you had only one match, then entered a dark room containing " +
                                    "an oil lamp, some newspaper, and some kindling wood, which " +
                                    "would you light first?",
                            "Oil Lamp",
                            "Match",
                            "Wood",
                            "Newspaper",
                            "Jika kamu memiliki sebuah korek, kemudian memasuki sebuah ruangan " +
                                    "yang di dalamnya terdapat lampu minyak, beberapa koran, beberapa kayu " +
                                    "bakar, apa yang akan kamu nyalakan terlebih dahulu?",
                            "Lampu minyak",
                            "Korek",
                            "Kayu",
                            "Koran",
                            "B"
                    )
            );

            questionDao.insert(
                    new Questions(
                            "During which month do people sleep the least?",
                            "December",
                            "October",
                            "February",
                            "January",
                            "Pada bulan apa orang-orang paling sedikit tidur?",
                            "Desember",
                            "Oktober",
                            "Februari",
                            "Januari",
                            "C"
                    )
            );

            questionDao.insert(
                    new Questions(
                            "5 cats eat 5 fishes in 5 minutes. 200 cats eat 200 fishes " +
                                    "in how many minutes?",
                            "1 minute",
                            "200 minute",
                            "5 minute",
                            "0 minute",
                            "5 kucing memakan 5 ikan dalam 5 menit. Berapa menit waktu " +
                                    "yang dibutuhkan 200 kucing untuk memakan 200 ikan?",
                            "1 menit",
                            "200 menit",
                            "5 menit",
                            "0 menit",
                            "C"
                    )
            );

            questionDao.insert(
                    new Questions(
                            "How many times does the alphabet a appear from 0-200?",
                            "0",
                            "28",
                            "75",
                            "100",
                            "Berapa kali huruf a muncul dari 0-200?",
                            "0",
                            "28",
                            "75",
                            "100",
                            "A"
                    )
            );

            questionDao.insert(
                    new Questions(
                            "If there are 12 fish and half of them drown, how many are there?",
                            "6",
                            "10",
                            "3",
                            "12",
                            "Jika ada 12 ikan dan separuh dari mereka tenggelam, ada berapa ikan disana?",
                            "6",
                            "10",
                            "3",
                            "12",
                            "D"
                    )
            );

            questionDao.insert(
                    new Questions(
                            "Which is heavier, 100 pounds of rocks or 100 pounds of feathers?",
                            "Rocks",
                            "Feathers",
                            "No one",
                            "Cottons",
                            "Manakah yang lebih berat, 100 pound batu atau 100 pound bulu?",
                            "Batu",
                            "Bulu",
                            "Tidak ada",
                            "Kapas",
                            "C"
                    )
            );

            questionDao.insert(
                    new Questions(
                            "How many times can you subtract 10 from 100?",
                            "10",
                            "5",
                            "2",
                            "1",
                            "Berapa kali kamu bisa mengurangi 10 dari 100?",
                            "10",
                            "5",
                            "2",
                            "1",
                            "D"
                    )
            );

            questionDao.insert(
                    new Questions(
                            "If you divide 30 by half and add ten, what do you get?",
                            "25",
                            "40",
                            "70",
                            "100",
                            "Jika kamu membagi 30 dengan setengah kemudian menambahkannya " +
                                    "dengan sepuluh, maka berapa hasilnya?",
                            "25",
                            "40",
                            "70",
                            "100",
                            "C"
                    )
            );

            questionDao.insert(
                    new Questions(
                            "If a doctor gives you 3 pills and tells you to take one " +
                                    "pill every half hour, how long would it take before all the " +
                                    "pills had been taken?",
                            "0.5 hour",
                            "1 hour",
                            "1.5 hour",
                            "2 hour",
                            "Jika seorang doktor memberimu 3 pil dan menyuruhmu untuk " +
                                    "makan satu pil setiap setengah jam, berapa lama waktu yang " +
                                    "dibutuhkan hingga semua pil termakan?",
                            "0.5 jam",
                            "1 jam",
                            "1.5 jam",
                            "2 jam",
                            "B"
                    )
            );

            questionDao.insert(
                    new Questions(
                            "Some months have 31 days, others have 30 days. How many have 28 days?",
                            "1",
                            "2",
                            "9",
                            "12",
                            "Beberapa bulan memiliki 31 hari, beberapa lainnya memiliki 30 hari. " +
                                    "Berapa banyak bulan yang memiliki 28 hari?",
                            "1",
                            "2",
                            "9",
                            "12",
                            "D"
                    )
            );

            return null;
        }

    }
}
