package edu.phoenixforce.scouting.mobile.database.legacy.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.Repositories.TeleRepo;
import edu.phoenixforce.scouting.mobile.database.entities.TeleData;

public class TeleView extends AndroidViewModel {

    private TeleRepo repo;
    private LiveData<List<TeleData>> todos;

    public TeleView(Application application){
        super(application);
        repo = new TeleRepo();
        todos = repo.getTele();
    }

    LiveData<List<TeleData>> getTodos(){
        return todos;
    }

    public LiveData<List<TeleData>> getAllWords() { return todos; }

    public void insert(TeleData ESTOY_MUY_BIEN){
        repo.insert(ESTOY_MUY_BIEN);
    }

}
