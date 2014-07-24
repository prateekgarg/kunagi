// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.EntityGenerator










package scrum.server.project;

import java.util.*;
import ilarkesto.core.base.Utl;
import ilarkesto.core.logging.Log;
import ilarkesto.persistence.ADatob;
import ilarkesto.persistence.AEntity;
import ilarkesto.persistence.AStructure;
import ilarkesto.auth.AUser;
import ilarkesto.core.base.Str;
import ilarkesto.core.persistance.EntityDoesNotExistException;

public abstract class GRequirement
            extends AEntity
            implements ilarkesto.auth.ViewProtected<scrum.server.admin.User>, java.lang.Comparable<Requirement>, ilarkesto.search.Searchable {

    protected static final ilarkesto.core.logging.Log log = ilarkesto.core.logging.Log.get(Requirement.class);

    // --- AEntity ---

    public final scrum.server.project.RequirementDao getDao() {
        return requirementDao;
    }

    protected void repairDeadDatob(ADatob datob) {
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
    }

    public int compareTo(Requirement other) {
        return toString().toLowerCase().compareTo(other.toString().toLowerCase());
    }

    public final java.util.Set<scrum.server.issues.Issue> getIssues() {
        return issueDao.getIssuesByStory((Requirement)this);
    }

    public final java.util.Set<scrum.server.project.Requirement> getRequirements() {
        return requirementDao.getRequirementsByEpic((Requirement)this);
    }

    public final java.util.Set<scrum.server.sprint.SprintReport> getSprintReports() {
        return sprintReportDao.getSprintReportsByCompletedRequirement((Requirement)this);
    }

    public final java.util.Set<scrum.server.sprint.SprintReport> getSprintReportWithRejectedRequirementss() {
        return sprintReportDao.getSprintReportsByRejectedRequirement((Requirement)this);
    }

    public final java.util.Set<scrum.server.sprint.Task> getTasks() {
        return taskDao.getTasksByRequirement((Requirement)this);
    }

    public final java.util.Set<scrum.server.estimation.RequirementEstimationVote> getRequirementEstimationVotes() {
        return requirementEstimationVoteDao.getRequirementEstimationVotesByRequirement((Requirement)this);
    }

    private static final ilarkesto.core.logging.Log LOG = ilarkesto.core.logging.Log.get(GRequirement.class);

    public static final String TYPE = "requirement";


    // -----------------------------------------------------------
    // - Searchable
    // -----------------------------------------------------------

    public boolean matchesKey(String key) {
        if (super.matchesKey(key)) return true;
        if (matchesKey(getLabel(), key)) return true;
        if (matchesKey(getDescription(), key)) return true;
        if (matchesKey(getTestDescription(), key)) return true;
        return false;
    }

    // -----------------------------------------------------------
    // - project
    // -----------------------------------------------------------

    private String projectId;

    public final String getProjectId() {
        return this.projectId;
    }

    public final scrum.server.project.Project getProject() {
        try {
            return this.projectId == null ? null : (scrum.server.project.Project) AEntity.getById(this.projectId);
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            throw ex.setCallerInfo("Requirement.project");
        }
    }

    public final void setProject(scrum.server.project.Project project) {
        project = prepareProject(project);
        if (isProject(project)) return;
        setProjectId(project == null ? null : project.getId());
    }

    public final void setProjectId(String id) {
        if (Utl.equals(projectId, id)) return;
        this.projectId = id;
            updateLastModified();
            fireModified("projectId", ilarkesto.core.persistance.Persistence.propertyAsString(this.projectId));
    }

    protected scrum.server.project.Project prepareProject(scrum.server.project.Project project) {
        return project;
    }

    protected void repairDeadProjectReference(String entityId) {
        if (this.projectId == null || entityId.equals(this.projectId)) {
            repairMissingMaster();
        }
    }

    public final boolean isProjectSet() {
        return this.projectId != null;
    }

    public final boolean isProject(scrum.server.project.Project project) {
        if (this.projectId == null && project == null) return true;
        return project != null && project.getId().equals(this.projectId);
    }

    protected final void updateProject(Object value) {
        setProject(value == null ? null : (scrum.server.project.Project)projectDao.getById((String)value));
    }

    // -----------------------------------------------------------
    // - sprint
    // -----------------------------------------------------------

    private String sprintId;

    public final String getSprintId() {
        return this.sprintId;
    }

    public final scrum.server.sprint.Sprint getSprint() {
        try {
            return this.sprintId == null ? null : (scrum.server.sprint.Sprint) AEntity.getById(this.sprintId);
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            throw ex.setCallerInfo("Requirement.sprint");
        }
    }

    public final void setSprint(scrum.server.sprint.Sprint sprint) {
        sprint = prepareSprint(sprint);
        if (isSprint(sprint)) return;
        setSprintId(sprint == null ? null : sprint.getId());
    }

    public final void setSprintId(String id) {
        if (Utl.equals(sprintId, id)) return;
        this.sprintId = id;
            updateLastModified();
            fireModified("sprintId", ilarkesto.core.persistance.Persistence.propertyAsString(this.sprintId));
    }

    protected scrum.server.sprint.Sprint prepareSprint(scrum.server.sprint.Sprint sprint) {
        return sprint;
    }

    protected void repairDeadSprintReference(String entityId) {
        if (this.sprintId == null || entityId.equals(this.sprintId)) {
            setSprint(null);
        }
    }

    public final boolean isSprintSet() {
        return this.sprintId != null;
    }

    public final boolean isSprint(scrum.server.sprint.Sprint sprint) {
        if (this.sprintId == null && sprint == null) return true;
        return sprint != null && sprint.getId().equals(this.sprintId);
    }

    protected final void updateSprint(Object value) {
        setSprint(value == null ? null : (scrum.server.sprint.Sprint)sprintDao.getById((String)value));
    }

    // -----------------------------------------------------------
    // - issue
    // -----------------------------------------------------------

    private String issueId;

    public final String getIssueId() {
        return this.issueId;
    }

    public final scrum.server.issues.Issue getIssue() {
        try {
            return this.issueId == null ? null : (scrum.server.issues.Issue) AEntity.getById(this.issueId);
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            throw ex.setCallerInfo("Requirement.issue");
        }
    }

    public final void setIssue(scrum.server.issues.Issue issue) {
        issue = prepareIssue(issue);
        if (isIssue(issue)) return;
        setIssueId(issue == null ? null : issue.getId());
    }

    public final void setIssueId(String id) {
        if (Utl.equals(issueId, id)) return;
        this.issueId = id;
            updateLastModified();
            fireModified("issueId", ilarkesto.core.persistance.Persistence.propertyAsString(this.issueId));
    }

    protected scrum.server.issues.Issue prepareIssue(scrum.server.issues.Issue issue) {
        return issue;
    }

    protected void repairDeadIssueReference(String entityId) {
        if (this.issueId == null || entityId.equals(this.issueId)) {
            setIssue(null);
        }
    }

    public final boolean isIssueSet() {
        return this.issueId != null;
    }

    public final boolean isIssue(scrum.server.issues.Issue issue) {
        if (this.issueId == null && issue == null) return true;
        return issue != null && issue.getId().equals(this.issueId);
    }

    protected final void updateIssue(Object value) {
        setIssue(value == null ? null : (scrum.server.issues.Issue)issueDao.getById((String)value));
    }

    // -----------------------------------------------------------
    // - number
    // -----------------------------------------------------------

    private int number;

    public final int getNumber() {
        return number;
    }

    public final void setNumber(int number) {
        number = prepareNumber(number);
        if (isNumber(number)) return;
        this.number = number;
            updateLastModified();
            fireModified("number", ilarkesto.core.persistance.Persistence.propertyAsString(this.number));
    }

    protected int prepareNumber(int number) {
        return number;
    }

    public final boolean isNumber(int number) {
        return this.number == number;
    }

    protected final void updateNumber(Object value) {
        setNumber((Integer)value);
    }

    // -----------------------------------------------------------
    // - qualitys
    // -----------------------------------------------------------

    private java.util.Set<String> qualitysIds = new java.util.HashSet<String>();

    public final java.util.Set<scrum.server.project.Quality> getQualitys() {
        try {
            return (java.util.Set) AEntity.getByIdsAsSet(this.qualitysIds);
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            throw ex.setCallerInfo("Requirement.qualitys");
        }
    }

    public final void setQualitys(Collection<scrum.server.project.Quality> qualitys) {
        qualitys = prepareQualitys(qualitys);
        if (qualitys == null) qualitys = Collections.emptyList();
        java.util.Set<String> ids = getIdsAsSet(qualitys);
        setQualitysIds(ids);
    }

    public final void setQualitysIds(java.util.Set<String> ids) {
        if (Utl.equals(qualitysIds, ids)) return;
        qualitysIds = ids;
            updateLastModified();
            fireModified("qualitysIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.qualitysIds));
    }

    protected Collection<scrum.server.project.Quality> prepareQualitys(Collection<scrum.server.project.Quality> qualitys) {
        return qualitys;
    }

    protected void repairDeadQualityReference(String entityId) {
        if (this.qualitysIds.remove(entityId)) {
            updateLastModified();
            fireModified("qualitysIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.qualitysIds));
        }
    }

    public final boolean containsQuality(scrum.server.project.Quality quality) {
        if (quality == null) return false;
        return this.qualitysIds.contains(quality.getId());
    }

    public final int getQualitysCount() {
        return this.qualitysIds.size();
    }

    public final boolean isQualitysEmpty() {
        return this.qualitysIds.isEmpty();
    }

    public final boolean addQuality(scrum.server.project.Quality quality) {
        if (quality == null) throw new IllegalArgumentException("quality == null");
        boolean added = this.qualitysIds.add(quality.getId());
        if (added) {
            updateLastModified();
            fireModified("qualitysIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.qualitysIds));
        }
        return added;
    }

    public final boolean addQualitys(Collection<scrum.server.project.Quality> qualitys) {
        if (qualitys == null) throw new IllegalArgumentException("qualitys == null");
        boolean added = false;
        for (scrum.server.project.Quality quality : qualitys) {
            added = added | this.qualitysIds.add(quality.getId());
        }
        if (added) {
            updateLastModified();
            fireModified("qualitysIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.qualitysIds));
        }
        return added;
    }

    public final boolean removeQuality(scrum.server.project.Quality quality) {
        if (quality == null) return false;
        if (this.qualitysIds == null) return false;
        boolean removed = this.qualitysIds.remove(quality.getId());
        if (removed) {
            updateLastModified();
            fireModified("qualitysIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.qualitysIds));
        }
        return removed;
    }

    public final boolean removeQualitys(Collection<scrum.server.project.Quality> qualitys) {
        if (qualitys == null) return false;
        if (qualitys.isEmpty()) return false;
        boolean removed = false;
        for (scrum.server.project.Quality _element: qualitys) {
            removed = removed | this.qualitysIds.remove(_element);
        }
        if (removed) {
            updateLastModified();
            fireModified("qualitysIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.qualitysIds));
        }
        return removed;
    }

    public final boolean clearQualitys() {
        if (this.qualitysIds.isEmpty()) return false;
        this.qualitysIds.clear();
            updateLastModified();
            fireModified("qualitysIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.qualitysIds));
        return true;
    }

    // -----------------------------------------------------------
    // - label
    // -----------------------------------------------------------

    private java.lang.String label;

    public final java.lang.String getLabel() {
        return label;
    }

    public final void setLabel(java.lang.String label) {
        label = prepareLabel(label);
        if (isLabel(label)) return;
        this.label = label;
            updateLastModified();
            fireModified("label", ilarkesto.core.persistance.Persistence.propertyAsString(this.label));
    }

    protected java.lang.String prepareLabel(java.lang.String label) {
        // label = Str.removeUnreadableChars(label);
        return label;
    }

    public final boolean isLabelSet() {
        return this.label != null;
    }

    public final boolean isLabel(java.lang.String label) {
        if (this.label == null && label == null) return true;
        return this.label != null && this.label.equals(label);
    }

    protected final void updateLabel(Object value) {
        setLabel((java.lang.String)value);
    }

    // -----------------------------------------------------------
    // - description
    // -----------------------------------------------------------

    private java.lang.String description;

    public final java.lang.String getDescription() {
        return description;
    }

    public final void setDescription(java.lang.String description) {
        description = prepareDescription(description);
        if (isDescription(description)) return;
        this.description = description;
            updateLastModified();
            fireModified("description", ilarkesto.core.persistance.Persistence.propertyAsString(this.description));
    }

    protected java.lang.String prepareDescription(java.lang.String description) {
        // description = Str.removeUnreadableChars(description);
        return description;
    }

    public final boolean isDescriptionSet() {
        return this.description != null;
    }

    public final boolean isDescription(java.lang.String description) {
        if (this.description == null && description == null) return true;
        return this.description != null && this.description.equals(description);
    }

    protected final void updateDescription(Object value) {
        setDescription((java.lang.String)value);
    }

    // -----------------------------------------------------------
    // - testDescription
    // -----------------------------------------------------------

    private java.lang.String testDescription;

    public final java.lang.String getTestDescription() {
        return testDescription;
    }

    public final void setTestDescription(java.lang.String testDescription) {
        testDescription = prepareTestDescription(testDescription);
        if (isTestDescription(testDescription)) return;
        this.testDescription = testDescription;
            updateLastModified();
            fireModified("testDescription", ilarkesto.core.persistance.Persistence.propertyAsString(this.testDescription));
    }

    protected java.lang.String prepareTestDescription(java.lang.String testDescription) {
        // testDescription = Str.removeUnreadableChars(testDescription);
        return testDescription;
    }

    public final boolean isTestDescriptionSet() {
        return this.testDescription != null;
    }

    public final boolean isTestDescription(java.lang.String testDescription) {
        if (this.testDescription == null && testDescription == null) return true;
        return this.testDescription != null && this.testDescription.equals(testDescription);
    }

    protected final void updateTestDescription(Object value) {
        setTestDescription((java.lang.String)value);
    }

    // -----------------------------------------------------------
    // - estimatedWork
    // -----------------------------------------------------------

    private java.lang.Float estimatedWork;

    public final java.lang.Float getEstimatedWork() {
        return estimatedWork;
    }

    public final void setEstimatedWork(java.lang.Float estimatedWork) {
        estimatedWork = prepareEstimatedWork(estimatedWork);
        if (isEstimatedWork(estimatedWork)) return;
        this.estimatedWork = estimatedWork;
            updateLastModified();
            fireModified("estimatedWork", ilarkesto.core.persistance.Persistence.propertyAsString(this.estimatedWork));
    }

    protected java.lang.Float prepareEstimatedWork(java.lang.Float estimatedWork) {
        return estimatedWork;
    }

    public final boolean isEstimatedWorkSet() {
        return this.estimatedWork != null;
    }

    public final boolean isEstimatedWork(java.lang.Float estimatedWork) {
        if (this.estimatedWork == null && estimatedWork == null) return true;
        return this.estimatedWork != null && this.estimatedWork.equals(estimatedWork);
    }

    protected final void updateEstimatedWork(Object value) {
        setEstimatedWork((java.lang.Float)value);
    }

    // -----------------------------------------------------------
    // - rejectDate
    // -----------------------------------------------------------

    private ilarkesto.core.time.Date rejectDate;

    public final ilarkesto.core.time.Date getRejectDate() {
        return rejectDate;
    }

    public final void setRejectDate(ilarkesto.core.time.Date rejectDate) {
        rejectDate = prepareRejectDate(rejectDate);
        if (isRejectDate(rejectDate)) return;
        this.rejectDate = rejectDate;
            updateLastModified();
            fireModified("rejectDate", ilarkesto.core.persistance.Persistence.propertyAsString(this.rejectDate));
    }

    protected ilarkesto.core.time.Date prepareRejectDate(ilarkesto.core.time.Date rejectDate) {
        return rejectDate;
    }

    public final boolean isRejectDateSet() {
        return this.rejectDate != null;
    }

    public final boolean isRejectDate(ilarkesto.core.time.Date rejectDate) {
        if (this.rejectDate == null && rejectDate == null) return true;
        return this.rejectDate != null && this.rejectDate.equals(rejectDate);
    }

    protected final void updateRejectDate(Object value) {
        value = value == null ? null : new ilarkesto.core.time.Date((String)value);
        setRejectDate((ilarkesto.core.time.Date)value);
    }

    // -----------------------------------------------------------
    // - closed
    // -----------------------------------------------------------

    private boolean closed;

    public final boolean isClosed() {
        return closed;
    }

    public final void setClosed(boolean closed) {
        closed = prepareClosed(closed);
        if (isClosed(closed)) return;
        this.closed = closed;
            updateLastModified();
            fireModified("closed", ilarkesto.core.persistance.Persistence.propertyAsString(this.closed));
    }

    protected boolean prepareClosed(boolean closed) {
        return closed;
    }

    public final boolean isClosed(boolean closed) {
        return this.closed == closed;
    }

    protected final void updateClosed(Object value) {
        setClosed((Boolean)value);
    }

    // -----------------------------------------------------------
    // - deleted
    // -----------------------------------------------------------

    private boolean deleted;

    public final boolean isDeleted() {
        return deleted;
    }

    public final void setDeleted(boolean deleted) {
        deleted = prepareDeleted(deleted);
        if (isDeleted(deleted)) return;
        this.deleted = deleted;
            updateLastModified();
            fireModified("deleted", ilarkesto.core.persistance.Persistence.propertyAsString(this.deleted));
    }

    protected boolean prepareDeleted(boolean deleted) {
        return deleted;
    }

    public final boolean isDeleted(boolean deleted) {
        return this.deleted == deleted;
    }

    protected final void updateDeleted(Object value) {
        setDeleted((Boolean)value);
    }

    // -----------------------------------------------------------
    // - dirty
    // -----------------------------------------------------------

    private boolean dirty;

    public final boolean isDirty() {
        return dirty;
    }

    public final void setDirty(boolean dirty) {
        dirty = prepareDirty(dirty);
        if (isDirty(dirty)) return;
        this.dirty = dirty;
            updateLastModified();
            fireModified("dirty", ilarkesto.core.persistance.Persistence.propertyAsString(this.dirty));
    }

    protected boolean prepareDirty(boolean dirty) {
        return dirty;
    }

    public final boolean isDirty(boolean dirty) {
        return this.dirty == dirty;
    }

    protected final void updateDirty(Object value) {
        setDirty((Boolean)value);
    }

    // -----------------------------------------------------------
    // - workEstimationVotingActive
    // -----------------------------------------------------------

    private boolean workEstimationVotingActive;

    public final boolean isWorkEstimationVotingActive() {
        return workEstimationVotingActive;
    }

    public final void setWorkEstimationVotingActive(boolean workEstimationVotingActive) {
        workEstimationVotingActive = prepareWorkEstimationVotingActive(workEstimationVotingActive);
        if (isWorkEstimationVotingActive(workEstimationVotingActive)) return;
        this.workEstimationVotingActive = workEstimationVotingActive;
            updateLastModified();
            fireModified("workEstimationVotingActive", ilarkesto.core.persistance.Persistence.propertyAsString(this.workEstimationVotingActive));
    }

    protected boolean prepareWorkEstimationVotingActive(boolean workEstimationVotingActive) {
        return workEstimationVotingActive;
    }

    public final boolean isWorkEstimationVotingActive(boolean workEstimationVotingActive) {
        return this.workEstimationVotingActive == workEstimationVotingActive;
    }

    protected final void updateWorkEstimationVotingActive(Object value) {
        setWorkEstimationVotingActive((Boolean)value);
    }

    // -----------------------------------------------------------
    // - workEstimationVotingShowoff
    // -----------------------------------------------------------

    private boolean workEstimationVotingShowoff;

    public final boolean isWorkEstimationVotingShowoff() {
        return workEstimationVotingShowoff;
    }

    public final void setWorkEstimationVotingShowoff(boolean workEstimationVotingShowoff) {
        workEstimationVotingShowoff = prepareWorkEstimationVotingShowoff(workEstimationVotingShowoff);
        if (isWorkEstimationVotingShowoff(workEstimationVotingShowoff)) return;
        this.workEstimationVotingShowoff = workEstimationVotingShowoff;
            updateLastModified();
            fireModified("workEstimationVotingShowoff", ilarkesto.core.persistance.Persistence.propertyAsString(this.workEstimationVotingShowoff));
    }

    protected boolean prepareWorkEstimationVotingShowoff(boolean workEstimationVotingShowoff) {
        return workEstimationVotingShowoff;
    }

    public final boolean isWorkEstimationVotingShowoff(boolean workEstimationVotingShowoff) {
        return this.workEstimationVotingShowoff == workEstimationVotingShowoff;
    }

    protected final void updateWorkEstimationVotingShowoff(Object value) {
        setWorkEstimationVotingShowoff((Boolean)value);
    }

    // -----------------------------------------------------------
    // - tasksOrderIds
    // -----------------------------------------------------------

    private java.util.List<java.lang.String> tasksOrderIds = new java.util.ArrayList<java.lang.String>();

    public final java.util.List<java.lang.String> getTasksOrderIds() {
        return new java.util.ArrayList<java.lang.String>(tasksOrderIds);
    }

    public final void setTasksOrderIds(Collection<java.lang.String> tasksOrderIds) {
        tasksOrderIds = prepareTasksOrderIds(tasksOrderIds);
        if (tasksOrderIds == null) tasksOrderIds = Collections.emptyList();
        if (this.tasksOrderIds.equals(tasksOrderIds)) return;
        this.tasksOrderIds = new java.util.ArrayList<java.lang.String>(tasksOrderIds);
            updateLastModified();
            fireModified("tasksOrderIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.tasksOrderIds));
    }

    protected Collection<java.lang.String> prepareTasksOrderIds(Collection<java.lang.String> tasksOrderIds) {
        return tasksOrderIds;
    }

    public final boolean containsTasksOrderId(java.lang.String tasksOrderId) {
        if (tasksOrderId == null) return false;
        return this.tasksOrderIds.contains(tasksOrderId);
    }

    public final int getTasksOrderIdsCount() {
        return this.tasksOrderIds.size();
    }

    public final boolean isTasksOrderIdsEmpty() {
        return this.tasksOrderIds.isEmpty();
    }

    public final boolean addTasksOrderId(java.lang.String tasksOrderId) {
        if (tasksOrderId == null) throw new IllegalArgumentException("tasksOrderId == null");
        boolean added = this.tasksOrderIds.add(tasksOrderId);
        if (added) {
            updateLastModified();
            fireModified("tasksOrderIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.tasksOrderIds));
        }
        return added;
    }

    public final boolean addTasksOrderIds(Collection<java.lang.String> tasksOrderIds) {
        if (tasksOrderIds == null) throw new IllegalArgumentException("tasksOrderIds == null");
        boolean added = false;
        for (java.lang.String tasksOrderId : tasksOrderIds) {
            added = added | this.tasksOrderIds.add(tasksOrderId);
        }
        if (added) {
            updateLastModified();
            fireModified("tasksOrderIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.tasksOrderIds));
        }
        return added;
    }

    public final boolean removeTasksOrderId(java.lang.String tasksOrderId) {
        if (tasksOrderId == null) return false;
        if (this.tasksOrderIds == null) return false;
        boolean removed = this.tasksOrderIds.remove(tasksOrderId);
        if (removed) {
            updateLastModified();
            fireModified("tasksOrderIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.tasksOrderIds));
        }
        return removed;
    }

    public final boolean removeTasksOrderIds(Collection<java.lang.String> tasksOrderIds) {
        if (tasksOrderIds == null) return false;
        if (tasksOrderIds.isEmpty()) return false;
        boolean removed = false;
        for (java.lang.String _element: tasksOrderIds) {
            removed = removed | this.tasksOrderIds.remove(_element);
        }
        if (removed) {
            updateLastModified();
            fireModified("tasksOrderIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.tasksOrderIds));
        }
        return removed;
    }

    public final boolean clearTasksOrderIds() {
        if (this.tasksOrderIds.isEmpty()) return false;
        this.tasksOrderIds.clear();
            updateLastModified();
            fireModified("tasksOrderIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.tasksOrderIds));
        return true;
    }

    public final String getTasksOrderIdsAsCommaSeparatedString() {
        if (this.tasksOrderIds.isEmpty()) return null;
        return Str.concat(this.tasksOrderIds,", ");
    }

    public final void setTasksOrderIdsAsCommaSeparatedString(String tasksOrderIds) {
        setTasksOrderIds(Str.parseCommaSeparatedString(tasksOrderIds));
    }

    // -----------------------------------------------------------
    // - themes
    // -----------------------------------------------------------

    private java.util.List<java.lang.String> themes = new java.util.ArrayList<java.lang.String>();

    public final java.util.List<java.lang.String> getThemes() {
        return new java.util.ArrayList<java.lang.String>(themes);
    }

    public final void setThemes(Collection<java.lang.String> themes) {
        themes = prepareThemes(themes);
        if (themes == null) themes = Collections.emptyList();
        if (this.themes.equals(themes)) return;
        this.themes = new java.util.ArrayList<java.lang.String>(themes);
            updateLastModified();
            fireModified("themes", ilarkesto.core.persistance.Persistence.propertyAsString(this.themes));
    }

    protected Collection<java.lang.String> prepareThemes(Collection<java.lang.String> themes) {
        return themes;
    }

    public final boolean containsTheme(java.lang.String theme) {
        if (theme == null) return false;
        return this.themes.contains(theme);
    }

    public final int getThemesCount() {
        return this.themes.size();
    }

    public final boolean isThemesEmpty() {
        return this.themes.isEmpty();
    }

    public final boolean addTheme(java.lang.String theme) {
        if (theme == null) throw new IllegalArgumentException("theme == null");
        boolean added = this.themes.add(theme);
        if (added) {
            updateLastModified();
            fireModified("themes", ilarkesto.core.persistance.Persistence.propertyAsString(this.themes));
        }
        return added;
    }

    public final boolean addThemes(Collection<java.lang.String> themes) {
        if (themes == null) throw new IllegalArgumentException("themes == null");
        boolean added = false;
        for (java.lang.String theme : themes) {
            added = added | this.themes.add(theme);
        }
        if (added) {
            updateLastModified();
            fireModified("themes", ilarkesto.core.persistance.Persistence.propertyAsString(this.themes));
        }
        return added;
    }

    public final boolean removeTheme(java.lang.String theme) {
        if (theme == null) return false;
        if (this.themes == null) return false;
        boolean removed = this.themes.remove(theme);
        if (removed) {
            updateLastModified();
            fireModified("themes", ilarkesto.core.persistance.Persistence.propertyAsString(this.themes));
        }
        return removed;
    }

    public final boolean removeThemes(Collection<java.lang.String> themes) {
        if (themes == null) return false;
        if (themes.isEmpty()) return false;
        boolean removed = false;
        for (java.lang.String _element: themes) {
            removed = removed | this.themes.remove(_element);
        }
        if (removed) {
            updateLastModified();
            fireModified("themes", ilarkesto.core.persistance.Persistence.propertyAsString(this.themes));
        }
        return removed;
    }

    public final boolean clearThemes() {
        if (this.themes.isEmpty()) return false;
        this.themes.clear();
            updateLastModified();
            fireModified("themes", ilarkesto.core.persistance.Persistence.propertyAsString(this.themes));
        return true;
    }

    public final String getThemesAsCommaSeparatedString() {
        if (this.themes.isEmpty()) return null;
        return Str.concat(this.themes,", ");
    }

    public final void setThemesAsCommaSeparatedString(String themes) {
        setThemes(Str.parseCommaSeparatedString(themes));
    }

    // -----------------------------------------------------------
    // - epic
    // -----------------------------------------------------------

    private String epicId;

    public final String getEpicId() {
        return this.epicId;
    }

    public final scrum.server.project.Requirement getEpic() {
        try {
            return this.epicId == null ? null : (scrum.server.project.Requirement) AEntity.getById(this.epicId);
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            throw ex.setCallerInfo("Requirement.epic");
        }
    }

    public final void setEpic(scrum.server.project.Requirement epic) {
        epic = prepareEpic(epic);
        if (isEpic(epic)) return;
        setEpicId(epic == null ? null : epic.getId());
    }

    public final void setEpicId(String id) {
        if (Utl.equals(epicId, id)) return;
        this.epicId = id;
            updateLastModified();
            fireModified("epicId", ilarkesto.core.persistance.Persistence.propertyAsString(this.epicId));
    }

    protected scrum.server.project.Requirement prepareEpic(scrum.server.project.Requirement epic) {
        return epic;
    }

    protected void repairDeadEpicReference(String entityId) {
        if (this.epicId == null || entityId.equals(this.epicId)) {
            setEpic(null);
        }
    }

    public final boolean isEpicSet() {
        return this.epicId != null;
    }

    public final boolean isEpic(scrum.server.project.Requirement epic) {
        if (this.epicId == null && epic == null) return true;
        return epic != null && epic.getId().equals(this.epicId);
    }

    protected final void updateEpic(Object value) {
        setEpic(value == null ? null : (scrum.server.project.Requirement)requirementDao.getById((String)value));
    }

    public void updateProperties(Map<String, String> properties) {
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            String property = entry.getKey();
            if (property.equals("id")) continue;
            String value = entry.getValue();
            if (property.equals("projectId")) setProjectId(ilarkesto.core.persistance.Persistence.parsePropertyReference(value));
            if (property.equals("sprintId")) setSprintId(ilarkesto.core.persistance.Persistence.parsePropertyReference(value));
            if (property.equals("issueId")) setIssueId(ilarkesto.core.persistance.Persistence.parsePropertyReference(value));
            if (property.equals("number")) setNumber(ilarkesto.core.persistance.Persistence.parsePropertyint(value));
            if (property.equals("qualitysIds")) setQualitysIds(ilarkesto.core.persistance.Persistence.parsePropertyReferenceSet(value));
            if (property.equals("label")) setLabel(ilarkesto.core.persistance.Persistence.parsePropertyString(value));
            if (property.equals("description")) setDescription(ilarkesto.core.persistance.Persistence.parsePropertyString(value));
            if (property.equals("testDescription")) setTestDescription(ilarkesto.core.persistance.Persistence.parsePropertyString(value));
            if (property.equals("estimatedWork")) setEstimatedWork(ilarkesto.core.persistance.Persistence.parsePropertyFloat(value));
            if (property.equals("rejectDate")) setRejectDate(ilarkesto.core.persistance.Persistence.parsePropertyDate(value));
            if (property.equals("closed")) setClosed(ilarkesto.core.persistance.Persistence.parsePropertyboolean(value));
            if (property.equals("deleted")) setDeleted(ilarkesto.core.persistance.Persistence.parsePropertyboolean(value));
            if (property.equals("dirty")) setDirty(ilarkesto.core.persistance.Persistence.parsePropertyboolean(value));
            if (property.equals("workEstimationVotingActive")) setWorkEstimationVotingActive(ilarkesto.core.persistance.Persistence.parsePropertyboolean(value));
            if (property.equals("workEstimationVotingShowoff")) setWorkEstimationVotingShowoff(ilarkesto.core.persistance.Persistence.parsePropertyboolean(value));
            if (property.equals("tasksOrderIds")) setTasksOrderIds(ilarkesto.core.persistance.Persistence.parsePropertyStringCollection(value));
            if (property.equals("themes")) setThemes(ilarkesto.core.persistance.Persistence.parsePropertyStringCollection(value));
            if (property.equals("epicId")) setEpicId(ilarkesto.core.persistance.Persistence.parsePropertyReference(value));
        }
    }

    protected void repairDeadReferences(String entityId) {
        super.repairDeadReferences(entityId);
        repairDeadProjectReference(entityId);
        repairDeadSprintReference(entityId);
        repairDeadIssueReference(entityId);
        if (this.qualitysIds == null) this.qualitysIds = new java.util.HashSet<String>();
        repairDeadQualityReference(entityId);
        if (this.tasksOrderIds == null) this.tasksOrderIds = new java.util.ArrayList<java.lang.String>();
        if (this.themes == null) this.themes = new java.util.ArrayList<java.lang.String>();
        repairDeadEpicReference(entityId);
    }

    // --- ensure integrity ---
    @Override
    public void ensureIntegrity() {
        super.ensureIntegrity();
        if (!isProjectSet()) {
            repairMissingMaster();
        }
        try {
            getProject();
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            LOG.info("Repairing dead project reference");
            repairDeadProjectReference(this.projectId);
        }
        try {
            getSprint();
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            LOG.info("Repairing dead sprint reference");
            repairDeadSprintReference(this.sprintId);
        }
        try {
            getIssue();
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            LOG.info("Repairing dead issue reference");
            repairDeadIssueReference(this.issueId);
        }
        if (this.qualitysIds == null) this.qualitysIds = new java.util.HashSet<String>();
        Set<String> qualitys = new HashSet<String>(this.qualitysIds);
        for (String entityId : qualitys) {
            try {
                AEntity.getById(entityId);
            } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
                LOG.info("Repairing dead quality reference");
                repairDeadQualityReference(entityId);
            }
        }
        if (this.tasksOrderIds == null) this.tasksOrderIds = new java.util.ArrayList<java.lang.String>();
        if (this.themes == null) this.themes = new java.util.ArrayList<java.lang.String>();
        try {
            getEpic();
        } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
            LOG.info("Repairing dead epic reference");
            repairDeadEpicReference(this.epicId);
        }
    }


    // -----------------------------------------------------------
    // - dependencies
    // -----------------------------------------------------------

    static scrum.server.project.ProjectDao projectDao;

    public static final void setProjectDao(scrum.server.project.ProjectDao projectDao) {
        GRequirement.projectDao = projectDao;
    }

    static scrum.server.sprint.SprintDao sprintDao;

    public static final void setSprintDao(scrum.server.sprint.SprintDao sprintDao) {
        GRequirement.sprintDao = sprintDao;
    }

    static scrum.server.issues.IssueDao issueDao;

    public static final void setIssueDao(scrum.server.issues.IssueDao issueDao) {
        GRequirement.issueDao = issueDao;
    }

    static scrum.server.project.QualityDao qualityDao;

    public static final void setQualityDao(scrum.server.project.QualityDao qualityDao) {
        GRequirement.qualityDao = qualityDao;
    }

    static scrum.server.project.RequirementDao requirementDao;

    public static final void setRequirementDao(scrum.server.project.RequirementDao requirementDao) {
        GRequirement.requirementDao = requirementDao;
    }

    static scrum.server.sprint.SprintReportDao sprintReportDao;

    public static final void setSprintReportDao(scrum.server.sprint.SprintReportDao sprintReportDao) {
        GRequirement.sprintReportDao = sprintReportDao;
    }

    static scrum.server.sprint.TaskDao taskDao;

    public static final void setTaskDao(scrum.server.sprint.TaskDao taskDao) {
        GRequirement.taskDao = taskDao;
    }

    static scrum.server.estimation.RequirementEstimationVoteDao requirementEstimationVoteDao;

    public static final void setRequirementEstimationVoteDao(scrum.server.estimation.RequirementEstimationVoteDao requirementEstimationVoteDao) {
        GRequirement.requirementEstimationVoteDao = requirementEstimationVoteDao;
    }

}