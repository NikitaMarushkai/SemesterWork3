package ru.kpfu.itis.group408.marushkai.gwt.client.admincontent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import ru.kpfu.itis.group408.marushkai.domain.Advert;
import ru.kpfu.itis.group408.marushkai.gwt.client.AddPostService;
import ru.kpfu.itis.group408.marushkai.gwt.client.AddPostServiceAsync;

import java.util.List;

/**
 * Created by unlim_000 on 02.06.2016.
 */
public class AdvertisementTab {

    private AddPostServiceAsync addPostService = GWT.create(AddPostService.class);
    private AsyncCallback<List<Advert>> callback;

    public FormPanel getAdvertisementTab() {
        VerticalPanel vPanel = new VerticalPanel();
        vPanel.setSpacing(10);

        Label name = new Label("Добавление рекламы");
        final Label status = new Label();

        vPanel.add(name);
        vPanel.add(status);

        final FormPanel formPanel = new FormPanel();
        formPanel.setAction("/admin/addAdvert");
        formPanel.setMethod(FormPanel.METHOD_POST);
        formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);

        //text
        final Label advTextLabel = new Label("Введите текст объявления");
        final TextBox advText = new TextBox();
        advText.getElement().setAttribute("type", "text");
        advText.setName("advText");
        vPanel.add(advTextLabel);
        vPanel.add(advText);

        //link
        final Label advLinkLabel = new Label("Введите ссылку");
        final TextBox linkText = new TextBox();
        linkText.getElement().setAttribute("type", "text");
        linkText.setName("linkText");
        vPanel.add(advLinkLabel);
        vPanel.add(linkText);

        //image
        final Label imageLabel = new Label("Выберите картинку для объявления");
        final FileUpload fileUpload = new FileUpload();
        fileUpload.setName("image");
        vPanel.add(imageLabel);
        vPanel.add(fileUpload);

        //deletion
        final Hidden hidden = new Hidden();
        hidden.setVisible(false);
        hidden.getElement().setAttribute("type", "text");
        hidden.setName("delete");
        vPanel.add(hidden);
        final ListBox advList = new ListBox();
        advList.setName("listAdv");
        callback = new AsyncCallback<List<Advert>>() {
            @Override
            public void onFailure(Throwable caught) {
                status.setText("Ошибка в загрузке списка рекламы");
            }

            @Override
            public void onSuccess(List<Advert> result) {
                for (Advert advert : result) {
                    advList.addItem(advert.getLink(), String.valueOf(advert.getId()));
                }
            }
        };

        advList.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                addPostService.getAllAdverts(callback);
            }
        });

        vPanel.add(advList);

        final Button deleteButton = new Button("Удалить рекламу");
        deleteButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                hidden.setValue("1");
                formPanel.submit();
                status.setText("Успешно удалено");
            }
        });

        vPanel.add(deleteButton);

        final Button submitButton = new Button("Добавить");
        submitButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                hidden.setValue("0");
                formPanel.submit();
                status.setText("Успешно добавлено");
            }
        });

        vPanel.add(submitButton);

        formPanel.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                advText.setValue("");
                linkText.setValue("");
            }
        });


        formPanel.add(vPanel);

        return formPanel;
    }
}
