package edu.phoenixforce.scouting.mobile.persistence;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Entity(tableName = "control_panel_event")
public class ControlPanelEvent extends RobotEvent {

    @NotNull
    @ColumnInfo(name = "three_turns")
    private ActionAttempt threeTurns = ActionAttempt.NOT_ATTEMPTED;

    @NotNull
    @ColumnInfo(name = "spun_wheel")
    private ActionAttempt spunWheel = ActionAttempt.NOT_ATTEMPTED;

    public ControlPanelEvent(@NonNull UUID matchId, int robotId) {
        super(matchId, robotId, EventType.CONTROL_PANEL);
    }

    @NotNull
    public ActionAttempt getThreeTurns() {
        return threeTurns;
    }

    public void setThreeTurns(@NotNull ActionAttempt threeTurns) {
        this.threeTurns = threeTurns;
    }

    @NotNull
    public ActionAttempt getSpunWheel() {
        return spunWheel;
    }

    public void setSpunWheel(@NotNull ActionAttempt spunWheel) {
        this.spunWheel = spunWheel;
    }
}
