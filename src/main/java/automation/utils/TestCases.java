package automation.utils;

public enum TestCases {
    T1("Gmail Compose function");

    private String testName;

    TestCases(String testName) {
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }
}
