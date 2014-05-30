package at.graphes.jforum.entities;


import java.io.Serializable;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * A reply to a topic 
 *
 */
@Entity

public class Post extends Message implements Serializable {

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn
    private Topic parent;

    public Topic getParent() {
        return parent;
    }

    public void setParent(Topic parent) {
        this.parent = parent;
    }
}
