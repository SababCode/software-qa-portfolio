public class PostValidator
{
    public boolean isValidUser(int userId)
    {
        return userId == 1;
    }

    public boolean isValidTitle(String title)
    {
        if (title==null) {
            return false;
        }
        return !title.trim().isEmpty();
    }
    
    public String isValidatePost(Post post)
    {
        if(!isValidUser(post.getUserID()))
        {
            return "INVALID_USER";
        }
        else if(!isValidTitle(post.getTitle()))
        {
            return "INVALID_TITLE";
        }
        return "VALID";
    }
}