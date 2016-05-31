package ru.kpfu.itis.group408.marushkai.form;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Created by unlim_000 on 09.05.2016.
 */
@Component
public class AddNewsForm implements Serializable {

    private String head;
    private String content;
    private MultipartFile image;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
