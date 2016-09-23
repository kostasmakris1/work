package gamesys.hr.raffle.cucumber.runner;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "src/test/resources/features", format={"pretty", "html:target/cucumber"}, glue = "gamesys.hr.raffle.cucumber")
public class RunAllTests {
}
