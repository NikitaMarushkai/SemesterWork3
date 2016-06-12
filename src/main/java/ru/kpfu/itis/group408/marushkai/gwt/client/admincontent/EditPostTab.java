package ru.kpfu.itis.group408.marushkai.gwt.client.admincontent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DatePicker;
import ru.kpfu.itis.group408.marushkai.domain.Post;
import ru.kpfu.itis.group408.marushkai.gwt.client.AddPostService;
import ru.kpfu.itis.group408.marushkai.gwt.client.AddPostServiceAsync;

import java.util.Date;
import java.util.List;

/**
 * Created by unlim_000 on 29.04.2016.
 */
public class EditPostTab {

    private AddPostServiceAsync addPostService = GWT.create(AddPostService.class);
    private AsyncCallback<List<Post>> callback;
    private AsyncCallback<List<Post>> callback1;

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

        final Label chooseDateLabel = new Label("Выберите границы дат для отображения новостей");
        final DatePicker fromDate = new DatePicker();
        final DatePicker toDate = new DatePicker();
        final Hidden dateFromHidden = new Hidden();
        dateFromHidden.getElement().setAttribute("type", "text");
        dateFromHidden.setName("fromDate");
        dateFromHidden.setVisible(false);
        vPanel.add(dateFromHidden);
        final Hidden dateToHidden = new Hidden();
        dateToHidden.getElement().setAttribute("type", "text");
        dateToHidden.setName("toDate");
        dateToHidden.setVisible(false);
        vPanel.add(dateToHidden);
        vPanel.add(chooseDateLabel);


        final HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.setSpacing(20);

        fromDate.addValueChangeHandler(new ValueChangeHandler<Date>() {
            @Override
            public void onValueChange(ValueChangeEvent<Date> valueChangeEvent) {
                Date date = valueChangeEvent.getValue();
                dateFromHidden.setValue(String.valueOf(date.getTime()));
            }
        });

        toDate.addValueChangeHandler(new ValueChangeHandler<Date>() {
            @Override
            public void onValueChange(ValueChangeEvent<Date> valueChangeEvent) {
                Date date = valueChangeEvent.getValue();
                dateToHidden.setValue(String.valueOf(date.getTime()));
            }
        });

        hPanel.add(fromDate);
        hPanel.add(toDate);
        vPanel.add(hPanel);

        final ListBox listNews = new ListBox();


        callback = new AsyncCallback<List<Post>>() {

            @Override
            public void onFailure(Throwable caught) {
                status.setText("Ошибка в загрузке списка новостей");
            }

            @Override
            public void onSuccess(List<Post> result) {
                listNews.clear();
                for (Post post : result) {
                    status.setText(String.valueOf(post.getServDate().getTime()));
                    if ((post.getServDate().getTime() > Long.parseLong(dateFromHidden.getValue())) &&
                            (post.getServDate().getTime() < Long.parseLong(dateToHidden.getValue()))){
                        listNews.addItem(post.getName(), String.valueOf(post.getId()));
                    }
                }
            }
        };


        Button updateButton = new Button("Обновить список");
        updateButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                addPostService.getAllPosts(callback);
            }
        });

        vPanel.add(updateButton);



        final Hidden hidden = new Hidden();
        hidden.setVisible(false);
        vPanel.add(hidden);
        listNews.addChangeHandler(new ChangeHandler() {
            @Override
            public void onChange(ChangeEvent changeEvent) {
                hidden.setValue(listNews.getValue(listNews.getSelectedIndex()));
                addPostService.getAllPosts(callback1);
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
        final TextArea editContentText = new TextArea();
        editContentText.getElement().setAttribute("type", "text");
        editContentText.setName("editContent");
        editContentText.setVisibleLines(15);
        editContentText.setCharacterWidth(150);
        vPanel.add(editContentLabel);
        vPanel.add(editContentText);

        callback1 = new AsyncCallback<List<Post>>() {
            @Override
            public void onFailure(Throwable throwable) {
                status.setText("Ошибка в загрузке содержимого новости");
            }

            @Override
            public void onSuccess(List<Post> post) {
                for (Post post1 : post){
                    if (post1.getId() == Integer.parseInt(hidden.getValue())){
                        editContentText.setValue(post1.getContent());
                        editHeadText.setValue(post1.getName());
                    }
                }
            }
        };

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
                hiddenField.setValue("");
            }
        });

        editNews.add(vPanel);


        return editNews;
    }
}
