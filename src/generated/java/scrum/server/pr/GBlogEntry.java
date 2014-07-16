// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.EntityGenerator










package scrum.server.pr;

import java.util.*;
import ilarkesto.core.base.Utl;
import ilarkesto.core.logging.Log;
import ilarkesto.persistence.ADatob;
import ilarkesto.persistence.AEntity;
import ilarkesto.persistence.AStructure;
import ilarkesto.auth.AUser;
import ilarkesto.core.base.Str;
import ilarkesto.core.persistance.EntityDoesNotExistException;

public abstract class GBlogEntry
            extends AEntity
            implements ilarkesto.auth.ViewProtected<scrum.server.admin.User>, java.lang.Comparable<BlogEntry>, ilarkesto.search.Searchable {

    protected static final ilarkesto.core.logging.Log log = ilarkesto.core.logging.Log.get(BlogEntry.class);

    // --- AEntity ---

    public final scrum.server.pr.BlogEntryDao getDao() {
        return blogEntryDao;
    }

    protected void repairDeadDatob(ADatob datob) {
    }

    @Override
    public void storeProperties(Map<String, String> properties) {
        super.storeProperties(properties);
        properties.put("projectId", ilarkesto.core.persistance.Persistence.propertyAsString(this.projectId));
        properties.put("number", ilarkesto.core.persistance.Persistence.propertyAsString(this.number));
        properties.put("authorsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.authorsIds));
        properties.put("title", ilarkesto.core.persistance.Persistence.propertyAsString(this.title));
        properties.put("text", ilarkesto.core.persistance.Persistence.propertyAsString(this.text));
        properties.put("dateAndTime", ilarkesto.core.persistance.Persistence.propertyAsString(this.dateAndTime));
        properties.put("releasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.releasesIds));
        properties.put("published", ilarkesto.core.persistance.Persistence.propertyAsString(this.published));
    }

    public int compareTo(BlogEntry other) {
        return toString().toLowerCase().compareTo(other.toString().toLowerCase());
    }

    private static final ilarkesto.core.logging.Log LOG = ilarkesto.core.logging.Log.get(GBlogEntry.class);

    public static final String TYPE = "blogEntry";


    // -----------------------------------------------------------
    // - Searchable
    // -----------------------------------------------------------

    public boolean matchesKey(String key) {
        if (super.matchesKey(key)) return true;
        if (matchesKey(getTitle(), key)) return true;
        if (matchesKey(getText(), key)) return true;
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
        return this.projectId == null ? null : (scrum.server.project.Project)projectDao.getById(this.projectId);
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
    // - authors
    // -----------------------------------------------------------

    private java.util.Set<String> authorsIds = new java.util.HashSet<String>();

    public final java.util.Set<scrum.server.admin.User> getAuthors() {
        return (java.util.Set) userDao.getByIdsAsSet(this.authorsIds);
    }

    public final void setAuthors(Collection<scrum.server.admin.User> authors) {
        authors = prepareAuthors(authors);
        if (authors == null) authors = Collections.emptyList();
        java.util.Set<String> ids = getIdsAsSet(authors);
        setAuthorsIds(ids);
    }

    public final void setAuthorsIds(java.util.Set<String> ids) {
        if (Utl.equals(authorsIds, ids)) return;
        authorsIds = ids;
            updateLastModified();
            fireModified("authorsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.authorsIds));
    }

    protected Collection<scrum.server.admin.User> prepareAuthors(Collection<scrum.server.admin.User> authors) {
        return authors;
    }

    protected void repairDeadAuthorReference(String entityId) {
        if (this.authorsIds.remove(entityId)) {
            updateLastModified();
            fireModified("authorsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.authorsIds));
        }
    }

    public final boolean containsAuthor(scrum.server.admin.User author) {
        if (author == null) return false;
        return this.authorsIds.contains(author.getId());
    }

    public final int getAuthorsCount() {
        return this.authorsIds.size();
    }

    public final boolean isAuthorsEmpty() {
        return this.authorsIds.isEmpty();
    }

    public final boolean addAuthor(scrum.server.admin.User author) {
        if (author == null) throw new IllegalArgumentException("author == null");
        boolean added = this.authorsIds.add(author.getId());
        if (added) {
            updateLastModified();
            fireModified("authorsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.authorsIds));
        }
        return added;
    }

    public final boolean addAuthors(Collection<scrum.server.admin.User> authors) {
        if (authors == null) throw new IllegalArgumentException("authors == null");
        boolean added = false;
        for (scrum.server.admin.User author : authors) {
            added = added | this.authorsIds.add(author.getId());
        }
        if (added) {
            updateLastModified();
            fireModified("authorsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.authorsIds));
        }
        return added;
    }

    public final boolean removeAuthor(scrum.server.admin.User author) {
        if (author == null) return false;
        if (this.authorsIds == null) return false;
        boolean removed = this.authorsIds.remove(author.getId());
        if (removed) {
            updateLastModified();
            fireModified("authorsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.authorsIds));
        }
        return removed;
    }

    public final boolean removeAuthors(Collection<scrum.server.admin.User> authors) {
        if (authors == null) return false;
        if (authors.isEmpty()) return false;
        boolean removed = false;
        for (scrum.server.admin.User _element: authors) {
            removed = removed | this.authorsIds.remove(_element);
        }
        if (removed) {
            updateLastModified();
            fireModified("authorsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.authorsIds));
        }
        return removed;
    }

    public final boolean clearAuthors() {
        if (this.authorsIds.isEmpty()) return false;
        this.authorsIds.clear();
            updateLastModified();
            fireModified("authorsIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.authorsIds));
        return true;
    }

    // -----------------------------------------------------------
    // - title
    // -----------------------------------------------------------

    private java.lang.String title;

    public final java.lang.String getTitle() {
        return title;
    }

    public final void setTitle(java.lang.String title) {
        title = prepareTitle(title);
        if (isTitle(title)) return;
        if (title == null) throw new IllegalArgumentException("Mandatory field can not be set to null: title");
        this.title = title;
            updateLastModified();
            fireModified("title", ilarkesto.core.persistance.Persistence.propertyAsString(this.title));
    }

    protected java.lang.String prepareTitle(java.lang.String title) {
        // title = Str.removeUnreadableChars(title);
        return title;
    }

    public final boolean isTitleSet() {
        return this.title != null;
    }

    public final boolean isTitle(java.lang.String title) {
        if (this.title == null && title == null) return true;
        return this.title != null && this.title.equals(title);
    }

    protected final void updateTitle(Object value) {
        setTitle((java.lang.String)value);
    }

    // -----------------------------------------------------------
    // - text
    // -----------------------------------------------------------

    private java.lang.String text;

    public final java.lang.String getText() {
        return text;
    }

    public final void setText(java.lang.String text) {
        text = prepareText(text);
        if (isText(text)) return;
        this.text = text;
            updateLastModified();
            fireModified("text", ilarkesto.core.persistance.Persistence.propertyAsString(this.text));
    }

    protected java.lang.String prepareText(java.lang.String text) {
        // text = Str.removeUnreadableChars(text);
        return text;
    }

    public final boolean isTextSet() {
        return this.text != null;
    }

    public final boolean isText(java.lang.String text) {
        if (this.text == null && text == null) return true;
        return this.text != null && this.text.equals(text);
    }

    protected final void updateText(Object value) {
        setText((java.lang.String)value);
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
    // - releases
    // -----------------------------------------------------------

    private java.util.Set<String> releasesIds = new java.util.HashSet<String>();

    public final java.util.Set<scrum.server.release.Release> getReleases() {
        return (java.util.Set) releaseDao.getByIdsAsSet(this.releasesIds);
    }

    public final void setReleases(Collection<scrum.server.release.Release> releases) {
        releases = prepareReleases(releases);
        if (releases == null) releases = Collections.emptyList();
        java.util.Set<String> ids = getIdsAsSet(releases);
        setReleasesIds(ids);
    }

    public final void setReleasesIds(java.util.Set<String> ids) {
        if (Utl.equals(releasesIds, ids)) return;
        releasesIds = ids;
            updateLastModified();
            fireModified("releasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.releasesIds));
    }

    protected Collection<scrum.server.release.Release> prepareReleases(Collection<scrum.server.release.Release> releases) {
        return releases;
    }

    protected void repairDeadReleaseReference(String entityId) {
        if (this.releasesIds.remove(entityId)) {
            updateLastModified();
            fireModified("releasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.releasesIds));
        }
    }

    public final boolean containsRelease(scrum.server.release.Release release) {
        if (release == null) return false;
        return this.releasesIds.contains(release.getId());
    }

    public final int getReleasesCount() {
        return this.releasesIds.size();
    }

    public final boolean isReleasesEmpty() {
        return this.releasesIds.isEmpty();
    }

    public final boolean addRelease(scrum.server.release.Release release) {
        if (release == null) throw new IllegalArgumentException("release == null");
        boolean added = this.releasesIds.add(release.getId());
        if (added) {
            updateLastModified();
            fireModified("releasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.releasesIds));
        }
        return added;
    }

    public final boolean addReleases(Collection<scrum.server.release.Release> releases) {
        if (releases == null) throw new IllegalArgumentException("releases == null");
        boolean added = false;
        for (scrum.server.release.Release release : releases) {
            added = added | this.releasesIds.add(release.getId());
        }
        if (added) {
            updateLastModified();
            fireModified("releasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.releasesIds));
        }
        return added;
    }

    public final boolean removeRelease(scrum.server.release.Release release) {
        if (release == null) return false;
        if (this.releasesIds == null) return false;
        boolean removed = this.releasesIds.remove(release.getId());
        if (removed) {
            updateLastModified();
            fireModified("releasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.releasesIds));
        }
        return removed;
    }

    public final boolean removeReleases(Collection<scrum.server.release.Release> releases) {
        if (releases == null) return false;
        if (releases.isEmpty()) return false;
        boolean removed = false;
        for (scrum.server.release.Release _element: releases) {
            removed = removed | this.releasesIds.remove(_element);
        }
        if (removed) {
            updateLastModified();
            fireModified("releasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.releasesIds));
        }
        return removed;
    }

    public final boolean clearReleases() {
        if (this.releasesIds.isEmpty()) return false;
        this.releasesIds.clear();
            updateLastModified();
            fireModified("releasesIds", ilarkesto.core.persistance.Persistence.propertyAsString(this.releasesIds));
        return true;
    }

    // -----------------------------------------------------------
    // - published
    // -----------------------------------------------------------

    private boolean published;

    public final boolean isPublished() {
        return published;
    }

    public final void setPublished(boolean published) {
        published = preparePublished(published);
        if (isPublished(published)) return;
        this.published = published;
            updateLastModified();
            fireModified("published", ilarkesto.core.persistance.Persistence.propertyAsString(this.published));
    }

    protected boolean preparePublished(boolean published) {
        return published;
    }

    public final boolean isPublished(boolean published) {
        return this.published == published;
    }

    protected final void updatePublished(Object value) {
        setPublished((Boolean)value);
    }

    public void updateProperties(Map<String, String> properties) {
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            String property = entry.getKey();
            if (property.equals("id")) continue;
            String value = entry.getValue();
            if (property.equals("projectId")) setProjectId(ilarkesto.core.persistance.Persistence.parsePropertyReference(value));
            if (property.equals("number")) setNumber(ilarkesto.core.persistance.Persistence.parsePropertyint(value));
            if (property.equals("authorsIds")) setAuthorsIds(ilarkesto.core.persistance.Persistence.parsePropertyReferenceSet(value));
            if (property.equals("title")) setTitle(ilarkesto.core.persistance.Persistence.parsePropertyString(value));
            if (property.equals("text")) setText(ilarkesto.core.persistance.Persistence.parsePropertyString(value));
            if (property.equals("dateAndTime")) setDateAndTime(ilarkesto.core.persistance.Persistence.parsePropertyDateAndTime(value));
            if (property.equals("releasesIds")) setReleasesIds(ilarkesto.core.persistance.Persistence.parsePropertyReferenceSet(value));
            if (property.equals("published")) setPublished(ilarkesto.core.persistance.Persistence.parsePropertyboolean(value));
        }
    }

    protected void repairDeadReferences(String entityId) {
        super.repairDeadReferences(entityId);
        repairDeadProjectReference(entityId);
        if (this.authorsIds == null) this.authorsIds = new java.util.HashSet<String>();
        repairDeadAuthorReference(entityId);
        if (this.releasesIds == null) this.releasesIds = new java.util.HashSet<String>();
        repairDeadReleaseReference(entityId);
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
        if (this.authorsIds == null) this.authorsIds = new java.util.HashSet<String>();
        Set<String> authors = new HashSet<String>(this.authorsIds);
        for (String entityId : authors) {
            try {
                userDao.getById(entityId);
            } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
                LOG.info("Repairing dead author reference");
                repairDeadAuthorReference(entityId);
            }
        }
        if (this.releasesIds == null) this.releasesIds = new java.util.HashSet<String>();
        Set<String> releases = new HashSet<String>(this.releasesIds);
        for (String entityId : releases) {
            try {
                releaseDao.getById(entityId);
            } catch (ilarkesto.core.persistance.EntityDoesNotExistException ex) {
                LOG.info("Repairing dead release reference");
                repairDeadReleaseReference(entityId);
            }
        }
    }


    // -----------------------------------------------------------
    // - dependencies
    // -----------------------------------------------------------

    static scrum.server.project.ProjectDao projectDao;

    public static final void setProjectDao(scrum.server.project.ProjectDao projectDao) {
        GBlogEntry.projectDao = projectDao;
    }

    static scrum.server.release.ReleaseDao releaseDao;

    public static final void setReleaseDao(scrum.server.release.ReleaseDao releaseDao) {
        GBlogEntry.releaseDao = releaseDao;
    }

    static scrum.server.pr.BlogEntryDao blogEntryDao;

    public static final void setBlogEntryDao(scrum.server.pr.BlogEntryDao blogEntryDao) {
        GBlogEntry.blogEntryDao = blogEntryDao;
    }

}