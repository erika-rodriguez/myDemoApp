package com.solvd;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.mobile.common.CatalogScreenBase;
import com.solvd.mobile.common.ReviewSubmittedMessageBase;
import com.solvd.mobile.common.SortingScreenBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTests implements IAbstractTest {


    @Test(description = "[TC14]-testAscendingPriceButton")
    public void testAscendingPriceButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        SortingScreenBase sortingOptions = catalog.clickOnSortingItem();
        CatalogScreenBase sortedCatalog = sortingOptions.clickOnPriceAscendingOrder();

        Assert.assertTrue(sortedCatalog.isCatalogAscendingSorted(), "The catalog is not sorted in ascending order.");
    }

    @Test(description = "[TC13]-testDescendingPriceOrder")
    public void testDescendingPriceOrder() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        SortingScreenBase sortingOptions = catalog.clickOnSortingItem();
        CatalogScreenBase sortedCatalog = sortingOptions.clickOnPriceDescendingOrder();

        Assert.assertTrue(sortedCatalog.isCatalogDescendingSorted(), "The catalog is not sorted in descending order.");
    }

    @Test(description = "[TC-15]-testAscendingNameButton")
    public void testAscendingNameButton() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        SortingScreenBase sortingOptions = catalog.clickOnSortingItem();
        sortingOptions.clickOnNameAscendingOption();

        Assert.assertTrue(catalog.isAscendingNameSorted(), "The catalog is not sorted in ascending order.");
    }

    @Test(description = "[TC12]-testDescendingNameOrder")
    public void testDescendingNameOrder() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        SortingScreenBase sortingOptions = catalog.clickOnSortingItem();
        CatalogScreenBase sortedCatalog = sortingOptions.clickOnNameDescendingOrder();

        Assert.assertTrue(sortedCatalog.isCatalogDescendingNameSorted(), "Catalog's names are not sorted in descending order.");
    }


    @Test(description = "[TC19]-testSubmitReviewOnCatalog")
    public void testSubmitReviewOnCatalog() {
        CatalogScreenBase catalog = initPage(getDriver(), CatalogScreenBase.class);
        ReviewSubmittedMessageBase reviewMessage = catalog.clickOneStarReview();

        Assert.assertTrue(reviewMessage.isReviewSubmitted(), "The review was not submitted.");
    }

}
