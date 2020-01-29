package edu.phoenixforce.scouting.mobile.persistence;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.UUID;

@Entity(tableName = "robot_event")
public class RobotEvent extends MatchEvent {

    @ColumnInfo(name = "robot_id")
    private int robotId;

    public RobotEvent(@NonNull UUID matchId, int robotId) {
        super(matchId);
        setEventType(EventType.ROBOT);
        this.robotId = robotId;
    }

    protected RobotEvent(@NonNull UUID matchId, int robotId, @NonNull EventType eventType) {
        super(matchId);
        setEventType(eventType);
        this.robotId = robotId;
    }

    public int getRobotId() {
        return robotId;
    }

    public void setRobotId(int robotId) {
        this.robotId = robotId;
    }

}
