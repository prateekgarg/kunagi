// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.GwtEntityGenerator










package scrum.client.project;

import java.util.*;
import ilarkesto.core.base.Utl;
import ilarkesto.core.logging.Log;
import scrum.client.common.*;
import ilarkesto.gwt.client.*;

public abstract class GRequirement
            extends scrum.client.common.AScrumGwtEntity {

    protected scrum.client.Dao getDao() {
        return scrum.client.Dao.get();
    }

    @Override
    protected void doPersist() {
        getDao().createRequirement((Requirement)this);
    }

    public abstract boolean isEditable();

    public GRequirement() {
    }

    public GRequirement(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "requirement";

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

    public final Requirement setProject(scrum.client.project.Project project) {
        String id = project == null ? null : project.getId();
        if (equals(this.projectId, id)) return (Requirement) this;
        this.projectId = id;
        propertyChanged("projectId", ilarkesto.core.persistance.Persistence.propertyAsString(this.projectId));
        return (Requirement)this;
    }

    public final boolean isProject(scrum.client.project.Project project) {
        String id = project==null ? null : project.getId();
        return equals(this.projectId, id);
    }

    // --- sprint ---

    private String sprintId;

    public final scrum.client.sprint.Sprint getSprint() {
        if (sprintId == null) return null;
        return getDao().getSprint(this.sprintId);
    }

    public final boolean isSprintSet() {
        return sprintId != null;
    }

    public final Requirement setSprint(scrum.client.sprint.Sprint sprint) {
        String id = sprint == null ? null : sprint.getId();
        if (equals(this.sprintId, id)) return (Requirement) this;
        this.sprintId = id;
        propertyChanged("sprintId", ilarkesto.core.persistance.Persistence.propertyAsString(this.sprintId));
        return (Requirement)this;
    }

    public final boolean isSprint(scrum.client.sprint.Sprint sprint) {
        String id = sprint==null ? null : sprint.getId();
        return equals(this.sprintId, id);
    }

    // --- issue ---

    private String issueId;

    public final scrum.client.issues.Issue getIssue() {
        if (issueId == null) return null;
        return getDao().getIssue(this.issueId);
    }

    public final boolean isIssueSet() {
        return issueId != null;
    }

    public final Requirement setIssue(scrum.client.issues.Issue issue) {
        String id = issue == null ? null : issue.getId();
        if (equals(this.issueId, id)) return (Requirement) this;
        this.issueId = id;
        propertyChanged("issueId", ilarkesto.core.persistance.Persistence.propertyAsString(this.issueId));
        return (Requirement)this;
    }

    public final boolean isIssue(scrum.client.issues.Issue issue) {
        String id = issue==null ? null : issue.getId();
        return equals(this.issueId, id);
    }

    // --- number ---

    private int number ;

    public final int getNumber() {
        return this.number ;
    }

    public final Requirement setNumber(int number) {
        if (isNumber(number)) return (Requirement)this;
        this.number = number ;
        propertyChanged("number", ilarkesto.core.persistance.Persistence.propertyAsString(this.number));
        return (Requirement)this;
    }

    public final boolean isNumber(int number) {
        return equals(this.number, number);
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
            return "Requirement_number";
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

    // --- qualitys ---

    private Set<String> qualitysIds = new HashSet<String>();

    public final java.util.Set<scrum.client.project.Quality> getQualitys() {
        if ( qualitysIds.isEmpty()) return Collections.emptySet();
        return getDao().getQualitys(this.qualitysIds);
    }

    public final void setQualitys(Collection<scrum.client.project.Quality> values) {
        qualitysIds = ilarkesto.gwt.client.Gwt.getIdsAsSet(values);
        propertyChanged("qualitysIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.qualitysIds));
    }

    public final void addQuality(scrum.client.project.Quality quality) {
        String id = quality.getId();
        if (qualitysIds.contains(id)) return;
        qualitysIds.add(id);
        propertyChanged("qualitysIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.qualitysIds));
    }

    public final void removeQuality(scrum.client.project.Quality quality) {
        String id = quality.getId();
        if (!qualitysIds.contains(id)) return;
        qualitysIds.remove(id);
        propertyChanged("qualitysIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.qualitysIds));
    }

    public final boolean containsQuality(scrum.client.project.Quality quality) {
        return qualitysIds.contains(quality.getId());
    }


    // --- label ---

    private java.lang.String label ;

    public final java.lang.String getLabel() {
        return this.label ;
    }

    public final Requirement setLabel(java.lang.String label) {
        if (isLabel(label)) return (Requirement)this;
        this.label = label ;
        propertyChanged("label", ilarkesto.core.persistance.Persistence.propertyAsString(this.label));
        return (Requirement)this;
    }

    public final boolean isLabel(java.lang.String label) {
        return equals(this.label, label);
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
            return "Requirement_label";
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
        public boolean isEditable() { return GRequirement.this.isEditable(); }
        @Override
        public String getTooltip() { return "The label should be short (as it appears where the Story is referenced), yet give a hint strong enough to make the content of it come to mind."; }

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

    public final Requirement setDescription(java.lang.String description) {
        if (isDescription(description)) return (Requirement)this;
        this.description = description ;
        propertyChanged("description", ilarkesto.core.persistance.Persistence.propertyAsString(this.description));
        return (Requirement)this;
    }

    public final boolean isDescription(java.lang.String description) {
        return equals(this.description, description);
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
            return "Requirement_description";
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
        public boolean isEditable() { return GRequirement.this.isEditable(); }

        @Override
        public boolean isRichtext() { return true; }
        @Override
        public String getTooltip() { return "The description of a Story should make what the label cannot: It should provide information on what is and what is not part of it. Ideally, it is given in terms of a user story: 'As a [user] I want [function] so that [value].'"; }

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

    public final Requirement setTestDescription(java.lang.String testDescription) {
        if (isTestDescription(testDescription)) return (Requirement)this;
        this.testDescription = testDescription ;
        propertyChanged("testDescription", ilarkesto.core.persistance.Persistence.propertyAsString(this.testDescription));
        return (Requirement)this;
    }

    public final boolean isTestDescription(java.lang.String testDescription) {
        return equals(this.testDescription, testDescription);
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
            return "Requirement_testDescription";
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
        public boolean isEditable() { return GRequirement.this.isEditable(); }

        @Override
        public boolean isRichtext() { return true; }
        @Override
        public String getTooltip() { return "The Test contains requirements that have to be met by the Team in order for the Story to be considered done."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- estimatedWork ---

    private java.lang.Float estimatedWork ;

    public final java.lang.Float getEstimatedWork() {
        return this.estimatedWork ;
    }

    public final Requirement setEstimatedWork(java.lang.Float estimatedWork) {
        if (isEstimatedWork(estimatedWork)) return (Requirement)this;
        this.estimatedWork = estimatedWork ;
        propertyChanged("estimatedWork", ilarkesto.core.persistance.Persistence.propertyAsString(this.estimatedWork));
        return (Requirement)this;
    }

    public final boolean isEstimatedWork(java.lang.Float estimatedWork) {
        return equals(this.estimatedWork, estimatedWork);
    }

    private transient EstimatedWorkModel estimatedWorkModel;

    public EstimatedWorkModel getEstimatedWorkModel() {
        if (estimatedWorkModel == null) estimatedWorkModel = createEstimatedWorkModel();
        return estimatedWorkModel;
    }

    protected EstimatedWorkModel createEstimatedWorkModel() { return new EstimatedWorkModel(); }

    protected class EstimatedWorkModel extends ilarkesto.gwt.client.editor.AFloatEditorModel {

        @Override
        public String getId() {
            return "Requirement_estimatedWork";
        }

        @Override
        public java.lang.Float getValue() {
            return getEstimatedWork();
        }

        @Override
        public void setValue(java.lang.Float value) {
            setEstimatedWork(value);
        }
        @Override
        public String getTooltip() { return "The estimated work gives a relative estimation of effort that needs to be put into the Story to complete it. The bigger the Story the less important the accuracy of the estimation. Big Stories (Epics) close to being worked on should be split to be smaller."; }

        @Override
        protected void onChangeValue(java.lang.Float oldValue, java.lang.Float newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- rejectDate ---

    private ilarkesto.core.time.Date rejectDate ;

    public final ilarkesto.core.time.Date getRejectDate() {
        return this.rejectDate ;
    }

    public final Requirement setRejectDate(ilarkesto.core.time.Date rejectDate) {
        if (isRejectDate(rejectDate)) return (Requirement)this;
        this.rejectDate = rejectDate ;
        propertyChanged("rejectDate", ilarkesto.core.persistance.Persistence.propertyAsString(this.rejectDate));
        return (Requirement)this;
    }

    public final boolean isRejectDate(ilarkesto.core.time.Date rejectDate) {
        return equals(this.rejectDate, rejectDate);
    }

    private transient RejectDateModel rejectDateModel;

    public RejectDateModel getRejectDateModel() {
        if (rejectDateModel == null) rejectDateModel = createRejectDateModel();
        return rejectDateModel;
    }

    protected RejectDateModel createRejectDateModel() { return new RejectDateModel(); }

    protected class RejectDateModel extends ilarkesto.gwt.client.editor.ADateEditorModel {

        @Override
        public String getId() {
            return "Requirement_rejectDate";
        }

        @Override
        public ilarkesto.core.time.Date getValue() {
            return getRejectDate();
        }

        @Override
        public void setValue(ilarkesto.core.time.Date value) {
            setRejectDate(value);
        }

        @Override
        protected void onChangeValue(ilarkesto.core.time.Date oldValue, ilarkesto.core.time.Date newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- closed ---

    private boolean closed ;

    public final boolean isClosed() {
        return this.closed ;
    }

    public final Requirement setClosed(boolean closed) {
        if (isClosed(closed)) return (Requirement)this;
        this.closed = closed ;
        propertyChanged("closed", ilarkesto.core.persistance.Persistence.propertyAsString(this.closed));
        return (Requirement)this;
    }

    public final boolean isClosed(boolean closed) {
        return equals(this.closed, closed);
    }

    private transient ClosedModel closedModel;

    public ClosedModel getClosedModel() {
        if (closedModel == null) closedModel = createClosedModel();
        return closedModel;
    }

    protected ClosedModel createClosedModel() { return new ClosedModel(); }

    protected class ClosedModel extends ilarkesto.gwt.client.editor.ABooleanEditorModel {

        @Override
        public String getId() {
            return "Requirement_closed";
        }

        @Override
        public java.lang.Boolean getValue() {
            return isClosed();
        }

        @Override
        public void setValue(java.lang.Boolean value) {
            setClosed(value);
        }

        @Override
        public boolean isMandatory() { return true; }

        @Override
        protected void onChangeValue(java.lang.Boolean oldValue, java.lang.Boolean newValue) {
            super.onChangeValue(oldValue, newValue);
            if (oldValue == null) return;
            addUndo(this, oldValue);
        }

    }

    // --- deleted ---

    private boolean deleted ;

    public final boolean isDeleted() {
        return this.deleted ;
    }

    public final Requirement setDeleted(boolean deleted) {
        if (isDeleted(deleted)) return (Requirement)this;
        this.deleted = deleted ;
        propertyChanged("deleted", ilarkesto.core.persistance.Persistence.propertyAsString(this.deleted));
        return (Requirement)this;
    }

    public final boolean isDeleted(boolean deleted) {
        return equals(this.deleted, deleted);
    }

    private transient DeletedModel deletedModel;

    public DeletedModel getDeletedModel() {
        if (deletedModel == null) deletedModel = createDeletedModel();
        return deletedModel;
    }

    protected DeletedModel createDeletedModel() { return new DeletedModel(); }

    protected class DeletedModel extends ilarkesto.gwt.client.editor.ABooleanEditorModel {

        @Override
        public String getId() {
            return "Requirement_deleted";
        }

        @Override
        public java.lang.Boolean getValue() {
            return isDeleted();
        }

        @Override
        public void setValue(java.lang.Boolean value) {
            setDeleted(value);
        }

        @Override
        public boolean isMandatory() { return true; }

        @Override
        protected void onChangeValue(java.lang.Boolean oldValue, java.lang.Boolean newValue) {
            super.onChangeValue(oldValue, newValue);
            if (oldValue == null) return;
            addUndo(this, oldValue);
        }

    }

    // --- dirty ---

    private boolean dirty ;

    public final boolean isDirty() {
        return this.dirty ;
    }

    public final Requirement setDirty(boolean dirty) {
        if (isDirty(dirty)) return (Requirement)this;
        this.dirty = dirty ;
        propertyChanged("dirty", ilarkesto.core.persistance.Persistence.propertyAsString(this.dirty));
        return (Requirement)this;
    }

    public final boolean isDirty(boolean dirty) {
        return equals(this.dirty, dirty);
    }

    private transient DirtyModel dirtyModel;

    public DirtyModel getDirtyModel() {
        if (dirtyModel == null) dirtyModel = createDirtyModel();
        return dirtyModel;
    }

    protected DirtyModel createDirtyModel() { return new DirtyModel(); }

    protected class DirtyModel extends ilarkesto.gwt.client.editor.ABooleanEditorModel {

        @Override
        public String getId() {
            return "Requirement_dirty";
        }

        @Override
        public java.lang.Boolean getValue() {
            return isDirty();
        }

        @Override
        public void setValue(java.lang.Boolean value) {
            setDirty(value);
        }

        @Override
        public boolean isMandatory() { return true; }

        @Override
        protected void onChangeValue(java.lang.Boolean oldValue, java.lang.Boolean newValue) {
            super.onChangeValue(oldValue, newValue);
            if (oldValue == null) return;
            addUndo(this, oldValue);
        }

    }

    // --- workEstimationVotingActive ---

    private boolean workEstimationVotingActive ;

    public final boolean isWorkEstimationVotingActive() {
        return this.workEstimationVotingActive ;
    }

    public final Requirement setWorkEstimationVotingActive(boolean workEstimationVotingActive) {
        if (isWorkEstimationVotingActive(workEstimationVotingActive)) return (Requirement)this;
        this.workEstimationVotingActive = workEstimationVotingActive ;
        propertyChanged("workEstimationVotingActive", ilarkesto.core.persistance.Persistence.propertyAsString(this.workEstimationVotingActive));
        return (Requirement)this;
    }

    public final boolean isWorkEstimationVotingActive(boolean workEstimationVotingActive) {
        return equals(this.workEstimationVotingActive, workEstimationVotingActive);
    }

    private transient WorkEstimationVotingActiveModel workEstimationVotingActiveModel;

    public WorkEstimationVotingActiveModel getWorkEstimationVotingActiveModel() {
        if (workEstimationVotingActiveModel == null) workEstimationVotingActiveModel = createWorkEstimationVotingActiveModel();
        return workEstimationVotingActiveModel;
    }

    protected WorkEstimationVotingActiveModel createWorkEstimationVotingActiveModel() { return new WorkEstimationVotingActiveModel(); }

    protected class WorkEstimationVotingActiveModel extends ilarkesto.gwt.client.editor.ABooleanEditorModel {

        @Override
        public String getId() {
            return "Requirement_workEstimationVotingActive";
        }

        @Override
        public java.lang.Boolean getValue() {
            return isWorkEstimationVotingActive();
        }

        @Override
        public void setValue(java.lang.Boolean value) {
            setWorkEstimationVotingActive(value);
        }

        @Override
        public boolean isMandatory() { return true; }

        @Override
        protected void onChangeValue(java.lang.Boolean oldValue, java.lang.Boolean newValue) {
            super.onChangeValue(oldValue, newValue);
            if (oldValue == null) return;
            addUndo(this, oldValue);
        }

    }

    // --- workEstimationVotingShowoff ---

    private boolean workEstimationVotingShowoff ;

    public final boolean isWorkEstimationVotingShowoff() {
        return this.workEstimationVotingShowoff ;
    }

    public final Requirement setWorkEstimationVotingShowoff(boolean workEstimationVotingShowoff) {
        if (isWorkEstimationVotingShowoff(workEstimationVotingShowoff)) return (Requirement)this;
        this.workEstimationVotingShowoff = workEstimationVotingShowoff ;
        propertyChanged("workEstimationVotingShowoff", ilarkesto.core.persistance.Persistence.propertyAsString(this.workEstimationVotingShowoff));
        return (Requirement)this;
    }

    public final boolean isWorkEstimationVotingShowoff(boolean workEstimationVotingShowoff) {
        return equals(this.workEstimationVotingShowoff, workEstimationVotingShowoff);
    }

    private transient WorkEstimationVotingShowoffModel workEstimationVotingShowoffModel;

    public WorkEstimationVotingShowoffModel getWorkEstimationVotingShowoffModel() {
        if (workEstimationVotingShowoffModel == null) workEstimationVotingShowoffModel = createWorkEstimationVotingShowoffModel();
        return workEstimationVotingShowoffModel;
    }

    protected WorkEstimationVotingShowoffModel createWorkEstimationVotingShowoffModel() { return new WorkEstimationVotingShowoffModel(); }

    protected class WorkEstimationVotingShowoffModel extends ilarkesto.gwt.client.editor.ABooleanEditorModel {

        @Override
        public String getId() {
            return "Requirement_workEstimationVotingShowoff";
        }

        @Override
        public java.lang.Boolean getValue() {
            return isWorkEstimationVotingShowoff();
        }

        @Override
        public void setValue(java.lang.Boolean value) {
            setWorkEstimationVotingShowoff(value);
        }

        @Override
        public boolean isMandatory() { return true; }

        @Override
        protected void onChangeValue(java.lang.Boolean oldValue, java.lang.Boolean newValue) {
            super.onChangeValue(oldValue, newValue);
            if (oldValue == null) return;
            addUndo(this, oldValue);
        }

    }

    // --- tasksOrderIds ---

    private java.util.List<java.lang.String> tasksOrderIds = new java.util.ArrayList<java.lang.String>();

    public final java.util.List<java.lang.String> getTasksOrderIds() {
        return new java.util.ArrayList<java.lang.String>(tasksOrderIds);
    }

    public final void setTasksOrderIds(java.util.List<java.lang.String> tasksOrderIds) {
        if (tasksOrderIds == null) throw new IllegalArgumentException("null is not allowed");
        if (this.tasksOrderIds.equals(tasksOrderIds)) return;
        this.tasksOrderIds = new java.util.ArrayList<java.lang.String>(tasksOrderIds);
        propertyChanged("tasksOrderIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.tasksOrderIds));
    }

    public final boolean containsTasksOrderId(java.lang.String tasksOrderId) {
        return tasksOrderIds.contains(tasksOrderId);
    }


    // --- themes ---

    private java.util.List<java.lang.String> themes = new java.util.ArrayList<java.lang.String>();

    public final java.util.List<java.lang.String> getThemes() {
        return new java.util.ArrayList<java.lang.String>(themes);
    }

    public final void setThemes(java.util.List<java.lang.String> themes) {
        if (themes == null) throw new IllegalArgumentException("null is not allowed");
        if (this.themes.equals(themes)) return;
        this.themes = new java.util.ArrayList<java.lang.String>(themes);
        propertyChanged("themes", ilarkesto.core.persistance.Persistence.propertyAsString(this.themes));
    }

    public final boolean containsTheme(java.lang.String theme) {
        return themes.contains(theme);
    }


    // --- epic ---

    private String epicId;

    public final scrum.client.project.Requirement getEpic() {
        if (epicId == null) return null;
        return getDao().getRequirement(this.epicId);
    }

    public final boolean isEpicSet() {
        return epicId != null;
    }

    public final Requirement setEpic(scrum.client.project.Requirement epic) {
        String id = epic == null ? null : epic.getId();
        if (equals(this.epicId, id)) return (Requirement) this;
        this.epicId = id;
        propertyChanged("epicId", ilarkesto.core.persistance.Persistence.propertyAsString(this.epicId));
        return (Requirement)this;
    }

    public final boolean isEpic(scrum.client.project.Requirement epic) {
        String id = epic==null ? null : epic.getId();
        return equals(this.epicId, id);
    }

    // --- externalTrackerId ---

    private java.lang.String externalTrackerId ;

    public final java.lang.String getExternalTrackerId() {
        return this.externalTrackerId ;
    }

    public final Requirement setExternalTrackerId(java.lang.String externalTrackerId) {
        if (isExternalTrackerId(externalTrackerId)) return (Requirement)this;
        this.externalTrackerId = externalTrackerId ;
        propertyChanged("externalTrackerId", ilarkesto.core.persistance.Persistence.propertyAsString(this.externalTrackerId));
        return (Requirement)this;
    }

    public final boolean isExternalTrackerId(java.lang.String externalTrackerId) {
        return equals(this.externalTrackerId, externalTrackerId);
    }

    private transient ExternalTrackerIdModel externalTrackerIdModel;

    public ExternalTrackerIdModel getExternalTrackerIdModel() {
        if (externalTrackerIdModel == null) externalTrackerIdModel = createExternalTrackerIdModel();
        return externalTrackerIdModel;
    }

    protected ExternalTrackerIdModel createExternalTrackerIdModel() { return new ExternalTrackerIdModel(); }

    protected class ExternalTrackerIdModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Requirement_externalTrackerId";
        }

        @Override
        public java.lang.String getValue() {
            return getExternalTrackerId();
        }

        @Override
        public void setValue(java.lang.String value) {
            setExternalTrackerId(value);
        }

        @Override
        public boolean isEditable() { return GRequirement.this.isEditable(); }
        @Override
        public String getTooltip() { return "External system ID. From other bug tracker or else."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
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
            if (property.equals("sprintId")) sprintId = ilarkesto.core.persistance.Persistence.parsePropertyReference(value);
            if (property.equals("issueId")) issueId = ilarkesto.core.persistance.Persistence.parsePropertyReference(value);
            if (property.equals("number")) number = ilarkesto.core.persistance.Persistence.parsePropertyint(value);
            if (property.equals("qualitysIds")) qualitysIds = ilarkesto.core.persistance.Persistence.parsePropertyReferenceSet(value);
            if (property.equals("label")) label = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("description")) description = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("testDescription")) testDescription = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("estimatedWork")) estimatedWork = ilarkesto.core.persistance.Persistence.parsePropertyFloat(value);
            if (property.equals("rejectDate")) rejectDate = ilarkesto.core.persistance.Persistence.parsePropertyDate(value);
            if (property.equals("closed")) closed = ilarkesto.core.persistance.Persistence.parsePropertyboolean(value);
            if (property.equals("deleted")) deleted = ilarkesto.core.persistance.Persistence.parsePropertyboolean(value);
            if (property.equals("dirty")) dirty = ilarkesto.core.persistance.Persistence.parsePropertyboolean(value);
            if (property.equals("workEstimationVotingActive")) workEstimationVotingActive = ilarkesto.core.persistance.Persistence.parsePropertyboolean(value);
            if (property.equals("workEstimationVotingShowoff")) workEstimationVotingShowoff = ilarkesto.core.persistance.Persistence.parsePropertyboolean(value);
            if (property.equals("tasksOrderIds")) tasksOrderIds = ilarkesto.core.persistance.Persistence.parsePropertyStringList(value);
            if (property.equals("themes")) themes = ilarkesto.core.persistance.Persistence.parsePropertyStringList(value);
            if (property.equals("epicId")) epicId = ilarkesto.core.persistance.Persistence.parsePropertyReference(value);
            if (property.equals("externalTrackerId")) externalTrackerId = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
        }
        updateLastModified();
    }

    @Override
    public void storeProperties(Map<String, String> properties) {
        super.storeProperties(properties);
        properties.put("projectId", ilarkesto.core.persistance.Persistence.propertyAsString(this.projectId));
        properties.put("sprintId", ilarkesto.core.persistance.Persistence.propertyAsString(this.sprintId));
        properties.put("issueId", ilarkesto.core.persistance.Persistence.propertyAsString(this.issueId));
        properties.put("number", ilarkesto.core.persistance.Persistence.propertyAsString(this.number));
        properties.put("qualitysIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.qualitysIds));
        properties.put("label", ilarkesto.core.persistance.Persistence.propertyAsString(this.label));
        properties.put("description", ilarkesto.core.persistance.Persistence.propertyAsString(this.description));
        properties.put("testDescription", ilarkesto.core.persistance.Persistence.propertyAsString(this.testDescription));
        properties.put("estimatedWork", ilarkesto.core.persistance.Persistence.propertyAsString(this.estimatedWork));
        properties.put("rejectDate", ilarkesto.core.persistance.Persistence.propertyAsString(this.rejectDate));
        properties.put("closed", ilarkesto.core.persistance.Persistence.propertyAsString(this.closed));
        properties.put("deleted", ilarkesto.core.persistance.Persistence.propertyAsString(this.deleted));
        properties.put("dirty", ilarkesto.core.persistance.Persistence.propertyAsString(this.dirty));
        properties.put("workEstimationVotingActive", ilarkesto.core.persistance.Persistence.propertyAsString(this.workEstimationVotingActive));
        properties.put("workEstimationVotingShowoff", ilarkesto.core.persistance.Persistence.propertyAsString(this.workEstimationVotingShowoff));
        properties.put("tasksOrderIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.tasksOrderIds));
        properties.put("themes", ilarkesto.core.persistance.Persistence.propertyAsString(this.themes));
        properties.put("epicId", ilarkesto.core.persistance.Persistence.propertyAsString(this.epicId));
        properties.put("externalTrackerId", ilarkesto.core.persistance.Persistence.propertyAsString(this.externalTrackerId));
    }

    public final java.util.List<scrum.client.issues.Issue> getIssues() {
        return getDao().getIssuesByStory((Requirement)this);
    }

    public final java.util.List<scrum.client.project.Requirement> getRequirements() {
        return getDao().getRequirementsByEpic((Requirement)this);
    }

    public final java.util.List<scrum.client.sprint.SprintReport> getSprintReports() {
        return getDao().getSprintReportsByCompletedRequirement((Requirement)this);
    }

    public final java.util.List<scrum.client.sprint.SprintReport> getSprintReportWithRejectedRequirementss() {
        return getDao().getSprintReportsByRejectedRequirement((Requirement)this);
    }

    public final java.util.List<scrum.client.sprint.Task> getTasks() {
        return getDao().getTasksByRequirement((Requirement)this);
    }

    public final java.util.List<scrum.client.estimation.RequirementEstimationVote> getRequirementEstimationVotes() {
        return getDao().getRequirementEstimationVotesByRequirement((Requirement)this);
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