package edu.phoenixforce.scouting.mobile.database.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import edu.phoenixforce.scouting.mobile.database.daos.PitDao;
import edu.phoenixforce.scouting.mobile.database.daos.TeleDao;
import edu.phoenixforce.scouting.mobile.database.entities.PitData;
import edu.phoenixforce.scouting.mobile.database.entities.TeleData;

public class PitRepo {

    private PitDao Pit;
    private List<PitData> todos;

    public PitRepo(Application application) {
        ScoreDataBase data = ScoreDataBase.getDatabase(application);
        Pit = data.pitDao();
        todos = Pit.getAllScores();
    }

    public List<PitData> getPit() {
        return todos;
    }

    public void insert(PitData pitData){
        ScoreDataBase.databaseWriteExecutor.execute(() -> {
            Pit.insertAll(pitData);
        });
    }
}
