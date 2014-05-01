package at.graphes.jforum.pages.post;

import at.graphes.jforum.dao.PostDAO;
import at.graphes.jforum.entities.Post;
import at.graphes.jforum.pages.Index;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author valerian
 */
public class NewPost {
    
    @Property
    private Post newPost;
    
    @Inject
    private PostDAO postManager;
    
    @InjectPage
    private Index index;
    
    @CommitAfter
    Object onSuccess() {
        postManager.save(newPost);
        
        return index;
    }
}
