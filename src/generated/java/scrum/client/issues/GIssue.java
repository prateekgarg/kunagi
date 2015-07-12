// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.GwtEntityGenerator










package scrum.client.issues;

import java.util.*;
import ilarkesto.core.base.Utl;
import ilarkesto.core.logging.Log;
import scrum.client.common.*;
import ilarkesto.gwt.client.*;

public abstract class GIssue
            extends scrum.client.common.AScrumGwtEntity {

    protected scrum.client.Dao getDao() {
        return scrum.client.Dao.get();
    }

    @Override
    protected void doPersist() {
        getDao().createIssue((Issue)this);
    }

    public GIssue() {
    }

    public GIssue(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "Issue";

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

    public final Issue setProject(scrum.client.project.Project project) {
        String id = project == null ? null : project.getId();
        if (ilarkesto.core.base.Utl.equals(this.projectId, id)) return (Issue) this;
        this.projectId = id;
        propertyChanged("projectId", ilarkesto.core.persistance.Persistence.propertyAsString(this.projectId));
        return (Issue)this;
    }

    public final boolean isProject(scrum.client.project.Project project) {
        String id = project==null ? null : project.getId();
        return ilarkesto.core.base.Utl.equals(this.projectId, id);
    }

    // --- story ---

    private String storyId;

    public final scrum.client.project.Requirement getStory() {
        if (storyId == null) return null;
        return getDao().getRequirement(this.storyId);
    }

    public final boolean isStorySet() {
        return storyId != null;
    }

    public final Issue setStory(scrum.client.project.Requirement story) {
        String id = story == null ? null : story.getId();
        if (ilarkesto.core.base.Utl.equals(this.storyId, id)) return (Issue) this;
        this.storyId = id;
        propertyChanged("storyId", ilarkesto.core.persistance.Persistence.propertyAsString(this.storyId));
        return (Issue)this;
    }

    public final boolean isStory(scrum.client.project.Requirement story) {
        String id = story==null ? null : story.getId();
        return ilarkesto.core.base.Utl.equals(this.storyId, id);
    }

    // --- number ---

    private int number ;

    public final int getNumber() {
        return this.number ;
    }

    public final Issue setNumber(int number) {
        if (isNumber(number)) return (Issue)this;
        this.number = number ;
        propertyChanged("number", ilarkesto.core.persistance.Persistence.propertyAsString(this.number));
        return (Issue)this;
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
            return "Issue_number";
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

    // --- type ---

    private java.lang.String type ;

    public final java.lang.String getType() {
        return this.type ;
    }

    public final Issue setType(java.lang.String type) {
        if (isType(type)) return (Issue)this;
        this.type = type ;
        propertyChanged("type", ilarkesto.core.persistance.Persistence.propertyAsString(this.type));
        return (Issue)this;
    }

    public final boolean isType(java.lang.String type) {
        return ilarkesto.core.base.Utl.equals(this.type, type);
    }

    public abstract List<java.lang.String> getTypeOptions();

    private transient TypeModel typeModel;

    public TypeModel getTypeModel() {
        if (typeModel == null) typeModel = createTypeModel();
        return typeModel;
    }

    protected TypeModel createTypeModel() { return new TypeModel(); }

    protected class TypeModel extends ilarkesto.gwt.client.editor.AOptionEditorModel<java.lang.String> {

        @Override
        public String getId() {
            return "Issue_type";
        }

        @Override
        public java.lang.String getValue() {
            return getType();
        }

        @Override
        public void setValue(java.lang.String value) {
            setType(value);
        }

        @Override
        public List<java.lang.String> getOptions() {
            return getTypeOptions();
        }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- date ---

    private ilarkesto.core.time.DateAndTime date ;

    public final ilarkesto.core.time.DateAndTime getDate() {
        return this.date ;
    }

    public final Issue setDate(ilarkesto.core.time.DateAndTime date) {
        if (isDate(date)) return (Issue)this;
        if (date == null) throw new RuntimeException("Field is mandatory.");
        this.date = date ;
        propertyChanged("date", ilarkesto.core.persistance.Persistence.propertyAsString(this.date));
        return (Issue)this;
    }

    public final boolean isDate(ilarkesto.core.time.DateAndTime date) {
        return ilarkesto.core.base.Utl.equals(this.date, date);
    }

    private transient DateModel dateModel;

    public DateModel getDateModel() {
        if (dateModel == null) dateModel = createDateModel();
        return dateModel;
    }

    protected DateModel createDateModel() { return new DateModel(); }

    protected class DateModel extends ilarkesto.gwt.client.editor.ADateAndTimeEditorModel {

        @Override
        public String getId() {
            return "Issue_date";
        }

        @Override
        public ilarkesto.core.time.DateAndTime getValue() {
            return getDate();
        }

        @Override
        public void setValue(ilarkesto.core.time.DateAndTime value) {
            setDate(value);
        }

        @Override
        public boolean isMandatory() { return true; }

        @Override
        protected void onChangeValue(ilarkesto.core.time.DateAndTime oldValue, ilarkesto.core.time.DateAndTime newValue) {
            super.onChangeValue(oldValue, newValue);
            if (oldValue == null) return;
            addUndo(this, oldValue);
        }

    }

    // --- creator ---

    private String creatorId;

    public final scrum.client.admin.User getCreator() {
        if (creatorId == null) return null;
        return getDao().getUser(this.creatorId);
    }

    public final boolean isCreatorSet() {
        return creatorId != null;
    }

    public final Issue setCreator(scrum.client.admin.User creator) {
        String id = creator == null ? null : creator.getId();
        if (ilarkesto.core.base.Utl.equals(this.creatorId, id)) return (Issue) this;
        this.creatorId = id;
        propertyChanged("creatorId", ilarkesto.core.persistance.Persistence.propertyAsString(this.creatorId));
        return (Issue)this;
    }

    public final boolean isCreator(scrum.client.admin.User creator) {
        String id = creator==null ? null : creator.getId();
        return ilarkesto.core.base.Utl.equals(this.creatorId, id);
    }

    // --- label ---

    private java.lang.String label ;

    public final java.lang.String getLabel() {
        return this.label ;
    }

    public final Issue setLabel(java.lang.String label) {
        if (isLabel(label)) return (Issue)this;
        this.label = label ;
        propertyChanged("label", ilarkesto.core.persistance.Persistence.propertyAsString(this.label));
        return (Issue)this;
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
            return "Issue_label";
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
        public String getTooltip() { return "The label should be short (as it appears where the Issue is referenced), yet give a hint strong enough to make the content of it come to mind."; }

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

    public final Issue setDescription(java.lang.String description) {
        if (isDescription(description)) return (Issue)this;
        this.description = description ;
        propertyChanged("description", ilarkesto.core.persistance.Persistence.propertyAsString(this.description));
        return (Issue)this;
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
            return "Issue_description";
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
        public boolean isRichtext() { return true; }
        @Override
        public String getTooltip() { return "The description of an issue should give enough information for other people to understand what the issue is about. That contains information on how to reproduce an issue and what symptoms are, as well as suggestions on how to fix it."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- additionalInfo ---

    private java.lang.String additionalInfo ;

    public final java.lang.String getAdditionalInfo() {
        return this.additionalInfo ;
    }

    public final Issue setAdditionalInfo(java.lang.String additionalInfo) {
        if (isAdditionalInfo(additionalInfo)) return (Issue)this;
        this.additionalInfo = additionalInfo ;
        propertyChanged("additionalInfo", ilarkesto.core.persistance.Persistence.propertyAsString(this.additionalInfo));
        return (Issue)this;
    }

    public final boolean isAdditionalInfo(java.lang.String additionalInfo) {
        return ilarkesto.core.base.Utl.equals(this.additionalInfo, additionalInfo);
    }

    private transient AdditionalInfoModel additionalInfoModel;

    public AdditionalInfoModel getAdditionalInfoModel() {
        if (additionalInfoModel == null) additionalInfoModel = createAdditionalInfoModel();
        return additionalInfoModel;
    }

    protected AdditionalInfoModel createAdditionalInfoModel() { return new AdditionalInfoModel(); }

    protected class AdditionalInfoModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Issue_additionalInfo";
        }

        @Override
        public java.lang.String getValue() {
            return getAdditionalInfo();
        }

        @Override
        public void setValue(java.lang.String value) {
            setAdditionalInfo(value);
        }

        @Override
        public boolean isRichtext() { return true; }
        @Override
        public String getTooltip() { return "Additional info, only visible to project participants. Can be used for error details like stack traces or other information about the issues environment."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- statement ---

    private java.lang.String statement ;

    public final java.lang.String getStatement() {
        return this.statement ;
    }

    public final Issue setStatement(java.lang.String statement) {
        if (isStatement(statement)) return (Issue)this;
        this.statement = statement ;
        propertyChanged("statement", ilarkesto.core.persistance.Persistence.propertyAsString(this.statement));
        return (Issue)this;
    }

    public final boolean isStatement(java.lang.String statement) {
        return ilarkesto.core.base.Utl.equals(this.statement, statement);
    }

    private transient StatementModel statementModel;

    public StatementModel getStatementModel() {
        if (statementModel == null) statementModel = createStatementModel();
        return statementModel;
    }

    protected StatementModel createStatementModel() { return new StatementModel(); }

    protected class StatementModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Issue_statement";
        }

        @Override
        public java.lang.String getValue() {
            return getStatement();
        }

        @Override
        public void setValue(java.lang.String value) {
            setStatement(value);
        }

        @Override
        public boolean isRichtext() { return true; }
        @Override
        public String getTooltip() { return "Official statement from the Scrum Team to the public about this issue. This could be a  workaround description, the reason or some other information about status of the  issue."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- issuerName ---

    private java.lang.String issuerName ;

    public final java.lang.String getIssuerName() {
        return this.issuerName ;
    }

    public final Issue setIssuerName(java.lang.String issuerName) {
        if (isIssuerName(issuerName)) return (Issue)this;
        this.issuerName = issuerName ;
        propertyChanged("issuerName", ilarkesto.core.persistance.Persistence.propertyAsString(this.issuerName));
        return (Issue)this;
    }

    public final boolean isIssuerName(java.lang.String issuerName) {
        return ilarkesto.core.base.Utl.equals(this.issuerName, issuerName);
    }

    private transient IssuerNameModel issuerNameModel;

    public IssuerNameModel getIssuerNameModel() {
        if (issuerNameModel == null) issuerNameModel = createIssuerNameModel();
        return issuerNameModel;
    }

    protected IssuerNameModel createIssuerNameModel() { return new IssuerNameModel(); }

    protected class IssuerNameModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Issue_issuerName";
        }

        @Override
        public java.lang.String getValue() {
            return getIssuerName();
        }

        @Override
        public void setValue(java.lang.String value) {
            setIssuerName(value);
        }
        @Override
        public String getTooltip() { return "The person who filed this issue."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- issuerEmail ---

    private java.lang.String issuerEmail ;

    public final java.lang.String getIssuerEmail() {
        return this.issuerEmail ;
    }

    public final Issue setIssuerEmail(java.lang.String issuerEmail) {
        if (isIssuerEmail(issuerEmail)) return (Issue)this;
        this.issuerEmail = issuerEmail ;
        propertyChanged("issuerEmail", ilarkesto.core.persistance.Persistence.propertyAsString(this.issuerEmail));
        return (Issue)this;
    }

    public final boolean isIssuerEmail(java.lang.String issuerEmail) {
        return ilarkesto.core.base.Utl.equals(this.issuerEmail, issuerEmail);
    }

    private transient IssuerEmailModel issuerEmailModel;

    public IssuerEmailModel getIssuerEmailModel() {
        if (issuerEmailModel == null) issuerEmailModel = createIssuerEmailModel();
        return issuerEmailModel;
    }

    protected IssuerEmailModel createIssuerEmailModel() { return new IssuerEmailModel(); }

    protected class IssuerEmailModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Issue_issuerEmail";
        }

        @Override
        public java.lang.String getValue() {
            return getIssuerEmail();
        }

        @Override
        public void setValue(java.lang.String value) {
            setIssuerEmail(value);
        }
        @Override
        public String getTooltip() { return "E-Mail address of the person, who filed this issue."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- acceptDate ---

    private ilarkesto.core.time.Date acceptDate ;

    public final ilarkesto.core.time.Date getAcceptDate() {
        return this.acceptDate ;
    }

    public final Issue setAcceptDate(ilarkesto.core.time.Date acceptDate) {
        if (isAcceptDate(acceptDate)) return (Issue)this;
        this.acceptDate = acceptDate ;
        propertyChanged("acceptDate", ilarkesto.core.persistance.Persistence.propertyAsString(this.acceptDate));
        return (Issue)this;
    }

    public final boolean isAcceptDate(ilarkesto.core.time.Date acceptDate) {
        return ilarkesto.core.base.Utl.equals(this.acceptDate, acceptDate);
    }

    private transient AcceptDateModel acceptDateModel;

    public AcceptDateModel getAcceptDateModel() {
        if (acceptDateModel == null) acceptDateModel = createAcceptDateModel();
        return acceptDateModel;
    }

    protected AcceptDateModel createAcceptDateModel() { return new AcceptDateModel(); }

    protected class AcceptDateModel extends ilarkesto.gwt.client.editor.ADateEditorModel {

        @Override
        public String getId() {
            return "Issue_acceptDate";
        }

        @Override
        public ilarkesto.core.time.Date getValue() {
            return getAcceptDate();
        }

        @Override
        public void setValue(ilarkesto.core.time.Date value) {
            setAcceptDate(value);
        }

        @Override
        protected void onChangeValue(ilarkesto.core.time.Date oldValue, ilarkesto.core.time.Date newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- urgent ---

    private boolean urgent ;

    public final boolean isUrgent() {
        return this.urgent ;
    }

    public final Issue setUrgent(boolean urgent) {
        if (isUrgent(urgent)) return (Issue)this;
        this.urgent = urgent ;
        propertyChanged("urgent", ilarkesto.core.persistance.Persistence.propertyAsString(this.urgent));
        return (Issue)this;
    }

    public final boolean isUrgent(boolean urgent) {
        return ilarkesto.core.base.Utl.equals(this.urgent, urgent);
    }

    private transient UrgentModel urgentModel;

    public UrgentModel getUrgentModel() {
        if (urgentModel == null) urgentModel = createUrgentModel();
        return urgentModel;
    }

    protected UrgentModel createUrgentModel() { return new UrgentModel(); }

    protected class UrgentModel extends ilarkesto.gwt.client.editor.ABooleanEditorModel {

        @Override
        public String getId() {
            return "Issue_urgent";
        }

        @Override
        public java.lang.Boolean getValue() {
            return isUrgent();
        }

        @Override
        public void setValue(java.lang.Boolean value) {
            setUrgent(value);
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

    // --- severity ---

    private int severity ;

    public final int getSeverity() {
        return this.severity ;
    }

    public final Issue setSeverity(int severity) {
        if (isSeverity(severity)) return (Issue)this;
        this.severity = severity ;
        propertyChanged("severity", ilarkesto.core.persistance.Persistence.propertyAsString(this.severity));
        return (Issue)this;
    }

    public final boolean isSeverity(int severity) {
        return ilarkesto.core.base.Utl.equals(this.severity, severity);
    }

    public abstract List<java.lang.Integer> getSeverityOptions();

    private transient SeverityModel severityModel;

    public SeverityModel getSeverityModel() {
        if (severityModel == null) severityModel = createSeverityModel();
        return severityModel;
    }

    protected SeverityModel createSeverityModel() { return new SeverityModel(); }

    protected class SeverityModel extends ilarkesto.gwt.client.editor.AOptionEditorModel<java.lang.Integer> {

        @Override
        public String getId() {
            return "Issue_severity";
        }

        @Override
        public java.lang.Integer getValue() {
            return getSeverity();
        }

        @Override
        public void setValue(java.lang.Integer value) {
            setSeverity(value);
        }

        @Override
        public List<java.lang.Integer> getOptions() {
            return getSeverityOptions();
        }

        @Override
        public boolean isMandatory() { return true; }
        @Override
        public String getTooltip() { return "The level of this bug's impact. A minor bug might be a cosmetic failure, a normal bug encumbers the user's work, a severe bug might lead to loss of data or property, a critical bug makes product usage impossible."; }

        @Override
        protected void onChangeValue(java.lang.Integer oldValue, java.lang.Integer newValue) {
            super.onChangeValue(oldValue, newValue);
            if (oldValue == null) return;
            addUndo(this, oldValue);
        }

    }

    // --- owner ---

    private String ownerId;

    public final scrum.client.admin.User getOwner() {
        if (ownerId == null) return null;
        return getDao().getUser(this.ownerId);
    }

    public final boolean isOwnerSet() {
        return ownerId != null;
    }

    public final Issue setOwner(scrum.client.admin.User owner) {
        String id = owner == null ? null : owner.getId();
        if (ilarkesto.core.base.Utl.equals(this.ownerId, id)) return (Issue) this;
        this.ownerId = id;
        propertyChanged("ownerId", ilarkesto.core.persistance.Persistence.propertyAsString(this.ownerId));
        return (Issue)this;
    }

    public final boolean isOwner(scrum.client.admin.User owner) {
        String id = owner==null ? null : owner.getId();
        return ilarkesto.core.base.Utl.equals(this.ownerId, id);
    }

    // --- fixDate ---

    private ilarkesto.core.time.Date fixDate ;

    public final ilarkesto.core.time.Date getFixDate() {
        return this.fixDate ;
    }

    public final Issue setFixDate(ilarkesto.core.time.Date fixDate) {
        if (isFixDate(fixDate)) return (Issue)this;
        this.fixDate = fixDate ;
        propertyChanged("fixDate", ilarkesto.core.persistance.Persistence.propertyAsString(this.fixDate));
        return (Issue)this;
    }

    public final boolean isFixDate(ilarkesto.core.time.Date fixDate) {
        return ilarkesto.core.base.Utl.equals(this.fixDate, fixDate);
    }

    private transient FixDateModel fixDateModel;

    public FixDateModel getFixDateModel() {
        if (fixDateModel == null) fixDateModel = createFixDateModel();
        return fixDateModel;
    }

    protected FixDateModel createFixDateModel() { return new FixDateModel(); }

    protected class FixDateModel extends ilarkesto.gwt.client.editor.ADateEditorModel {

        @Override
        public String getId() {
            return "Issue_fixDate";
        }

        @Override
        public ilarkesto.core.time.Date getValue() {
            return getFixDate();
        }

        @Override
        public void setValue(ilarkesto.core.time.Date value) {
            setFixDate(value);
        }

        @Override
        protected void onChangeValue(ilarkesto.core.time.Date oldValue, ilarkesto.core.time.Date newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- closeDate ---

    private ilarkesto.core.time.Date closeDate ;

    public final ilarkesto.core.time.Date getCloseDate() {
        return this.closeDate ;
    }

    public final Issue setCloseDate(ilarkesto.core.time.Date closeDate) {
        if (isCloseDate(closeDate)) return (Issue)this;
        this.closeDate = closeDate ;
        propertyChanged("closeDate", ilarkesto.core.persistance.Persistence.propertyAsString(this.closeDate));
        return (Issue)this;
    }

    public final boolean isCloseDate(ilarkesto.core.time.Date closeDate) {
        return ilarkesto.core.base.Utl.equals(this.closeDate, closeDate);
    }

    private transient CloseDateModel closeDateModel;

    public CloseDateModel getCloseDateModel() {
        if (closeDateModel == null) closeDateModel = createCloseDateModel();
        return closeDateModel;
    }

    protected CloseDateModel createCloseDateModel() { return new CloseDateModel(); }

    protected class CloseDateModel extends ilarkesto.gwt.client.editor.ADateEditorModel {

        @Override
        public String getId() {
            return "Issue_closeDate";
        }

        @Override
        public ilarkesto.core.time.Date getValue() {
            return getCloseDate();
        }

        @Override
        public void setValue(ilarkesto.core.time.Date value) {
            setCloseDate(value);
        }

        @Override
        protected void onChangeValue(ilarkesto.core.time.Date oldValue, ilarkesto.core.time.Date newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- suspendedUntilDate ---

    private ilarkesto.core.time.Date suspendedUntilDate ;

    public final ilarkesto.core.time.Date getSuspendedUntilDate() {
        return this.suspendedUntilDate ;
    }

    public final Issue setSuspendedUntilDate(ilarkesto.core.time.Date suspendedUntilDate) {
        if (isSuspendedUntilDate(suspendedUntilDate)) return (Issue)this;
        this.suspendedUntilDate = suspendedUntilDate ;
        propertyChanged("suspendedUntilDate", ilarkesto.core.persistance.Persistence.propertyAsString(this.suspendedUntilDate));
        return (Issue)this;
    }

    public final boolean isSuspendedUntilDate(ilarkesto.core.time.Date suspendedUntilDate) {
        return ilarkesto.core.base.Utl.equals(this.suspendedUntilDate, suspendedUntilDate);
    }

    private transient SuspendedUntilDateModel suspendedUntilDateModel;

    public SuspendedUntilDateModel getSuspendedUntilDateModel() {
        if (suspendedUntilDateModel == null) suspendedUntilDateModel = createSuspendedUntilDateModel();
        return suspendedUntilDateModel;
    }

    protected SuspendedUntilDateModel createSuspendedUntilDateModel() { return new SuspendedUntilDateModel(); }

    protected class SuspendedUntilDateModel extends ilarkesto.gwt.client.editor.ADateEditorModel {

        @Override
        public String getId() {
            return "Issue_suspendedUntilDate";
        }

        @Override
        public ilarkesto.core.time.Date getValue() {
            return getSuspendedUntilDate();
        }

        @Override
        public void setValue(ilarkesto.core.time.Date value) {
            setSuspendedUntilDate(value);
        }

        @Override
        protected void onChangeValue(ilarkesto.core.time.Date oldValue, ilarkesto.core.time.Date newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- affectedReleases ---

    private Set<String> affectedReleasesIds = new HashSet<String>();

    public final java.util.Set<scrum.client.release.Release> getAffectedReleases() {
        if ( affectedReleasesIds.isEmpty()) return Collections.emptySet();
        return getDao().getReleases(this.affectedReleasesIds);
    }

    public final void setAffectedReleases(Collection<scrum.client.release.Release> values) {
        affectedReleasesIds = ilarkesto.gwt.client.Gwt.getIdsAsSet(values);
        propertyChanged("affectedReleasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.affectedReleasesIds));
    }

    public final void addAffectedRelease(scrum.client.release.Release affectedRelease) {
        String id = affectedRelease.getId();
        if (affectedReleasesIds.contains(id)) return;
        affectedReleasesIds.add(id);
        propertyChanged("affectedReleasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.affectedReleasesIds));
    }

    public final void removeAffectedRelease(scrum.client.release.Release affectedRelease) {
        String id = affectedRelease.getId();
        if (!affectedReleasesIds.contains(id)) return;
        affectedReleasesIds.remove(id);
        propertyChanged("affectedReleasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.affectedReleasesIds));
    }

    public final boolean containsAffectedRelease(scrum.client.release.Release affectedRelease) {
        return affectedReleasesIds.contains(affectedRelease.getId());
    }


    // --- fixReleases ---

    private Set<String> fixReleasesIds = new HashSet<String>();

    public final java.util.Set<scrum.client.release.Release> getFixReleases() {
        if ( fixReleasesIds.isEmpty()) return Collections.emptySet();
        return getDao().getReleases(this.fixReleasesIds);
    }

    public final void setFixReleases(Collection<scrum.client.release.Release> values) {
        fixReleasesIds = ilarkesto.gwt.client.Gwt.getIdsAsSet(values);
        propertyChanged("fixReleasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.fixReleasesIds));
    }

    public final void addFixRelease(scrum.client.release.Release fixRelease) {
        String id = fixRelease.getId();
        if (fixReleasesIds.contains(id)) return;
        fixReleasesIds.add(id);
        propertyChanged("fixReleasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.fixReleasesIds));
    }

    public final void removeFixRelease(scrum.client.release.Release fixRelease) {
        String id = fixRelease.getId();
        if (!fixReleasesIds.contains(id)) return;
        fixReleasesIds.remove(id);
        propertyChanged("fixReleasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.fixReleasesIds));
    }

    public final boolean containsFixRelease(scrum.client.release.Release fixRelease) {
        return fixReleasesIds.contains(fixRelease.getId());
    }


    // --- published ---

    private boolean published ;

    public final boolean isPublished() {
        return this.published ;
    }

    public final Issue setPublished(boolean published) {
        if (isPublished(published)) return (Issue)this;
        this.published = published ;
        propertyChanged("published", ilarkesto.core.persistance.Persistence.propertyAsString(this.published));
        return (Issue)this;
    }

    public final boolean isPublished(boolean published) {
        return ilarkesto.core.base.Utl.equals(this.published, published);
    }

    private transient PublishedModel publishedModel;

    public PublishedModel getPublishedModel() {
        if (publishedModel == null) publishedModel = createPublishedModel();
        return publishedModel;
    }

    protected PublishedModel createPublishedModel() { return new PublishedModel(); }

    protected class PublishedModel extends ilarkesto.gwt.client.editor.ABooleanEditorModel {

        @Override
        public String getId() {
            return "Issue_published";
        }

        @Override
        public java.lang.Boolean getValue() {
            return isPublished();
        }

        @Override
        public void setValue(java.lang.Boolean value) {
            setPublished(value);
        }

        @Override
        public boolean isMandatory() { return true; }
        @Override
        public String getTooltip() { return "Issue is visible on the public homepage."; }

        @Override
        protected void onChangeValue(java.lang.Boolean oldValue, java.lang.Boolean newValue) {
            super.onChangeValue(oldValue, newValue);
            if (oldValue == null) return;
            addUndo(this, oldValue);
        }

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


    // --- externalTrackerId ---

    private java.lang.String externalTrackerId ;

    public final java.lang.String getExternalTrackerId() {
        return this.externalTrackerId ;
    }

    public final Issue setExternalTrackerId(java.lang.String externalTrackerId) {
        if (isExternalTrackerId(externalTrackerId)) return (Issue)this;
        this.externalTrackerId = externalTrackerId ;
        propertyChanged("externalTrackerId", ilarkesto.core.persistance.Persistence.propertyAsString(this.externalTrackerId));
        return (Issue)this;
    }

    public final boolean isExternalTrackerId(java.lang.String externalTrackerId) {
        return ilarkesto.core.base.Utl.equals(this.externalTrackerId, externalTrackerId);
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
            return "Issue_externalTrackerId";
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
            if (property.equals("storyId")) storyId = ilarkesto.core.persistance.Persistence.parsePropertyReference(value);
            if (property.equals("number")) number = ilarkesto.core.persistance.Persistence.parsePropertyint(value);
            if (property.equals("type")) type = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("date")) date = ilarkesto.core.persistance.Persistence.parsePropertyDateAndTime(value);
            if (property.equals("creatorId")) creatorId = ilarkesto.core.persistance.Persistence.parsePropertyReference(value);
            if (property.equals("label")) label = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("description")) description = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("additionalInfo")) additionalInfo = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("statement")) statement = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("issuerName")) issuerName = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("issuerEmail")) issuerEmail = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("acceptDate")) acceptDate = ilarkesto.core.persistance.Persistence.parsePropertyDate(value);
            if (property.equals("urgent")) urgent = ilarkesto.core.persistance.Persistence.parsePropertyboolean(value);
            if (property.equals("severity")) severity = ilarkesto.core.persistance.Persistence.parsePropertyint(value);
            if (property.equals("ownerId")) ownerId = ilarkesto.core.persistance.Persistence.parsePropertyReference(value);
            if (property.equals("fixDate")) fixDate = ilarkesto.core.persistance.Persistence.parsePropertyDate(value);
            if (property.equals("closeDate")) closeDate = ilarkesto.core.persistance.Persistence.parsePropertyDate(value);
            if (property.equals("suspendedUntilDate")) suspendedUntilDate = ilarkesto.core.persistance.Persistence.parsePropertyDate(value);
            if (property.equals("affectedReleasesIds")) affectedReleasesIds = ilarkesto.core.persistance.Persistence.parsePropertyReferenceSet(value);
            if (property.equals("fixReleasesIds")) fixReleasesIds = ilarkesto.core.persistance.Persistence.parsePropertyReferenceSet(value);
            if (property.equals("published")) published = ilarkesto.core.persistance.Persistence.parsePropertyboolean(value);
            if (property.equals("themes")) themes = ilarkesto.core.persistance.Persistence.parsePropertyStringList(value);
            if (property.equals("externalTrackerId")) externalTrackerId = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
        }
        updateLastModified();
    }

    @Override
    public void storeProperties(Map<String, String> properties) {
        super.storeProperties(properties);
        properties.put("projectId", ilarkesto.core.persistance.Persistence.propertyAsString(this.projectId));
        properties.put("storyId", ilarkesto.core.persistance.Persistence.propertyAsString(this.storyId));
        properties.put("number", ilarkesto.core.persistance.Persistence.propertyAsString(this.number));
        properties.put("type", ilarkesto.core.persistance.Persistence.propertyAsString(this.type));
        properties.put("date", ilarkesto.core.persistance.Persistence.propertyAsString(this.date));
        properties.put("creatorId", ilarkesto.core.persistance.Persistence.propertyAsString(this.creatorId));
        properties.put("label", ilarkesto.core.persistance.Persistence.propertyAsString(this.label));
        properties.put("description", ilarkesto.core.persistance.Persistence.propertyAsString(this.description));
        properties.put("additionalInfo", ilarkesto.core.persistance.Persistence.propertyAsString(this.additionalInfo));
        properties.put("statement", ilarkesto.core.persistance.Persistence.propertyAsString(this.statement));
        properties.put("issuerName", ilarkesto.core.persistance.Persistence.propertyAsString(this.issuerName));
        properties.put("issuerEmail", ilarkesto.core.persistance.Persistence.propertyAsString(this.issuerEmail));
        properties.put("acceptDate", ilarkesto.core.persistance.Persistence.propertyAsString(this.acceptDate));
        properties.put("urgent", ilarkesto.core.persistance.Persistence.propertyAsString(this.urgent));
        properties.put("severity", ilarkesto.core.persistance.Persistence.propertyAsString(this.severity));
        properties.put("ownerId", ilarkesto.core.persistance.Persistence.propertyAsString(this.ownerId));
        properties.put("fixDate", ilarkesto.core.persistance.Persistence.propertyAsString(this.fixDate));
        properties.put("closeDate", ilarkesto.core.persistance.Persistence.propertyAsString(this.closeDate));
        properties.put("suspendedUntilDate", ilarkesto.core.persistance.Persistence.propertyAsString(this.suspendedUntilDate));
        properties.put("affectedReleasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.affectedReleasesIds));
        properties.put("fixReleasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.fixReleasesIds));
        properties.put("published", ilarkesto.core.persistance.Persistence.propertyAsString(this.published));
        properties.put("themes", ilarkesto.core.persistance.Persistence.propertyAsString(this.themes));
        properties.put("externalTrackerId", ilarkesto.core.persistance.Persistence.propertyAsString(this.externalTrackerId));
    }

    public final java.util.List<scrum.client.project.Requirement> getRequirements() {
        return getDao().getRequirementsByIssue((Issue)this);
    }

    @Override
    public boolean matchesKey(String key) {
        if (super.matchesKey(key)) return true;
        if (matchesKey(getLabel(), key)) return true;
        if (matchesKey(getDescription(), key)) return true;
        if (matchesKey(getAdditionalInfo(), key)) return true;
        if (matchesKey(getStatement(), key)) return true;
        return false;
    }

}