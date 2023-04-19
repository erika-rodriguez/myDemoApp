package com.solvd;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.mobile.common.CartScreenBase;
import com.solvd.mobile.common.CatalogScreenBase;
import com.solvd.mobile.common.ProductScreenBase;
import com.solvd.mobile.common.ReviewSubmittedMessageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests implements IAbstractTest {

    @Test(description = "[TC21]-testMinusButton")
    public void testMinusButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        ProductScreenBase product = catalog.clickOnProduct();
        product.clickOnPlusButton();

        Assert.assertEquals(product.productAmount(), 2, "The Plus button is not Working");
    }

    @Test(description = "[TC23]-testSelectColorButton")
    @TestLabel(name = "testSelectColorButton", value = {"Mobile", "Android"})
    public void testSelectColorButtonAndroid() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        ProductScreenBase product = catalog.clickOnProduct();
        product.clickOnBlueSelectionButton();

        Assert.assertTrue(product.isColorButtonSelected(), "The Blue button is not working");
    }

    @Test(description = "[TC24]-testSelectColorButton-iOS")
    @TestLabel(name = "testSelectColorButton", value = {"Mobile", "iOS"})
    public void testSelectColorButton_iOS() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        ProductScreenBase product = catalog.clickOnProduct();
        product.clickOnBlueSelectionButton();
        product.clickOnAddToCartBtn();
        CartScreenBase cart = catalog.clickOnCart();

        Assert.assertTrue(cart.isColourSelected(), "The Blue button is not working");
    }

    @Test(description = "[TC22]-testAddPlusItemProduct")
    public void testAddPlusItemProduct(){
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        ProductScreenBase product=catalog.clickOnProduct();
        product.clickOnAddItem();

        Assert.assertEquals(product.isItemAdded(), 2);
    }
    @Test(description = "[TC20]-testSubmitReviewOnProduct")
    public void testSubmitReviewOnProduct() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        ProductScreenBase product = catalog.clickOnProduct();
        ReviewSubmittedMessageBase reviewMessage = product.clickOneStarReview();

        Assert.assertTrue(reviewMessage.isReviewSubmitted(), "The review was not submitted.");

    }

}
