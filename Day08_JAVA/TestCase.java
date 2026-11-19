public class TestCase{
    private String testId;
    private int actualStatus;
    private int expectedStatus;

    public TestCase(String testId, int actualStatus, int expectedStatus) {
        this.testId = testId;
        this.actualStatus = actualStatus;
        this.expectedStatus = expectedStatus;
    }

    public String getTestId() {
        return testId;
    }
    public int getActualStatus() {
        return actualStatus;
    }
    public int getExpectedStatus() {
        return expectedStatus;
    }

}