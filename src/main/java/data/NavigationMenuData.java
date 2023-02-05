package data;

public enum NavigationMenuData {
    TESTING("Тестирование");

    private final String name;
    NavigationMenuData(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
