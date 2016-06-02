package ru.kpfu.itis.group408.marushkai.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by unlim_000 on 19.03.2016.
 */

@Entity
@Table(name = "POSTS")
public class Post implements Serializable {

    public Post() {
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CREATION_DATE")
    @GeneratedValue
    private String creationDate = new Date().toString();

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "CONTENT")
    private String content;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID")
    private transient Set<Comment> comments;


    public Post(String name, String image, String content) {
        this.name = name;
        this.image = image;
        this.content = content;
    }

    public Post(String name, String image, String content, Set<Comment> comments) {
        this.name = name;
        this.image = image;
        this.content = content;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
