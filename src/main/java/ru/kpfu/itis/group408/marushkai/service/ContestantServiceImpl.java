package ru.kpfu.itis.group408.marushkai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.group408.marushkai.dao.ContestantDAO;
import ru.kpfu.itis.group408.marushkai.domain.Contestant;

import java.util.List;

/**
 * Created by unlim_000 on 25.03.2016.
 */
@Service
public class ContestantServiceImpl implements ContestantService<Contestant> {

    @Autowired
    ContestantDAO contestantDAO;

    @Transactional
    @Override
    public void add(Contestant toAdd) {
        contestantDAO.add(toAdd);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) throws Exception {
        contestantDAO.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByName(String name) {
        contestantDAO.deleteByName(name);
    }

    @Transactional
    @Override
    public Contestant getByName(String name) {
        return contestantDAO.getByName(name);
    }

    @Transactional
    @Override
    public Contestant getById(Integer id) throws Exception {
        return contestantDAO.getById(id);
    }

    @Transactional
    @Override
    public List<Contestant> listContestants() {
        return contestantDAO.listContestants();
    }
}
