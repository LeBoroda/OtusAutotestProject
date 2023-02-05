package data;

public enum EventsMenuData {
    OPENDOORS("open_doors", "День открытых дверей");
    private final String name;
    private final String categoryNameOnTile;
    EventsMenuData(String name, String categoryNameOnTile){
        this.name = name;
        this.categoryNameOnTile = categoryNameOnTile;
    }

    public String getName() {
        return name;
    }

    public String getCategoryNameOnTile(){
        return categoryNameOnTile;
    }
}
