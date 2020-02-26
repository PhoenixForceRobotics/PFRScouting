package edu.phoenixforce.scouting.mobile.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class RoomRepository {

    private Color_Wheel_Dao mWordDao;
    private LiveData<List<color_wheel>> mAllWords;

    RoomRepository(Application application) {
        TheRoomDataBase db = TheRoomDataBase.getDatabase(application);
        mWordDao = db.RoomDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    LiveData<List<color_wheel>> getAllWords() {
        return mAllWords;
    }
    void insert(color_wheel color_wheel) {
        TheRoomDataBase.databaseWriteExecutor.execute(() -> {
            mWordDao.Insert(color_wheel);
        });
    }
}