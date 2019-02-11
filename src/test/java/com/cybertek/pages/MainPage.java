package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "auto_make_model")
    public WebElement makeBox;

    @FindBy(name = "search_distance")
    public WebElement searchDistanceBox;

    @FindBy(name = "postal")
    public WebElement zipCodeBox;

    @FindBy(name = "min_auto_year")
    public WebElement minYearBox;

    @FindBy(id = "subcatAbb")
    public WebElement subCatSearchBox;









}
