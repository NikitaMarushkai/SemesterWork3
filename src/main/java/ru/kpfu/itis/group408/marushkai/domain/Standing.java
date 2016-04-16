package ru.kpfu.itis.group408.marushkai.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by unlim_000 on 19.03.2016.
 */
@Entity
@Table(name = "standings")
public class Standing {

    @Id
    @Column(name = "team")
    private String team;

    @Column(name = "side")
    private String side;

    @Column(name = "games")
    private Integer games;

    @Column(name = "wins")
    private Integer wins;

    @Column(name = "overTimeWins")
    private Integer overTimeWins;

    @Column(name = "BullitWins")
    private Integer bullitWins;

    @Column(name = "BullitFaults")
    private Integer bullitFaults;

    @Column(name = "OverTimeFaults")
    private Integer overTimeFaults;

    @Column(name = "Faults")
    private Integer faults;

    @Column(name = "Goals")
    private Integer goals;

    @Column(name = "Score")
    private Integer score;

    public Standing(String team, String side, Integer games, Integer wins, Integer overTimeWins, Integer bullitWins, Integer bullitFaults, Integer overTimeFaults, Integer faults, Integer goals, Integer score) {
        this.team = team;
        this.side = side;
        this.games = games;
        this.wins = wins;
        this.overTimeWins = overTimeWins;
        this.bullitWins = bullitWins;
        this.bullitFaults = bullitFaults;
        this.overTimeFaults = overTimeFaults;
        this.faults = faults;
        this.goals = goals;
        this.score = score;
    }

    public Standing() {
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getOverTimeWins() {
        return overTimeWins;
    }

    public void setOverTimeWins(Integer overTimeWins) {
        this.overTimeWins = overTimeWins;
    }

    public Integer getBullitWins() {
        return bullitWins;
    }

    public void setBullitWins(Integer bullitWins) {
        this.bullitWins = bullitWins;
    }

    public Integer getBullitFaults() {
        return bullitFaults;
    }

    public void setBullitFaults(Integer bullitFaults) {
        this.bullitFaults = bullitFaults;
    }

    public Integer getOverTimeFaults() {
        return overTimeFaults;
    }

    public void setOverTimeFaults(Integer overTimeFaults) {
        this.overTimeFaults = overTimeFaults;
    }

    public Integer getFaults() {
        return faults;
    }

    public void setFaults(Integer faults) {
        this.faults = faults;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
