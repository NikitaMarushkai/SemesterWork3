package ru.kpfu.itis.group408.marushkai.service.interfaces;

import ru.kpfu.itis.group408.marushkai.form.AddNewsForm;
import ru.kpfu.itis.group408.marushkai.form.UpdateNewsForm;

import java.io.Serializable;
import java.util.List;

/**
 * Created by unlim_000 on 29.03.2016.
 */
public interface PostService<T> extends Serializable {
    void add(AddNewsForm toAdd);

    void update(UpdateNewsForm updateNewsForm);

    void deleteById(Integer id) throws Exception;

    void deleteByName(String name);

    T getByName(String name);

    T getById(Integer id) throws Exception;

    List<T> listContestants();
}
