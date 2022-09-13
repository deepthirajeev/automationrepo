package automation;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/report.html"},
        features = "src/main/resources/features",        
    	dryRun = false //to check the mapping is proper between feature file and step def file
)
public class Runner {

    @Test
    public void tests(){}
}
