// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.GwtEntityGenerator










package scrum.client.project;

import java.util.*;
import ilarkesto.core.base.Utl;
import ilarkesto.core.logging.Log;
import scrum.client.common.*;
import ilarkesto.gwt.client.*;

public abstract class GQuality
            extends scrum.client.common.AScrumGwtEntity {

    protected scrum.client.Dao getDao() {
        return scrum.client.Dao.get();
    }

    @Override
    protected void doPersist() {
        getDao().createQuality((Quality)this);
    }

    @Override
    public void delete() {
        getDao().deleteQuality((Quality)this);
    }

    public abstract boolean isEditable();

    public GQuality() {
    }

    public GQuality(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "Quality";

    @Override
    public final String getEntityType() {
        return ENTITY_TYPE;
    }

    // --- project ---

    private String projectId;

    public final scrum.client.project.Project getProject() {
        if (projectId == null) return null;
        return getDao().getProject(this.projectId);
    }

    public final boolean isProjectSet() {
        return projectId != null;
    }

    public final Quality setProject(scrum.client.project.Project project) {
        String id = project == null ? null : project.getId();
        if (ilarkesto.core.base.Utl.equals(this.projectId, id)) return (Quality) this;
        this.projectId = id;
        propertyChanged("projectId", ilarkesto.core.persistance.Persistence.propertyAsString(this.projectId));
        return (Quality)this;
    }

    public final boolean isProject(scrum.client.project.Project project) {
        String id = project==null ? null : project.getId();
        return ilarkesto.core.base.Utl.equals(this.projectId, id);
    }

    // --- number ---

    private int number ;

    public final int getNumber() {
        return this.number ;
    }

    public final Quality setNumber(int number) {
        if (isNumber(number)) return (Quality)this;
        this.number = number ;
        propertyChanged("number", ilarkesto.core.persistance.Persistence.propertyAsString(this.number));
        return (Quality)this;
    }

    public final boolean isNumber(int number) {
        return ilarkesto.core.base.Utl.equals(this.number, number);
    }

    private transient NumberModel numberModel;

    public NumberModel getNumberModel() {
        if (numberModel == null) numberModel = createNumberModel();
        return numberModel;
    }

    protected NumberModel createNumberModel() { return new NumberModel(); }

    protected class NumberModel extends ilarkesto.gwt.client.editor.AIntegerEditorModel {

        @Override
        public String getId() {
            return "Quality_number";
        }

        @Override
        public java.lang.Integer getValue() {
            return getNumber();
        }

        @Override
        public void setValue(java.lang.Integer value) {
            setNumber(value);
        }

            @Override
            public void increment() {
                setNumber(getNumber() + 1);
            }

            @Override
            public void decrement() {
                setNumber(getNumber() - 1);
            }

        @Override
        public boolean isMandatory() { return true; }

        @Override
        protected void onChangeValue(java.lang.Integer oldValue, java.lang.Integer newValue) {
            super.onChangeValue(oldValue, newValue);
            if (oldValue == null) return;
            addUndo(this, oldValue);
        }

    }

    // --- label ---

    private java.lang.String label ;

    public final java.lang.String getLabel() {
        return this.label ;
    }

    public final Quality setLabel(java.lang.String label) {
        if (isLabel(label)) return (Quality)this;
        this.label = label ;
        propertyChanged("label", ilarkesto.core.persistance.Persistence.propertyAsString(this.label));
        return (Quality)this;
    }

    public final boolean isLabel(java.lang.String label) {
        return ilarkesto.core.base.Utl.equals(this.label, label);
    }

    private transient LabelModel labelModel;

    public LabelModel getLabelModel() {
        if (labelModel == null) labelModel = createLabelModel();
        return labelModel;
    }

    protected LabelModel createLabelModel() { return new LabelModel(); }

    protected class LabelModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Quality_label";
        }

        @Override
        public java.lang.String getValue() {
            return getLabel();
        }

        @Override
        public void setValue(java.lang.String value) {
            setLabel(value);
        }

        @Override
        public boolean isEditable() { return GQuality.this.isEditable(); }
        @Override
        public String getTooltip() { return "The label should be short (as it appears where the Quality is referenced), yet give a hint strong enough to make the content of it come to mind."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- description ---

    private java.lang.String description ;

    public final java.lang.String getDescription() {
        return this.description ;
    }

    public final Quality setDescription(java.lang.String description) {
        if (isDescription(description)) return (Quality)this;
        this.description = description ;
        propertyChanged("description", ilarkesto.core.persistance.Persistence.propertyAsString(this.description));
        return (Quality)this;
    }

    public final boolean isDescription(java.lang.String description) {
        return ilarkesto.core.base.Utl.equals(this.description, description);
    }

    private transient DescriptionModel descriptionModel;

    public DescriptionModel getDescriptionModel() {
        if (descriptionModel == null) descriptionModel = createDescriptionModel();
        return descriptionModel;
    }

    protected DescriptionModel createDescriptionModel() { return new DescriptionModel(); }

    protected class DescriptionModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Quality_description";
        }

        @Override
        public java.lang.String getValue() {
            return getDescription();
        }

        @Override
        public void setValue(java.lang.String value) {
            setDescription(value);
        }

        @Override
        public boolean isEditable() { return GQuality.this.isEditable(); }

        @Override
        public boolean isRichtext() { return true; }
        @Override
        public String getTooltip() { return "The desctiption of a Quality should give detailled information on what the Quality is about and how it affects Storys that reference it."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- testDescription ---

    private java.lang.String testDescription ;

    public final java.lang.String getTestDescription() {
        return this.testDescription ;
    }

    public final Quality setTestDescription(java.lang.String testDescription) {
        if (isTestDescription(testDescription)) return (Quality)this;
        this.testDescription = testDescription ;
        propertyChanged("testDescription", ilarkesto.core.persistance.Persistence.propertyAsString(this.testDescription));
        return (Quality)this;
    }

    public final boolean isTestDescription(java.lang.String testDescription) {
        return ilarkesto.core.base.Utl.equals(this.testDescription, testDescription);
    }

    private transient TestDescriptionModel testDescriptionModel;

    public TestDescriptionModel getTestDescriptionModel() {
        if (testDescriptionModel == null) testDescriptionModel = createTestDescriptionModel();
        return testDescriptionModel;
    }

    protected TestDescriptionModel createTestDescriptionModel() { return new TestDescriptionModel(); }

    protected class TestDescriptionModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Quality_testDescription";
        }

        @Override
        public java.lang.String getValue() {
            return getTestDescription();
        }

        @Override
        public void setValue(java.lang.String value) {
            setTestDescription(value);
        }

        @Override
        public boolean isEditable() { return GQuality.this.isEditable(); }

        @Override
        public boolean isRichtext() { return true; }
        @Override
        public String getTooltip() { return "The Test contains requirements that have to be met by the Team in order for a Story that references this Quality to be considered done."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- autoAdd ---

    private boolean autoAdd ;

    public final boolean isAutoAdd() {
        return this.autoAdd ;
    }

    public final Quality setAutoAdd(boolean autoAdd) {
        if (isAutoAdd(autoAdd)) return (Quality)this;
        this.autoAdd = autoAdd ;
        propertyChanged("autoAdd", ilarkesto.core.persistance.Persistence.propertyAsString(this.autoAdd));
        return (Quality)this;
    }

    public final boolean isAutoAdd(boolean autoAdd) {
        return ilarkesto.core.base.Utl.equals(this.autoAdd, autoAdd);
    }

    private transient AutoAddModel autoAddModel;

    public AutoAddModel getAutoAddModel() {
        if (autoAddModel == null) autoAddModel = createAutoAddModel();
        return autoAddModel;
    }

    protected AutoAddModel createAutoAddModel() { return new AutoAddModel(); }

    protected class AutoAddModel extends ilarkesto.gwt.client.editor.ABooleanEditorModel {

        @Override
        public String getId() {
            return "Quality_autoAdd";
        }

        @Override
        public java.lang.Boolean getValue() {
            return isAutoAdd();
        }

        @Override
        public void setValue(java.lang.Boolean value) {
            setAutoAdd(value);
        }

        @Override
        public boolean isMandatory() { return true; }

        @Override
        public boolean isEditable() { return GQuality.this.isEditable(); }
        @Override
        public String getTooltip() { return "If enabled this quality will be added to all new Stories."; }

        @Override
        protected void onChangeValue(java.lang.Boolean oldValue, java.lang.Boolean newValue) {
            super.onChangeValue(oldValue, newValue);
            if (oldValue == null) return;
            addUndo(this, oldValue);
        }

    }

    // --- update properties by map ---

    public void updateProperties(Map<String, String> properties) {
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            String property = entry.getKey();
            if (property.equals("id")) continue;
            String value = entry.getValue();
            if (property.equals("projectId")) projectId = ilarkesto.core.persistance.Persistence.parsePropertyReference(value);
            if (property.equals("number")) number = ilarkesto.core.persistance.Persistence.parsePropertyint(value);
            if (property.equals("label")) label = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("description")) description = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("testDescription")) testDescription = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("autoAdd")) autoAdd = ilarkesto.core.persistance.Persistence.parsePropertyboolean(value);
        }
        updateLastModified();
    }

    @Override
    public void storeProperties(Map<String, String> properties) {
        super.storeProperties(properties);
        properties.put("projectId", ilarkesto.core.persistance.Persistence.propertyAsString(this.projectId));
        properties.put("number", ilarkesto.core.persistance.Persistence.propertyAsString(this.number));
        properties.put("label", ilarkesto.core.persistance.Persistence.propertyAsString(this.label));
        properties.put("description", ilarkesto.core.persistance.Persistence.propertyAsString(this.description));
        properties.put("testDescription", ilarkesto.core.persistance.Persistence.propertyAsString(this.testDescription));
        properties.put("autoAdd", ilarkesto.core.persistance.Persistence.propertyAsString(this.autoAdd));
    }

    public final java.util.List<scrum.client.admin.ProjectUserConfig> getProjectUserConfigs() {
        return getDao().getProjectUserConfigsByPblFilterQuality((Quality)this);
    }

    public final java.util.List<scrum.client.project.Requirement> getRequirements() {
        return getDao().getRequirementsByQuality((Quality)this);
    }

    @Override
    public boolean matchesKey(String key) {
        if (super.matchesKey(key)) return true;
        if (matchesKey(getLabel(), key)) return true;
        if (matchesKey(getDescription(), key)) return true;
        if (matchesKey(getTestDescription(), key)) return true;
        return false;
    }

}