package ru.kpfu.itis.group408.marushkai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.group408.marushkai.dao.AdvertDao;
import ru.kpfu.itis.group408.marushkai.domain.Advert;
import ru.kpfu.itis.group408.marushkai.form.AddAdvertForm;
import ru.kpfu.itis.group408.marushkai.service.interfaces.AdvertService;
import ru.kpfu.itis.group408.marushkai.util.PropertiesWork;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by unlim_000 on 02.06.2016.
 */
@Service
public class AdvertServiceImpl implements AdvertService {

    @Autowired
    AdvertDao advertDao;

    @Override
    @Transactional
    public void add(AddAdvertForm advertForm) {
        Advert advert = new Advert();
        advert.setText(advertForm.getAdvText());
        advert.setLink(advertForm.getLinkText());
        MultipartFile file = advertForm.getImage();
        String newFileName = null;
        File directory;
        //Загружаем картинку
        if (!file.isEmpty()) {
            try {
                byte[] fileBytes = file.getBytes();
                directory = new File(PropertiesWork.getPath() + File.separator + "news_images");
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                //Гененрируем имя картинке
                newFileName = UUID.randomUUID().toString() + "." +
                        file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                File serverFile = new File(directory.getAbsolutePath() + File.separator + newFileName);
                //Сохраняем картинку
                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                    bos.write(fileBytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        advert.setImage("/images/news_images/" + newFileName);

        advertDao.add(advert);
    }

    @Override
    @Transactional
    public Advert get(Integer id) {
        return advertDao.getById(id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        advertDao.deleteById(id);
    }

    @Override
    @Transactional
    public List<Advert> getAll() {
        return advertDao.listContestants();
    }
}
