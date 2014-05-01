package at.graphes.jforum.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Board
 *
 */
@Entity
public class Board implements Serializable {

	@Id
        @GeneratedValue
        private int id;
	private String name;
	private String description;
        
	@OneToMany(targetEntity = Topic.class, fetch = LAZY, mappedBy="board")
	private List<Topic> topics;
	private static final long serialVersionUID = 1L;

	public Board() {
		super();
	}   

        public Integer getId() {
            return id;
        }
        
        public void setId(Integer id) {
            this.id = id;
        }
        
        public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
        
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public List<Topic> getTopics() {
		return this.topics;
	}

   
}
