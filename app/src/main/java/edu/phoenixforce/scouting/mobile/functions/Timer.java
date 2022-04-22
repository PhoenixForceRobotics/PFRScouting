package edu.phoenixforce.scouting.mobile.functions;

import java.util.Calendar;

//Could be used to count down time or see how long something took
//Could be used to remind users to change from autoscore with threading

public class Timer {

    public long miliTime;
    public int currentTime;

    public  void Timer(){

        Calendar calendar = Calendar.getInstance();
        miliTime =  calendar.getTimeInMillis();
        currentTime = (int)miliTime;







    }


}


//Smart goal note - Specific - measurable - agreed upon - resonable - timely *THIS HAS NOTHING TO DO WITH CODE*

// Academic goal - By the end of the semester I would like to be able to have a 4.0 GPA.
//Not - by the time we reach build season I would like to have a functional database that logs at least 15 variable that can be read back later..