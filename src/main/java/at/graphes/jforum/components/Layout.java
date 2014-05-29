package at.graphes.jforum.components;

import at.graphes.jforum.services.auth.AuthenticationService;
import org.apache.tapestry5.*;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.*;

/**
 * Layout component for pages of application JForum.
 */
@Import(stylesheet = "context:layout/layout.css")
public class Layout {

    @Inject
    @Property
    AuthenticationService auth;
    
    /**
     * The page title, for the <title> element and the <h1> element.
     */
    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title;

    @Property
    private String pageName;

    @Inject
    private ComponentResources resources;

    @Property
    @Inject
    @Symbol(SymbolConstants.APPLICATION_VERSION)
    private String appVersion;

}
