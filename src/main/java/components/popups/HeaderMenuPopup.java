package components.popups;

import components.AbsComponent;
import data.menu.HeaderMenuItemsData;
import data.menu.IHeaderSubMenu;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderMenuPopup extends AbsComponent implements IMenuPopup {
    private final String headerMenuPopUPSelector = "[data-name='%s'].js-header3-popup";
    private final String subMenuItemByNameLocator = "(//*[contains(@class, 'header3__nav-item-popup-content')]//a[contains(text(), '%s')])[1]";

    public HeaderMenuPopup(WebDriver driver) {
        super(driver);
    }

    @Override
    public void popUpShouldNotBeVisible(HeaderMenuItemsData headerMenuItemsData) {
        String selector = String.format(headerMenuPopUPSelector, headerMenuItemsData.getName().toLowerCase());
        Assertions.assertTrue(waiter.waitForCondition(
                ExpectedConditions.attributeContains($(By.cssSelector(selector)),
                        "style", "none")));
    }

    @Override
    public void popUpShouldBeVisible(HeaderMenuItemsData headerMenuItemsData) {
        String selector = String.format(headerMenuPopUPSelector, headerMenuItemsData.getName().toLowerCase());
        Assertions.assertTrue(waiter.waitForCondition(
                ExpectedConditions.not(
                        ExpectedConditions.attributeContains($(By.cssSelector(selector)),
                                "style", "none"))));
    }

    public void clickMenuItemByName(IHeaderSubMenu subMenuItemData) {
        String locator = String.format(subMenuItemByNameLocator, subMenuItemData.getName());
        $(By.xpath(locator)).click();
    }
}
