package edu.phoenixforce.scouting.mobile.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private RoomRepository mRepository;

    private LiveData<List<color_wheel>> mAllWords;

    public ViewModel(Application application) {
        super(application);
        mRepository = new RoomRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<color_wheel>> getAllWords() { return mAllWords; }

    public void insert(color_wheel E)
    { mRepository.insert(E); }

}