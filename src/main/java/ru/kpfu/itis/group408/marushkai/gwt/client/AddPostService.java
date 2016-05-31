package ru.kpfu.itis.group408.marushkai.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.kpfu.itis.group408.marushkai.domain.Post;

import java.util.List;

/**
 * Created by unlim_000 on 16.04.2016.
 */

@RemoteServiceRelativePath("springGwtServices/addPostService")
public interface AddPostService extends RemoteService {

    void add();

    List<Post> getAllPosts();
}
