package edu.phoenixforce.scouting.mobile.database.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import edu.phoenixforce.scouting.mobile.database.daos.BallDao;
import edu.phoenixforce.scouting.mobile.database.entities.Scores;

public class ScoresRepository {

    private BallDao score;
    private List<Scores> todos;

    public ScoresRepository(Application application){

        ScoreDataBase db = ScoreDataBase.getDatabase(application);
        score = db.ballDao();
        todos = score.getAllScores();
    }

    public List<Scores> getTodos(){
        return todos;
    }

    public void insert(Scores scores){
        ScoreDataBase.databaseWriteExecutor.execute(() -> {
            score.insertAll(scores);
        });
    }
}
