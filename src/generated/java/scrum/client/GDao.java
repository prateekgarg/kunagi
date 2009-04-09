// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.gen.GwtDaoGenerator










package scrum.client;

import java.util.*;
import scrum.client.common.*;
import ilarkesto.gwt.client.*;

public abstract class GDao
            extends ilarkesto.gwt.client.AGwtDao {

    // --- Risk ---

    private Map<String, scrum.client.risks.Risk> risks = new HashMap<String, scrum.client.risks.Risk>();

    public final void clearRisks() {
        risks.clear();
    }

    public final boolean containsRisk(scrum.client.risks.Risk risk) {
        return risks.containsKey(risk.getId());
    }

    public final void deleteRisk(scrum.client.risks.Risk risk) {
        risks.remove(risk.getId());
        entityDeleted(risk);
    }

    public final void createRisk(scrum.client.risks.Risk risk) {
        risks.put(risk.getId(), risk);
        entityCreated(risk);
    }

    private final void updateRisk(Map data) {
        String id = (String) data.get("id");
        scrum.client.risks.Risk entity = risks.get(id);
        if (entity == null) {
            entity = new scrum.client.risks.Risk(data);
            risks.put(id, entity);
            ilarkesto.gwt.client.GwtLogger.DEBUG("Risk received: " + entity.getId() + " ("+entity+")");
        } else {
            entity.updateProperties(data);
            ilarkesto.gwt.client.GwtLogger.DEBUG("Risk updated: " + entity);
        }
        onEntityModifiedRemotely(entity);
    }

    public final scrum.client.risks.Risk getRisk(String id) {
        scrum.client.risks.Risk ret = risks.get(id);
        if (ret == null) throw new RuntimeException("Risk does not exist: " + id);
        return ret;
    }

    public final Set<scrum.client.risks.Risk> getRisks(Collection<String> ids) {
        Set<scrum.client.risks.Risk> ret = new HashSet<scrum.client.risks.Risk>();
        for (String id : ids) {
            scrum.client.risks.Risk entity = risks.get(id);
            if (entity == null) throw new RuntimeException("Risk does not exist: " + id);
            ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.risks.Risk> getRisks() {
        return new ArrayList<scrum.client.risks.Risk>(risks.values());
    }

    public final List<scrum.client.risks.Risk> getRisksByProject(scrum.client.project.Project project) {
        List<scrum.client.risks.Risk> ret = new ArrayList<scrum.client.risks.Risk>();
        for (scrum.client.risks.Risk entity : risks.values()) {
            if (entity.isProject(project)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.risks.Risk> getRisksByLabel(java.lang.String label) {
        List<scrum.client.risks.Risk> ret = new ArrayList<scrum.client.risks.Risk>();
        for (scrum.client.risks.Risk entity : risks.values()) {
            if (entity.isLabel(label)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.risks.Risk> getRisksByDescription(java.lang.String description) {
        List<scrum.client.risks.Risk> ret = new ArrayList<scrum.client.risks.Risk>();
        for (scrum.client.risks.Risk entity : risks.values()) {
            if (entity.isDescription(description)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.risks.Risk> getRisksByProbability(int probability) {
        List<scrum.client.risks.Risk> ret = new ArrayList<scrum.client.risks.Risk>();
        for (scrum.client.risks.Risk entity : risks.values()) {
            if (entity.isProbability(probability)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.risks.Risk> getRisksByImpact(int impact) {
        List<scrum.client.risks.Risk> ret = new ArrayList<scrum.client.risks.Risk>();
        for (scrum.client.risks.Risk entity : risks.values()) {
            if (entity.isImpact(impact)) ret.add(entity);
        }
        return ret;
    }

    // --- Task ---

    private Map<String, scrum.client.sprint.Task> tasks = new HashMap<String, scrum.client.sprint.Task>();

    public final void clearTasks() {
        tasks.clear();
    }

    public final boolean containsTask(scrum.client.sprint.Task task) {
        return tasks.containsKey(task.getId());
    }

    public final void deleteTask(scrum.client.sprint.Task task) {
        tasks.remove(task.getId());
        entityDeleted(task);
    }

    public final void createTask(scrum.client.sprint.Task task) {
        tasks.put(task.getId(), task);
        entityCreated(task);
    }

    private final void updateTask(Map data) {
        String id = (String) data.get("id");
        scrum.client.sprint.Task entity = tasks.get(id);
        if (entity == null) {
            entity = new scrum.client.sprint.Task(data);
            tasks.put(id, entity);
            ilarkesto.gwt.client.GwtLogger.DEBUG("Task received: " + entity.getId() + " ("+entity+")");
        } else {
            entity.updateProperties(data);
            ilarkesto.gwt.client.GwtLogger.DEBUG("Task updated: " + entity);
        }
        onEntityModifiedRemotely(entity);
    }

    public final scrum.client.sprint.Task getTask(String id) {
        scrum.client.sprint.Task ret = tasks.get(id);
        if (ret == null) throw new RuntimeException("Task does not exist: " + id);
        return ret;
    }

    public final Set<scrum.client.sprint.Task> getTasks(Collection<String> ids) {
        Set<scrum.client.sprint.Task> ret = new HashSet<scrum.client.sprint.Task>();
        for (String id : ids) {
            scrum.client.sprint.Task entity = tasks.get(id);
            if (entity == null) throw new RuntimeException("Task does not exist: " + id);
            ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.sprint.Task> getTasks() {
        return new ArrayList<scrum.client.sprint.Task>(tasks.values());
    }

    public final List<scrum.client.sprint.Task> getTasksByRequirement(scrum.client.project.Requirement requirement) {
        List<scrum.client.sprint.Task> ret = new ArrayList<scrum.client.sprint.Task>();
        for (scrum.client.sprint.Task entity : tasks.values()) {
            if (entity.isRequirement(requirement)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.sprint.Task> getTasksByLabel(java.lang.String label) {
        List<scrum.client.sprint.Task> ret = new ArrayList<scrum.client.sprint.Task>();
        for (scrum.client.sprint.Task entity : tasks.values()) {
            if (entity.isLabel(label)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.sprint.Task> getTasksByRemainingWork(int remainingWork) {
        List<scrum.client.sprint.Task> ret = new ArrayList<scrum.client.sprint.Task>();
        for (scrum.client.sprint.Task entity : tasks.values()) {
            if (entity.isRemainingWork(remainingWork)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.sprint.Task> getTasksByBurnedWork(int burnedWork) {
        List<scrum.client.sprint.Task> ret = new ArrayList<scrum.client.sprint.Task>();
        for (scrum.client.sprint.Task entity : tasks.values()) {
            if (entity.isBurnedWork(burnedWork)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.sprint.Task> getTasksByNotice(java.lang.String notice) {
        List<scrum.client.sprint.Task> ret = new ArrayList<scrum.client.sprint.Task>();
        for (scrum.client.sprint.Task entity : tasks.values()) {
            if (entity.isNotice(notice)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.sprint.Task> getTasksByOwner(scrum.client.admin.User owner) {
        List<scrum.client.sprint.Task> ret = new ArrayList<scrum.client.sprint.Task>();
        for (scrum.client.sprint.Task entity : tasks.values()) {
            if (entity.isOwner(owner)) ret.add(entity);
        }
        return ret;
    }

    // --- Project ---

    private Map<String, scrum.client.project.Project> projects = new HashMap<String, scrum.client.project.Project>();

    public final void clearProjects() {
        projects.clear();
    }

    public final boolean containsProject(scrum.client.project.Project project) {
        return projects.containsKey(project.getId());
    }

    public final void deleteProject(scrum.client.project.Project project) {
        projects.remove(project.getId());
        entityDeleted(project);
    }

    public final void createProject(scrum.client.project.Project project) {
        projects.put(project.getId(), project);
        entityCreated(project);
    }

    private final void updateProject(Map data) {
        String id = (String) data.get("id");
        scrum.client.project.Project entity = projects.get(id);
        if (entity == null) {
            entity = new scrum.client.project.Project(data);
            projects.put(id, entity);
            ilarkesto.gwt.client.GwtLogger.DEBUG("Project received: " + entity.getId() + " ("+entity+")");
        } else {
            entity.updateProperties(data);
            ilarkesto.gwt.client.GwtLogger.DEBUG("Project updated: " + entity);
        }
        onEntityModifiedRemotely(entity);
    }

    public final scrum.client.project.Project getProject(String id) {
        scrum.client.project.Project ret = projects.get(id);
        if (ret == null) throw new RuntimeException("Project does not exist: " + id);
        return ret;
    }

    public final Set<scrum.client.project.Project> getProjects(Collection<String> ids) {
        Set<scrum.client.project.Project> ret = new HashSet<scrum.client.project.Project>();
        for (String id : ids) {
            scrum.client.project.Project entity = projects.get(id);
            if (entity == null) throw new RuntimeException("Project does not exist: " + id);
            ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Project> getProjects() {
        return new ArrayList<scrum.client.project.Project>(projects.values());
    }

    public final List<scrum.client.project.Project> getProjectsByLabel(java.lang.String label) {
        List<scrum.client.project.Project> ret = new ArrayList<scrum.client.project.Project>();
        for (scrum.client.project.Project entity : projects.values()) {
            if (entity.isLabel(label)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Project> getProjectsByDescription(java.lang.String description) {
        List<scrum.client.project.Project> ret = new ArrayList<scrum.client.project.Project>();
        for (scrum.client.project.Project entity : projects.values()) {
            if (entity.isDescription(description)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Project> getProjectsByBegin(ilarkesto.gwt.client.Date begin) {
        List<scrum.client.project.Project> ret = new ArrayList<scrum.client.project.Project>();
        for (scrum.client.project.Project entity : projects.values()) {
            if (entity.isBegin(begin)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Project> getProjectsByEnd(ilarkesto.gwt.client.Date end) {
        List<scrum.client.project.Project> ret = new ArrayList<scrum.client.project.Project>();
        for (scrum.client.project.Project entity : projects.values()) {
            if (entity.isEnd(end)) ret.add(entity);
        }
        return ret;
    }






    public final List<scrum.client.project.Project> getProjectsByCurrentSprint(scrum.client.sprint.Sprint currentSprint) {
        List<scrum.client.project.Project> ret = new ArrayList<scrum.client.project.Project>();
        for (scrum.client.project.Project entity : projects.values()) {
            if (entity.isCurrentSprint(currentSprint)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Project> getProjectsByNextSprint(scrum.client.sprint.Sprint nextSprint) {
        List<scrum.client.project.Project> ret = new ArrayList<scrum.client.project.Project>();
        for (scrum.client.project.Project entity : projects.values()) {
            if (entity.isNextSprint(nextSprint)) ret.add(entity);
        }
        return ret;
    }


    // --- Requirement ---

    private Map<String, scrum.client.project.Requirement> requirements = new HashMap<String, scrum.client.project.Requirement>();

    public final void clearRequirements() {
        requirements.clear();
    }

    public final boolean containsRequirement(scrum.client.project.Requirement requirement) {
        return requirements.containsKey(requirement.getId());
    }

    public final void deleteRequirement(scrum.client.project.Requirement requirement) {
        requirements.remove(requirement.getId());
        entityDeleted(requirement);
    }

    public final void createRequirement(scrum.client.project.Requirement requirement) {
        requirements.put(requirement.getId(), requirement);
        entityCreated(requirement);
    }

    private final void updateRequirement(Map data) {
        String id = (String) data.get("id");
        scrum.client.project.Requirement entity = requirements.get(id);
        if (entity == null) {
            entity = new scrum.client.project.Requirement(data);
            requirements.put(id, entity);
            ilarkesto.gwt.client.GwtLogger.DEBUG("Requirement received: " + entity.getId() + " ("+entity+")");
        } else {
            entity.updateProperties(data);
            ilarkesto.gwt.client.GwtLogger.DEBUG("Requirement updated: " + entity);
        }
        onEntityModifiedRemotely(entity);
    }

    public final scrum.client.project.Requirement getRequirement(String id) {
        scrum.client.project.Requirement ret = requirements.get(id);
        if (ret == null) throw new RuntimeException("Requirement does not exist: " + id);
        return ret;
    }

    public final Set<scrum.client.project.Requirement> getRequirements(Collection<String> ids) {
        Set<scrum.client.project.Requirement> ret = new HashSet<scrum.client.project.Requirement>();
        for (String id : ids) {
            scrum.client.project.Requirement entity = requirements.get(id);
            if (entity == null) throw new RuntimeException("Requirement does not exist: " + id);
            ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Requirement> getRequirements() {
        return new ArrayList<scrum.client.project.Requirement>(requirements.values());
    }

    public final List<scrum.client.project.Requirement> getRequirementsByProject(scrum.client.project.Project project) {
        List<scrum.client.project.Requirement> ret = new ArrayList<scrum.client.project.Requirement>();
        for (scrum.client.project.Requirement entity : requirements.values()) {
            if (entity.isProject(project)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Requirement> getRequirementsBySprint(scrum.client.sprint.Sprint sprint) {
        List<scrum.client.project.Requirement> ret = new ArrayList<scrum.client.project.Requirement>();
        for (scrum.client.project.Requirement entity : requirements.values()) {
            if (entity.isSprint(sprint)) ret.add(entity);
        }
        return ret;
    }


    public final List<scrum.client.project.Requirement> getRequirementsByLabel(java.lang.String label) {
        List<scrum.client.project.Requirement> ret = new ArrayList<scrum.client.project.Requirement>();
        for (scrum.client.project.Requirement entity : requirements.values()) {
            if (entity.isLabel(label)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Requirement> getRequirementsByDescription(java.lang.String description) {
        List<scrum.client.project.Requirement> ret = new ArrayList<scrum.client.project.Requirement>();
        for (scrum.client.project.Requirement entity : requirements.values()) {
            if (entity.isDescription(description)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Requirement> getRequirementsByTestDescription(java.lang.String testDescription) {
        List<scrum.client.project.Requirement> ret = new ArrayList<scrum.client.project.Requirement>();
        for (scrum.client.project.Requirement entity : requirements.values()) {
            if (entity.isTestDescription(testDescription)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Requirement> getRequirementsByEstimatedWork(java.lang.Integer estimatedWork) {
        List<scrum.client.project.Requirement> ret = new ArrayList<scrum.client.project.Requirement>();
        for (scrum.client.project.Requirement entity : requirements.values()) {
            if (entity.isEstimatedWork(estimatedWork)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Requirement> getRequirementsByClosed(boolean closed) {
        List<scrum.client.project.Requirement> ret = new ArrayList<scrum.client.project.Requirement>();
        for (scrum.client.project.Requirement entity : requirements.values()) {
            if (entity.isClosed(closed)) ret.add(entity);
        }
        return ret;
    }

    // --- Quality ---

    private Map<String, scrum.client.project.Quality> qualitys = new HashMap<String, scrum.client.project.Quality>();

    public final void clearQualitys() {
        qualitys.clear();
    }

    public final boolean containsQuality(scrum.client.project.Quality quality) {
        return qualitys.containsKey(quality.getId());
    }

    public final void deleteQuality(scrum.client.project.Quality quality) {
        qualitys.remove(quality.getId());
        entityDeleted(quality);
    }

    public final void createQuality(scrum.client.project.Quality quality) {
        qualitys.put(quality.getId(), quality);
        entityCreated(quality);
    }

    private final void updateQuality(Map data) {
        String id = (String) data.get("id");
        scrum.client.project.Quality entity = qualitys.get(id);
        if (entity == null) {
            entity = new scrum.client.project.Quality(data);
            qualitys.put(id, entity);
            ilarkesto.gwt.client.GwtLogger.DEBUG("Quality received: " + entity.getId() + " ("+entity+")");
        } else {
            entity.updateProperties(data);
            ilarkesto.gwt.client.GwtLogger.DEBUG("Quality updated: " + entity);
        }
        onEntityModifiedRemotely(entity);
    }

    public final scrum.client.project.Quality getQuality(String id) {
        scrum.client.project.Quality ret = qualitys.get(id);
        if (ret == null) throw new RuntimeException("Quality does not exist: " + id);
        return ret;
    }

    public final Set<scrum.client.project.Quality> getQualitys(Collection<String> ids) {
        Set<scrum.client.project.Quality> ret = new HashSet<scrum.client.project.Quality>();
        for (String id : ids) {
            scrum.client.project.Quality entity = qualitys.get(id);
            if (entity == null) throw new RuntimeException("Quality does not exist: " + id);
            ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Quality> getQualitys() {
        return new ArrayList<scrum.client.project.Quality>(qualitys.values());
    }

    public final List<scrum.client.project.Quality> getQualitysByProject(scrum.client.project.Project project) {
        List<scrum.client.project.Quality> ret = new ArrayList<scrum.client.project.Quality>();
        for (scrum.client.project.Quality entity : qualitys.values()) {
            if (entity.isProject(project)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Quality> getQualitysByLabel(java.lang.String label) {
        List<scrum.client.project.Quality> ret = new ArrayList<scrum.client.project.Quality>();
        for (scrum.client.project.Quality entity : qualitys.values()) {
            if (entity.isLabel(label)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Quality> getQualitysByDescription(java.lang.String description) {
        List<scrum.client.project.Quality> ret = new ArrayList<scrum.client.project.Quality>();
        for (scrum.client.project.Quality entity : qualitys.values()) {
            if (entity.isDescription(description)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.project.Quality> getQualitysByTestDescription(java.lang.String testDescription) {
        List<scrum.client.project.Quality> ret = new ArrayList<scrum.client.project.Quality>();
        for (scrum.client.project.Quality entity : qualitys.values()) {
            if (entity.isTestDescription(testDescription)) ret.add(entity);
        }
        return ret;
    }

    // --- Sprint ---

    private Map<String, scrum.client.sprint.Sprint> sprints = new HashMap<String, scrum.client.sprint.Sprint>();

    public final void clearSprints() {
        sprints.clear();
    }

    public final boolean containsSprint(scrum.client.sprint.Sprint sprint) {
        return sprints.containsKey(sprint.getId());
    }

    public final void deleteSprint(scrum.client.sprint.Sprint sprint) {
        sprints.remove(sprint.getId());
        entityDeleted(sprint);
    }

    public final void createSprint(scrum.client.sprint.Sprint sprint) {
        sprints.put(sprint.getId(), sprint);
        entityCreated(sprint);
    }

    private final void updateSprint(Map data) {
        String id = (String) data.get("id");
        scrum.client.sprint.Sprint entity = sprints.get(id);
        if (entity == null) {
            entity = new scrum.client.sprint.Sprint(data);
            sprints.put(id, entity);
            ilarkesto.gwt.client.GwtLogger.DEBUG("Sprint received: " + entity.getId() + " ("+entity+")");
        } else {
            entity.updateProperties(data);
            ilarkesto.gwt.client.GwtLogger.DEBUG("Sprint updated: " + entity);
        }
        onEntityModifiedRemotely(entity);
    }

    public final scrum.client.sprint.Sprint getSprint(String id) {
        scrum.client.sprint.Sprint ret = sprints.get(id);
        if (ret == null) throw new RuntimeException("Sprint does not exist: " + id);
        return ret;
    }

    public final Set<scrum.client.sprint.Sprint> getSprints(Collection<String> ids) {
        Set<scrum.client.sprint.Sprint> ret = new HashSet<scrum.client.sprint.Sprint>();
        for (String id : ids) {
            scrum.client.sprint.Sprint entity = sprints.get(id);
            if (entity == null) throw new RuntimeException("Sprint does not exist: " + id);
            ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.sprint.Sprint> getSprints() {
        return new ArrayList<scrum.client.sprint.Sprint>(sprints.values());
    }

    public final List<scrum.client.sprint.Sprint> getSprintsByProject(scrum.client.project.Project project) {
        List<scrum.client.sprint.Sprint> ret = new ArrayList<scrum.client.sprint.Sprint>();
        for (scrum.client.sprint.Sprint entity : sprints.values()) {
            if (entity.isProject(project)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.sprint.Sprint> getSprintsByLabel(java.lang.String label) {
        List<scrum.client.sprint.Sprint> ret = new ArrayList<scrum.client.sprint.Sprint>();
        for (scrum.client.sprint.Sprint entity : sprints.values()) {
            if (entity.isLabel(label)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.sprint.Sprint> getSprintsByGoal(java.lang.String goal) {
        List<scrum.client.sprint.Sprint> ret = new ArrayList<scrum.client.sprint.Sprint>();
        for (scrum.client.sprint.Sprint entity : sprints.values()) {
            if (entity.isGoal(goal)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.sprint.Sprint> getSprintsByBegin(ilarkesto.gwt.client.Date begin) {
        List<scrum.client.sprint.Sprint> ret = new ArrayList<scrum.client.sprint.Sprint>();
        for (scrum.client.sprint.Sprint entity : sprints.values()) {
            if (entity.isBegin(begin)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.sprint.Sprint> getSprintsByEnd(ilarkesto.gwt.client.Date end) {
        List<scrum.client.sprint.Sprint> ret = new ArrayList<scrum.client.sprint.Sprint>();
        for (scrum.client.sprint.Sprint entity : sprints.values()) {
            if (entity.isEnd(end)) ret.add(entity);
        }
        return ret;
    }

    // --- Impediment ---

    private Map<String, scrum.client.impediments.Impediment> impediments = new HashMap<String, scrum.client.impediments.Impediment>();

    public final void clearImpediments() {
        impediments.clear();
    }

    public final boolean containsImpediment(scrum.client.impediments.Impediment impediment) {
        return impediments.containsKey(impediment.getId());
    }

    public final void deleteImpediment(scrum.client.impediments.Impediment impediment) {
        impediments.remove(impediment.getId());
        entityDeleted(impediment);
    }

    public final void createImpediment(scrum.client.impediments.Impediment impediment) {
        impediments.put(impediment.getId(), impediment);
        entityCreated(impediment);
    }

    private final void updateImpediment(Map data) {
        String id = (String) data.get("id");
        scrum.client.impediments.Impediment entity = impediments.get(id);
        if (entity == null) {
            entity = new scrum.client.impediments.Impediment(data);
            impediments.put(id, entity);
            ilarkesto.gwt.client.GwtLogger.DEBUG("Impediment received: " + entity.getId() + " ("+entity+")");
        } else {
            entity.updateProperties(data);
            ilarkesto.gwt.client.GwtLogger.DEBUG("Impediment updated: " + entity);
        }
        onEntityModifiedRemotely(entity);
    }

    public final scrum.client.impediments.Impediment getImpediment(String id) {
        scrum.client.impediments.Impediment ret = impediments.get(id);
        if (ret == null) throw new RuntimeException("Impediment does not exist: " + id);
        return ret;
    }

    public final Set<scrum.client.impediments.Impediment> getImpediments(Collection<String> ids) {
        Set<scrum.client.impediments.Impediment> ret = new HashSet<scrum.client.impediments.Impediment>();
        for (String id : ids) {
            scrum.client.impediments.Impediment entity = impediments.get(id);
            if (entity == null) throw new RuntimeException("Impediment does not exist: " + id);
            ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.impediments.Impediment> getImpediments() {
        return new ArrayList<scrum.client.impediments.Impediment>(impediments.values());
    }

    public final List<scrum.client.impediments.Impediment> getImpedimentsByProject(scrum.client.project.Project project) {
        List<scrum.client.impediments.Impediment> ret = new ArrayList<scrum.client.impediments.Impediment>();
        for (scrum.client.impediments.Impediment entity : impediments.values()) {
            if (entity.isProject(project)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.impediments.Impediment> getImpedimentsByLabel(java.lang.String label) {
        List<scrum.client.impediments.Impediment> ret = new ArrayList<scrum.client.impediments.Impediment>();
        for (scrum.client.impediments.Impediment entity : impediments.values()) {
            if (entity.isLabel(label)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.impediments.Impediment> getImpedimentsByDate(ilarkesto.gwt.client.Date date) {
        List<scrum.client.impediments.Impediment> ret = new ArrayList<scrum.client.impediments.Impediment>();
        for (scrum.client.impediments.Impediment entity : impediments.values()) {
            if (entity.isDate(date)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.impediments.Impediment> getImpedimentsByDescription(java.lang.String description) {
        List<scrum.client.impediments.Impediment> ret = new ArrayList<scrum.client.impediments.Impediment>();
        for (scrum.client.impediments.Impediment entity : impediments.values()) {
            if (entity.isDescription(description)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.impediments.Impediment> getImpedimentsBySolution(java.lang.String solution) {
        List<scrum.client.impediments.Impediment> ret = new ArrayList<scrum.client.impediments.Impediment>();
        for (scrum.client.impediments.Impediment entity : impediments.values()) {
            if (entity.isSolution(solution)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.impediments.Impediment> getImpedimentsBySolveDate(ilarkesto.gwt.client.Date solveDate) {
        List<scrum.client.impediments.Impediment> ret = new ArrayList<scrum.client.impediments.Impediment>();
        for (scrum.client.impediments.Impediment entity : impediments.values()) {
            if (entity.isSolveDate(solveDate)) ret.add(entity);
        }
        return ret;
    }

    // --- User ---

    private Map<String, scrum.client.admin.User> users = new HashMap<String, scrum.client.admin.User>();

    public final void clearUsers() {
        users.clear();
    }

    public final boolean containsUser(scrum.client.admin.User user) {
        return users.containsKey(user.getId());
    }

    public final void deleteUser(scrum.client.admin.User user) {
        users.remove(user.getId());
        entityDeleted(user);
    }

    public final void createUser(scrum.client.admin.User user) {
        users.put(user.getId(), user);
        entityCreated(user);
    }

    private final void updateUser(Map data) {
        String id = (String) data.get("id");
        scrum.client.admin.User entity = users.get(id);
        if (entity == null) {
            entity = new scrum.client.admin.User(data);
            users.put(id, entity);
            ilarkesto.gwt.client.GwtLogger.DEBUG("User received: " + entity.getId() + " ("+entity+")");
        } else {
            entity.updateProperties(data);
            ilarkesto.gwt.client.GwtLogger.DEBUG("User updated: " + entity);
        }
        onEntityModifiedRemotely(entity);
    }

    public final scrum.client.admin.User getUser(String id) {
        scrum.client.admin.User ret = users.get(id);
        if (ret == null) throw new RuntimeException("User does not exist: " + id);
        return ret;
    }

    public final Set<scrum.client.admin.User> getUsers(Collection<String> ids) {
        Set<scrum.client.admin.User> ret = new HashSet<scrum.client.admin.User>();
        for (String id : ids) {
            scrum.client.admin.User entity = users.get(id);
            if (entity == null) throw new RuntimeException("User does not exist: " + id);
            ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.admin.User> getUsers() {
        return new ArrayList<scrum.client.admin.User>(users.values());
    }

    public final List<scrum.client.admin.User> getUsersByName(java.lang.String name) {
        List<scrum.client.admin.User> ret = new ArrayList<scrum.client.admin.User>();
        for (scrum.client.admin.User entity : users.values()) {
            if (entity.isName(name)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.admin.User> getUsersByAdmin(boolean admin) {
        List<scrum.client.admin.User> ret = new ArrayList<scrum.client.admin.User>();
        for (scrum.client.admin.User entity : users.values()) {
            if (entity.isAdmin(admin)) ret.add(entity);
        }
        return ret;
    }

    public final List<scrum.client.admin.User> getUsersByEmail(java.lang.String email) {
        List<scrum.client.admin.User> ret = new ArrayList<scrum.client.admin.User>();
        for (scrum.client.admin.User entity : users.values()) {
            if (entity.isEmail(email)) ret.add(entity);
        }
        return ret;
    }

    public final void clearAllEntities() {
            clearRisks();
            clearTasks();
            clearProjects();
            clearRequirements();
            clearQualitys();
            clearSprints();
            clearImpediments();
            clearUsers();
    }

    private Collection<Map<String, ? extends AGwtEntity>> entityMaps;

    @Override
    protected final Collection<Map<String, ? extends AGwtEntity>> getEntityMaps() {
        if (entityMaps == null) {
            entityMaps = new ArrayList<Map<String, ? extends AGwtEntity>>();
            entityMaps.add(risks);
            entityMaps.add(tasks);
            entityMaps.add(projects);
            entityMaps.add(requirements);
            entityMaps.add(qualitys);
            entityMaps.add(sprints);
            entityMaps.add(impediments);
            entityMaps.add(users);
        }
        return entityMaps;
    }

    @Override
    protected final void updateLocalEntity(String type, Map data) {
        if (type.equals(scrum.client.risks.Risk.ENTITY_TYPE)) {
            updateRisk(data);
            return;
        }
        if (type.equals(scrum.client.sprint.Task.ENTITY_TYPE)) {
            updateTask(data);
            return;
        }
        if (type.equals(scrum.client.project.Project.ENTITY_TYPE)) {
            updateProject(data);
            return;
        }
        if (type.equals(scrum.client.project.Requirement.ENTITY_TYPE)) {
            updateRequirement(data);
            return;
        }
        if (type.equals(scrum.client.project.Quality.ENTITY_TYPE)) {
            updateQuality(data);
            return;
        }
        if (type.equals(scrum.client.sprint.Sprint.ENTITY_TYPE)) {
            updateSprint(data);
            return;
        }
        if (type.equals(scrum.client.impediments.Impediment.ENTITY_TYPE)) {
            updateImpediment(data);
            return;
        }
        if (type.equals(scrum.client.admin.User.ENTITY_TYPE)) {
            updateUser(data);
            return;
        }
       throw new RuntimeException("Unsupported type: " + type);
    }

}