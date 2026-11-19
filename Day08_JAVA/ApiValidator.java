public class ApiValidator
{
    private int maxResponseTime;
    public ApiValidator(int maxResponseTime) {
        if (maxResponseTime <= 0) {
            throw new IllegalArgumentException("생성자 예외 발생");
        }
        this.maxResponseTime = maxResponseTime;
    }
    public ApiValidator() {
        
    }
    public boolean checkStatus(int actual, int expected)
    {
        return actual == expected;
    }
    public boolean checkResponseTime (int actual)
    {
        if (actual < 0) {
            throw new IllegalArgumentException("예외 발생");
        }
        return actual <= maxResponseTime;
    }
    public static boolean checkErrorCode(int actual, int expected)
    {
        return actual == expected;
    }
}