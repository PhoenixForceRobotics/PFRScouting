package edu.phoenixforce.scouting.mobile.database.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.Repositories.ScoresRepository;
import edu.phoenixforce.scouting.mobile.database.entities.Scores;

public class ScoreViewModel extends AndroidViewModel {

    //bruh
    private ScoresRepository repository;
    private List<Scores> todos;

    public ScoreViewModel(Application application) {
        super(application);
        repository = new ScoresRepository(application);
        todos = repository.getTodos();
    }

    List<Scores> getTodos() {
        return todos;
    }

    public void insert(Scores YEEEEEEEEEEEEEEEEEEEEEEEEEEET){
        repository.insert(YEEEEEEEEEEEEEEEEEEEEEEEEEEET);
    }
}


