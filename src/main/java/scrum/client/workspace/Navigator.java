package scrum.client.workspace;

import ilarkesto.core.base.Str;
import ilarkesto.core.scope.Scope;
import ilarkesto.gwt.client.AGwtEntity;

import java.util.Map;

import scrum.client.ScrumGwt;
import scrum.client.ScrumScopeManager;
import scrum.client.admin.User;
import scrum.client.collaboration.ForumSupport;
import scrum.client.communication.TouchLastActivityServiceCall;
import scrum.client.core.ApplicationStartedEvent;
import scrum.client.core.ApplicationStartedHandler;
import scrum.client.project.Project;
import scrum.client.project.ProjectDataReceivedEvent;
import scrum.client.project.SelectProjectServiceCall;
import scrum.client.workspace.history.HistoryToken;
import scrum.client.workspace.history.HistoryTokenObserver;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Widget;

public class Navigator extends GNavigator implements BlockExpandedHandler, ApplicationStartedHandler,
		HistoryTokenObserver {

	public static enum Mode {
		USER, PROJECT
	}

	private HistoryToken historyToken;
	private String page = "Dashboard";

	private Mode currentMode;
	private boolean toggleMode;

	@Override
	public void initialize() {
		historyToken = new HistoryToken(this);
		History.addValueChangeHandler(new ValueChangeHandler<String>() {

			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				evalHistoryToken(event.getValue());
			}
		});
	}

	@Override
	public void onProjectChanged() {}

	@Override
	public void onPageChanged() {}

	@Override
	public void onEntityChanged() {}

	private void evalHistoryToken(String token) {
		log.info("evaluating history token:", token);

		Map<String, String> tokens = HistoryToken.parseHistoryToken(token);

		onHistoryToken(tokens);
	}

	private void onHistoryToken(final Map<String, String> tokens) {

		if (tokens.containsKey("projectSelector")) {
			gotoProjectSelector();
			return;
		}

		String projectId = tokens.get("project");
		if (projectId == null) {
			gotoProjectSelector();
			return;
		}

		toggleMode = Str.isTrue(tokens.get("toggle"));
		gotoProject(projectId, tokens.get("page"), tokens.get("entity"));
	}

	@Override
	public void onApplicationStarted(ApplicationStartedEvent event) {
		String historyToken = History.getToken();
		if (historyToken.contains("project=")) {
			evalHistoryToken(historyToken);
		} else {
			gotoUsersStart();
		}
	}

	private void gotoUsersStart() {
		User user = auth.getUser();
		Project project = user.getCurrentProject();
		if (project == null || user.isAdmin()) {
			gotoProjectSelector();
		} else {
			gotoProject(project.getId());
		}
	}

	public void gotoProjectSelector() {
		History.newItem("projectSelector", false);
		activateUserMode();
	}

	public void gotoProject(String projectId) {
		gotoProject(projectId, null, null);
	}

	private void gotoProject(String projectId, String page, String entityId) {
		new TouchLastActivityServiceCall().execute();

		Project project = Scope.get().getComponent(Project.class);
		if (project != null && !projectId.equals(project.getId())) {
			project = null;
		}

		if (project == null) {
			project = dao.getProject(projectId);
			if (project == null) throw new RuntimeException("Project does not exist: " + projectId);
			acitvateProjectMode(project, page, entityId);
			return;
		}

		ProjectWorkspaceWidgets workspace = Scope.get().getComponent(ProjectWorkspaceWidgets.class);
		if (page != null && !page.equals(this.page)) {
			this.page = page;
			workspace.showPage(page);
		}

		if (entityId != null) {
			if (ScrumGwt.isEntityReferenceOrWikiPage(entityId)) {
				workspace.showEntityByReference(entityId);
			} else {
				if ("Forum".equals(this.page)) {
					ForumSupport entity = (ForumSupport) dao.getEntity(entityId);
					workspace.showForum(entity);
				} else {
					workspace.showEntityById(entityId);
				}
			}
		}

		String token = "project=" + projectId;
		if (page != null) token += "|page=" + page;
		if (entityId != null) token += "|entity=" + entityId;
		History.newItem(token, false);
	}

	public void gotoEntity(String entityId) {
		Project project = Scope.get().getComponent(Project.class);
		gotoEntity(project.getId(), entityId);
	}

	public void gotoEntity(String projectId, String entityId) {
		gotoProject(projectId, null, entityId);
	}

	public void setPage(String page) {
		this.page = page;
	}

	private void setToken(AGwtEntity entity) {
		Project project = Scope.get().getComponent(Project.class);
		if (project == null) return;
		History.newItem("project=" + project.getId() + "|page=" + page + "|entity=" + entity.getId(), false);
	}

	@Override
	public void onBlockExpanded(BlockExpandedEvent event) {
		Object object = event.getObject();
		if (object instanceof AGwtEntity) {
			setToken((AGwtEntity) object);
		}
	}

	private void activateUserMode() {
		if (currentMode == Mode.PROJECT) {
			ScrumScopeManager.destroyProjectScope();
		}

		log.info("Activating USER mode");
		Scope.get().getComponent(UsersWorkspaceWidgets.class).activate();
		currentMode = Mode.USER;
	}

	private void acitvateProjectMode(final Project project, final String page, final String entityId) {
		assert project != null;

		if (currentMode == Mode.PROJECT) {
			if (project.equals(Scope.get().getComponent(Project.class))) return;
			ScrumScopeManager.destroyProjectScope();
		}

		log.info("Activating PROJECT mode");
		Scope.get().getComponent(Ui.class).lock("Loading " + project.getLabel() + "...");
		new SelectProjectServiceCall(project.getId()).execute(new Runnable() {

			@Override
			public void run() {
				ScrumScopeManager.createProjectScope(project);
				currentMode = Mode.PROJECT;
				new ProjectDataReceivedEvent().fireInCurrentScope();
				ProjectWorkspaceWidgets projectWorkspaceWidgets = Scope.get().getComponent(
					ProjectWorkspaceWidgets.class);
				projectWorkspaceWidgets.activate();
				if (page != null) {
					projectWorkspaceWidgets.showPage(page);
				} else {
					projectWorkspaceWidgets.showDashboard();
					setToken(project);
				}
				if (entityId != null) {
					gotoEntity(entityId);
				}
			}
		});
	}

	public static String getPageHref(String page) {
		StringBuilder sb = new StringBuilder();
		sb.append("#");
		Project project = Scope.get().getComponent(Project.class);
		if (project != null) sb.append("project=").append(project.getId()).append("|");
		sb.append("page=").append(page);
		return sb.toString();
	}

	public static String getPageHref(Class<? extends Widget> pageClass) {
		return getPageHref(Page.getPageName(pageClass));
	}

	public static String getEntityHref(AGwtEntity entity) {
		return getEntityHref(entity.getId());
	}

	public boolean isToggleMode() {
		return toggleMode;
	}

	public static String getEntityHref(String entityId) {
		StringBuilder sb = new StringBuilder();
		sb.append("#");

		Project project = Scope.get().getComponent(Project.class);
		if (project != null) sb.append("project=").append(project.getId()).append("|");

		Navigator navigator = Scope.get().getComponent(Navigator.class);
		if (navigator != null && navigator.page != null) sb.append("page=").append(navigator.page).append("|");

		sb.append("entity=").append(entityId);
		return sb.toString();
	}

}