package edu.phoenixforce.scouting.mobile.database.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fyrebirdscout11.R;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.entities.DevId;

public class DevAdapter extends RecyclerView.Adapter<DevAdapter.ViewHolder> {

    List<DevId> devId;

    public DevAdapter(List<DevId> autoDat) {
        this.devId = autoDat;
    }

    @NonNull
    @Override
    public DevAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DevAdapter.ViewHolder holder, int position) {

        holder.DevId.setText(devId.get(position).getDevId());






    }

    @Override
    public int getItemCount() {
        return devId.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView DevId;


        public ViewHolder(View itemView) {
            super(itemView);
        }


    }
}
