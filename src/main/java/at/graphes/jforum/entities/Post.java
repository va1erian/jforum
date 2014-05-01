package at.graphes.jforum.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * A reply to a topic 
 *
 */
@Entity

public class Post extends Message implements Serializable {

    @ManyToOne
    private Topic parent;
    
   
}
