// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.GwtEntityGenerator










package scrum.client.pr;

import java.util.*;
import ilarkesto.core.base.Utl;
import ilarkesto.core.logging.Log;
import scrum.client.common.*;
import ilarkesto.gwt.client.*;

public abstract class GSubscription
            extends scrum.client.common.AScrumGwtEntity {

    protected scrum.client.Dao getDao() {
        return scrum.client.Dao.get();
    }

    @Override
    protected void doPersist() {
        getDao().createSubscription((Subscription)this);
    }

    public GSubscription() {
    }

    public GSubscription(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "subscription";

    @Override
    public final String getEntityType() {
        return ENTITY_TYPE;
    }

    // --- subject ---

    private String subjectId;

    public final ilarkesto.gwt.client.AGwtEntity getSubject() {
        if (subjectId == null) return null;
        return getDao().getEntity(this.subjectId);
    }

    public final boolean isSubjectSet() {
        return subjectId != null;
    }

    public final Subscription setSubject(ilarkesto.gwt.client.AGwtEntity subject) {
        String id = subject == null ? null : subject.getId();
        if (equals(this.subjectId, id)) return (Subscription) this;
        this.subjectId = id;
        propertyChanged("subjectId", ilarkesto.core.persistance.Persistence.propertyAsString(this.subjectId));
        return (Subscription)this;
    }

    public final boolean isSubject(ilarkesto.gwt.client.AGwtEntity subject) {
        String id = subject==null ? null : subject.getId();
        return equals(this.subjectId, id);
    }

    // --- subscribersEmails ---

    private java.util.Set<java.lang.String> subscribersEmails = new java.util.HashSet<java.lang.String>();

    public final java.util.Set<java.lang.String> getSubscribersEmails() {
        return new java.util.HashSet<java.lang.String>(subscribersEmails);
    }

    public final void setSubscribersEmails(java.util.Set<java.lang.String> subscribersEmails) {
        if (subscribersEmails == null) throw new IllegalArgumentException("null is not allowed");
        if (this.subscribersEmails.equals(subscribersEmails)) return;
        this.subscribersEmails = new java.util.HashSet<java.lang.String>(subscribersEmails);
        propertyChanged("subscribersEmails", ilarkesto.core.persistance.Persistence.propertyAsString(this.subscribersEmails));
    }

    public final boolean containsSubscribersEmail(java.lang.String subscribersEmail) {
        return subscribersEmails.contains(subscribersEmail);
    }


    // --- update properties by map ---

    public void updateProperties(Map<String, String> properties) {
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            String property = entry.getKey();
            if (property.equals("id")) continue;
            String value = entry.getValue();
            if (property.equals("subjectId")) subjectId = ilarkesto.core.persistance.Persistence.parsePropertyReference(value);
            if (property.equals("subscribersEmails")) subscribersEmails = ilarkesto.core.persistance.Persistence.parsePropertyStringSet(value);
        }
        updateLastModified();
    }

    @Override
    public void storeProperties(Map<String, String> properties) {
        super.storeProperties(properties);
        properties.put("subjectId", ilarkesto.core.persistance.Persistence.propertyAsString(this.subjectId));
        properties.put("subscribersEmails", ilarkesto.core.persistance.Persistence.propertyAsString(this.subscribersEmails));
    }

}