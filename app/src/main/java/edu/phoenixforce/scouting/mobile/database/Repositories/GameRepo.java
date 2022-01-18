package edu.phoenixforce.scouting.mobile.database.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import edu.phoenixforce.scouting.mobile.database.daos.GameDao;
import edu.phoenixforce.scouting.mobile.database.daos.TeleDao;
import edu.phoenixforce.scouting.mobile.database.entities.GameData;
import edu.phoenixforce.scouting.mobile.database.entities.TeleData;

public class GameRepo {

    private GameDao Game;
    private LiveData<List<GameData>> todos;

    public GameRepo(Application application) {
        ScoreDataBase data = ScoreDataBase.getDatabase(application);
        Game = data.gameDao();
        //todos = Game.getAllScores();
    }

    public LiveData<List<GameData>> getGame() {
        return todos;
    }

    public void insert(GameData gameData){
        ScoreDataBase.databaseWriteExecutor.execute(() -> {
            Game.insert(gameData);
        });
    }
}
