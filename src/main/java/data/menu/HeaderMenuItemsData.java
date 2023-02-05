package data.menu;

public enum HeaderMenuItemsData {
    LEARNING("learning");

    private final String name;

    HeaderMenuItemsData(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
