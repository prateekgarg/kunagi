// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.GwtEntityGenerator










package scrum.client.collaboration;

import java.util.*;
import ilarkesto.core.base.Utl;
import ilarkesto.core.logging.Log;
import scrum.client.common.*;
import ilarkesto.gwt.client.*;

public abstract class GEmoticon
            extends scrum.client.common.AScrumGwtEntity {

    protected scrum.client.Dao getDao() {
        return scrum.client.Dao.get();
    }

    @Override
    protected void doPersist() {
        getDao().createEmoticon((Emoticon)this);
    }

    public GEmoticon() {
    }

    public GEmoticon(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "emoticon";

    @Override
    public final String getEntityType() {
        return ENTITY_TYPE;
    }

    // --- parent ---

    private String parentId;

    public final ilarkesto.gwt.client.AGwtEntity getParent() {
        if (parentId == null) return null;
        return getDao().getEntity(this.parentId);
    }

    public final boolean isParentSet() {
        return parentId != null;
    }

    public final Emoticon setParent(ilarkesto.gwt.client.AGwtEntity parent) {
        String id = parent == null ? null : parent.getId();
        if (ilarkesto.core.base.Utl.equals(this.parentId, id)) return (Emoticon) this;
        this.parentId = id;
        propertyChanged("parentId", ilarkesto.core.persistance.Persistence.propertyAsString(this.parentId));
        return (Emoticon)this;
    }

    public final boolean isParent(ilarkesto.gwt.client.AGwtEntity parent) {
        String id = parent==null ? null : parent.getId();
        return ilarkesto.core.base.Utl.equals(this.parentId, id);
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

    public final Emoticon setOwner(scrum.client.admin.User owner) {
        String id = owner == null ? null : owner.getId();
        if (ilarkesto.core.base.Utl.equals(this.ownerId, id)) return (Emoticon) this;
        this.ownerId = id;
        propertyChanged("ownerId", ilarkesto.core.persistance.Persistence.propertyAsString(this.ownerId));
        return (Emoticon)this;
    }

    public final boolean isOwner(scrum.client.admin.User owner) {
        String id = owner==null ? null : owner.getId();
        return ilarkesto.core.base.Utl.equals(this.ownerId, id);
    }

    // --- emotion ---

    private java.lang.String emotion ;

    public final java.lang.String getEmotion() {
        return this.emotion ;
    }

    public final Emoticon setEmotion(java.lang.String emotion) {
        if (isEmotion(emotion)) return (Emoticon)this;
        this.emotion = emotion ;
        propertyChanged("emotion", ilarkesto.core.persistance.Persistence.propertyAsString(this.emotion));
        return (Emoticon)this;
    }

    public final boolean isEmotion(java.lang.String emotion) {
        return ilarkesto.core.base.Utl.equals(this.emotion, emotion);
    }

    private transient EmotionModel emotionModel;

    public EmotionModel getEmotionModel() {
        if (emotionModel == null) emotionModel = createEmotionModel();
        return emotionModel;
    }

    protected EmotionModel createEmotionModel() { return new EmotionModel(); }

    protected class EmotionModel extends ilarkesto.gwt.client.editor.ATextEditorModel {

        @Override
        public String getId() {
            return "Emoticon_emotion";
        }

        @Override
        public java.lang.String getValue() {
            return getEmotion();
        }

        @Override
        public void setValue(java.lang.String value) {
            setEmotion(value);
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
            if (property.equals("parentId")) parentId = ilarkesto.core.persistance.Persistence.parsePropertyReference(value);
            if (property.equals("ownerId")) ownerId = ilarkesto.core.persistance.Persistence.parsePropertyReference(value);
            if (property.equals("emotion")) emotion = ilarkesto.core.persistance.Persistence.parsePropertyString(value);
        }
        updateLastModified();
    }

    @Override
    public void storeProperties(Map<String, String> properties) {
        super.storeProperties(properties);
        properties.put("parentId", ilarkesto.core.persistance.Persistence.propertyAsString(this.parentId));
        properties.put("ownerId", ilarkesto.core.persistance.Persistence.propertyAsString(this.ownerId));
        properties.put("emotion", ilarkesto.core.persistance.Persistence.propertyAsString(this.emotion));
    }

}