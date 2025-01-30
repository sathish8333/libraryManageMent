import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.sr.colleges.lms.steps"},
        features = {"src/test/java/com/sr/colleges/lms/feature-files/"},
        plugin = {"pretty", "json:target/cucumber-report.json"})
public class CucumberRunnerTest {

}
