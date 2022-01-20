/*package edu.phoenixforce.scouting.mobile.database.adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fyrebirdscout11.R;

import java.util.List;


import edu.phoenixforce.scouting.mobile.database.entities.GameData;
import edu.phoenixforce.scouting.mobile.database.entities.TeleData;
import edu.phoenixforce.scouting.mobile.layouts.TeleScore;

public class GameDataAdapter extends RecyclerView.Adapter<GameDataAdapter.ViewHolder> {

    List<GameData> gameDat;
    private final LayoutInflater Layout;

    public GameDataAdapter(Context context) {
        Layout = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public GameDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item32, parent, false);
        return new ViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull GameDataAdapter.ViewHolder holder, int position) {

        if (gameDat == null) {
            holder.textView.setText("No Word");
        } else {

            GameData currentMatchNum = gameDat.get(position);
            GameData currentTeamNum = gameDat.get(position);
            GameData currentMoved = gameDat.get(position);
            GameData currentStalled = gameDat.get(position);
            GameData currentClimbLow = gameDat.get(position);
            GameData currentClimbMid = gameDat.get(position);
            GameData currentClimbHigh = gameDat.get(position);
            GameData currentClimbHigher = gameDat.get(position);
            GameData currentBallLow = gameDat.get(position);
            GameData currentBallHigh = gameDat.get(position);
            GameData currentAutoBallHigh = gameDat.get(position);
            GameData currentAutoBallLow = gameDat.get(position);
            GameData currentDevNum = gameDat.get(position);
            GameData currentScout = gameDat.get(position);
            holder.textView.setText("Scout + ", currentMatchNum.getMatchNum());

            /*
           TeleData TheMostCurrent1 = teleDat.get(position);
            TeleData current1 = teleDat.get(position);
            TeleData lessCurrent1 = teleDat.get(position);
            TeleData EvenLessCurrent1 = teleDat.get(position);
            TeleData TheMostCurrent = teleDat.get(position);
            TeleData current = teleDat.get(position);
            TeleData lessCurrent = teleDat.get(position);
            TeleData EvenLessCurrent = teleDat.get(position);
            TeleData TheEvenMostCurrent = teleDat.get(position);
            TeleData TheLeastCurrent = teleDat.get(position);
            TeleData TheLeasterCurrent = teleDat.get(position);
            holder.ItemView.setText("Time: " + TheLeasterCurrent.getMatch() + " - Ball Low: " + current1.getBallLow() + " - Ball Mid: "
                    + EvenLessCurrent1.getBallMid() + " - Ball High: " + TheMostCurrent1.getBallThree() +
                    " - Balls Intook: " + TheEvenMostCurrent.getBallsIntook() + " - Shots Missed: " + lessCurrent1.getShotsMissed()
                    + " - Robot Broke Down: " + TheMostCurrent.getRobotBroken() + " - Solo: " + current.getSoloClimb() + " - Spun to color: " +
                    lessCurrent.getSpunWheelColor() + " - Buddy Climb: " + EvenLessCurrent.getBuddyClimb() + " - Spun Wheel: " +
                    TheLeastCurrent.getSpunWheelTimes()
            );

        }

        /*
        holder.ballLow.setText("No Word");
        holder.ballMid.setText("No Word");
        holder.ballThree.setText("No Word");
        holder.buddyClimb.setText("No Word");
        holder.robotBroke.setText("No Word");
        holder.soloClimb.setText("No Word");
        holder.spunThreeTimes.setText("No Word");
        holder.spuncolor.setText("No Word");
        if (teleDat == null) {
            holder.ballLow.setText("No Word");
            holder.ballMid.setText("No Word");
            holder.ballThree.setText("No Word");
            holder.buddyClimb.setText("No Word");
            holder.robotBroke.setText("No Word");
            holder.soloClimb.setText("No Word");
            holder.spunThreeTimes.setText("No Word");
            holder.spuncolor.setText("No Word");
        } else {
       holder.ballLow.setText(teleDat.get(position).getBallLow());
       holder.ballMid.setText(teleDat.get(position).getBallMid());
       holder.ballThree.setText(teleDat.get(position).getBallThree());
       holder.buddyClimb.setText(teleDat.get(position).getBuddyClimb());
       holder.robotBroke.setText(teleDat.get(position).getRobotBroken());
       holder.soloClimb.setText(teleDat.get(position).getSoloClimb());
       holder.spuncolor.setText(teleDat.get(position).getSpunWheelColor());
       holder.spunThreeTimes.setText(teleDat.get(position).getSpunWheelTimes());
       }

         */
            //holder.timeStamp.setText(teleDat.get(position).getTimeStamp());
            //holder.missedShot.setText(teleDat.get(position).getMissedShot());
      /*   }


        @Override
        public int getItemCount () {
            if (gameDat != null)
                return gameDat.size();
            else return 0;
        }

        public void setData1 (List < GameData > data) {
            gameDat = data;
            notifyDataSetChanged();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView textView;

            private ViewHolder(View itemView) {
                super(itemView);
                //textView = textView.findViewById(R.id.textView11);
            }
        }

/*
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView ballLow;
        public TextView ballMid;
        public TextView ballThree;
        public TextView soloClimb;
        public TextView buddyClimb;
        public TextView robotBroke;
        public TextView spuncolor;
        public TextView spunThreeTimes;
        public TextView timeStamp;
        public TextView missedShot;

        public ViewHolder(View itemView) {
            super(itemView);
        }


    }


    }
}

*/

