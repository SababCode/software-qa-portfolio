public class App {
    private static int testId = 1;
    public static String nextTc() {
        return String.format("TC%02d: ", testId++);
    }

    public static void main(String[] args) throws Exception
    {
        int[] actualCodes = {200, 404, 201};
        int[] expectedCodes = {200, 200, 201};
        ApiValidator validator = new ApiValidator();
        // 1. 클래스와 객체 생성
        for(int i = 0; i < actualCodes.length; i++)
        {
            String resultstatus = validator.checkStatus(actualCodes[i],expectedCodes[i]) ? "PASS" : "FAIL";
            System.out.println(nextTc() + resultstatus);
        }

        // 2. 생성자와 캡슐화
        int[] actualTime = {150, 250, 200, -10, 100};
        int[] expectedResponseTimes = {200, 200, 200, 200, 0};
        
        for (int i = 0; i < actualTime.length; i++)
        {
            String testId = nextTc();
            try{
                ApiValidator timevalidator = new ApiValidator(expectedResponseTimes[i]);
                String resultstatus = timevalidator.checkResponseTime(actualTime[i]) ? "PASS" : "FAIL";
                System.out.println(testId + resultstatus);
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(testId + "EXCEPTION / "+ e.getMessage());
            }
        }

        // 3. Static 공통 검증
        actualCodes = new int[] {400, 500, 401};
        expectedCodes = new int[] {400, 404, 401};
        for (int i = 0; i < actualCodes.length; i++)
        {
            String resulterrorcode = ApiValidator.checkErrorCode(actualCodes[i], expectedCodes[i]) ? "PASS" : "FAIL";
            System.out.println(nextTc() + resulterrorcode);
        }

        // 4. TestCase 객체 배열 생성 및 검증
        actualCodes = new int[] {200, 404, 201};
        expectedCodes = new int[] {200, 200, 201};
        TestCase[] testCases = new TestCase[actualCodes.length];
        for (int i = 0; i < actualCodes.length; i++) {
            testCases[i] = new TestCase(nextTc(), actualCodes[i], expectedCodes[i]);
        }
        for (int i = 0; i < testCases.length; i++) {
            String resultstatus = validator.checkStatus(testCases[i].getActualStatus(), testCases[i].getExpectedStatus()) ? "PASS" : "FAIL";
            System.out.println(testCases[i].getTestId() + resultstatus);
        }

        // 5. 테스트 결과 자동 집계
        actualCodes = new int[] {200, 201, 404, 500, 204};
        expectedCodes = new int[] {200, 200, 404, 200, 204};
        testCases = new TestCase[actualCodes.length];
        int passCount = 0;
        int failCount = 0;
        for (int i = 0; i < actualCodes.length; i++) {
            testCases[i] = new TestCase(nextTc(), actualCodes[i], expectedCodes[i]);
        }
        for (int i = 0; i < testCases.length; i++) {
            if (validator.checkStatus(testCases[i].getActualStatus(), testCases[i].getExpectedStatus())) {
                System.out.println(testCases[i].getTestId() + "PASS");
                passCount++;
            } else {
                System.out.println(testCases[i].getTestId() + "FAIL");
                failCount++;
            }
        }
        System.out.println("Total: " + testCases.length);
        System.out.println("PASS: " + passCount);
        System.out.println("FAIL: " + failCount);
        System.out.println("Summary Validation: " + ((passCount+failCount) == testCases.length ? "PASS" : "FAIL"));
    }
}
