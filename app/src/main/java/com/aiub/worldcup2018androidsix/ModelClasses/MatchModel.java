package com.aiub.worldcup2018androidsix.ModelClasses;

public class MatchModel extends Team {
    private int matchName, stadiumId, homeTeam, awayTeam, homeResult, awayResult;
    private String matchStage, matchTime;

    public MatchModel(int matchName, int stadiumId, int homeTeam, int awayTeam, int homeResult, int awayResult, String matchStage, String matchTime) {
        this.matchName = matchName;
        this.stadiumId = stadiumId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeResult = homeResult;
        this.awayResult = awayResult;
        this.matchStage = matchStage;
        this.matchTime = matchTime;
    }

    public MatchModel() {

    }

    public int getMatchName() {
        return matchName;
    }

    public void setMatchName(int matchName) {
        this.matchName = matchName;
    }

    public int getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(int stadiumId) {
        this.stadiumId = stadiumId;
    }

    public int getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(int homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(int awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeResult() {
        return homeResult;
    }

    public void setHomeResult(int homeResult) {
        this.homeResult = homeResult;
    }

    public int getAwayResult() {
        return awayResult;
    }

    public void setAwayResult(int awayResult) {
        this.awayResult = awayResult;
    }

    public String getMatchStage() {
        return matchStage;
    }

    public void setMatchStage(String matchStage) {
        this.matchStage = matchStage;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }
}
