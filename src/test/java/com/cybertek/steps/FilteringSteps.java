package com.cybertek.steps;
import com.cybertek.pages.ProductPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import static com.cybertek.utilities.BrowserUtils.*;

public class FilteringSteps extends BrowserUtils {

    Pages pages = new Pages();


    @Given("user goes to the main page {string}")
    public void user_goes_to_the_main_page(String string) {
        string=ConfigurationReader.getProperty("url");
       Driver.getDriver().get(string);
    }

    @Then("user clicks on the link {string}")
    public void user_clicks_on_the_link(String string) {
        clickByText(string).click();
    }

    @Then("user types in the make and model text box {string}")
    public void user_types_in_the_make_and_model_text_box(String string) {
        string=ConfigurationReader.getProperty("make");
        pages.mainPage().makeBox.sendKeys(string);
    }

    @Then("user types in the miles text box {string}")
    public void user_types_in_the_miles_text_box(String string) {
        string=ConfigurationReader.getProperty("miles");
        pages.mainPage().milesBox.sendKeys(string);
    }

    @Then("user types in the ZIP text box {string}")
    public void user_types_in_the_ZIP_text_box(String string) {
        string=ConfigurationReader.getProperty("zipCode");
        pages.mainPage().zipBox.sendKeys(string);
    }
    @Then("user types in the year text box {string}")
    public void user_types_in_the_year_text_box(String string) {
        string=ConfigurationReader.getProperty("minYear");
        pages.mainPage().minYearBox.sendKeys(string+Keys.ENTER);
    }

    @When("the filtered options of {string} appear on the page")
    public void the_filtered_options_of_appear_on_the_page(String string) {

        Select select = new Select(pages.mainPage().subCatSearchBox);
        String actualProduct = select.getFirstSelectedOption().getText();
//        string = ConfigurationReader.getProperty("product");
        System.out.println(actualProduct);
        System.out.println(string);
        waitForVisibility(pages.mainPage().subCatSearchBox,5);

        Assert.assertTrue("searched product sis not appear",actualProduct.equals(string));

    }

    @Then("year of the selected motorcycle must be greater or equal to {string}")
    public void year_of_the_selected_motorcycle_must_be_greater_or_equal_to(String string) {
        string=ConfigurationReader.getProperty("make");
        clickByPartialText(string).click();
        String yearText = pages.productPage().yearTextBox.getText();// 2005 BMW FSTC
        String [] yearArray = yearText.split(" ");
        yearText = yearArray [0]; // 2005 as a string
        int actualYearInt = Integer.valueOf(yearText); // 2005 as int
        int expectedYear =Integer.valueOf(ConfigurationReader.getProperty("minYear"));
        System.out.println(actualYearInt);
        System.out.println(expectedYear);

        Assert.assertTrue("year of the product is wrong",expectedYear<=actualYearInt);


    }
  }
