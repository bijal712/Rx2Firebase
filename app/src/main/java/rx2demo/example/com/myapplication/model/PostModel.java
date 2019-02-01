package rx2demo.example.com.myapplication.model;

public class PostModel {
    private Posts posts;
    private UsersModel users;
    private String postId;
    private long comments;
    private long likes;

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public long getComments() {
        return comments;
    }

    public void setComments(long comments) {
        this.comments = comments;
    }

    public UsersModel getUsers() {
        return users;
    }

    public void setUsers(UsersModel users) {
        this.users = users;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

}
