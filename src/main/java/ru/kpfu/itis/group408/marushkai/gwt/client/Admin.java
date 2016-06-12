package ru.kpfu.itis.group408.marushkai.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import ru.kpfu.itis.group408.marushkai.gwt.client.admincontent.*;


/**
 * Created by unlim_000 on 16.04.2016.
 */
public class Admin implements EntryPoint {

    @Override
    public void onModuleLoad() {
        TabPanel tabPanel = new TabPanel();

        String tab1title = "Добавить новость";
        String tab2title = "Редактировать новости";
        String tab3title = "Реклама";
        String tab4title = "Редактор турнирной таблицы";
        String tab5title = "Переход на сайт";
        String tab6title = "Редактор расписания";

        //Create tabs
        final AddPostTab addPostTab = new AddPostTab();
        final EditPostTab editPostTab = new EditPostTab();
        final EditTableTab editTableTab = new EditTableTab();
        final AdvertisementTab advertisementTab = new AdvertisementTab();
        final ModifyTimeTableTab modifyTimeTableTab = new ModifyTimeTableTab();
        tabPanel.add(addPostTab.getAddPostForm(), tab1title);
        tabPanel.add(editPostTab.getEditPostTab(), tab2title);
        tabPanel.add(editTableTab.getEditTableTab(), tab4title);
        tabPanel.add(modifyTimeTableTab.getModifyTimeTableTab(), tab6title);
        tabPanel.add(advertisementTab.getAdvertisementTab(), tab3title);
        tabPanel.add(new Anchor("Перейти на сайт", "/"), tab5title);

        tabPanel.selectTab(0);

        tabPanel.setAnimationEnabled(true);

        RootPanel.get().add(tabPanel);

    }
}
