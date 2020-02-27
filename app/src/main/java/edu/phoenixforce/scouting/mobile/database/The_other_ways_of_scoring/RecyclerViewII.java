package edu.phoenixforce.scouting.mobile.database.The_other_ways_of_scoring;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fyrebirdscout11.R;

import java.util.List;

class ListAdapter extends RecyclerView.Adapter<ListAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textViewTwo);
        }
    }

    private final LayoutInflater mInflater;
    private List<ClimberScore> mWords;

    ListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item1, parent, false);
        return new WordViewHolder(itemView);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mWords == null) {
            holder.wordItemView.setText("No Word");
        } else {
            ClimberScore TheMostCurrent1 = mWords.get(position);
            ClimberScore current1 = mWords.get(position);
            ClimberScore lessCurrent1 = mWords.get(position);
            ClimberScore EvenLessCurrent1 = mWords.get(position);
            holder.wordItemView.setText(lessCurrent1.isBrokeDown() + ", " + current1.isCanBuddyClimb() + ", "
                    + EvenLessCurrent1.isCanClimb() + ", " + TheMostCurrent1.isDefenceMostOfTheTime() +" - "
            );

        }
    }

    void setWords(List<ClimberScore> words){
        mWords = words;
        notifyDataSetChanged();
    }



    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }

}