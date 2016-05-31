package ru.kpfu.itis.group408.marushkai.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.kpfu.itis.group408.marushkai.domain.Post;

import java.util.List;

/**
 * Created by unlim_000 on 16.04.2016.
 */
public interface AddPostServiceAsync {
    void add(AsyncCallback<Void> callback);

    void getAllPosts(AsyncCallback<List<Post>> callback);
}
