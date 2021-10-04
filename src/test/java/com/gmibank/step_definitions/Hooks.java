package com.gmibank.step_definitions;

import com.gmibank.utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


        @Before
        public void setUpScenario() {
            System.out.println("----> Before annotation: Setting up browser");
        }

        // @Before(value = "@db", order = 1)
        public void setUpDataBaseConnection() {
            System.out.println("------>BEFORE ANNOTATION: DB CONNECTION CREATED <------");
        }

        @After(order = 1)
        public void tearDownScenario(Scenario scenario) { // coming from scenario class
            //  System.out.println("----> After annotation: Closing browser");
            System.out.println("scenario.getName() = " + scenario.getName());

            if (scenario.isFailed()) {
                try {
                    byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                    scenario.embed(screenshot, "image/png");
                    scenario.getStatus();
                    System.out.println("scenario.getName() = " + scenario.getName());
                    scenario.write("This test is written to the report..");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
