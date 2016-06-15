package ru.kpfu.itis.group408.marushkai.form;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by unlim_000 on 17.05.2016.
 */
public class UpdateNewsForm {


    private Integer newsChooser;
    private String editHead;
    private String editContent;
    private MultipartFile editPhoto;
    private Integer delete;

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public Integer getNewsChooser() {
        return newsChooser;
    }

    public void setNewsChooser(Integer newsChooser) {
        this.newsChooser = newsChooser;
    }

    public String getEditHead() {
        return editHead;
    }

    public void setEditHead(String editHead) {
        this.editHead = editHead;
    }

    public String getEditContent() {
        return editContent;
    }

    public void setEditContent(String editContent) {
        this.editContent = editContent;
    }

    public MultipartFile getEditPhoto() {
        return editPhoto;
    }

    public void setEditPhoto(MultipartFile editPhoto) {
        this.editPhoto = editPhoto;
    }
}
