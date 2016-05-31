package ru.kpfu.itis.group408.marushkai.domain;

import javax.persistence.*;
import java.io.Serializable;

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
    private String creationDate;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "CONTENT")
    private String content;

    public Post(String name, String image, String content) {
        this.name = name;
        this.image = image;
        this.content = content;
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
}
