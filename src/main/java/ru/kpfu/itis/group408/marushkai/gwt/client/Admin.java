package ru.kpfu.itis.group408.marushkai.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import ru.kpfu.itis.group408.marushkai.gwt.client.admincontent.AddPostTab;
import ru.kpfu.itis.group408.marushkai.gwt.client.admincontent.EditPostTab;
import ru.kpfu.itis.group408.marushkai.gwt.client.admincontent.EditTableTab;


/**
 * Created by unlim_000 on 16.04.2016.
 */
public class Admin implements EntryPoint {

    @Override
    public void onModuleLoad() {
        TabPanel tabPanel = new TabPanel();

        String tab1title = "Добавить новость";
        String tab2title = "Редактировать новости";
        String tab3title = "Редактор команд";
        String tab4title = "Редактор турнирной таблицы";
        String tab5title = "Переход на сайт";

        //Create tabs
        final AddPostTab addPostTab = new AddPostTab();
        final EditPostTab editPostTab = new EditPostTab();
        final EditTableTab editTableTab = new EditTableTab();
        tabPanel.add(addPostTab.getAddPostForm(), tab1title);
        tabPanel.add(editPostTab.getEditPostTab(), tab2title);
        tabPanel.add(editTableTab.getEditTableTab(), tab4title);

        tabPanel.selectTab(0);

        tabPanel.setAnimationEnabled(true);

        RootPanel.get().add(tabPanel);

    }
}
