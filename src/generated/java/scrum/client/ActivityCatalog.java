// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.generator.ActivityCatalogGenerator










package scrum.client;

import java.util.*;

public class ActivityCatalog
            extends ilarkesto.gwt.client.desktop.AActivityCatalog {

    public java.util.List<String> ACTIVITY_NAMES = java.util.Arrays.asList("ProjectSelectorActivity");

    @Override
    public java.util.List<String> getActivityNames() {
        return ACTIVITY_NAMES;
    }

    @Override
    public  boolean isActivityAvailable(String name) {
        if (name.equals("ProjectSelector")) return true;
        return false;
    }

    @Override
    public ilarkesto.gwt.client.desktop.AActivity instantiateActivity(String name) {
        if (name.equals("ProjectSelector")) return new scrum.client.projectselector.ProjectSelectorActivity();
        throw new IllegalArgumentException("Activity does not exist: " + name);
    }

}