package ru.kpfu.itis.group408.marushkai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.group408.marushkai.dao.TeamDAO;
import ru.kpfu.itis.group408.marushkai.domain.Team;
import ru.kpfu.itis.group408.marushkai.service.interfaces.TeamService;

import java.util.List;

/**
 * Created by unlim_000 on 25.03.2016.
 */
@Service
public class TeamServiceImpl implements TeamService<Team> {

    @Autowired
    TeamDAO teamDAO;

    @Transactional
    @Override
    public void add(Team toAdd) {
        teamDAO.add(toAdd);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) throws Exception {
        teamDAO.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByName(String name) {
        teamDAO.deleteByName(name);
    }

    @Transactional
    @Override
    public Team getByName(String name) {
        return teamDAO.getByName(name);
    }

    @Transactional
    @Override
    public Team getById(Integer id) throws Exception {
        return teamDAO.getById(id);
    }

    @Transactional
    @Override
    public List<Team> listContestants() {
        return teamDAO.listContestants();
    }
}
