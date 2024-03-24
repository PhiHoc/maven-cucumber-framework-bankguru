package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinition",
        monochrome = true,
        plugin = {"pretty","html:target/site/cucumber-report-defult","json:target/site/cucumber.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "")
public class CucumberTestRunner {
}
