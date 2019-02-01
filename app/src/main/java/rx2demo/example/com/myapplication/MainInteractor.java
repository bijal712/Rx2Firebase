package rx2demo.example.com.myapplication;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import durdinapps.rxfirebase2.RxFirebaseDatabase;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.functions.Function;
import rx2demo.example.com.myapplication.model.PostModel;
import rx2demo.example.com.myapplication.model.Posts;
import rx2demo.example.com.myapplication.model.UsersModel;
import rx2demo.example.com.myapplication.utils.Listener;

public class MainInteractor implements MainContract.interactor {

    private FirebaseDatabase database;
    private DatabaseReference postsQuery;
    private DatabaseReference usersQuery;
    private DatabaseReference commentsQuery;
    private List<String> feedsList = new ArrayList<>();
    private List<Posts> postList = new ArrayList<>();
    private List<PostModel> postModelList = new ArrayList<>();
    private Listener<List<PostModel>> listener;
    private long count = 0;

    /*@Override
    public void fetchPostData(Listener<List<PostModel>> listener) {
        this.listener = listener;
        database = FirebaseDatabase.getInstance("https://fair-food-forager-main-staging.firebaseio.com/");

        feedsList.clear();
        postList.clear();
        postModelList.clear();
        Query query = database.getReference().child("feeds").child("lFegBurakXQ8qQfXAPocA4NtJMI3").limitToLast(20);

        query.addValueEventListener(new ValueEventListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {

                    postsQuery = database.getReference().child("posts");
                    usersQuery = database.getReference().child("users");
                    commentsQuery = database.getReference().child("comments");


                    PostModel model = new PostModel();
                    RxFirebaseDatabase.observeSingleValueEvent(postsQuery.child(itemSnapshot.getKey()), new Function<DataSnapshot, MaybeSource<PostModel>>() {
                        @Override
                        public MaybeSource<PostModel> apply(DataSnapshot dataSnapshot) throws Exception {
                            Posts posts = dataSnapshot.getValue(Posts.class);

                            if (dataSnapshot.hasChild("attachments")) {
                                DataSnapshot attachments = dataSnapshot.child("attachments");
                                for (DataSnapshot snapshot : attachments.getChildren()) {
                                    posts.setAttachments(snapshot.getValue(Posts.Attachments.class));
                                }
                            }
                            DataSnapshot likeSnapshot = dataSnapshot.child("likes");
                            long like = likeSnapshot.getChildrenCount();
                            model.setLikes(like);
                            model.setPosts(posts);
                            model.setPostId(itemSnapshot.getKey());
                            return Maybe.just(model);
                        }
                        *//*@Override
                        public Object apply(DataSnapshot dataSnapshot) throws Exception {
                           *//**//* (Function<DataSnapshot, MaybeSource<PostModel>>) dataSnapshot1 -> {

                            }*//**//*
                            return null;
                        }*//*
                    }).flatMap(posts -> RxFirebaseDatabase.observeSingleValueEvent(usersQuery.child(model.getPosts().getAuthorId()), (Function<DataSnapshot, MaybeSource<PostModel>>) dataSnapshot12 -> {
                                UsersModel usersModel = dataSnapshot12.getValue(UsersModel.class);
                                model.setUsers(usersModel);
                                feedsList.add(itemSnapshot.getKey());
                                return Maybe.just(model);
                    })).flatMap(postModel -> RxFirebaseDatabase.observeSingleValueEvent(commentsQuery, (Function<DataSnapshot, Object>) dataSnapshot13 -> {
                                for (DataSnapshot snapshot : dataSnapshot13.getChildren()) {
                                    String objectId = (String) snapshot.child("objectId").getValue();
                                    if (objectId != null && objectId.equals(model.getPostId())) {
                                        count++;
                                    }
                                }
                                model.setComments(count);
                                count = 0;
                                postModelList.add(model);
                                return Maybe.just(model);
                            }))
                            .subscribe(comments -> setList(postModelList),
                                    throwable -> manageError(throwable));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("error", "onCancelled: " + databaseError.getMessage());
            }
        });
    }*/

    private void setList(List<PostModel> postModelList) {
        if (postModelList.size() < feedsList.size()) {
            Log.d("TAG", "fetchPostList: ");
        } else {
            listener.onNext(postModelList);
        }
    }

    private Object manageError(Throwable throwable) {
        Log.e("TAG", "manageError: " + throwable.getMessage());
        return 0;
    }


    @Override
    public void fetchPostData(Listener<List<PostModel>> listener) {
        this.listener = listener;
        database = FirebaseDatabase.getInstance("https://fair-food-forager-main-staging.firebaseio.com/");

        feedsList.clear();
        postList.clear();
        postModelList.clear();
        Query query = database.getReference().child("feeds").child("lFegBurakXQ8qQfXAPocA4NtJMI3").limitToLast(20);


        query.addValueEventListener(new ValueEventListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (final DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                    postsQuery = database.getReference().child("posts");
                    usersQuery = database.getReference().child("users");
                    commentsQuery = database.getReference().child("comments");

                    PostModel model = new PostModel();
                    RxFirebaseDatabase.observeSingleValueEvent(postsQuery.child(itemSnapshot.getKey()), (Function<DataSnapshot, MaybeSource<PostModel>>) dataSnapshot1 -> {
                        Posts posts = dataSnapshot1.getValue(Posts.class);

                        if (dataSnapshot1.hasChild("attachments")) {
                            DataSnapshot attachments = dataSnapshot1.child("attachments");
                            for (DataSnapshot snapshot : attachments.getChildren()) {
                                posts.setAttachments(snapshot.getValue(Posts.Attachments.class));
                            }
                        }
                        DataSnapshot likeSnapshot = dataSnapshot1.child("likes");
                        long like = likeSnapshot.getChildrenCount();
                        model.setLikes(like);
                        model.setPosts(posts);
                        model.setPostId(itemSnapshot.getKey());
                        return Maybe.just(model);
                    }).flatMap(posts -> RxFirebaseDatabase.observeSingleValueEvent(usersQuery.child(model.getPosts().getAuthorId()), (Function<DataSnapshot, MaybeSource<PostModel>>) dataSnapshot12 -> {
                        UsersModel usersModel = dataSnapshot12.getValue(UsersModel.class);
                        model.setUsers(usersModel);
                        feedsList.add(itemSnapshot.getKey());
                        return Maybe.just(model);
                    })).flatMap(postModel -> RxFirebaseDatabase.observeSingleValueEvent(commentsQuery, (Function<DataSnapshot, Object>) dataSnapshot13 -> {
                        for (DataSnapshot snapshot : dataSnapshot13.getChildren()) {
                            String objectId = (String) snapshot.child("objectId").getValue();
                            if (objectId != null && objectId.equals(model.getPostId())) {
                                count++;
                            }
                        }
                        model.setComments(count);
                        count = 0;
                        postModelList.add(model);
                        return Maybe.just(model);
                    }))
                            .subscribe(comments -> setList(postModelList),
                                    throwable -> manageError(throwable));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}