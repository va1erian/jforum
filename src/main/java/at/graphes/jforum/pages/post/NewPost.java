package at.graphes.jforum.pages.post;

import at.graphes.jforum.entities.Post;
import at.graphes.jforum.entities.Topic;
import at.graphes.jforum.pages.Index;
import at.graphes.jforum.services.auth.AuthenticationService;
import at.graphes.jforum.services.auth.RequiresAuthentication;
import at.graphes.jforum.services.domain.PostDAO;
import java.util.Date;
import org.apache.tapestry5.annotations.ActivationRequestParameter;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author valerian
 */
@RequiresAuthentication
public class NewPost {
    
    @PageActivationContext
    @Property
    private Topic topic;
    
    @Property 
    private String content;
    
    @Inject
    private PostDAO postManager;
    
    @Inject
    private AuthenticationService auth;
    
    @CommitAfter
    Object onSuccess() {
        Post p = new Post();
        p.setParent(topic);
        p.setContent(content);
        p.setAuthor(auth.getLoggedUser());
        p.setPostDate(new Date());
        
        postManager.save(p);
        
        return Index.class;
    }
}
