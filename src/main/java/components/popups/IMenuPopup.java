package components.popups;

import data.menu.HeaderMenuItemsData;

public interface IMenuPopup {
    public void popUpShouldNotBeVisible(HeaderMenuItemsData headerMenuItemsData);
    public void popUpShouldBeVisible(HeaderMenuItemsData headerMenuItemsData);
}
