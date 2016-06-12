package ru.kpfu.itis.group408.marushkai.domain;

import com.google.gwt.user.client.rpc.IsSerializable;
import ru.kpfu.itis.group408.marushkai.domain.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by unlim_000 on 01.06.2016.
 */
@Entity
@Table(name = "comments")
public class Comment implements IsSerializable, Serializable {

    public Comment() {
    }

    @Id
    @GeneratedValue
    @Column(name = "commentID")
    private Integer commentId;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "creationDate")
    private String creationDate = new Date().toString();

    @ManyToOne
    @JoinColumn(name = "ID")
    private Post post;

    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    public Comment(String text, Post post, User user) {
        this.text = text;
        this.post = post;
        this.user = user;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
