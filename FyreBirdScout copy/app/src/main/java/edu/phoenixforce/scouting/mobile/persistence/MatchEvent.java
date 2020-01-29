package edu.phoenixforce.scouting.mobile.persistence;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.UUID;

@Entity(tableName = "match_event")
public class MatchEvent {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "event_id")
    private UUID eventId;

    @NonNull
    @ColumnInfo(name = "event_timestamp")
    private Calendar eventTimestamp;

    @NonNull
    @ColumnInfo(name = "match_id")
    private UUID matchId;

    @ColumnInfo(name = "event_type")
    private EventType eventType;

    @ColumnInfo(name = "comments")
    private String comments = new String();

    public MatchEvent(@NonNull UUID matchId) {
        this.eventId = UUID.randomUUID();
        this.eventTimestamp = new GregorianCalendar();
        this.matchId = matchId;
        setEventType(EventType.MATCH);
    }

    @NonNull
    public UUID getEventId() {
        return eventId;
    }

    @NonNull
    public Calendar getEventTimestamp() {
        return eventTimestamp;
    }

    @NonNull
    public UUID getMatchId() {
        return matchId;
    }

    protected void setMatchId(@NonNull UUID matchId) {
        this.matchId = matchId;
    }

    @NonNull
    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(@NonNull EventType eventType) {
        this.eventType = eventType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(@NonNull String comments) {
        this.comments = comments;
    }

}
