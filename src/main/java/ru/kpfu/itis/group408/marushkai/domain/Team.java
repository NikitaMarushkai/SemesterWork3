package ru.kpfu.itis.group408.marushkai.domain;

import com.google.gwt.user.client.rpc.IsSerializable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by unlim_000 on 19.03.2016.
 */
@Entity
@Table(name = "teams")
public class Team implements IsSerializable, Serializable {
    public Team() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "descr")
    private String descr;

    @Column(name = "site_link")
    private String siteLink;

    public Team(String name, String image, String descr, String siteLink) {
        this.name = name;
        this.image = image;
        this.descr = descr;
        this.siteLink = siteLink;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getSiteLink() {
        return siteLink;
    }

    public void setSiteLink(String siteLink) {
        this.siteLink = siteLink;
    }
}
