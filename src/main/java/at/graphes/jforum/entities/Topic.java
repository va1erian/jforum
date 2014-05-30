/*
 * Copyright (C) 2014 valerian
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package at.graphes.jforum.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 *
 * @author valerian
 */
@Entity
public class Topic extends Message implements Serializable {
    
    @ManyToOne
    @JoinColumn
    private Board board;
    
    private String title;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    @OrderBy("postDate ASC")
    private List<Post> replies;

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the replies
     */
    public List<Post> getReplies() {
        return replies;
    }

    /**
     * @param replies the replies to set
     */
    public void setReplies(List<Post> replies) {
        this.replies = replies;
    }
    
    public int getPostCount() {
        return replies.size();
    }
}
