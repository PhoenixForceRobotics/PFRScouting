package edu.phoenixforce.scouting.mobile.database.Repositories;

import android.app.Application;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import edu.phoenixforce.scouting.mobile.database.daos.DevDao;
import edu.phoenixforce.scouting.mobile.database.daos.TeamDao;
import edu.phoenixforce.scouting.mobile.database.entities.DevId;
import edu.phoenixforce.scouting.mobile.database.entities.Team;

public class TheFinalTwoRepos {

    private TeamDao teamDao;
    private DevDao devDao;

    private List<Team> todos;
    private List<DevId> todosII;

    public TheFinalTwoRepos(Application application){

        ScoreDataBase data = ScoreDataBase.getDatabase(application);
        devDao = data.devIdDao();
        teamDao = data.teamDao();

        todos = teamDao.getAllScores();
        todosII = devDao.getAllScores();
    }

    public List<Team> getTeamDao() {
        return todos;
    }

    public List<DevId> getDevDao() {
        return todosII;
    }

    public void insert(Team team){
        ScoreDataBase.databaseWriteExecutor.execute(() -> {
            teamDao.insertAll(team);
        });
    }

    public void insert(DevId team){
        ScoreDataBase.databaseWriteExecutor.execute(() -> {
            devDao.insertAll(team);
        });
    }
}
