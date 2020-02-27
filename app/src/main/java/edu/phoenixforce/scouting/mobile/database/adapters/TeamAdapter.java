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

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    List<Team> ascores1;

    public TeamAdapter(List<Team> ascores) {
        this.ascores1 = ascores;
    }

    @NonNull
    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.ViewHolder holder, int position) {

        holder.scout1.setText(ascores1.get(position).getTeamNum() + ascores1.get(position).getMatchNum());
    }

    @Override
    public int getItemCount() {
        return ascores1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView scout1;

        public ViewHolder(View itemView) {

            super(itemView);
            //scout = itemView.findViewById(R.id.Scout);

        }
    }
}
