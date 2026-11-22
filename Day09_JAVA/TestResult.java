import java.util.ArrayList;
import java.util.List;

public class TestResult
{
    private int totalCount;
    private int passCount;
    private int failCount;
    private int errorCount;
    private List<String> result = new ArrayList<>();

    public TestResult()
    {
        this.totalCount = 0;
        this.passCount = 0;
        this.failCount = 0;
        this.errorCount = 0;
    }

    public void setTotal(int totalCount){this.totalCount = totalCount;}
    public int getTotal(){return this.totalCount;}

    public void increasePass(){this.passCount++;}
    public int getPass(){return this.passCount;}

    public void increaseFail(){this.failCount++;}
    public int getFail(){return this.failCount;}

    public void increaseError(){this.errorCount++;}
    public int getError(){return this.errorCount;}

    public void addResult(String result)
    {
        this.result.add(result);
    }
    public String getResult(int i) {return this.result.get(i);}

    public void printResult()
    {
        System.out.println("Total: " + this.totalCount);
        System.out.println("PASS: " + this.passCount);
        System.out.println("FAIL: " + this.failCount);
        System.out.println("ERROR: " + this.errorCount);
        double passRate = (double) passCount / this.totalCount * 100;
        System.out.printf("PASS RATE: %.2f%%%n", passRate);
    }

    public void printOverallResult()
    {
        System.out.println("OVERALL RESULT: " + (this.failCount==0 && this.errorCount == 0 ? "PASS" : "FAIL"));
        System.out.println("COUNT VALID: "+ (this.totalCount ==this.passCount + this.failCount + this.errorCount));
    }
}