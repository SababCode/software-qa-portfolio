public class TestCase
{
    private String tid;
    private int expectedCode;
    private int actualCode;
    private int responseTime;

    public TestCase(int tid, int actualCode, int expectedCode, int responseTime)
    {
        this.tid = String.format("TC%02d: ", tid);
        this.actualCode = actualCode;
        this.expectedCode = expectedCode;
        this.responseTime = responseTime;
    }
    
    public String getTid(){return tid;}
    public int getExpectedCode(){return expectedCode;}
    public int getActualCode(){return actualCode;}
    public int getresponseTime(){return responseTime;}
}