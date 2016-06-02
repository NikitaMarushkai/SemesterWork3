package ru.kpfu.itis.group408.marushkai.gwt.client.admincontent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import ru.kpfu.itis.group408.marushkai.domain.Standing;
import ru.kpfu.itis.group408.marushkai.gwt.client.AddPostService;
import ru.kpfu.itis.group408.marushkai.gwt.client.AddPostServiceAsync;

import java.util.List;

/**
 * Created by unlim_000 on 29.04.2016.
 */
public class EditTableTab {

    private AddPostServiceAsync addPostService = GWT.create(AddPostService.class);
    private AsyncCallback<List<Standing>> callback;

    public FormPanel getEditTableTab() {

        VerticalPanel vPanel = new VerticalPanel();
        vPanel.setSpacing(10);

        //head and status
        final Label head = new Label("Редактирование таблички с текущим состоянием команд");
        final Label status = new Label();

        vPanel.add(head);
        vPanel.add(status);

        //Editing form
        final FormPanel formPanel = new FormPanel();
        formPanel.setAction("/admin/editTable");
        formPanel.setMethod(FormPanel.METHOD_POST);
        formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);

        final ListBox teams = new ListBox();

        callback = new AsyncCallback<List<Standing>>() {
            @Override
            public void onFailure(Throwable caught) {
                status.setText("Ошибка в загрузке списка команд");
            }

            @Override
            public void onSuccess(List<Standing> result) {
                for (Standing standing : result) {
                    teams.addItem(standing.getTeam(), String.valueOf(standing.getId()));
                }
            }
        };

        teams.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                addPostService.getAllTeams(callback);
            }
        });

        //Adding choose teams
        final Label chooseTeamLabel = new Label("Выберите команду");
        teams.setVisibleItemCount(0);
        teams.setName("teamChooser");
        vPanel.add(chooseTeamLabel);
        vPanel.add(teams);

        //Games Number
        final Label gamesNumberLabel = new Label("Число игр");
        final TextBox gamesNumberText = new TextBox();
        gamesNumberText.getElement().setAttribute("type", "text");
        gamesNumberText.setName("gamesNumber");
        vPanel.add(gamesNumberLabel);
        vPanel.add(gamesNumberText);

        //Wins number
        final Label winsNumberLabel = new Label("Число выигрышей");
        final TextBox winsNumberText = new TextBox();
        winsNumberText.getElement().setAttribute("type", "text");
        winsNumberText.setName("winsNumber");
        vPanel.add(winsNumberLabel);
        vPanel.add(winsNumberText);

        //Overtime wins
        final Label overtimeWinsNumberLabel = new Label("Число выигрышей в овертайме");
        final TextBox overtimeWinsNumberText = new TextBox();
        overtimeWinsNumberText.getElement().setAttribute("type", "text");
        overtimeWinsNumberText.setName("overtimeWinsNumber");
        vPanel.add(overtimeWinsNumberLabel);
        vPanel.add(overtimeWinsNumberText);

        //Bullit wins
        final Label bullitWinsNumberLabel = new Label("Число выигрышей по буллитам");
        final TextBox bullitWinsNumberText = new TextBox();
        bullitWinsNumberText.getElement().setAttribute("type", "text");
        bullitWinsNumberText.setName("bullitWinsNumber");
        vPanel.add(bullitWinsNumberLabel);
        vPanel.add(bullitWinsNumberText);

        //Bullit loses
        final Label bullitLosesNumberLabel = new Label("Число проигрышей по буллитам");
        final TextBox bullitLosesNumberText = new TextBox();
        bullitLosesNumberText.getElement().setAttribute("type", "text");
        bullitLosesNumberText.setName("bullitLosesNumber");
        vPanel.add(bullitLosesNumberLabel);
        vPanel.add(bullitLosesNumberText);

        //OT loses
        final Label overtimeLosesNumberLabel = new Label("Число проигрышей в овертайме");
        final TextBox overtimeLosesNumberText = new TextBox();
        overtimeLosesNumberText.getElement().setAttribute("type", "text");
        overtimeLosesNumberText.setName("overtimeLosesNumber");
        vPanel.add(overtimeLosesNumberLabel);
        vPanel.add(overtimeLosesNumberText);

        //Loses
        final Label losesNumberLabel = new Label("Число проигрышей");
        final TextBox losesNumberText = new TextBox();
        losesNumberText.getElement().setAttribute("type", "text");
        losesNumberText.setName("losesNumber");
        vPanel.add(losesNumberLabel);
        vPanel.add(losesNumberText);

        //Total goals
        final Label totalGoalsLabel = new Label("Число заброшенных шайб");
        final TextBox totalGoalsText = new TextBox();
        totalGoalsText.getElement().setAttribute("type", "text");
        totalGoalsText.setName("totalGoalsNumber");
        vPanel.add(totalGoalsLabel);
        vPanel.add(totalGoalsText);

        //Points
        final Label pointsLabel = new Label("Общее число очков");
        final TextBox pointsText = new TextBox();
        pointsText.getElement().setAttribute("type", "text");
        pointsText.setName("pointsNumber");
        vPanel.add(pointsLabel);
        vPanel.add(pointsText);

        final Button submitButton = new Button("Подтвердить");

        submitButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                formPanel.submit();
            }
        });

        vPanel.add(submitButton);

        formPanel.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                gamesNumberText.setValue("");
                winsNumberText.setValue("");
                overtimeWinsNumberText.setValue("");
                bullitWinsNumberText.setValue("");
                bullitLosesNumberText.setValue("");
                overtimeLosesNumberText.setValue("");
                losesNumberText.setValue("");
                totalGoalsText.setValue("");
                pointsText.setValue("");
                status.setText("Информация успешно обновлена");
            }
        });

        formPanel.add(vPanel);

        return formPanel;
    }
}
