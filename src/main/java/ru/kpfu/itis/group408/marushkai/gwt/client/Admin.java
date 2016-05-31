package ru.kpfu.itis.group408.marushkai.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import ru.kpfu.itis.group408.marushkai.gwt.client.admincontent.AddPostTab;
import ru.kpfu.itis.group408.marushkai.gwt.client.admincontent.EditPostTab;


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
        tabPanel.add(addPostTab.getAddPostForm(), tab1title);
        tabPanel.add(editPostTab.getEditPostTab(), tab2title);

        tabPanel.selectTab(0);

        tabPanel.setAnimationEnabled(true);

        RootPanel.get().add(tabPanel);

    }

//    private AddPostServiceAsync addPostService = GWT.create(AddPostService.class);
//    private Button addMore = new Button();
//    private Label error = new Label();
//    private VPanelGetter panelGetter = new VPanelGetter();
//
//    private void initComponents(){
//        addMore.setText("Больше новостей");
//        addMore.setWidth("200");
//        addMore.setHeight("100");
//
//        error.setHeight("100");
//        error.setWidth("200");
//    }
//
//    @Override
//    public void onModuleLoad() {
//
//        this.initComponents();
//
//        RootPanel.get("button").add(addMore);
//        RootPanel.get("error").add(error);
//
//        final AsyncCallback<ArrayList<Post>> callback = new AsyncCallback<ArrayList<Post>>() {
//            @Override
//            public void onFailure(Throwable caught) {
//                error.setText("Error loading new posts");
//            }
//
//            @Override
//            public void onSuccess(ArrayList<Post> result) {
//                for (Post post : result) {
//                    RootPanel.get("news").add(panelGetter.getCreateVerticalPanel(post.getName(),
//                            post.getImage(), post.getContent(), post.getCreationDate(), post.getId()));
//                }
//            }
//        };
//
//        addMore.addClickHandler(new ClickHandler() {
//            @Override
//            public void onClick(ClickEvent event) {
//                addPostService.add(callback);
//            }
//        });
//    }
}
