package edu.phoenixforce.scouting.mobile.database.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fyrebirdscout11.R;

import java.util.List;

import edu.phoenixforce.scouting.mobile.database.entities.Team;

public class TeamAdapter extends RecyclerView.Adapter<BallScoreAdapter.ViewHolder> {

    List<Team> ascores;

    public TeamAdapter(List<Team> ascores) {
        this.ascores = ascores;
    }

    @NonNull
    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull BallScoreAdapter.ViewHolder holder, int position) {

        holder.scout.setText(ascores.get(position).getTeamNum() + ascores.get(position).getMatchNum());
    }

    @Override
    public int getItemCount() {
        return ascores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView scout1;

        public ViewHolder(View itemView) {

            super(itemView);
            //scout = itemView.findViewById(R.id.Scout);

        }
    }
}
