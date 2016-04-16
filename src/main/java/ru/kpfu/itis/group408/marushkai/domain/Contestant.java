package ru.kpfu.itis.group408.marushkai.domain;

import javax.persistence.*;

/**
 * Created by unlim_000 on 19.03.2016.
 */
@Entity
@Table(name = "CONTESTANTS")
public class Contestant {
    public Contestant() {
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "TEAM1")
    private String team1;

    @Column(name = "TEAM2")
    private String team2;

    @Column(name = "CONTEST")
    private String contest;

    @Column(name = "REGION")
    private String region;

    public Contestant(String team1, String team2, String contest, String region) {
        this.team1 = team1;
        this.team2 = team2;
        this.contest = contest;
        this.region = region;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getContest() {
        return contest;
    }

    public void setContest(String contest) {
        this.contest = contest;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
