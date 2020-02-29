package edu.phoenixforce.scouting.mobile.database.adapters;


import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fyrebirdscout11.R;

import java.util.List;


import edu.phoenixforce.scouting.mobile.database.entities.TeleData;

public class TeleDataAdapter extends RecyclerView.Adapter<TeleDataAdapter.ViewHolder> {

    List<TeleData> teleDat;

    public TeleDataAdapter(List<TeleData> autoDat) {
        this.teleDat = teleDat;
    }

    @NonNull
    @Override
    public TeleDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeleDataAdapter.ViewHolder holder, int position) {





       holder.ballLow.setText(teleDat.get(position).getBallLow());
       holder.ballMid.setText(teleDat.get(position).getBallMid());
       holder.ballThree.setText(teleDat.get(position).getBallThree());
       holder.timeStamp.setText(teleDat.get(position).getTimeStamp());
       holder.missedShot.setText(teleDat.get(position).getMissedShot());










    }

    @Override
    public int getItemCount() {
        return teleDat.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView ballLow;
        public TextView ballMid;
        public TextView ballThree;
        public TextView timeStamp;
        public TextView missedShot;

        public ViewHolder(View itemView) {
            super(itemView);
        }


    }
}



