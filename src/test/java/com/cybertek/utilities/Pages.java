package com.cybertek.utilities;

import com.cybertek.pages.MainPage;
import com.cybertek.pages.ProductPage;

public class Pages {
    private MainPage mainPage;
    private ProductPage productPage;


    public MainPage mainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public ProductPage productPage() {

        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }


}
