import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features"
        ,glue={"bindings"}
        ,tags = {"not @avoid","@FunctionalTest"}
        , plugin = {"json:target/cucumber.json", "html:target/cucumber-pretty"}
)
public class RunnerTest {
}
