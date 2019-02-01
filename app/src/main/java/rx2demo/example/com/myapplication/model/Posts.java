package rx2demo.example.com.myapplication.model;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;

public class Posts {
    private String authorId;
    private String createdAt;
    private String text;
    private Attachments attachments;

   /* private long likes;
    private String postId;*/

   /* public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }
*/
    public Attachments getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachments attachments) {
        this.attachments = attachments;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public static class Attachments {
        private String authorId;
        private String createdAt;
        private String fileName;
        private long fileSize;
        private String fileType;
        private String postId;
        private String storageUrl;
        private String storgePath;
        private String updatedAt;

        public String getAuthorId() {
            return authorId;
        }

        public void setAuthorId(String authorId) {
            this.authorId = authorId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public long getFileSize() {
            return fileSize;
        }

        public void setFileSize(long fileSize) {
            this.fileSize = fileSize;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public String getPostId() {
            return postId;
        }

        public void setPostId(String postId) {
            this.postId = postId;
        }

        public String getStorageUrl() {
            return storageUrl;
        }

        public void setStorageUrl(String storageUrl) {
            this.storageUrl = storageUrl;
        }

        public String getStorgePath() {
            return storgePath;
        }

        public void setStorgePath(String storgePath) {
            this.storgePath = storgePath;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        @Override
        public String toString() {
            return "Attachments{" +
                    "authorId='" + authorId + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", fileName='" + fileName + '\'' +
                    ", fileSize=" + fileSize +
                    ", fileType='" + fileType + '\'' +
                    ", postId='" + postId + '\'' +
                    ", storageUrl='" + storageUrl + '\'' +
                    ", storgePath='" + storgePath + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    '}';
        }
    }
}
