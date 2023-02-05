package data;

public enum TestCoursePageVersionData {
    QALEAD("qalead"),
    QAENGINEER("qaengineerbasic"),
    JAVAQAPRO("java qa pro"),
    AVTOMATIZACIYAWEBTESTIROVANIYA("avtomatizaciyawebtestirovaniya"),
    QAJS("qajs"),
    LOADQA("loadqa"),
    JAVAQABASIC("javaqabasic"),
    QAAUTOJAVASPECIALIZATION("qaautojavaspecialization"),
    KOTLINQAENGINEER("kotlinqaengineer"),
    QAGAME("qagame"),
    MANUALTESTING("manualtesting"),
    TESTAUTOMATIONOPENSTACK("testautomationopenstack");
    private final String name;
    TestCoursePageVersionData(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
