public class Main {
    public static void main(String[] args)
    {
        //1. HTTP 상태 코드 검증
        int expectedStatus = 200;
        compareStatusCode(404, expectedStatus);

        //2. API 응답 시간 검증
        double expectedResponseTime = 1.00;
        validateResponseTime(0.99, expectedResponseTime);
        validateResponseTime(1.00, expectedResponseTime);
        validateResponseTime(1.01, expectedResponseTime);
        validateResponseTime(1.25, expectedResponseTime);
        //2-1. 음수 응답 시간 입력 시 IllegalArgumentException 발생 확인
        try{
            validateResponseTime(-3.14, expectedResponseTime);
        }
        catch(IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        //2-2. NaN 응답 시간 입력 시 IllegalArgumentException 발생 확인
        try{
            validateResponseTime(Double.NaN, expectedResponseTime);
        }
        catch(IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        //3. 다중 테스트 케이스 검증 및 결과 집계
        int[] actualCodes = {200, 400, 204, 404, 503};
        int[] expectedCodes = {200, 201, 204, 404, 500};
        verifyTestResults(actualCodes, expectedCodes);
        
        // 3-1. 배열 길이 불일치 예외 확인
        try{
            actualCodes = new int[] {200, 400, 204, 404, 503, 600};
            verifyTestResults(actualCodes, expectedCodes);
        }
        catch(IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        //3-2. null 배열 예외 확인
        try{
            actualCodes = null;
            verifyTestResults(actualCodes, expectedCodes);
        }
        catch(IllegalArgumentException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        //4. boolean 반환 메서드를 활용한 다중 상태코드 검증
        actualCodes = new int[] {200, 201, 204};
        expectedCodes = new int[] {200, 400, 204};
        for(int i = 0; i < actualCodes.length; i++)
        {
            if(checkStatus(actualCodes[i], expectedCodes[i]))
            {
                System.out.println("TC"+(i+1) + ": PASS");
            }
            else
            {
                System.out.println("TC"+(i+1) + ": FAIL");
            }
        }
    }

    public static void compareStatusCode(int actualStatus, int expectedStatus)
    {
        String testResult = "";

        if(expectedStatus == actualStatus)
        {
            testResult = "PASS";
        }
        else
        {
            testResult = "FAIL";
        }
        
        System.out.println("Expected: " + expectedStatus);
        System.out.println("Actual: " + actualStatus);
        System.out.println("Result: " + testResult);

    }

    public static void validateResponseTime(double responseTime, double maxResponseTime)
    {
        if(!Double.isFinite(responseTime)||responseTime < 0)
        {
            throw new IllegalArgumentException("유효하지 않은 응답 시간입니다.");
        }

        String testResult = "";

        if(responseTime <= maxResponseTime)
        {
            testResult = "PASS";
        }
        else
        {
            testResult = "FAIL";
        }
        System.out.println("Response Time: " + responseTime);
        System.out.println("Result: " + testResult);
    }

    public static void verifyTestResults(int[] actualCodes, int[] expectedCodes)
    {
        if (actualCodes == null || expectedCodes == null)
        {
            throw new IllegalArgumentException("테스트 데이터가 null입니다.");
        }
        if(actualCodes.length != expectedCodes.length)
        {
            throw new IllegalArgumentException("테스트 데이터 개수가 일치하지 않습니다.");
        }
        int passCount = 0;
        int failCount = 0;
        String testResult = "";

        for(int i = 0; i < actualCodes.length; i++)
        {
            if(checkStatus(actualCodes[i], expectedCodes[i]))
            {
                testResult = "PASS";
                passCount++;
            }
            else
            {
                testResult = "FAIL";
                failCount++;
            }
            System.out.println("TC"+(i+1)+": "+ testResult);    
        }
        System.out.println("Total: "+ (passCount + failCount));
        System.out.println("Passed: "+ passCount);
        System.out.println("Failed: "+ failCount);
    }
    
    public static boolean checkStatus(int actual, int expected)
    {
        return (expected == actual);
    }
}
