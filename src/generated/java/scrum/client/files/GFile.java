// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.GwtEntityGenerator










package scrum.client.files;

import java.util.*;
import ilarkesto.core.base.Utl;
import ilarkesto.core.logging.Log;
import scrum.client.common.*;
import ilarkesto.gwt.client.*;

public abstract class GFile
            extends scrum.client.common.AScrumGwtEntity {

    protected scrum.client.Dao getDao() {
        return scrum.client.Dao.get();
    }

    @Override
    protected void doPersist() {
        getDao().createFile((File)this);
    }

    @Override
    public void delete() {
        getDao().deleteFile((File)this);
    }

    public GFile() {
    }

    public GFile(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "File";

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

    public final File setProject(scrum.client.project.Project project) {
        String id = project == null ? null : project.getId();
        if (ilarkesto.core.base.Utl.equals(this.projectId, id)) return (File) this;
        this.projectId = id;
        propertyChanged("projectId", ilarkesto.core.persistance.Persistence.propertyAsString(this.projectId));
        return (File)this;
    }

    public final boolean isProject(scrum.client.project.Project project) {
        String id = project==null ? null : project.getId();
        return ilarkesto.core.base.Utl.equals(this.projectId, id);
    }

    // --- filename ---

    private java.lang.String filename ;

    public final java.lang.String getFilename() {
        return this.filename ;
    }

    public final File setFilename(java.lang.String filename) {
        if (isFilename(filename)) return (File)this;
        if (ilarkesto.core.base.Str.isBlank(filename)) throw new RuntimeException("Field is mandatory.");
        this.filename = filename ;
        propertyChanged("filename", ilarkesto.core.persistance.Persistence.propertyAsString(this.filename));
        return (File)this;
    }

    public final boolean isFilename(java.lang.String filename) {
        return ilarkesto.core.base.Utl.equals(this.filename, filename);
    }

    private transient FilenameModel filenameModel;

    public FilenameModel getFilenameModel() {
        if (filenameModel == null) filenameModel = createFilenameModel();
        return filenameModel;
    }

    protected FilenameModel createFilenameModel() { return new FilenameModel(); }

    protected class FilenameModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "File_filename";
        }

        @Override
        public java.lang.String getValue() {
            return getFilename();
        }

        @Override
        public void setValue(java.lang.String value) {
            setFilename(value);
        }

        @Override
        public boolean isMandatory() { return true; }

        @Override
        public boolean isEditable() { return false; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            if (oldValue == null) return;
            addUndo(this, oldValue);
        }

    }

    // --- uploadTime ---

    private ilarkesto.core.time.DateAndTime uploadTime ;

    public final ilarkesto.core.time.DateAndTime getUploadTime() {
        return this.uploadTime ;
    }

    public final File setUploadTime(ilarkesto.core.time.DateAndTime uploadTime) {
        if (isUploadTime(uploadTime)) return (File)this;
        if (uploadTime == null) throw new RuntimeException("Field is mandatory.");
        this.uploadTime = uploadTime ;
        propertyChanged("uploadTime", ilarkesto.core.persistance.Persistence.propertyAsString(this.uploadTime));
        return (File)this;
    }

    public final boolean isUploadTime(ilarkesto.core.time.DateAndTime uploadTime) {
        return ilarkesto.core.base.Utl.equals(this.uploadTime, uploadTime);
    }

    private transient UploadTimeModel uploadTimeModel;

    public UploadTimeModel getUploadTimeModel() {
        if (uploadTimeModel == null) uploadTimeModel = createUploadTimeModel();
        return uploadTimeModel;
    }

    protected UploadTimeModel createUploadTimeModel() { return new UploadTimeModel(); }

    protected class UploadTimeModel extends ilarkesto.gwt.client.editor.ADateAndTimeEditorModel {

        @Override
        public String getId() {
            return "File_uploadTime";
        }

        @Override
        public ilarkesto.core.time.DateAndTime getValue() {
            return getUploadTime();
        }

        @Override
        public void setValue(ilarkesto.core.time.DateAndTime value) {
            setUploadTime(value);
        }

        @Override
        public boolean isMandatory() { return true; }

        @Override
        public boolean isEditable() { return false; }

        @Override
        protected void onChangeValue(ilarkesto.core.time.DateAndTime oldValue, ilarkesto.core.time.DateAndTime newValue) {
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

    public final File setLabel(java.lang.String label) {
        if (isLabel(label)) return (File)this;
        if (ilarkesto.core.base.Str.isBlank(label)) throw new RuntimeException("Field is mandatory.");
        this.label = label ;
        propertyChanged("label", ilarkesto.core.persistance.Persistence.propertyAsString(this.label));
        return (File)this;
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
            return "File_label";
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
        public String getTooltip() { return "The label is used to provide a human readable name for the uploaded file. It may (and probably should) differ from the filename."; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            if (oldValue == null) return;
            addUndo(this, oldValue);
        }

    }

    // --- number ---

    private int number ;

    public final int getNumber() {
        return this.number ;
    }

    public final File setNumber(int number) {
        if (isNumber(number)) return (File)this;
        this.number = number ;
        propertyChanged("number", ilarkesto.core.persistance.Persistence.propertyAsString(this.number));
        return (File)this;
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
            return "File_number";
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

    // --- note ---

    private java.lang.String note ;

    public final java.lang.String getNote() {
        return this.note ;
    }

    public final File setNote(java.lang.String note) {
        if (isNote(note)) return (File)this;
        this.note = note ;
        propertyChanged("note", ilarkesto.core.persistance.Persistence.propertyAsString(this.note));
        return (File)this;
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
            return "File_note";
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
        public String getTooltip() { return "Use this to give additional information on this uploaded file useful for other project members."; }

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
            if (property.equals("filename")) filename = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("uploadTime")) uploadTime = ilarkesto.core.persistance.Persistence.parsePropertyDateAndTime(value);
            if (property.equals("label")) label = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
            if (property.equals("number")) number = ilarkesto.core.persistance.Persistence.parsePropertyint(value);
            if (property.equals("note")) note = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
        }
        updateLastModified();
    }

    @Override
    public void storeProperties(Map<String, String> properties) {
        super.storeProperties(properties);
        properties.put("projectId", ilarkesto.core.persistance.Persistence.propertyAsString(this.projectId));
        properties.put("filename", ilarkesto.core.persistance.Persistence.propertyAsString(this.filename));
        properties.put("uploadTime", ilarkesto.core.persistance.Persistence.propertyAsString(this.uploadTime));
        properties.put("label", ilarkesto.core.persistance.Persistence.propertyAsString(this.label));
        properties.put("number", ilarkesto.core.persistance.Persistence.propertyAsString(this.number));
        properties.put("note", ilarkesto.core.persistance.Persistence.propertyAsString(this.note));
    }

    @Override
    public boolean matchesKey(String key) {
        if (super.matchesKey(key)) return true;
        if (matchesKey(getFilename(), key)) return true;
        if (matchesKey(getLabel(), key)) return true;
        if (matchesKey(getNote(), key)) return true;
        return false;
    }

}