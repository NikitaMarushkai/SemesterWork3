package ru.kpfu.itis.group408.marushkai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.group408.marushkai.dao.StandingDAO;
import ru.kpfu.itis.group408.marushkai.domain.Standing;
import ru.kpfu.itis.group408.marushkai.form.EditTableForm;
import ru.kpfu.itis.group408.marushkai.service.interfaces.StandingService;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by unlim_000 on 25.03.2016.
 */
@Service
public class StandingServiceImpl implements StandingService<Standing> {

    @Autowired
    StandingDAO standingDAO;

    @Transactional
    @Override
    public void add(Standing toAdd) {
        standingDAO.add(toAdd);
    }

    @Deprecated
    @Override
    public void deleteById(Integer id) throws Exception {
        standingDAO.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByName(String name) {
        standingDAO.deleteByName(name);
    }

    @Transactional
    @Override
    public Standing getByName(String name) {
        return standingDAO.getByName(name);
    }

    @Override
    public Standing getById(Integer id) throws Exception {
        return standingDAO.getById(id);
    }

    @Transactional
    @Override
    public List<Standing> getWestSide() {
        List<Standing> all = standingDAO.listContestants();
        List<Standing> westSide = new ArrayList<>();
        for (Standing standing : all) {
            if (standing.getSide().equals("west")) {
                westSide.add(standing);
            }
        }
        return westSide;
    }

    @Transactional
    @Override
    public List<Standing> getEastSide() {
        List<Standing> all = standingDAO.listContestants();
        List<Standing> east = new ArrayList<>();
        for (Standing standing : all) {
            if (standing.getSide().equals("east")) {
                east.add(standing);
            }
        }
        return east;
    }

    @Override
    public void update(EditTableForm form) {
        Standing standing = standingDAO.getById(form.getTeamChooser());
        if (form.getBullitLosesNumber().length() != 0) {
            standing.setBullitFaults(parseInt(form.getBullitLosesNumber()));
        }
        if (form.getBullitWinsNumber().length() != 0) {
            standing.setBullitWins(parseInt(form.getBullitWinsNumber()));
        }
        if (form.getGamesNumber().length() != 0) {
            standing.setGames(parseInt(form.getGamesNumber()));
        }
        if (form.getLosesNumber().length() != 0) {
            standing.setFaults(parseInt(form.getLosesNumber()));
        }
        if (form.getOvertimeLosesNumber().length() != 0) {
            standing.setOverTimeFaults(parseInt(form.getOvertimeLosesNumber()));
        }
        if (form.getOvertimeWinsNumber().length() != 0) {
            standing.setOverTimeWins(parseInt(form.getOvertimeWinsNumber()));
        }
        if (form.getPointsNumber().length() != 0) {
            standing.setScore(parseInt(form.getPointsNumber()));
        }
        if (form.getTotalGoalsNumber().length() != 0) {
            standing.setGoals(parseInt(form.getTotalGoalsNumber()));
        }
        if (form.getWinsNumber().length() != 0) {
            standing.setWins(parseInt(form.getWinsNumber()));
        }
        standingDAO.updateStanding(standing);
    }


}
