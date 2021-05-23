package cucumberTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    //tags = "@activity1_1",
    //tags = "@activity1_2",
    //tags = "@activity1_3",
    //tags = "@activity2_4",
     tags = "@activity2_5",
    plugin = { "pretty", "html: test-reports" },
    monochrome = true
)

public class ActivitiesRunner {
    //empty
}