package edu.phoenixforce.scouting.mobile.database.adapters;


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


import edu.phoenixforce.scouting.mobile.database.entities.TeleData;
import edu.phoenixforce.scouting.mobile.layouts.TeleScore;

public class TeleDataAdapter extends RecyclerView.Adapter<TeleDataAdapter.ViewHolder> {

    List<TeleData> teleDat;
    private final LayoutInflater Layout;

    public TeleDataAdapter(Context context) {
        Layout = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TeleDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item32, parent, false);
        return new ViewHolder(view);
    }
    

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull TeleDataAdapter.ViewHolder holder, int position) {

        if (teleDat == null) {
            holder.ItemView.setText("No Word");
        } else {
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
            holder.ItemView.setText("Time:" + TheLeasterCurrent.getMatch() + " - Ball Low:" + current1.getBallLow() + " - Ball Mid:"
                    + EvenLessCurrent1.getBallMid() + " - Ball High" + TheMostCurrent1.getBallThree() +
                    " - Balls Intook" + TheEvenMostCurrent.getBallsIntook() + " - Shots Missed" + lessCurrent1.getShotsMissed()
                    + " - Robot Broke Down:" + TheMostCurrent.getRobotBroken() + " - Solo" + current.getSoloClimb() + " - Spun to color" +
                    lessCurrent.getSpunWheelColor() + " - Buddy Climb" + EvenLessCurrent.getBuddyClimb() + " - Times Spun Wheel" +
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
    }

    @Override
    public int getItemCount() {
        if (teleDat != null)
            return teleDat.size();
        else return 0;
    }

    public void setData1(List<TeleData> data){
        teleDat = data;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView ItemView;

        private ViewHolder(View itemView) {
            super(itemView);
            ItemView = itemView.findViewById(R.id.textView11);
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
    
 */
}



