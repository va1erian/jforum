package at.graphes.jforum.pages;

import at.graphes.jforum.dao.BoardDAO;
import at.graphes.jforum.entities.Board;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 * Start page of application JForum.
 */
public class Index {

    @Inject
    BoardDAO boardDAO;
    
    @Property
    Board board;
    
    public List<Board> getBoards() {
        return boardDAO.findAll();
    }
    
}
