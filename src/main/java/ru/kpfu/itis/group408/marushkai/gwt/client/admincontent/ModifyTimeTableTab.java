package ru.kpfu.itis.group408.marushkai.gwt.client.admincontent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DatePicker;
import ru.kpfu.itis.group408.marushkai.domain.Contestant;
import ru.kpfu.itis.group408.marushkai.gwt.client.AddPostService;
import ru.kpfu.itis.group408.marushkai.gwt.client.AddPostServiceAsync;

import java.util.Date;
import java.util.List;

/**
 * Created by unlim_000 on 29.04.2016.
 */
public class ModifyTimeTableTab {

    private AddPostServiceAsync addPostService = GWT.create(AddPostService.class);
    private AsyncCallback<List<Contestant>> callback;
    private AsyncCallback<List<Contestant>> callback1;

    public FormPanel getModifyTimeTableTab(){

        final VerticalPanel vPanel = new VerticalPanel();
        final FormPanel formPanel = new FormPanel();
        formPanel.setAction("/admin/modifyTimeTable");
        formPanel.setMethod(FormPanel.METHOD_POST);
        formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);

        //label and status
        final Label name = new Label("Редактирование расписания");
        final Label status = new Label();
        vPanel.add(name);
        vPanel.add(status);

        //team1 field
        final Label team1Label = new Label("Название первой команды");
        final TextBox team1Text = new TextBox();
        team1Text.getElement().setAttribute("type", "text");
        team1Text.setName("team1");
        vPanel.add(team1Label);
        vPanel.add(team1Text);

        //team2 field
        final Label team2Label = new Label("Название второй команды");
        final TextBox team2Text = new TextBox();
        team2Text.getElement().setAttribute("type", "text");
        team2Text.setName("team2");
        vPanel.add(team2Label);
        vPanel.add(team2Text);


        //region
        final Label chooseRegion = new Label("Выберите регион");
        final ListBox regionTextBox = new ListBox();
        regionTextBox.setName("region");
        regionTextBox.addItem("Запад", "east");
        regionTextBox.addItem("Восток", "west");
        vPanel.add(chooseRegion);
        vPanel.add(regionTextBox);


        //Contest date
        final Label chooseDateLabel = new Label("Выберите дату");
        final DatePicker contestDateChooser = new DatePicker();
        final Hidden date = new Hidden();
        date.getElement().setAttribute("type", "text");
        date.setName("contestDate");
        date.setVisible(false);

        contestDateChooser.addValueChangeHandler(new ValueChangeHandler<Date>() {
            @Override
            public void onValueChange(ValueChangeEvent<Date> valueChangeEvent) {
                Date date1 = valueChangeEvent.getValue();
                date.setValue(DateTimeFormat.getFormat("dd.MM.yyyy").format(date1));
            }
        });

        vPanel.add(chooseDateLabel);
        vPanel.add(contestDateChooser);
        vPanel.add(date);

        //add button
        final Button addContest = new Button("Добавить");

        //edit contests
        final Label editContestLabel = new Label("Редактирование расписания");
        final ListBox chooseEditContest = new ListBox();
        chooseEditContest.setName("chooseContestToEdit");

        callback = new AsyncCallback<List<Contestant>>() {
            @Override
            public void onFailure(Throwable throwable) {
                status.setText("Ошибка в получении списка расписаний");
            }

            @Override
            public void onSuccess(List<Contestant> contestants) {
                chooseEditContest.clear();
                for (Contestant cont : contestants) {
                    chooseEditContest.addItem(cont.getTeam1() + " : " + cont.getTeam2(), String.valueOf(cont.getId()));
                }
            }
        };

        addPostService.getAllContestants(callback);

        final Button updateButton = new Button("Обновить");
        updateButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                addPostService.getAllContestants(callback);
            }
        });

        vPanel.add(updateButton);

        vPanel.add(editContestLabel);
        vPanel.add(chooseEditContest);

        //deleteCont
        final Hidden deleteContHidden = new Hidden();
        deleteContHidden.getElement().setAttribute("type", "text");
        deleteContHidden.setName("deleteContest");
        deleteContHidden.setVisible(false);
        vPanel.add(deleteContHidden);

        final Button deleteContButton = new Button("Удалить строчку");
        deleteContButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                deleteContHidden.setValue("1");
                formPanel.submit();
            }
        });

        addContest.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                deleteContHidden.setValue("0");
                formPanel.submit();
            }
        });

        formPanel.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent submitCompleteEvent) {
                status.setText("Строка расписания обновлена");
                team1Text.setValue("");
                team2Text.setValue("");
                date.setValue("");
            }
        });

        vPanel.add(addContest);
        vPanel.add(deleteContButton);

        formPanel.add(vPanel);

        return formPanel;
    }

}
