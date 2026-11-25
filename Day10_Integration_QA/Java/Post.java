public class Post
{
    private int postId;
    private int userId;
    private String title;
    private String expectResult;

    public Post(int postId, int userId, String title, String expectResult)
    {
        this.postId = postId;
        this.userId = userId;
        this.title = title;
        this.expectResult = expectResult;
    }

    public int getPostId() {return this.postId;}
    public int getUserID() {return this.userId;}
    public String getTitle() {return this.title;}
    public String getExpectResult() {return this.expectResult;}

}