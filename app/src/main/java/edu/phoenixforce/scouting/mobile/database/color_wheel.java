package edu.phoenixforce.scouting.mobile.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "Color Wheel")
public class color_wheel {

    public color_wheel(@NotNull String ColorWheelCanSpin, String ColorWheelCanTurnToColor) {
        this.ColorWheelCanSpin = ColorWheelCanSpin;
        this.ColorWheelCanTurnToColor = ColorWheelCanTurnToColor;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Can Spin Color Wheel")
    private String ColorWheelCanSpin;

    @ColumnInfo(name = "Can Spin to Color")
    private String ColorWheelCanTurnToColor;

    @NonNull
    public String getColorWheelCanSpin() {
        return ColorWheelCanSpin;
    }

    public String getColorWheelCanTurnToColor() {
        return ColorWheelCanTurnToColor;
    }

    public void setColorWheelCanSpin(@NonNull String colorWheelCanSpin) {
        this.ColorWheelCanSpin = colorWheelCanSpin;
    }

    public void setColorWheelCanTurnToColor(String colorWheelCanTurnToColor) {
        this.ColorWheelCanTurnToColor = colorWheelCanTurnToColor;
    }

}

