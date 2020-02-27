package edu.phoenixforce.scouting.mobile.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fyrebirdscout11.R;

import java.util.List;

class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<color_wheel> mWords; // Cached copy of words

    WordListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview, parent, false);
        return new WordViewHolder(itemView);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mWords != null) {
            color_wheel current = mWords.get(position);
            color_wheel lessCurrent = mWords.get(position);
            holder.wordItemView.setText(current.getColorWheelCanSpin() + ", "
                    + lessCurrent.getColorWheelCanTurnToColor());

        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
        }
    }
    /*
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mWords == null && mWords1 == null) {
            holder.wordItemView.setText("No Word");
        } else {
            ClimberScore TheMostCurrent1 = mWords.get(position);
            ClimberScore current1 = mWords.get(position);
            ClimberScore lessCurrent1 = mWords.get(position);
            ClimberScore EvenLessCurrent1 = mWords.get(position);
            color_wheel current = mWords1.get(position);
            color_wheel lessCurrent = mWords1.get(position);
            holder.wordItemView.setText(lessCurrent1.isBrokeDown() + ", " + current1.isCanBuddyClimb() + ", "
                    + EvenLessCurrent1.isCanClimb() + ", " + TheMostCurrent1.isDefenceMostOfTheTime() +" - " +
                    current.getColorWheelCanSpin() + ", " + lessCurrent.getColorWheelCanTurnToColor());

        }
    }
     */

    void setWords(List<color_wheel> words){
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