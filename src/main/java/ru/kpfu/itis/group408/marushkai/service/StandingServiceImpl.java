package ru.kpfu.itis.group408.marushkai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.group408.marushkai.dao.StandingDAO;
import ru.kpfu.itis.group408.marushkai.domain.Standing;

import java.util.ArrayList;
import java.util.List;

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

    @Deprecated
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


}
