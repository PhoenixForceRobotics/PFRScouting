package edu.phoenixforce.scouting.mobile.database.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.Repositories.AutoRepo;
import edu.phoenixforce.scouting.mobile.database.entities.AutoData;

public class AutoView extends AndroidViewModel {

    //burhII
    private AutoRepo repos;
    private List<AutoData> todos;

    public AutoView(Application application){
        super(application);
        repos = new AutoRepo(application);
        todos = repos.getTodos();
    }

    List<AutoData> getTodos(){
        return todos;
    }

    public void insert(AutoData HI){
        repos.insert(HI);
    }
}
