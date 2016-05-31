package ru.kpfu.itis.group408.marushkai.gwt.client.admincontent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import ru.kpfu.itis.group408.marushkai.domain.Post;
import ru.kpfu.itis.group408.marushkai.gwt.client.AddPostService;
import ru.kpfu.itis.group408.marushkai.gwt.client.AddPostServiceAsync;

import java.util.List;

/**
 * Created by unlim_000 on 29.04.2016.
 */
public class EditPostTab {

    private AddPostServiceAsync addPostService = GWT.create(AddPostService.class);
    private AsyncCallback<List<Post>> callback;

    public FormPanel getEditPostTab() {
        VerticalPanel vPanel = new VerticalPanel();
        vPanel.setSpacing(10);

        //Adding head and status
        final Label head = new Label("Редактирование новостей");
        final Label status = new Label();
        vPanel.add(head);
        vPanel.add(status);

        final FormPanel editNews = new FormPanel();
        editNews.setAction("/admin/editForm");
        editNews.setMethod(FormPanel.METHOD_POST);
        editNews.setEncoding(FormPanel.ENCODING_MULTIPART);

        final ListBox listNews = new ListBox();


        callback = new AsyncCallback<List<Post>>() {

            @Override
            public void onFailure(Throwable caught) {
                status.setText("Ошибка в загрузке списка новостей");
            }

            @Override
            public void onSuccess(List<Post> result) {
                for (Post post : result) {
                    listNews.addItem(post.getName(), String.valueOf(post.getId()));
                }
            }
        };

        listNews.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                addPostService.getAllPosts(callback);
            }
        });

        //Adding choose news input
        final Label chooseNewsLabel = new Label("Выберите новость");
        listNews.setVisibleItemCount(0);
        listNews.setName("newsChooser");
        vPanel.add(chooseNewsLabel);
        vPanel.add(listNews);

        //Adding edit head input
        final Label editHeadLabel = new Label("Изменение имени новости");
        final TextBox editHeadText = new TextBox();
        editHeadText.getElement().setAttribute("type", "text");
        editHeadText.setName("editHead");
        vPanel.add(editHeadLabel);
        vPanel.add(editHeadText);

        //Adding edit content input
        final Label editContentLabel = new Label("Изменение содержания новости");
        final TextBox editContentText = new TextBox();
        editContentText.getElement().setAttribute("type", "text");
        editContentText.setName("editContent");
        vPanel.add(editContentLabel);
        vPanel.add(editContentText);

        //Adding edit photo input
        final Label editPhotoLabel = new Label("Изменение фотографии новости");
        final FileUpload newsFileUpload = new FileUpload();
        newsFileUpload.setName("editPhoto");
        vPanel.add(editPhotoLabel);
        vPanel.add(newsFileUpload);

        //Adding complete button
        final Button submitButton = new Button("Подтвердить");
        vPanel.add(submitButton);


        //Add hidden field for deleting of the post
        final Hidden hiddenField = new Hidden();
        hiddenField.setVisible(false);
        hiddenField.setName("delete");
        hiddenField.getElement().setAttribute("type", "text");
        final Button deleteButton = new Button("Удалить новость");
        vPanel.add(hiddenField);

        submitButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                hiddenField.setValue("0");
                editNews.submit();
            }
        });

        deleteButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                hiddenField.setValue("1");
                status.setText("Новость удалена");
                editNews.submit();
            }
        });

        vPanel.add(deleteButton);

        editNews.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                status.setText("Новость обновлена");
                editHeadText.setValue("");
                editContentText.setValue("");
            }
        });

        editNews.add(vPanel);


        return editNews;
    }
}
