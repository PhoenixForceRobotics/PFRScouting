package edu.phoenixforce.scouting.mobile.common;

public class Constants {
    String robotInfo;
    String userThoughts;
    String projectedCycleTime;
    String projectedClimbLevel;
    public void setRobotInfo(String text1) {
        this.robotInfo = text1;
    }

    public void setUserThoughts(String text2) {
        this.userThoughts = text2;
    }

    public void setProjectedCycleTime(String text3) { this.projectedCycleTime = text3; }

    public void setProjectedClimbLevel(String text4) { this.projectedClimbLevel = text4; }

    public String getRobotInfo() {
        return robotInfo;
    }

    public String getUserThoughts() {
        return userThoughts;
    }

    public String getProjectedCycleTime() { return projectedCycleTime; }

    public String getProjectedClimbLevel() { return projectedClimbLevel; }

    public static final int EXTERNAL_FILE_STORAGE_PERMISSION = 1;



}




