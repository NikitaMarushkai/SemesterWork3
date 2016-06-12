package ru.kpfu.itis.group408.marushkai.form;

/**
 * Created by unlim_000 on 06.06.2016.
 */
public class ModifyTimeTableForm {

    private String team1;
    private String team2;
    private String region;
    private String contestDate;
    private Integer chooseContestToEdit;
    private Integer deleteContest;

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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getContestDate() {
        return contestDate;
    }

    public void setContestDate(String contestDate) {
        this.contestDate = contestDate;
    }

    public Integer getChooseContestToEdit() {
        return chooseContestToEdit;
    }

    public void setChooseContestToEdit(Integer chooseContestToEdit) {
        this.chooseContestToEdit = chooseContestToEdit;
    }

    public Integer getDeleteContest() {
        return deleteContest;
    }

    public void setDeleteContest(Integer deleteContest) {
        this.deleteContest = deleteContest;
    }
}
