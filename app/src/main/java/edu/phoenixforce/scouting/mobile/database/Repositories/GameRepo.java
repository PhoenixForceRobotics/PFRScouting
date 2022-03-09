package edu.phoenixforce.scouting.mobile.database.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import android.os.AsyncTask;

import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import edu.phoenixforce.scouting.mobile.database.daos.GameDao;
import edu.phoenixforce.scouting.mobile.database.daos.TeleDao;
import edu.phoenixforce.scouting.mobile.database.entities.GameData;
import edu.phoenixforce.scouting.mobile.database.entities.TeleData;

public class GameRepo {

    private GameDao Game;
    private LiveData<List<GameData>> todos;

    public GameRepo(Application application) {
        //ScoreDataBase data = ScoreDataBase.getDatabase();
//        Game = data.gameDao();
      //  todos = Game.getAllScores();
    }

    // creating a method to insert the data to our database.
    public void insert(GameData gameData) {
        new InsertCourseAsyncTask(Game).execute(gameData);
    }


    public LiveData<List<GameData>> getGame() {
        return todos;
    }

   /* public void insert(GameData gameData){
        ScoreDataBase.databaseWriteExecutor.execute(() -> {
            Game.insertAll(gameData);
        });
    } */


    // we are creating a async task method to insert new course.
    private static class InsertCourseAsyncTask extends AsyncTask<GameData, Void, Void> {
        private GameDao gameDao;

        private InsertCourseAsyncTask(GameDao gameDao) {
            this.gameDao = gameDao;
        }

        @Override
        protected Void doInBackground(GameData... gameData) {
            // below line is use to insert our modal in dao.
            gameDao.insertAll(gameData[0]);
            return null;
        }
    }
}


