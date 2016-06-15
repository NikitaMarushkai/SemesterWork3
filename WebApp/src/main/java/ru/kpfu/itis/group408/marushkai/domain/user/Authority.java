package ru.kpfu.itis.group408.marushkai.domain.user;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by unlim_000 on 06.04.2016.
 */

@Entity
@Table(name = "authorities")
public class Authority implements Serializable {

    public Authority() {

    }

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "authority")
    private String authority;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public Authority(String authority, User user) {
        this.authority = authority;
        this.user = user;
    }

    public String getUsername() {
        return user.getUsername();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
