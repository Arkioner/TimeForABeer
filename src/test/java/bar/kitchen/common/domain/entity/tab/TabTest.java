package bar.kitchen.common.domain.entity.tab;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by IONER on 10/07/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:feature/tab/tab.feature"},
        dryRun = false,
        glue = {"bar.kitchen.common.domain.entity.tab.steps"},
        format = {"pretty"}
)
public class TabTest {
}