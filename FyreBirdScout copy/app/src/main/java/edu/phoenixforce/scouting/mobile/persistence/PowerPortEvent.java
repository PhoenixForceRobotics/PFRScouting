package edu.phoenixforce.scouting.mobile.persistence;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.UUID;

@Entity(tableName = "power_port_event")
public class PowerPortEvent extends RobotEvent {

    @ColumnInfo(name = "inner_port_shot_count")
    private int innerPortShotCount;
    @ColumnInfo(name = "outer_port_shot_count")
    private int outerPortShotCount;
    @ColumnInfo(name = "bottom_port_shot_count")
    private int bottomPortShotCount;
    @ColumnInfo(name = "missed_shot_count")
    private int missedShotCount;

    public PowerPortEvent(@NonNull UUID matchId, int robotId) {
        super(matchId, robotId, EventType.POWER_PORT);
    }

    public int getInnerPortShotCount() {
        return innerPortShotCount;
    }

    public void setInnerPortShotCount(int innerPortShotCount) {
        this.innerPortShotCount = innerPortShotCount;
    }

    public int getOuterPortShotCount() {
        return outerPortShotCount;
    }

    public void setOuterPortShotCount(int outerPortShotCount) {
        this.outerPortShotCount = outerPortShotCount;
    }

    public int getBottomPortShotCount() {
        return bottomPortShotCount;
    }

    public void setBottomPortShotCount(int bottomPortShotCount) {
        this.bottomPortShotCount = bottomPortShotCount;
    }

    public int getMissedShotCount() {
        return missedShotCount;
    }

    public void setMissedShotCount(int missedShotCount) {
        this.missedShotCount = missedShotCount;
    }
}
