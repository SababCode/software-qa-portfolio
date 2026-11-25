import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Post> postlist = new ArrayList<>();
        PostValidator pV = new PostValidator();
        TestResult testResult = new TestResult();

        int[] postId = {201, 202, 203, 204, 205, 206, 207, 208, 209};
        int[] userId = {1, 999, 1, 1, 1, 999, 999, 1, 1};
        String[] title = {"QA validation test", "Unknown user post", "   ", null, "", "정상 제목", null, "\t", "\n"};
        String[] expectResult = {"VALID", "INVALID_USER", "INVALID_TITLE", "INVALID_TITLE", "INVALID_TITLE", "INVALID_USER", "INVALID_USER","INVALID_TITLE", "INVALID_TITLE"};

        for(int i = 0; i < postId.length; i++)
        {
            postlist.add(new Post(postId[i], userId[i], title[i], expectResult[i]));
        }

        int passCount = 0;
        int failCount = 0;

        for(Post ps : postlist)
        {
            String actualResult = pV.isValidatePost(ps);
            boolean isPass = testResult.Result(ps.getExpectResult(), actualResult);
            System.out.println("Post" + ps.getPostId() +" | "
            + "Expected: " + ps.getExpectResult() + " | " 
            + "Actual: " + actualResult + " | "
            + (isPass ? "PASS" : "FAIL"));

            if(isPass) {
                passCount++;
            }
            else {
                failCount++;
            }
        }

        System.out.println("\n");
        System.out.println("Total: " + postlist.size());
        System.out.println("Passed: " + passCount);
        System.out.println("Failed: " + failCount);

    }
}
