package ru.kpfu.itis.group408.marushkai.service.interfaces;

import ru.kpfu.itis.group408.marushkai.domain.Comment;
import ru.kpfu.itis.group408.marushkai.domain.user.User;
import ru.kpfu.itis.group408.marushkai.form.AddNewsForm;
import ru.kpfu.itis.group408.marushkai.form.UpdateNewsForm;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

/**
 * Created by unlim_000 on 29.03.2016.
 */
public interface PostService<T> extends Serializable {
    void add(AddNewsForm toAdd);

    void update(UpdateNewsForm updateNewsForm) throws Exception;

    void deleteById(Integer id) throws Exception;

    void deleteByName(String name);

    T getByName(String name);

    T getById(Integer id) throws Exception;

    List<T> listContestants() throws ParseException;

    void addComment(Integer postID, String commentText, User user);

    List<Comment> getCommentsByPostId(Integer postId);

    void deleteComment(Integer commentId) throws Exception;
}
