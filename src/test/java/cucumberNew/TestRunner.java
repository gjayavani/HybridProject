package cucumberNew;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features/",
        glue = {"Stepdefinitions"},
        tags = "@smoke3",
        plugin = {"html:target/cucumber-reports/"})
public class TestRunner
        {

        }