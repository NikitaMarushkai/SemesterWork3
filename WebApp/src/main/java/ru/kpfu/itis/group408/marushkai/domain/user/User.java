package ru.kpfu.itis.group408.marushkai.domain.user;

import ru.kpfu.itis.group408.marushkai.domain.Comment;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by unlim_000 on 06.04.2016.
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

    public User() {

    }

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private int enabled;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;


    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "comment")
    private String comment;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private transient Set<Authority> authorities;

    @OneToOne
    @JoinColumn(name = "commentID")
    private Comment post_comment;

    public User(String username, String password, int enabled, String name, String surname, String patronymic, String email, String comment) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.email = email;
        this.comment = comment;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Comment getPost_comment() {
        return post_comment;
    }

    public void setPost_comment(Comment post_comment) {
        this.post_comment = post_comment;
    }
}
