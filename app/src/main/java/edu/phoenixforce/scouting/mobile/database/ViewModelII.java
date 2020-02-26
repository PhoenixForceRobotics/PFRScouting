package edu.phoenixforce.scouting.mobile.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModelII extends AndroidViewModel {

    private RoomRepositoryII mRepository;

    private LiveData<List<ClimberScore>> mAllWords;

    public ViewModelII(Application application) {
        super(application);
        mRepository = new RoomRepositoryII(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<ClimberScore>> getAllWords() { return mAllWords; }

    public void insert(ClimberScore what)
    { mRepository.insert(what); }

}