package edu.phoenixforce.scouting.mobile.database.Repositories;

import android.app.Application;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import edu.phoenixforce.scouting.mobile.database.daos.AutoDao;
import edu.phoenixforce.scouting.mobile.database.entities.AutoData;

public class AutoRepo {

    private AutoDao Auto;
    private List<AutoData> todos;

    public AutoRepo(Application application){
        ScoreDataBase db = ScoreDataBase.getDatabase(application);
        Auto = db.autoDao();
        todos = Auto.getAllScores();

    }
    public List<AutoData> getTodos(){
        return todos;
    }

    public void insert(AutoData THE_DATA){
        ScoreDataBase.databaseWriteExecutor.execute(() -> {
            Auto.insertAll(THE_DATA);
        });
    }

}
