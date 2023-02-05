package data.menu;

public enum HeaderSubSubMenuEventsData implements IHeaderSubMenu {
    EVENTS("Календарь мероприятий");
    private final String name;

    HeaderSubSubMenuEventsData(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
