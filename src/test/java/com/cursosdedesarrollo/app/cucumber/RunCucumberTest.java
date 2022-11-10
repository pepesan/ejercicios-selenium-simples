package com.cursosdedesarrollo.app.cucumber;


import io.cucumber.junit.platform.engine.Constants;
import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@SuiteDisplayName("JUnit Platform Suite Cucumber")
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
// se indican donde estan los ficheros de Step
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.cursosdedesarrollo.app")
//@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
//@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@cursos or @busqueda")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, junit:target/cucumber-results.xml, html:target/cucumber-report/cucumber.html")
public class RunCucumberTest {
}