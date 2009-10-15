package scrum.server.css;

import ilarkesto.ui.web.CssRenderer;

public class ScreenCssBuilder implements CssBuilder {

	// http://www.colorcombos.com/color-scheme-203.html

	String cBackground = "#E9EEF6";

	String cHeaderBackground = "#667B99";
	String cHeaderLink = "#D6E4E1";

	String cLink = "#2956B2";
	String cErrorBackground = "#FEE";
	String cError = "darkred";
	String cHeaderText = "white";

	String cNavigatorSeparator = "#D9DEE6";
	String cNavigatorLink = "#465B79";
	String cNavigatorHoverItemBackground = "#CCD5E6";
	String cNavigatorSelectedItemBackground = "#AFBBD2";

	String cBlockTitleBackground = cBackground;
	String cBlockTitleBackgroundGreen = "#CEFDC5";
	String cBlockTitleBackgroundRed = "#FDCEC5";
	String cBlockTitleBackgroundGrey = "#DEDEDE";

	String cToolbarBackground = cNavigatorHoverItemBackground;

	String cTrashBackground = "#F2F5FE";
	String cChatBackground = cTrashBackground;

	String cPagePanelHeaderBackground = "#FFF7F0";
	String cPagePanelHeader = "#FF6637";
	String cPagePanelBorder = cNavigatorSeparator;

	String cFieldBackground = "#FAFDFF";

	String cWaitBackground = cFieldBackground;
	String cWait = cLink;

	public void buildCss(CssRenderer css) {
		css.body().background(cBackground);

		css.style(".gwt-Hyperlink a").color(cLink);

		css.style(".BugMarker").borderSolid(1, cError).background(cErrorBackground).color(cError);

		css.style(".Workspace-header").background(cHeaderBackground);

		css.style(".HeaderWidget-title").color(cHeaderText);
		css.style(".HeaderWidget-user").color(cHeaderText);
		css.style(".HeaderWidget .ToolbarWidget").background("none");
		css.style(".HeaderWidget .gwt-Hyperlink a").color(cHeaderLink);

		css.style(".NavigatorWidget-head").borderBottom(1, "solid", cNavigatorSeparator);
		css.style(".NavigatorWidget .item a").borderBottom(1, "solid", cNavigatorSeparator).color(cNavigatorLink);
		css.style(".NavigatorWidget .item a:hover").background(cNavigatorHoverItemBackground);
		css.style(".NavigatorWidget .selected .item a").background(cNavigatorSelectedItemBackground);

		css.style(".TrashWidget").background(cTrashBackground);

		css.style(".ChatWidget-outputScroller").background(cChatBackground);
		css.style(".ChatWidget-output .author").color("green");
		css.style(".ChatWidget-output .author-system").color("red");
		css.style(".ChatWidget-output .author-me").color("gray");

		css.style(".CommentWidget-header-date").color("#333");

		css.style(".PagePanel-header").background(cPagePanelHeaderBackground).color(cPagePanelHeader);
		css.style(".PagePanel-content").background("white").border(1, "solid", cPagePanelBorder);

		css.style(".Workspace-body-west .PagePanel-header").background(cBackground).color(cHeaderText);
		css.style(".Workspace-body-west .PagePanel-content").background(cBackground).border("0");

		css.style(".ToolbarWidget").background(cToolbarBackground);

		css.style(".BlockDndMarkerWidget-active").background(cHeaderBackground);

		css.style(".ABlockWidget-block").background("white");
		css.style(".ABlockWidget-block-selected").border("0");
		css.style(".ABlockWidget-title").background(cBlockTitleBackground);
		css.style(".ABlockWidget-content-expanded").border(1, "solid", cBlockTitleBackground);

		css.style(".RequirementBlock-closed .ABlockWidget-title").background(cBlockTitleBackgroundGreen);
		css.style(".RequirementBlock-inCurrentSprint .ABlockWidget-title").background(cBlockTitleBackgroundRed);
		css.style(".RequirementBlock-invalidForSprint .ABlockWidget-title").background(cBlockTitleBackgroundGrey);

		css.style(".TaskBlock-taskClosed .ABlockWidget-title").background(cBlockTitleBackgroundGreen);

		css.style(".RequirementInSprintBlock-done .ABlockWidget-title").background(cBlockTitleBackgroundGreen);
		css.style(".TaskInRequirementBlock-taskClosed .ABlockWidget-title").background(cBlockTitleBackgroundGreen);

		css.style(".ImpedimentBlock-open .ABlockWidget-title").background(cBlockTitleBackgroundRed);
		css.style(".ImpedimentBlock-closed .ABlockWidget-title").background(cBlockTitleBackgroundGrey);

		css.style(".WhiteboardWidget-columnLabel").background(cPagePanelHeaderBackground).color(cPagePanelHeader);
		css.style(".WhiteboardWidget-open .ABlockWidget-title").background(cBlockTitleBackgroundRed);
		css.style(".WhiteboardWidget-owned .ABlockWidget-title ").background(cBlockTitleBackgroundGrey);
		css.style(".WhiteboardWidget-done .ABlockWidget-title").background(cBlockTitleBackgroundGreen);

		css.style(".fieldLabel").color(cHeaderBackground);
		css.style(".AFieldValueWidget").background("white").border(1, "dotted", "white");
		css.style(".FieldsWidget-fieldLabel").color(cHeaderBackground);

		css.style(".AViewEditWidget-viewer").background(cFieldBackground).border(1, "dotted",
			cNavigatorSelectedItemBackground);

		css.style(".dnd-drop-allowed").background(cHeaderBackground);

		css.style(".WidgetsTesterWidget .test-content").background("white").color("black").border(1, "solid", "#AAA");

		css.style(".highlighted .ABlockWidget-title").border(1, "solid", cError);

		css.style(".WaitWidget").background(cWaitBackground).borderTop(1, "solid", cPagePanelBorder).borderBottom(1,
			"solid", cPagePanelBorder);
		css.style(".LoginWidget-errorMessage").background("#FFEFEF").color("red").border(1, "solid", "red");
	}

}
