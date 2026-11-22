public class ApiValidator
{
    public boolean checkStatus(TestCase tc)
    {
        return tc.getActualCode() == tc.getExpectedCode();
    }
    
    public boolean checkResponseTime(TestCase tc)
    {
        if(tc.getresponseTime() < 0){
            throw new IllegalArgumentException("INVALID RESPONSE TIME");
        }
        return tc.getresponseTime() <= 1000;
    }
}