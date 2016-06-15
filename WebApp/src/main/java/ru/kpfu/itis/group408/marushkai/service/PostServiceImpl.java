package ru.kpfu.itis.group408.marushkai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.itis.group408.marushkai.annotation.TimeLog;
import ru.kpfu.itis.group408.marushkai.dao.PostDAO;
import ru.kpfu.itis.group408.marushkai.domain.Comment;
import ru.kpfu.itis.group408.marushkai.domain.Post;
import ru.kpfu.itis.group408.marushkai.domain.user.User;
import ru.kpfu.itis.group408.marushkai.form.AddNewsForm;
import ru.kpfu.itis.group408.marushkai.form.UpdateNewsForm;
import ru.kpfu.itis.group408.marushkai.service.interfaces.PostService;
import ru.kpfu.itis.group408.marushkai.util.PropertiesWork;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by unlim_000 on 25.03.2016.
 */
@Service
public class PostServiceImpl implements PostService<Post> {

    @Autowired
    PostDAO postDAO;

    @Transactional
    @Override
    @TimeLog
    public void add(AddNewsForm toAdd) {
        Post post = new Post();
        post.setName(toAdd.getHead());
        post.setContent(toAdd.getContent());
        post.setCreationDate(new DateFormatter("dd.MM.yyyy HH:mm").print(new Date(), Locale.getDefault()));
        MultipartFile file = toAdd.getImage();
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
        post.setImage("/images/news_images/" + newFileName);
        postDAO.add(post);
    }

    @Transactional
    @Override
    @TimeLog
    public void update(UpdateNewsForm updateNewsForm) throws Exception {
        Post post = postDAO.getById(updateNewsForm.getNewsChooser());
        System.out.println(post.getName());
        if (updateNewsForm.getDelete() == 1) {
            postDAO.deleteById(updateNewsForm.getNewsChooser());
        } else {
            if (updateNewsForm.getEditHead().length() != 0) {
                post.setName(updateNewsForm.getEditHead());
            }
            if (updateNewsForm.getEditContent().length() != 0) {
                post.setContent(updateNewsForm.getEditContent());
            }
            if (!updateNewsForm.getEditPhoto().isEmpty()) {
                new File(post.getImage()).delete();
                MultipartFile file = updateNewsForm.getEditPhoto();
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
                post.setImage("/images/news_images/" + newFileName);
            }
                postDAO.updatePost(post);
        }
    }

    @Transactional
    @Override
    public void deleteById(Integer id) throws Exception {
        postDAO.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByName(String name) {
        postDAO.deleteByName(name);
    }

    @Transactional
    @Override
    public Post getByName(String name) {
        return postDAO.getByName(name);
    }

    @Transactional
    @Override
    public Post getById(Integer id) throws Exception {
        return postDAO.getById(id);
    }

    @Transactional
    @Override
    public List<Post> listContestants() throws ParseException {
        return postDAO.listContestants();
    }

    @Transactional
    @Override
    public void addComment(Integer postID, String commentText, User user) {
        Comment comment = new Comment(commentText, postDAO.getById(postID), user);
        comment.setCreationDate(new DateFormatter("dd.MM.yyyy HH:mm").print(new Date(), Locale.getDefault()));
        postDAO.addComment(comment);
    }

    @Transactional
    @Override
    public List<Comment> getCommentsByPostId(Integer postId) {
        return postDAO.getCommentsByPostId(postId);
    }

    @Transactional
    @Override
    public void deleteComment(Integer commentId) throws Exception {
        postDAO.deleteCommentById(commentId);
    }


}
