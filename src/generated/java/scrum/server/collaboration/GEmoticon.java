// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.EntityGenerator










package scrum.server.collaboration;

import java.util.*;
import ilarkesto.core.base.Utl;
import ilarkesto.core.logging.Log;
import ilarkesto.persistence.ADatob;
import ilarkesto.persistence.AEntity;
import ilarkesto.persistence.AStructure;
import ilarkesto.auth.AUser;
import ilarkesto.core.base.Str;

public abstract class GEmoticon
            extends AEntity
            implements ilarkesto.auth.ViewProtected<scrum.server.admin.User>, java.lang.Comparable<Emoticon> {

    protected static final ilarkesto.core.logging.Log log = ilarkesto.core.logging.Log.get(Emoticon.class);

    // --- AEntity ---

    public final scrum.server.collaboration.EmoticonDao getDao() {
        return emoticonDao;
    }

    protected void repairDeadDatob(ADatob datob) {
    }

    @Override
    public void storeProperties(Map<String, String> properties) {
        super.storeProperties(properties);
        properties.put("parentId", ilarkesto.core.persistance.Persistence.propertyAsString(this.parentId));
        properties.put("ownerId", ilarkesto.core.persistance.Persistence.propertyAsString(this.ownerId));
        properties.put("emotion", ilarkesto.core.persistance.Persistence.propertyAsString(this.emotion));
    }

    public int compareTo(Emoticon other) {
        return toString().toLowerCase().compareTo(other.toString().toLowerCase());
    }

    private static final ilarkesto.core.logging.Log LOG = ilarkesto.core.logging.Log.get(GEmoticon.class);

    public static final String TYPE = "emoticon";

    // -----------------------------------------------------------
    // - parent
    // -----------------------------------------------------------

    private String parentId;
    private transient ilarkesto.persistence.AEntity parentCache;

    private void updateParentCache() {
        parentCache = this.parentId == null ? null : (ilarkesto.persistence.AEntity)getDaoService().getById(this.parentId);
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final ilarkesto.persistence.AEntity getParent() {
        if (parentCache == null) updateParentCache();
        return parentCache;
    }

    public final void setParent(ilarkesto.persistence.AEntity parent) {
        parent = prepareParent(parent);
        if (isParent(parent)) return;
        setParentId(parent == null ? null : parent.getId());
        parentCache = parent;
    }

    public final void setParentId(String id) {
        if (Utl.equals(parentId, id)) return;
        this.parentId = id;
        parentCache = null;
        updateLastModified();
        fireModified("parentId", ilarkesto.core.persistance.Persistence.propertyAsString(this.parentId));
    }

    protected ilarkesto.persistence.AEntity prepareParent(ilarkesto.persistence.AEntity parent) {
        return parent;
    }

    protected void repairDeadParentReference(String entityId) {
        if (this.parentId == null || entityId.equals(this.parentId)) {
            repairMissingMaster();
        }
    }

    public final boolean isParentSet() {
        return this.parentId != null;
    }

    public final boolean isParent(ilarkesto.persistence.AEntity parent) {
        if (this.parentId == null && parent == null) return true;
        return parent != null && parent.getId().equals(this.parentId);
    }

    protected final void updateParent(Object value) {
        setParent(value == null ? null : (ilarkesto.persistence.AEntity)getDaoService().getById((String)value));
    }

    // -----------------------------------------------------------
    // - owner
    // -----------------------------------------------------------

    private String ownerId;
    private transient scrum.server.admin.User ownerCache;

    private void updateOwnerCache() {
        ownerCache = this.ownerId == null ? null : (scrum.server.admin.User)userDao.getById(this.ownerId);
    }

    public final String getOwnerId() {
        return this.ownerId;
    }

    public final scrum.server.admin.User getOwner() {
        if (ownerCache == null) updateOwnerCache();
        return ownerCache;
    }

    public final void setOwner(scrum.server.admin.User owner) {
        owner = prepareOwner(owner);
        if (isOwner(owner)) return;
        setOwnerId(owner == null ? null : owner.getId());
        ownerCache = owner;
    }

    public final void setOwnerId(String id) {
        if (Utl.equals(ownerId, id)) return;
        this.ownerId = id;
        ownerCache = null;
        updateLastModified();
        fireModified("ownerId", ilarkesto.core.persistance.Persistence.propertyAsString(this.ownerId));
    }

    protected scrum.server.admin.User prepareOwner(scrum.server.admin.User owner) {
        return owner;
    }

    protected void repairDeadOwnerReference(String entityId) {
        if (this.ownerId == null || entityId.equals(this.ownerId)) {
            repairMissingMaster();
        }
    }

    public final boolean isOwnerSet() {
        return this.ownerId != null;
    }

    public final boolean isOwner(scrum.server.admin.User owner) {
        if (this.ownerId == null && owner == null) return true;
        return owner != null && owner.getId().equals(this.ownerId);
    }

    protected final void updateOwner(Object value) {
        setOwner(value == null ? null : (scrum.server.admin.User)userDao.getById((String)value));
    }

    // -----------------------------------------------------------
    // - emotion
    // -----------------------------------------------------------

    private java.lang.String emotion;

    public final java.lang.String getEmotion() {
        return emotion;
    }

    public final void setEmotion(java.lang.String emotion) {
        emotion = prepareEmotion(emotion);
        if (isEmotion(emotion)) return;
        this.emotion = emotion;
        updateLastModified();
        fireModified("emotion", ilarkesto.core.persistance.Persistence.propertyAsString(this.emotion));
    }

    protected java.lang.String prepareEmotion(java.lang.String emotion) {
        // emotion = Str.removeUnreadableChars(emotion);
        return emotion;
    }

    public final boolean isEmotionSet() {
        return this.emotion != null;
    }

    public final boolean isEmotion(java.lang.String emotion) {
        if (this.emotion == null && emotion == null) return true;
        return this.emotion != null && this.emotion.equals(emotion);
    }

    protected final void updateEmotion(Object value) {
        setEmotion((java.lang.String)value);
    }

    public void updateProperties(Map<String, String> properties) {
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            String property = entry.getKey();
            if (property.equals("id")) continue;
            String value = entry.getValue();
            if (property.equals("parentId")) setParentId(ilarkesto.core.persistance.Persistence.parsePropertyReference(value));
            if (property.equals("ownerId")) setOwnerId(ilarkesto.core.persistance.Persistence.parsePropertyReference(value));
            if (property.equals("emotion")) setEmotion(ilarkesto.core.persistance.Persistence.parsePropertyString(value));
        }
    }

    protected void repairDeadReferences(String entityId) {
        super.repairDeadReferences(entityId);
        repairDeadParentReference(entityId);
        repairDeadOwnerReference(entityId);
    }

    // --- ensure integrity ---
    @Override
    public void ensureIntegrity() {
        super.ensureIntegrity();
        if (!isParentSet()) {
            repairMissingMaster();
        }
        try {
            getParent();
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            LOG.info("Repairing dead parent reference");
            repairDeadParentReference(this.parentId);
        }
        if (!isOwnerSet()) {
            repairMissingMaster();
        }
        try {
            getOwner();
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            LOG.info("Repairing dead owner reference");
            repairDeadOwnerReference(this.ownerId);
        }
    }

    static scrum.server.collaboration.EmoticonDao emoticonDao;

    public static final void setEmoticonDao(scrum.server.collaboration.EmoticonDao emoticonDao) {
        GEmoticon.emoticonDao = emoticonDao;
    }

}