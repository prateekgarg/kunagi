// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.GwtEntityGenerator










package scrum.client.sprint;

import java.util.*;
import ilarkesto.core.base.Utl;
import ilarkesto.core.logging.Log;
import scrum.client.common.*;
import ilarkesto.gwt.client.*;

public abstract class GSprintReport
            extends scrum.client.common.AScrumGwtEntity {

    protected scrum.client.Dao getDao() {
        return scrum.client.Dao.get();
    }

    @Override
    protected void doPersist() {
        getDao().createSprintReport((SprintReport)this);
    }

    public GSprintReport() {
    }

    public GSprintReport(Map data) {
        super(data);
        updateProperties(data);
    }

    public static final String ENTITY_TYPE = "sprintReport";

    @Override
    public final String getEntityType() {
        return ENTITY_TYPE;
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

    public final SprintReport setSprint(scrum.client.sprint.Sprint sprint) {
        String id = sprint == null ? null : sprint.getId();
        if (equals(this.sprintId, id)) return (SprintReport) this;
        this.sprintId = id;
        propertyChanged("sprintId", ilarkesto.core.persistance.Persistence.propertyAsString(this.sprintId));
        return (SprintReport)this;
    }

    public final boolean isSprint(scrum.client.sprint.Sprint sprint) {
        String id = sprint==null ? null : sprint.getId();
        return equals(this.sprintId, id);
    }

    // --- completedRequirements ---

    private Set<String> completedRequirementsIds = new HashSet<String>();

    public final java.util.Set<scrum.client.project.Requirement> getCompletedRequirements() {
        if ( completedRequirementsIds.isEmpty()) return Collections.emptySet();
        return getDao().getRequirements(this.completedRequirementsIds);
    }

    public final void setCompletedRequirements(Collection<scrum.client.project.Requirement> values) {
        completedRequirementsIds = ilarkesto.gwt.client.Gwt.getIdsAsSet(values);
        propertyChanged("completedRequirementsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.completedRequirementsIds));
    }

    public final void addCompletedRequirement(scrum.client.project.Requirement completedRequirement) {
        String id = completedRequirement.getId();
        if (completedRequirementsIds.contains(id)) return;
        completedRequirementsIds.add(id);
        propertyChanged("completedRequirementsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.completedRequirementsIds));
    }

    public final void removeCompletedRequirement(scrum.client.project.Requirement completedRequirement) {
        String id = completedRequirement.getId();
        if (!completedRequirementsIds.contains(id)) return;
        completedRequirementsIds.remove(id);
        propertyChanged("completedRequirementsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.completedRequirementsIds));
    }

    public final boolean containsCompletedRequirement(scrum.client.project.Requirement completedRequirement) {
        return completedRequirementsIds.contains(completedRequirement.getId());
    }


    // --- rejectedRequirements ---

    private Set<String> rejectedRequirementsIds = new HashSet<String>();

    public final java.util.Set<scrum.client.project.Requirement> getRejectedRequirements() {
        if ( rejectedRequirementsIds.isEmpty()) return Collections.emptySet();
        return getDao().getRequirements(this.rejectedRequirementsIds);
    }

    public final void setRejectedRequirements(Collection<scrum.client.project.Requirement> values) {
        rejectedRequirementsIds = ilarkesto.gwt.client.Gwt.getIdsAsSet(values);
        propertyChanged("rejectedRequirementsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.rejectedRequirementsIds));
    }

    public final void addRejectedRequirement(scrum.client.project.Requirement rejectedRequirement) {
        String id = rejectedRequirement.getId();
        if (rejectedRequirementsIds.contains(id)) return;
        rejectedRequirementsIds.add(id);
        propertyChanged("rejectedRequirementsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.rejectedRequirementsIds));
    }

    public final void removeRejectedRequirement(scrum.client.project.Requirement rejectedRequirement) {
        String id = rejectedRequirement.getId();
        if (!rejectedRequirementsIds.contains(id)) return;
        rejectedRequirementsIds.remove(id);
        propertyChanged("rejectedRequirementsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.rejectedRequirementsIds));
    }

    public final boolean containsRejectedRequirement(scrum.client.project.Requirement rejectedRequirement) {
        return rejectedRequirementsIds.contains(rejectedRequirement.getId());
    }


    // --- requirementsOrderIds ---

    private java.util.List<java.lang.String> requirementsOrderIds = new java.util.ArrayList<java.lang.String>();

    public final java.util.List<java.lang.String> getRequirementsOrderIds() {
        return new java.util.ArrayList<java.lang.String>(requirementsOrderIds);
    }

    public final void setRequirementsOrderIds(java.util.List<java.lang.String> requirementsOrderIds) {
        if (requirementsOrderIds == null) throw new IllegalArgumentException("null is not allowed");
        if (this.requirementsOrderIds.equals(requirementsOrderIds)) return;
        this.requirementsOrderIds = new java.util.ArrayList<java.lang.String>(requirementsOrderIds);
        propertyChanged("requirementsOrderIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.requirementsOrderIds));
    }

    public final boolean containsRequirementsOrderId(java.lang.String requirementsOrderId) {
        return requirementsOrderIds.contains(requirementsOrderId);
    }


    // --- closedTasks ---

    private Set<String> closedTasksIds = new HashSet<String>();

    public final java.util.Set<scrum.client.sprint.Task> getClosedTasks() {
        if ( closedTasksIds.isEmpty()) return Collections.emptySet();
        return getDao().getTasks(this.closedTasksIds);
    }

    public final void setClosedTasks(Collection<scrum.client.sprint.Task> values) {
        closedTasksIds = ilarkesto.gwt.client.Gwt.getIdsAsSet(values);
        propertyChanged("closedTasksIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.closedTasksIds));
    }

    public final void addClosedTask(scrum.client.sprint.Task closedTask) {
        String id = closedTask.getId();
        if (closedTasksIds.contains(id)) return;
        closedTasksIds.add(id);
        propertyChanged("closedTasksIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.closedTasksIds));
    }

    public final void removeClosedTask(scrum.client.sprint.Task closedTask) {
        String id = closedTask.getId();
        if (!closedTasksIds.contains(id)) return;
        closedTasksIds.remove(id);
        propertyChanged("closedTasksIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.closedTasksIds));
    }

    public final boolean containsClosedTask(scrum.client.sprint.Task closedTask) {
        return closedTasksIds.contains(closedTask.getId());
    }


    // --- openTasks ---

    private Set<String> openTasksIds = new HashSet<String>();

    public final java.util.Set<scrum.client.sprint.Task> getOpenTasks() {
        if ( openTasksIds.isEmpty()) return Collections.emptySet();
        return getDao().getTasks(this.openTasksIds);
    }

    public final void setOpenTasks(Collection<scrum.client.sprint.Task> values) {
        openTasksIds = ilarkesto.gwt.client.Gwt.getIdsAsSet(values);
        propertyChanged("openTasksIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.openTasksIds));
    }

    public final void addOpenTask(scrum.client.sprint.Task openTask) {
        String id = openTask.getId();
        if (openTasksIds.contains(id)) return;
        openTasksIds.add(id);
        propertyChanged("openTasksIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.openTasksIds));
    }

    public final void removeOpenTask(scrum.client.sprint.Task openTask) {
        String id = openTask.getId();
        if (!openTasksIds.contains(id)) return;
        openTasksIds.remove(id);
        propertyChanged("openTasksIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.openTasksIds));
    }

    public final boolean containsOpenTask(scrum.client.sprint.Task openTask) {
        return openTasksIds.contains(openTask.getId());
    }


    // --- burnedWork ---

    private int burnedWork ;

    public final int getBurnedWork() {
        return this.burnedWork ;
    }

    public final SprintReport setBurnedWork(int burnedWork) {
        if (isBurnedWork(burnedWork)) return (SprintReport)this;
        this.burnedWork = burnedWork ;
        propertyChanged("burnedWork", ilarkesto.core.persistance.Persistence.propertyAsString(this.burnedWork));
        return (SprintReport)this;
    }

    public final boolean isBurnedWork(int burnedWork) {
        return equals(this.burnedWork, burnedWork);
    }

    private transient BurnedWorkModel burnedWorkModel;

    public BurnedWorkModel getBurnedWorkModel() {
        if (burnedWorkModel == null) burnedWorkModel = createBurnedWorkModel();
        return burnedWorkModel;
    }

    protected BurnedWorkModel createBurnedWorkModel() { return new BurnedWorkModel(); }

    protected class BurnedWorkModel extends ilarkesto.gwt.client.editor.AIntegerEditorModel {

        @Override
        public String getId() {
            return "SprintReport_burnedWork";
        }

        @Override
        public java.lang.Integer getValue() {
            return getBurnedWork();
        }

        @Override
        public void setValue(java.lang.Integer value) {
            setBurnedWork(value);
        }

            @Override
            public void increment() {
                setBurnedWork(getBurnedWork() + 1);
            }

            @Override
            public void decrement() {
                setBurnedWork(getBurnedWork() - 1);
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

    // --- update properties by map ---

    public void updateProperties(Map<String, String> properties) {
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            String property = entry.getKey();
            if (property.equals("id")) continue;
            String value = entry.getValue();
            if (property.equals("sprintId")) sprintId = ilarkesto.core.persistance.Persistence.parsePropertyReference(value);
            if (property.equals("completedRequirementsIds")) completedRequirementsIds = ilarkesto.core.persistance.Persistence.parsePropertyReferenceSet(value);
            if (property.equals("rejectedRequirementsIds")) rejectedRequirementsIds = ilarkesto.core.persistance.Persistence.parsePropertyReferenceSet(value);
            if (property.equals("requirementsOrderIds")) requirementsOrderIds = ilarkesto.core.persistance.Persistence.parsePropertyStringList(value);
            if (property.equals("closedTasksIds")) closedTasksIds = ilarkesto.core.persistance.Persistence.parsePropertyReferenceSet(value);
            if (property.equals("openTasksIds")) openTasksIds = ilarkesto.core.persistance.Persistence.parsePropertyReferenceSet(value);
            if (property.equals("burnedWork")) burnedWork = ilarkesto.core.persistance.Persistence.parsePropertyint(value);
        }
        updateLastModified();
    }

    @Override
    public void storeProperties(Map<String, String> properties) {
        super.storeProperties(properties);
        properties.put("sprintId", ilarkesto.core.persistance.Persistence.propertyAsString(this.sprintId));
        properties.put("completedRequirementsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.completedRequirementsIds));
        properties.put("rejectedRequirementsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.rejectedRequirementsIds));
        properties.put("requirementsOrderIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.requirementsOrderIds));
        properties.put("closedTasksIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.closedTasksIds));
        properties.put("openTasksIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.openTasksIds));
        properties.put("burnedWork", ilarkesto.core.persistance.Persistence.propertyAsString(this.burnedWork));
    }

}