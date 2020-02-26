/*package edu.phoenixforce.scouting.mobile.database.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fyrebirdscout11.R;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.entities.AutoData;
import edu.phoenixforce.scouting.mobile.database.entities.Scores;

public class AutoDataAdapter extends RecyclerView.Adapter<AutoDataAdapter.ViewHolder> {

    List<AutoData> autoDat;

    public AutoDataAdapter(List<AutoData> autoDat) {
        this.autoDat = autoDat;
    }

    @NonNull
    @Override
    public AutoDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AutoDataAdapter.ViewHolder holder, int position) {

        holder.moved.setText(autoDat.get(position).getMoved());



       /*( this.moved = moved;
        this.lowBall = lowBall;
        this.midBall = midBall;
        this.highBall = highBall;
        this.touchedWheel = touchedWheel;
        \


    }

    @Override
    public int getItemCount() {
        return autoDat.size();
    }

    public class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public TextView moved;

        public ViewHolder() {


        }
    }
}
*/
