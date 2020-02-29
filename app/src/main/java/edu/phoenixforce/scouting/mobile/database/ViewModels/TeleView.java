package edu.phoenixforce.scouting.mobile.database.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.Repositories.TeleRepo;
import edu.phoenixforce.scouting.mobile.database.entities.TeleData;

public class TeleView extends AndroidViewModel {

    private TeleRepo repo;
    private List<TeleData> todos;

    public TeleView(Application application){
        super(application);
        repo = new TeleRepo(application);
        todos = repo.getTele();
    }

    List<TeleData> getTodos(){
        return todos;
    }

    public void insert(TeleData ESTOY_MUY_BIEN){
        repo.insert(ESTOY_MUY_BIEN);
    }

}
