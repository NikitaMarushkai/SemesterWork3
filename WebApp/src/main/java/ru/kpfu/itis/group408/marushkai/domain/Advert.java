package ru.kpfu.itis.group408.marushkai.domain;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by unlim_000 on 02.06.2016.
 */

@Entity
@Table(name = "advert")
public class Advert implements IsSerializable, Serializable {

    public Advert() {

    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "image")
    private String image;

    @Column(name = "link")
    private String link;

    public Advert(String text, String image, String link) {
        this.text = text;
        this.image = image;
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
