// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: scrum.mda.KunagiModelApplication$1










package scrum.client.journal;

import java.util.*;
import ilarkesto.core.base.Utl;
import ilarkesto.core.logging.Log;
import ilarkesto.core.base.Str;
import ilarkesto.core.persistance.AEntity;
import ilarkesto.core.persistance.EntityDoesNotExistException;

public abstract class GChange
            extends scrum.client.common.AScrumGwtEntity
            implements java.lang.Comparable<Change> {

    protected static final ilarkesto.core.logging.Log log = ilarkesto.core.logging.Log.get(Change.class);

    private static transient ilarkesto.core.persistance.AEntitySetBackReferenceHelper<Change> parentBackReferencesCache = new ilarkesto.core.persistance.AEntitySetBackReferenceHelper<Change>() {
    @Override
        protected Set<Change> loadById(final String id) {
        return new AChangeQuery() {
            @Override
            public boolean test(Change entity) {
                return id.equals(entity.getParentId());
            }
            @Override
            public String toString() {
                return "Change:byParent";
            }
        }.list();
        }
    };

    public static Set< Change> listByParent(final scrum.client.common.AScrumGwtEntity parent) {
        if (parent == null) return new HashSet<Change>();
        return parentBackReferencesCache.getById(parent.getId());
    }

    private static transient ilarkesto.core.persistance.AEntitySetBackReferenceHelper<Change> userBackReferencesCache = new ilarkesto.core.persistance.AEntitySetBackReferenceHelper<Change>() {
    @Override
        protected Set<Change> loadById(final String id) {
        return new AChangeQuery() {
            @Override
            public boolean test(Change entity) {
                return id.equals(entity.getUserId());
            }
            @Override
            public String toString() {
                return "Change:byUser";
            }
        }.list();
        }
    };

    public static Set< Change> listByUser(final scrum.client.admin.User user) {
        if (user == null) return new HashSet<Change>();
        return userBackReferencesCache.getById(user.getId());
    }

    public static Set< Change> listByDateAndTime(final ilarkesto.core.time.DateAndTime dateAndTime) {
        return new AChangeQuery() {
            @Override
            public boolean test(Change entity) {
                return entity.isDateAndTime(dateAndTime);
            }
            @Override
            public String toString() {
                return "Change:byDateAndTime";
            }
        }.list();
    }

    public static Set< Change> listByKey(final java.lang.String key) {
        return new AChangeQuery() {
            @Override
            public boolean test(Change entity) {
                return entity.isKey(key);
            }
            @Override
            public String toString() {
                return "Change:byKey";
            }
        }.list();
    }

    public static Set< Change> listByOldValue(final java.lang.String oldValue) {
        return new AChangeQuery() {
            @Override
            public boolean test(Change entity) {
                return entity.isOldValue(oldValue);
            }
            @Override
            public String toString() {
                return "Change:byOldValue";
            }
        }.list();
    }

    public static Set< Change> listByNewValue(final java.lang.String newValue) {
        return new AChangeQuery() {
            @Override
            public boolean test(Change entity) {
                return entity.isNewValue(newValue);
            }
            @Override
            public String toString() {
                return "Change:byNewValue";
            }
        }.list();
    }

    public static Set< Change> listByComment(final java.lang.String comment) {
        return new AChangeQuery() {
            @Override
            public boolean test(Change entity) {
                return entity.isComment(comment);
            }
            @Override
            public String toString() {
                return "Change:byComment";
            }
        }.list();
    }

    @Override
    protected void onAfterPersist() {
        super.onAfterPersist();
        parentBackReferencesCache.clear(getParentId());
        userBackReferencesCache.clear(getUserId());
    }

    public abstract static class AChangeQuery extends ilarkesto.core.persistance.AEntityQuery<Change> {
    @Override
        public Class<Change> getType() {
            return Change.class;
        }
    }

    public static Set<Change> listAll() {
        return new ilarkesto.core.persistance.AllByTypeQuery(Change.class).list();
    }

    public static Change getById(String id) {
        return (Change) AEntity.getById(id);
    }

    @Override
    public Set<ilarkesto.core.persistance.Entity> getReferencedEntities() {
        Set<ilarkesto.core.persistance.Entity> ret = super.getReferencedEntities();
    // --- references ---
        try { Utl.addIfNotNull(ret, getParent()); } catch(EntityDoesNotExistException ex) {}
        try { Utl.addIfNotNull(ret, getUser()); } catch(EntityDoesNotExistException ex) {}
        return ret;
    }

    @Override
    public void storeProperties(Map<String, String> properties) {
        super.storeProperties(properties);
        properties.put("parentId", ilarkesto.core.persistance.Persistence.propertyAsString(this.parentId));
        properties.put("userId", ilarkesto.core.persistance.Persistence.propertyAsString(this.userId));
        properties.put("dateAndTime", ilarkesto.core.persistance.Persistence.propertyAsString(this.dateAndTime));
        properties.put("key", ilarkesto.core.persistance.Persistence.propertyAsString(this.key));
        properties.put("oldValue", ilarkesto.core.persistance.Persistence.propertyAsString(this.oldValue));
        properties.put("newValue", ilarkesto.core.persistance.Persistence.propertyAsString(this.newValue));
        properties.put("comment", ilarkesto.core.persistance.Persistence.propertyAsString(this.comment));
    }

    @Override
    public int compareTo(Change other) {
        return ilarkesto.core.localization.GermanComparator.INSTANCE.compare(toString(), other.toString());
    }

    private static final ilarkesto.core.logging.Log LOG = ilarkesto.core.logging.Log.get(GChange.class);

    public static final String TYPE = "Change";

    // -----------------------------------------------------------
    // - parent
    // -----------------------------------------------------------

    private String parentId;

    public final String getParentId() {
        return this.parentId;
    }

    public final scrum.client.common.AScrumGwtEntity getParent() {
        try {
            return this.parentId == null ? null : (scrum.client.common.AScrumGwtEntity) AEntity.getById(this.parentId);
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            throw ex.setCallerInfo("Change.parent");
        }
    }

    public final void setParent(scrum.client.common.AScrumGwtEntity parent) {
        parent = prepareParent(parent);
        if (isParent(parent)) return;
        setParentId(parent == null ? null : parent.getId());
    }

    public final void setParentId(String id) {
        if (Utl.equals(parentId, id)) return;
        clearParentBackReferenceCache(id, this.parentId);
        this.parentId = id;
            updateLastModified();
            fireModified("parentId", ilarkesto.core.persistance.Persistence.propertyAsString(this.parentId));
    }

    private void clearParentBackReferenceCache(String oldId, String newId) {
        parentBackReferencesCache.clear(oldId);
        parentBackReferencesCache.clear(newId);
    }

    private final void updateParentId(String id) {
        setParentId(id);
    }

    protected scrum.client.common.AScrumGwtEntity prepareParent(scrum.client.common.AScrumGwtEntity parent) {
        return parent;
    }

    protected void repairDeadParentReference(String entityId) {
        if (!isPersisted()) return;
        if (this.parentId == null || entityId.equals(this.parentId)) {
            repairMissingMaster();
        }
    }

    public final boolean isParentSet() {
        return this.parentId != null;
    }

    public final boolean isParent(scrum.client.common.AScrumGwtEntity parent) {
        if (this.parentId == null && parent == null) return true;
        return parent != null && parent.getId().equals(this.parentId);
    }


    // -----------------------------------------------------------
    // - user
    // -----------------------------------------------------------

    private String userId;

    public final String getUserId() {
        return this.userId;
    }

    public final scrum.client.admin.User getUser() {
        try {
            return this.userId == null ? null : (scrum.client.admin.User) AEntity.getById(this.userId);
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            throw ex.setCallerInfo("Change.user");
        }
    }

    public final void setUser(scrum.client.admin.User user) {
        user = prepareUser(user);
        if (isUser(user)) return;
        setUserId(user == null ? null : user.getId());
    }

    public final void setUserId(String id) {
        if (Utl.equals(userId, id)) return;
        clearUserBackReferenceCache(id, this.userId);
        this.userId = id;
            updateLastModified();
            fireModified("userId", ilarkesto.core.persistance.Persistence.propertyAsString(this.userId));
    }

    private void clearUserBackReferenceCache(String oldId, String newId) {
        userBackReferencesCache.clear(oldId);
        userBackReferencesCache.clear(newId);
    }

    private final void updateUserId(String id) {
        setUserId(id);
    }

    protected scrum.client.admin.User prepareUser(scrum.client.admin.User user) {
        return user;
    }

    protected void repairDeadUserReference(String entityId) {
        if (!isPersisted()) return;
        if (this.userId == null || entityId.equals(this.userId)) {
            setUser(null);
        }
    }

    public final boolean isUserSet() {
        return this.userId != null;
    }

    public final boolean isUser(scrum.client.admin.User user) {
        if (this.userId == null && user == null) return true;
        return user != null && user.getId().equals(this.userId);
    }


    // -----------------------------------------------------------
    // - dateAndTime
    // -----------------------------------------------------------

    private ilarkesto.core.time.DateAndTime dateAndTime;

    public final ilarkesto.core.time.DateAndTime getDateAndTime() {
        return dateAndTime;
    }

    public final void setDateAndTime(ilarkesto.core.time.DateAndTime dateAndTime) {
        dateAndTime = prepareDateAndTime(dateAndTime);
        if (isDateAndTime(dateAndTime)) return;
        if (dateAndTime == null) throw new IllegalArgumentException("Mandatory field can not be set to null: dateAndTime");
        this.dateAndTime = dateAndTime;
            updateLastModified();
            fireModified("dateAndTime", ilarkesto.core.persistance.Persistence.propertyAsString(this.dateAndTime));
    }

    private final void updateDateAndTime(ilarkesto.core.time.DateAndTime dateAndTime) {
        if (isDateAndTime(dateAndTime)) return;
        if (dateAndTime == null) throw new IllegalArgumentException("Mandatory field can not be set to null: dateAndTime");
        this.dateAndTime = dateAndTime;
            updateLastModified();
            fireModified("dateAndTime", ilarkesto.core.persistance.Persistence.propertyAsString(this.dateAndTime));
    }

    protected ilarkesto.core.time.DateAndTime prepareDateAndTime(ilarkesto.core.time.DateAndTime dateAndTime) {
        return dateAndTime;
    }

    public final boolean isDateAndTimeSet() {
        return this.dateAndTime != null;
    }

    public final boolean isDateAndTime(ilarkesto.core.time.DateAndTime dateAndTime) {
        if (this.dateAndTime == null && dateAndTime == null) return true;
        return this.dateAndTime != null && this.dateAndTime.equals(dateAndTime);
    }

    protected final void updateDateAndTime(Object value) {
        value = value == null ? null : new ilarkesto.core.time.DateAndTime((String)value);
        setDateAndTime((ilarkesto.core.time.DateAndTime)value);
    }

    // -----------------------------------------------------------
    // - key
    // -----------------------------------------------------------

    private java.lang.String key;

    public final java.lang.String getKey() {
        return key;
    }

    public final void setKey(java.lang.String key) {
        key = prepareKey(key);
        if (isKey(key)) return;
        this.key = key;
            updateLastModified();
            fireModified("key", ilarkesto.core.persistance.Persistence.propertyAsString(this.key));
    }

    private final void updateKey(java.lang.String key) {
        if (isKey(key)) return;
        this.key = key;
            updateLastModified();
            fireModified("key", ilarkesto.core.persistance.Persistence.propertyAsString(this.key));
    }

    protected java.lang.String prepareKey(java.lang.String key) {
        // key = Str.removeUnreadableChars(key);
        return key;
    }

    public final boolean isKeySet() {
        return this.key != null;
    }

    public final boolean isKey(java.lang.String key) {
        if (this.key == null && key == null) return true;
        return this.key != null && this.key.equals(key);
    }

    protected final void updateKey(Object value) {
        setKey((java.lang.String)value);
    }

    // -----------------------------------------------------------
    // - oldValue
    // -----------------------------------------------------------

    private java.lang.String oldValue;

    public final java.lang.String getOldValue() {
        return oldValue;
    }

    public final void setOldValue(java.lang.String oldValue) {
        oldValue = prepareOldValue(oldValue);
        if (isOldValue(oldValue)) return;
        this.oldValue = oldValue;
            updateLastModified();
            fireModified("oldValue", ilarkesto.core.persistance.Persistence.propertyAsString(this.oldValue));
    }

    private final void updateOldValue(java.lang.String oldValue) {
        if (isOldValue(oldValue)) return;
        this.oldValue = oldValue;
            updateLastModified();
            fireModified("oldValue", ilarkesto.core.persistance.Persistence.propertyAsString(this.oldValue));
    }

    protected java.lang.String prepareOldValue(java.lang.String oldValue) {
        // oldValue = Str.removeUnreadableChars(oldValue);
        return oldValue;
    }

    public final boolean isOldValueSet() {
        return this.oldValue != null;
    }

    public final boolean isOldValue(java.lang.String oldValue) {
        if (this.oldValue == null && oldValue == null) return true;
        return this.oldValue != null && this.oldValue.equals(oldValue);
    }

    protected final void updateOldValue(Object value) {
        setOldValue((java.lang.String)value);
    }

    // -----------------------------------------------------------
    // - newValue
    // -----------------------------------------------------------

    private java.lang.String newValue;

    public final java.lang.String getNewValue() {
        return newValue;
    }

    public final void setNewValue(java.lang.String newValue) {
        newValue = prepareNewValue(newValue);
        if (isNewValue(newValue)) return;
        this.newValue = newValue;
            updateLastModified();
            fireModified("newValue", ilarkesto.core.persistance.Persistence.propertyAsString(this.newValue));
    }

    private final void updateNewValue(java.lang.String newValue) {
        if (isNewValue(newValue)) return;
        this.newValue = newValue;
            updateLastModified();
            fireModified("newValue", ilarkesto.core.persistance.Persistence.propertyAsString(this.newValue));
    }

    protected java.lang.String prepareNewValue(java.lang.String newValue) {
        // newValue = Str.removeUnreadableChars(newValue);
        return newValue;
    }

    public final boolean isNewValueSet() {
        return this.newValue != null;
    }

    public final boolean isNewValue(java.lang.String newValue) {
        if (this.newValue == null && newValue == null) return true;
        return this.newValue != null && this.newValue.equals(newValue);
    }

    protected final void updateNewValue(Object value) {
        setNewValue((java.lang.String)value);
    }

    // -----------------------------------------------------------
    // - comment
    // -----------------------------------------------------------

    private java.lang.String comment;

    public final java.lang.String getComment() {
        return comment;
    }

    public final void setComment(java.lang.String comment) {
        comment = prepareComment(comment);
        if (isComment(comment)) return;
        this.comment = comment;
            updateLastModified();
            fireModified("comment", ilarkesto.core.persistance.Persistence.propertyAsString(this.comment));
    }

    private final void updateComment(java.lang.String comment) {
        if (isComment(comment)) return;
        this.comment = comment;
            updateLastModified();
            fireModified("comment", ilarkesto.core.persistance.Persistence.propertyAsString(this.comment));
    }

    protected java.lang.String prepareComment(java.lang.String comment) {
        // comment = Str.removeUnreadableChars(comment);
        return comment;
    }

    public final boolean isCommentSet() {
        return this.comment != null;
    }

    public final boolean isComment(java.lang.String comment) {
        if (this.comment == null && comment == null) return true;
        return this.comment != null && this.comment.equals(comment);
    }

    protected final void updateComment(Object value) {
        setComment((java.lang.String)value);
    }

    public void updateProperties(Map<String, String> properties) {
        super.updateProperties(properties);
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            String property = entry.getKey();
            if (property.equals("id")) continue;
            String value = entry.getValue();
            if (property.equals("parentId")) updateParentId(ilarkesto.core.persistance.Persistence.parsePropertyReference(value));
            if (property.equals("userId")) updateUserId(ilarkesto.core.persistance.Persistence.parsePropertyReference(value));
            if (property.equals("dateAndTime")) updateDateAndTime(ilarkesto.core.persistance.Persistence.parsePropertyDateAndTime(value));
            if (property.equals("key")) updateKey(ilarkesto.core.persistance.Persistence.parsePropertyString(value));
            if (property.equals("oldValue")) updateOldValue(ilarkesto.core.persistance.Persistence.parsePropertyString(value));
            if (property.equals("newValue")) updateNewValue(ilarkesto.core.persistance.Persistence.parsePropertyString(value));
            if (property.equals("comment")) updateComment(ilarkesto.core.persistance.Persistence.parsePropertyString(value));
        }
    }

    // --- ensure integrity ---
    @Override
    public void onEnsureIntegrity() {
        super.onEnsureIntegrity();
        if (!isParentSet()) {
            repairMissingMaster();
        }
        try {
            getParent();
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            LOG.info("Repairing dead parent reference");
            repairDeadParentReference(this.parentId);
        }
        try {
            getUser();
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            LOG.info("Repairing dead user reference");
            repairDeadUserReference(this.userId);
        }
    }

    // --- PLUGIN: GwtEntityPropertyEditorClassGeneratorPlugin ---

    private transient DateAndTimeModel dateAndTimeModel;

    public DateAndTimeModel getDateAndTimeModel() {
        if (dateAndTimeModel == null) dateAndTimeModel = createDateAndTimeModel();
        return dateAndTimeModel;
    }

    protected DateAndTimeModel createDateAndTimeModel() { return new DateAndTimeModel(); }

    protected class DateAndTimeModel extends ilarkesto.gwt.client.editor.ADateAndTimeEditorModel {

        @Override
        public String getId() {
            return "Change_dateAndTime";
        }

        @Override
        public ilarkesto.core.time.DateAndTime getValue() {
            return getDateAndTime();
        }

        @Override
        public void setValue(ilarkesto.core.time.DateAndTime value) {
            setDateAndTime(value);
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

    private transient KeyModel keyModel;

    public KeyModel getKeyModel() {
        if (keyModel == null) keyModel = createKeyModel();
        return keyModel;
    }

    protected KeyModel createKeyModel() { return new KeyModel(); }

    protected class KeyModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Change_key";
        }

        @Override
        public java.lang.String getValue() {
            return getKey();
        }

        @Override
        public void setValue(java.lang.String value) {
            setKey(value);
        }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    private transient OldValueModel oldValueModel;

    public OldValueModel getOldValueModel() {
        if (oldValueModel == null) oldValueModel = createOldValueModel();
        return oldValueModel;
    }

    protected OldValueModel createOldValueModel() { return new OldValueModel(); }

    protected class OldValueModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Change_oldValue";
        }

        @Override
        public java.lang.String getValue() {
            return getOldValue();
        }

        @Override
        public void setValue(java.lang.String value) {
            setOldValue(value);
        }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    private transient NewValueModel newValueModel;

    public NewValueModel getNewValueModel() {
        if (newValueModel == null) newValueModel = createNewValueModel();
        return newValueModel;
    }

    protected NewValueModel createNewValueModel() { return new NewValueModel(); }

    protected class NewValueModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Change_newValue";
        }

        @Override
        public java.lang.String getValue() {
            return getNewValue();
        }

        @Override
        public void setValue(java.lang.String value) {
            setNewValue(value);
        }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

    private transient CommentModel commentModel;

    public CommentModel getCommentModel() {
        if (commentModel == null) commentModel = createCommentModel();
        return commentModel;
    }

    protected CommentModel createCommentModel() { return new CommentModel(); }

    protected class CommentModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Change_comment";
        }

        @Override
        public java.lang.String getValue() {
            return getComment();
        }

        @Override
        public void setValue(java.lang.String value) {
            setComment(value);
        }

        @Override
        public boolean isRichtext() { return true; }

        @Override
        protected void onChangeValue(java.lang.String oldValue, java.lang.String newValue) {
            super.onChangeValue(oldValue, newValue);
            addUndo(this, oldValue);
        }

    }

}