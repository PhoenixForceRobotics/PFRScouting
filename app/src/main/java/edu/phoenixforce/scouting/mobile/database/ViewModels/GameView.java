package edu.phoenixforce.scouting.mobile.database.ViewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.Repositories.GameRepo;
import edu.phoenixforce.scouting.mobile.database.Repositories.TeleRepo;
import edu.phoenixforce.scouting.mobile.database.entities.GameData;
import edu.phoenixforce.scouting.mobile.database.entities.TeleData;

public class GameView extends AndroidViewModel {

    private GameRepo gameRepo;
    private LiveData<List<GameData>> todos;

    public GameView(Application application){
        super(application);
        gameRepo = new GameRepo(application);
        todos = gameRepo.getGame();
    }

    LiveData<List<GameData>> getTodos(){
        return todos;
    }

    public LiveData<List<GameData>> getAllWords() { return todos; }

    public void insert(GameData ESTOY_MUY_BIEN){
        gameRepo.insert(ESTOY_MUY_BIEN);
    }

}
