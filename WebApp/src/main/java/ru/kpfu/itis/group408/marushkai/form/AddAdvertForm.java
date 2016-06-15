package ru.kpfu.itis.group408.marushkai.form;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by unlim_000 on 02.06.2016.
 */
public class AddAdvertForm {

    private String advText;
    private MultipartFile image;
    private String linkText;
    private Integer delete;
    private Integer listAdv;

    public Integer getListAdv() {
        return listAdv;
    }

    public void setListAdv(Integer listAdv) {
        this.listAdv = listAdv;
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public String getAdvText() {
        return advText;
    }

    public void setAdvText(String advText) {
        this.advText = advText;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }
}
