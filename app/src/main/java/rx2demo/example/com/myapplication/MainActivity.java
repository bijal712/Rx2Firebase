package rx2demo.example.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import rx2demo.example.com.myapplication.model.PostModel;

public class MainActivity extends AppCompatActivity implements MainContract.view, View.OnClickListener{

    TextView apiCall;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        apiCall = findViewById(R.id.tvApiCall);
        presenter = new MainPresenter(this);

        apiCall.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        presenter.fetchPostDetails();

    }


    @Override
    public void setPostsList(List<PostModel> postModels) {

        Log.d("List", "setPostsList size: "+postModels.size());
        for (int i = 0; i < postModels.size(); i++) {
            if (postModels.get(i).getPosts().getAttachments()!=null) {
                Log.d("List", "attachments: " + postModels.get(i).getPosts().getAttachments().toString());
            }
            Log.d("List", "authorId: "+postModels.get(i).getPosts().getAuthorId());
            Log.d("List", "tetx: "+postModels.get(i).getPosts().getText());
            Log.d("List", "like: "+postModels.get(i).getLikes());
            Log.d("List", "fullname: "+postModels.get(i).getUsers().getFull_name());
            Log.d("List", "username: "+postModels.get(i).getUsers().getUsername());
            Log.d("List", "profile: "+postModels.get(i).getUsers().getProfile_picture());
            Log.d("List", "comment: "+postModels.get(i).getComments());
        }
    }
}
