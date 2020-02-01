package edu.phoenixforce.scouting.mobile.persistence;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Entity(tableName = "shield_generator_event")
public class ShieldGeneratorEvent extends RobotEvent {

    @NotNull
    @ColumnInfo(name = "helped_climb")
    private ActionAttempt helpedClimb = ActionAttempt.NOT_ATTEMPTED;

    @NotNull
    @ColumnInfo(name = "climbed")
    private ActionAttempt climbed = ActionAttempt.NOT_ATTEMPTED;

    @NotNull
    @ColumnInfo(name = "balanced")
    private ActionAttempt balanced = ActionAttempt.NOT_ATTEMPTED;

    public ShieldGeneratorEvent(@NonNull UUID matchId, int robotId) {
        super(matchId, robotId, EventType.SHIELD_GENERATOR);
    }

    @NotNull
    public ActionAttempt getHelpedClimb() {
        return helpedClimb;
    }

    public void setHelpedClimb(@NotNull ActionAttempt helpedClimb) {
        this.helpedClimb = helpedClimb;
    }

    @NotNull
    public ActionAttempt getClimbed() {
        return climbed;
    }

    public void setClimbed(@NotNull ActionAttempt climbed) {
        this.climbed = climbed;
    }

    @NotNull
    public ActionAttempt getBalanced() {
        return balanced;
    }

    public void setBalanced(@NotNull ActionAttempt balanced) {
        this.balanced = balanced;
    }
}
