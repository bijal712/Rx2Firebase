package rx2demo.example.com.myapplication.model;

public class UsersModel {

    private int attachmentCount;
    private String creationDate;
    private String email;
    private boolean facebookLinked;
    private int listsCount;
    private boolean twitterLinked;
    private String username;
    private String cover_picture;
    private String profile_picture;
    private String full_name;

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getCover_picture() {
        return cover_picture;
    }

    public void setCover_picture(String cover_picture) {
        this.cover_picture = cover_picture;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public int getAttachmentCount() {
        return attachmentCount;
    }

    public void setAttachmentCount(int attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isFacebookLinked() {
        return facebookLinked;
    }

    public void setFacebookLinked(boolean facebookLinked) {
        this.facebookLinked = facebookLinked;
    }

    public int getListsCount() {
        return listsCount;
    }

    public void setListsCount(int listsCount) {
        this.listsCount = listsCount;
    }

    public boolean isTwitterLinked() {
        return twitterLinked;
    }

    public void setTwitterLinked(boolean twitterLinked) {
        this.twitterLinked = twitterLinked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
