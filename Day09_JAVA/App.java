import java.util.ArrayList;
import java.util.List;
public class App {
    public static void main(String[] args) throws Exception {
        List<TestCase> testCases  = new ArrayList<>();
        ApiValidator ap = new ApiValidator();
        TestResult result = new TestResult();
        

        int[] actualcodes = {200, 201, 400, 404, 500, 200, 200, 500};
        int[] expectedcodes = {200, 201, 200, 404, 200, 200, 200, 200};
        int[] responseTime = {350, 950, 500, 1200, -100, 1000, -1, 400};
        
        for(int i = 0; i < expectedcodes.length; i++) {
            testCases .add(new TestCase(
                i+1,
                actualcodes[i],
                expectedcodes[i],
                responseTime[i]));
        }
        
        result.setTotal(testCases.size());

        for(TestCase tc : testCases) {
            String status;
            try{
            if(ap.checkStatus(tc)) {
                if (ap.checkResponseTime(tc)) {
                    status = "PASS";
                    result.increasePass();
                }
                else {
                    status = "FAIL (RESPONSE TIME)";
                    result.increaseFail();
                }
            }
            else {
                if (ap.checkResponseTime(tc)) {
                    status = "FAIL (STATUS)";
                }
                else{
                    status = "FAIL (STATUS, RESPONSE TIME)";
                }
                result.increaseFail();
            }
            }
            catch (IllegalArgumentException e)
            {
                status = "ERROR (" + e.getMessage() + ")";
                result.increaseError();
            }
            result.addResult(tc.getTid() + status);
        }
        
        System.out.println("===== TEST REPORT =====\n");
        for(int i = 0; i < result.getTotal(); i++)
        {
            System.out.println(result.getResult(i));
        }

        System.out.println("\n===== TEST SUMMARY =====\n");
        result.printResult();
        result.printOverallResult();

    }
}
