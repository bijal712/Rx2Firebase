package rx2demo.example.com.myapplication;

import android.util.Log;

import java.util.List;

import rx2demo.example.com.myapplication.model.PostModel;
import rx2demo.example.com.myapplication.utils.Listener;

public class MainPresenter implements MainContract.presenter {
    private MainContract.view mView;
    private MainInteractor mInteractor;

    public MainPresenter(MainContract.view mView) {
        this.mView = mView;
        this.mInteractor = new MainInteractor();
    }

    @Override
    public void fetchPostDetails() {
        mInteractor.fetchPostData(new Listener<List<PostModel>>(){
            @Override
            public void onNext(List<PostModel> postModels) {
                super.onNext(postModels);
                mView.setPostsList(postModels);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                Log.d("TAG", "onError: "+e.getMessage());
            }
        });
    }
}
