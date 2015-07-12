// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.GwtEntityGenerator










package scrum.client.release;

import java.util.*;
import ilarkesto.core.base.Utl;
import ilarkesto.core.logging.Log;
import scrum.client.common.*;
import ilarkesto.gwt.client.*;

public abstract class GRelease
            extends scrum.client.common.AScrumGwtEntity {

    protected scrum.client.Dao getDao() {
        return scrum.client.Dao.get();
    }

    @Override
    protected void doPersist() {
        getDao().createRelease((Release)this);
    }

    @Override
    public void delete() {
        getDao().deleteRelease((Release)this);
    }

    public GRelease() {
    }

    public GRelease(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "Release";

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

    public final Release setProject(scrum.client.project.Project project) {
        String id = project == null ? null : project.getId();
        if (ilarkesto.core.base.Utl.equals(this.projectId, id)) return (Release) this;
        this.projectId = id;
        propertyChanged("projectId", ilarkesto.core.persistance.Persistence.propertyAsString(this.projectId));
        return (Release)this;
    }

    public final boolean isProject(scrum.client.project.Project project) {
        String id = project==null ? null : project.getId();
        return ilarkesto.core.base.Utl.equals(this.projectId, id);
    }

    // --- parentRelease ---

    private String parentReleaseId;

    public final scrum.client.release.Release getParentRelease() {
        if (parentReleaseId == null) return null;
        return getDao().getRelease(this.parentReleaseId);
    }

    public final boolean isParentReleaseSet() {
        return parentReleaseId != null;
    }

    public final Release setParentRelease(scrum.client.release.Release parentRelease) {
        String id = parentRelease == null ? null : parentRelease.getId();
        if (ilarkesto.core.base.Utl.equals(this.parentReleaseId, id)) return (Release) this;
        this.parentReleaseId = id;
        propertyChanged("parentReleaseId", ilarkesto.core.persistance.Persistence.propertyAsString(this.parentReleaseId));
        return (Release)this;
    }

    public final boolean isParentRelease(scrum.client.release.Release parentRelease) {
        String id = parentRelease==null ? null : parentRelease.getId();
        return ilarkesto.core.base.Utl.equals(this.parentReleaseId, id);
    }

    // --- sprints ---

    private Set<String> sprintsIds = new HashSet<String>();

    public final java.util.Set<scrum.client.sprint.Sprint> getSprints() {
        if ( sprintsIds.isEmpty()) return Collections.emptySet();
        return getDao().getSprints(this.sprintsIds);
    }

    public final void setSprints(Collection<scrum.client.sprint.Sprint> values) {
        sprintsIds = ilarkesto.gwt.client.Gwt.getIdsAsSet(values);
        propertyChanged("sprintsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.sprintsIds));
    }

    public final void addSprint(scrum.client.sprint.Sprint sprint) {
        String id = sprint.getId();
        if (sprintsIds.contains(id)) return;
        sprintsIds.add(id);
        propertyChanged("sprintsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.sprintsIds));
    }

    public final void removeSprint(scrum.client.sprint.Sprint sprint) {
        String id = sprint.getId();
        if (!sprintsIds.contains(id)) return;
        sprintsIds.remove(id);
        propertyChanged("sprintsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.sprintsIds));
    }

    public final boolean containsSprint(scrum.client.sprint.Sprint sprint) {
        return sprintsIds.contains(sprint.getId());
    }


    // --- number ---

    private int number ;

    public final int getNumber() {
        return this.number ;
    }

    public final Release setNumber(int number) {
        if (isNumber(number)) return (Release)this;
        this.number = number ;
        propertyChanged("number", ilarkesto.core.persistance.Persistence.propertyAsString(this.number));
        return (Release)this;
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
            return "Release_number";
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

    public final Release setLabel(java.lang.String label) {
        if (isLabel(label)) return (Release)this;
        if (ilarkesto.core.base.Str.isBlank(label)) throw new RuntimeException("Field is mandatory.");
        this.label = label ;
        propertyChanged("label", ilarkesto.core.persistance.Persistence.propertyAsString(this.label));
        return (Release)this;
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
            return "Release_label";
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
        public boolean isMandatory() { return true; }
        @Override
        public String getTooltip() { return "This is the codename of the release, used to refer to it by project members and users."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            if (oldValue == null) return;
            addUndo(this, oldValue);
        }

    }

    // --- note ---

    private java.lang.String note ;

    public final java.lang.String getNote() {
        return this.note ;
    }

    public final Release setNote(java.lang.String note) {
        if (isNote(note)) return (Release)this;
        this.note = note ;
        propertyChanged("note", ilarkesto.core.persistance.Persistence.propertyAsString(this.note));
        return (Release)this;
    }

    public final boolean isNote(java.lang.String note) {
        return ilarkesto.core.base.Utl.equals(this.note, note);
    }

    private transient NoteModel noteModel;

    public NoteModel getNoteModel() {
        if (noteModel == null) noteModel = createNoteModel();
        return noteModel;
    }

    protected NoteModel createNoteModel() { return new NoteModel(); }

    protected class NoteModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Release_note";
        }

        @Override
        public java.lang.String getValue() {
            return getNote();
        }

        @Override
        public void setValue(java.lang.String value) {
            setNote(value);
        }

        @Override
        public boolean isRichtext() { return true; }
        @Override
        public String getTooltip() { return "The development notes contain information useful for project participants and stakeholders while working on the release."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- releaseDate ---

    private ilarkesto.core.time.Date releaseDate ;

    public final ilarkesto.core.time.Date getReleaseDate() {
        return this.releaseDate ;
    }

    public final Release setReleaseDate(ilarkesto.core.time.Date releaseDate) {
        if (isReleaseDate(releaseDate)) return (Release)this;
        this.releaseDate = releaseDate ;
        propertyChanged("releaseDate", ilarkesto.core.persistance.Persistence.propertyAsString(this.releaseDate));
        return (Release)this;
    }

    public final boolean isReleaseDate(ilarkesto.core.time.Date releaseDate) {
        return ilarkesto.core.base.Utl.equals(this.releaseDate, releaseDate);
    }

    private transient ReleaseDateModel releaseDateModel;

    public ReleaseDateModel getReleaseDateModel() {
        if (releaseDateModel == null) releaseDateModel = createReleaseDateModel();
        return releaseDateModel;
    }

    protected ReleaseDateModel createReleaseDateModel() { return new ReleaseDateModel(); }

    protected class ReleaseDateModel extends ilarkesto.gwt.client.editor.ADateEditorModel {

        @Override
        public String getId() {
            return "Release_releaseDate";
        }

        @Override
        public ilarkesto.core.time.Date getValue() {
            return getReleaseDate();
        }

        @Override
        public void setValue(ilarkesto.core.time.Date value) {
            setReleaseDate(value);
        }
        @Override
        public String getTooltip() { return "The intended or actual release date for planned and finished releases, respectively."; }

        @Override
        protected void onChangeValue(ilarkesto.core.time.Date oldValue, ilarkesto.core.time.Date newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- releaseTime ---

    private ilarkesto.core.time.Time releaseTime ;

    public final ilarkesto.core.time.Time getReleaseTime() {
        return this.releaseTime ;
    }

    public final Release setReleaseTime(ilarkesto.core.time.Time releaseTime) {
        if (isReleaseTime(releaseTime)) return (Release)this;
        this.releaseTime = releaseTime ;
        propertyChanged("releaseTime", ilarkesto.core.persistance.Persistence.propertyAsString(this.releaseTime));
        return (Release)this;
    }

    public final boolean isReleaseTime(ilarkesto.core.time.Time releaseTime) {
        return ilarkesto.core.base.Utl.equals(this.releaseTime, releaseTime);
    }

    private transient ReleaseTimeModel releaseTimeModel;

    public ReleaseTimeModel getReleaseTimeModel() {
        if (releaseTimeModel == null) releaseTimeModel = createReleaseTimeModel();
        return releaseTimeModel;
    }

    protected ReleaseTimeModel createReleaseTimeModel() { return new ReleaseTimeModel(); }

    protected class ReleaseTimeModel extends ilarkesto.gwt.client.editor.ATimeEditorModel {

        @Override
        public String getId() {
            return "Release_releaseTime";
        }

        @Override
        public ilarkesto.core.time.Time getValue() {
            return getReleaseTime();
        }

        @Override
        public void setValue(ilarkesto.core.time.Time value) {
            setReleaseTime(value);
        }

        @Override
        protected void onChangeValue(ilarkesto.core.time.Time oldValue, ilarkesto.core.time.Time newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- released ---

    private boolean released ;

    public final boolean isReleased() {
        return this.released ;
    }

    public final Release setReleased(boolean released) {
        if (isReleased(released)) return (Release)this;
        this.released = released ;
        propertyChanged("released", ilarkesto.core.persistance.Persistence.propertyAsString(this.released));
        return (Release)this;
    }

    public final boolean isReleased(boolean released) {
        return ilarkesto.core.base.Utl.equals(this.released, released);
    }

    private transient ReleasedModel releasedModel;

    public ReleasedModel getReleasedModel() {
        if (releasedModel == null) releasedModel = createReleasedModel();
        return releasedModel;
    }

    protected ReleasedModel createReleasedModel() { return new ReleasedModel(); }

    protected class ReleasedModel extends ilarkesto.gwt.client.editor.ABooleanEditorModel {

        @Override
        public String getId() {
            return "Release_released";
        }

        @Override
        public java.lang.Boolean getValue() {
            return isReleased();
        }

        @Override
        public void setValue(java.lang.Boolean value) {
            setReleased(value);
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

    // --- releaseNotes ---

    private java.lang.String releaseNotes ;

    public final java.lang.String getReleaseNotes() {
        return this.releaseNotes ;
    }

    public final Release setReleaseNotes(java.lang.String releaseNotes) {
        if (isReleaseNotes(releaseNotes)) return (Release)this;
        this.releaseNotes = releaseNotes ;
        propertyChanged("releaseNotes", ilarkesto.core.persistance.Persistence.propertyAsString(this.releaseNotes));
        return (Release)this;
    }

    public final boolean isReleaseNotes(java.lang.String releaseNotes) {
        return ilarkesto.core.base.Utl.equals(this.releaseNotes, releaseNotes);
    }

    private transient ReleaseNotesModel releaseNotesModel;

    public ReleaseNotesModel getReleaseNotesModel() {
        if (releaseNotesModel == null) releaseNotesModel = createReleaseNotesModel();
        return releaseNotesModel;
    }

    protected ReleaseNotesModel createReleaseNotesModel() { return new ReleaseNotesModel(); }

    protected class ReleaseNotesModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Release_releaseNotes";
        }

        @Override
        public java.lang.String getValue() {
            return getReleaseNotes();
        }

        @Override
        public void setValue(java.lang.String value) {
            setReleaseNotes(value);
        }

        @Override
        public boolean isRichtext() { return true; }
        @Override
        public String getTooltip() { return "The release notes contain a description used to articulate the changes that this release contains to the public. It should be done in human readable format and an informative manner."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- scmTag ---

    private java.lang.String scmTag ;

    public final java.lang.String getScmTag() {
        return this.scmTag ;
    }

    public final Release setScmTag(java.lang.String scmTag) {
        if (isScmTag(scmTag)) return (Release)this;
        this.scmTag = scmTag ;
        propertyChanged("scmTag", ilarkesto.core.persistance.Persistence.propertyAsString(this.scmTag));
        return (Release)this;
    }

    public final boolean isScmTag(java.lang.String scmTag) {
        return ilarkesto.core.base.Utl.equals(this.scmTag, scmTag);
    }

    private transient ScmTagModel scmTagModel;

    public ScmTagModel getScmTagModel() {
        if (scmTagModel == null) scmTagModel = createScmTagModel();
        return scmTagModel;
    }

    protected ScmTagModel createScmTagModel() { return new ScmTagModel(); }

    protected class ScmTagModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Release_scmTag";
        }

        @Override
        public java.lang.String getValue() {
            return getScmTag();
        }

        @Override
        public void setValue(java.lang.String value) {
            setScmTag(value);
        }
        @Override
        public String getTooltip() { return "The tag used in content management systems for this release."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    // --- scriptRunning ---

    private boolean scriptRunning ;

    public final boolean isScriptRunning() {
        return this.scriptRunning ;
    }

    public final Release setScriptRunning(boolean scriptRunning) {
        if (isScriptRunning(scriptRunning)) return (Release)this;
        this.scriptRunning = scriptRunning ;
        propertyChanged("scriptRunning", ilarkesto.core.persistance.Persistence.propertyAsString(this.scriptRunning));
        return (Release)this;
    }

    public final boolean isScriptRunning(boolean scriptRunning) {
        return ilarkesto.core.base.Utl.equals(this.scriptRunning, scriptRunning);
    }

    private transient ScriptRunningModel scriptRunningModel;

    public ScriptRunningModel getScriptRunningModel() {
        if (scriptRunningModel == null) scriptRunningModel = createScriptRunningModel();
        return scriptRunningModel;
    }

    protected ScriptRunningModel createScriptRunningModel() { return new ScriptRunningModel(); }

    protected class ScriptRunningModel extends ilarkesto.gwt.client.editor.ABooleanEditorModel {

        @Override
        public String getId() {
            return "Release_scriptRunning";
        }

        @Override
        public java.lang.Boolean getValue() {
            return isScriptRunning();
        }

        @Override
        public void setValue(java.lang.Boolean value) {
            setScriptRunning(value);
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

    // --- scriptOutput ---

    private java.lang.String scriptOutput ;

    public final java.lang.String getScriptOutput() {
        return this.scriptOutput ;
    }

    public final Release setScriptOutput(java.lang.String scriptOutput) {
        if (isScriptOutput(scriptOutput)) return (Release)this;
        this.scriptOutput = scriptOutput ;
        propertyChanged("scriptOutput", ilarkesto.core.persistance.Persistence.propertyAsString(this.scriptOutput));
        return (Release)this;
    }

    public final boolean isScriptOutput(java.lang.String scriptOutput) {
        return ilarkesto.core.base.Utl.equals(this.scriptOutput, scriptOutput);
    }

    private transient ScriptOutputModel scriptOutputModel;

    public ScriptOutputModel getScriptOutputModel() {
        if (scriptOutputModel == null) scriptOutputModel = createScriptOutputModel();
        return scriptOutputModel;
    }

    protected ScriptOutputModel createScriptOutputModel() { return new ScriptOutputModel(); }

    protected class ScriptOutputModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Release_scriptOutput";
        }

        @Override
        public java.lang.String getValue() {
            return getScriptOutput();
        }

        @Override
        public void setValue(java.lang.String value) {
            setScriptOutput(value);
        }

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
            if (property.equals("parentReleaseId")) parentReleaseId = ilarkesto.core.persistance.Persistence.parsePropertyReference(value);
            if (property.equals("sprintsIds")) sprintsIds = ilarkesto.core.persistance.Persistence.parsePropertyReferenceSet(value);
            if (property.equals("number")) number = ilarkesto.core.persistance.Persistence.parsePropertyint(value);
            if (property.equals("label")) label = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("note")) note = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("releaseDate")) releaseDate = ilarkesto.core.persistance.Persistence.parsePropertyDate(value);
            if (property.equals("releaseTime")) releaseTime = ilarkesto.core.persistance.Persistence.parsePropertyTime(value);
            if (property.equals("released")) released = ilarkesto.core.persistance.Persistence.parsePropertyboolean(value);
            if (property.equals("releaseNotes")) releaseNotes = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("scmTag")) scmTag = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("scriptRunning")) scriptRunning = ilarkesto.core.persistance.Persistence.parsePropertyboolean(value);
            if (property.equals("scriptOutput")) scriptOutput = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
        }
        updateLastModified();
    }

    @Override
    public void storeProperties(Map<String, String> properties) {
        super.storeProperties(properties);
        properties.put("projectId", ilarkesto.core.persistance.Persistence.propertyAsString(this.projectId));
        properties.put("parentReleaseId", ilarkesto.core.persistance.Persistence.propertyAsString(this.parentReleaseId));
        properties.put("sprintsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.sprintsIds));
        properties.put("number", ilarkesto.core.persistance.Persistence.propertyAsString(this.number));
        properties.put("label", ilarkesto.core.persistance.Persistence.propertyAsString(this.label));
        properties.put("note", ilarkesto.core.persistance.Persistence.propertyAsString(this.note));
        properties.put("releaseDate", ilarkesto.core.persistance.Persistence.propertyAsString(this.releaseDate));
        properties.put("releaseTime", ilarkesto.core.persistance.Persistence.propertyAsString(this.releaseTime));
        properties.put("released", ilarkesto.core.persistance.Persistence.propertyAsString(this.released));
        properties.put("releaseNotes", ilarkesto.core.persistance.Persistence.propertyAsString(this.releaseNotes));
        properties.put("scmTag", ilarkesto.core.persistance.Persistence.propertyAsString(this.scmTag));
        properties.put("scriptRunning", ilarkesto.core.persistance.Persistence.propertyAsString(this.scriptRunning));
        properties.put("scriptOutput", ilarkesto.core.persistance.Persistence.propertyAsString(this.scriptOutput));
    }

    public final java.util.List<scrum.client.release.Release> getReleases() {
        return getDao().getReleasesByParentRelease((Release)this);
    }

    public final java.util.List<scrum.client.issues.Issue> getAffectedIssues() {
        return getDao().getIssuesByAffectedRelease((Release)this);
    }

    public final java.util.List<scrum.client.issues.Issue> getFixIssues() {
        return getDao().getIssuesByFixRelease((Release)this);
    }

    public final java.util.List<scrum.client.pr.BlogEntry> getBlogEntrys() {
        return getDao().getBlogEntrysByRelease((Release)this);
    }

    @Override
    public boolean matchesKey(String key) {
        if (super.matchesKey(key)) return true;
        if (matchesKey(getLabel(), key)) return true;
        if (matchesKey(getNote(), key)) return true;
        if (matchesKey(getReleaseNotes(), key)) return true;
        if (matchesKey(getScmTag(), key)) return true;
        return false;
    }

}