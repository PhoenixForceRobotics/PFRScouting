package edu.phoenixforce.scouting.mobile.database.Repositories;

import android.app.Application;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import edu.phoenixforce.scouting.mobile.database.daos.TeleDao;
import edu.phoenixforce.scouting.mobile.database.entities.TeleData;

public class TeleRepo {

    private TeleDao Tele;
    private List<TeleData> todos;

    public TeleRepo(Application application) {
        ScoreDataBase data = ScoreDataBase.getDatabase(application);
        Tele = data.teleDao();
        todos = Tele.getAllScores();
    }

    public List<TeleData> getTele() {
        return todos;
    }

    public void insert(TeleData teleData){
        ScoreDataBase.databaseWriteExecutor.execute(() -> {
            Tele.insertAll(teleData);
        });
    }
}
