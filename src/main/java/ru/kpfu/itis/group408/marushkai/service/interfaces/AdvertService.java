package ru.kpfu.itis.group408.marushkai.service.interfaces;

import ru.kpfu.itis.group408.marushkai.domain.Advert;
import ru.kpfu.itis.group408.marushkai.form.AddAdvertForm;

import java.util.List;

/**
 * Created by unlim_000 on 02.06.2016.
 */
public interface AdvertService {

    void add(AddAdvertForm advert);

    Advert get(Integer id);

    void delete(Integer id);

    List<Advert> getAll();


}
