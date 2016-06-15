package ru.kpfu.itis.group408.marushkai.gwt.client.admincontent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

/**
 * Created by unlim_000 on 29.04.2016.
 */
public class AddPostTab {

    public FormPanel getAddPostForm() {
        VerticalPanel verticalPanel = new VerticalPanel();

        //Adding status label
        final Label status = new Label();
        verticalPanel.add(status);

        final FormPanel addingForm = new FormPanel();
        addingForm.setAction("/admin/addPost/news");
        addingForm.setMethod(FormPanel.METHOD_POST);
        addingForm.setEncoding(FormPanel.ENCODING_MULTIPART);

        //News name input
        final Label newsName = new Label("Имя новости");
        final TextBox nameContent = new TextBox();
        nameContent.getElement().setAttribute("type", "text");
        nameContent.setName("head");
        verticalPanel.add(newsName);
        verticalPanel.add(nameContent);

        //News content input
        final Label newsContentName = new Label("Содержание новости");
        final TextArea newsContent = new TextArea();
        newsContent.getElement().setAttribute("type", "text");
        newsContent.setName("content");
        newsContent.setCharacterWidth(150);
        newsContent.setVisibleLines(15);
        verticalPanel.add(newsContentName);
        verticalPanel.add(newsContent);

        //Picture upload
        final Label pictureLabel = new Label("Картинка к новости");
        final FileUpload fileUpload = new FileUpload();
        fileUpload.setName("image");
        verticalPanel.add(pictureLabel);
        verticalPanel.add(fileUpload);

        //Submit button
        final Button submit = new Button("Добавить новость");
        verticalPanel.add(submit);

        submit.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                String fileName = fileUpload.getFilename();
                if (fileName.length() == 0 || newsContent.getText().length() == 0 ||
                        nameContent.getText().length() == 0) {
                    status.setText("Заполните все поля!");
                    status.getElement().setClassName("error");
                } else {
                    addingForm.submit();
                }
            }
        });

        addingForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                status.setText("Новость добавлена!");
                status.getElement().setClassName("success");
                nameContent.setValue("");
                newsContent.setValue("");
            }
        });

        verticalPanel.setSpacing(10);
        addingForm.add(verticalPanel);

        return addingForm;
    }

}
