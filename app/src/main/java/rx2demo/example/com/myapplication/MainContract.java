package rx2demo.example.com.myapplication;

import java.util.List;

import rx2demo.example.com.myapplication.model.PostModel;
import rx2demo.example.com.myapplication.utils.Listener;

public interface MainContract {
    interface view {

        void setPostsList(List<PostModel> postModels);
    }

    interface interactor {

        void fetchPostData(Listener<List<PostModel>> listener);
    }

    interface presenter {

        void fetchPostDetails();
    }
}
