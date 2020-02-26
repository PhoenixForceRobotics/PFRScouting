package edu.phoenixforce.scouting.mobile.database.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fyrebirdscout11.R;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.entities.Scores;

public class BallScoreAdapter extends RecyclerView.Adapter<BallScoreAdapter.ViewHolder> {

    List<Scores> ascores;

    public BallScoreAdapter(List<Scores> ascores) {
        this.ascores = ascores;
    }

    @NonNull
    @Override
    public BallScoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BallScoreAdapter.ViewHolder holder, int position) {

        holder.scout.setText(ascores.get(position).getScout());
    }

    @Override
    public int getItemCount() {
        return ascores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView scout;

        public ViewHolder(View itemView) {

            super(itemView);
            //scout = itemView.findViewById(R.id.Scout);

    }
    }
}
