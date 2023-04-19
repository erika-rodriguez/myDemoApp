package com.solvd;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.mobile.common.CartScreenBase;
import com.solvd.mobile.common.CatalogScreenBase;
import com.solvd.mobile.common.NoItemScreenBase;
import com.solvd.mobile.common.ProductScreenBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests implements IAbstractTest {

    @Test(description = "[TC17]-testRemoveProductFromCartButton", dependsOnMethods = "testAddProductToCart")
    public void testRemoveProductFromCartButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        CartScreenBase product = catalog.clickOnCart();
        NoItemScreenBase noItemScreenBase = product.clickOnRemove();

        Assert.assertTrue(noItemScreenBase.isElementPresent(), "The product was not deleted");
    }

    @Test(description = "[TC16]-testAddProductToCart")
    public void testAddProductToCart() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        ProductScreenBase product = catalog.clickOnProduct();
        product.clickOnAddToCartBtn();
        CartScreenBase cart = catalog.clickOnCart();

        Assert.assertTrue(cart.isProductAdded(), "The product was not added to the cart.");
    }


    @Test(description = "[TC18]-testCalculatorOnCart")
    public void testCalculatorOnCart() {
        //As a precondition the cart must be empty
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        ProductScreenBase product = catalog.clickOnProduct();
        product.clickOnAddToCartBtn();
        CartScreenBase cart = catalog.clickOnCart();
        cart.clickOnPlusButton();

        Assert.assertEquals(cart.calculatorSum(), 5998, "The Calculator is not working");

    }
    @Test(description = "[TC25]-testGoShoppingBtn")
    public void testGoShoppingBtn(){
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        CartScreenBase cart=catalog.clickOnCart();
        catalog=cart.clickOnGoShoppingBtn();

        Assert.assertTrue(catalog.isProductsTxtPresent(),"GoShopping button did not work.");
    }

}
