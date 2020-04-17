package com.qa.TestRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\sivag\\eclipse-workspace\\CucumberPOM\\src\\main\\java\\com\\qa\\features\\CucumberPOM.feature",
glue="com.qa.StepDefinition",
dryRun=false)
public class TestRunner {

}
