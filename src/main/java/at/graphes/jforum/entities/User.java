package at.graphes.jforum.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "FORUM_USER")
public class User implements Serializable {

    /**
     * Used to specify the user role
     */
    public enum Type {
        USER, ADMINISTRATOR;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    
    @Column(nullable = false)
    private String nickname;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String passHash;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date regDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogDate;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private User.Type type;
    
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "recipient", fetch = FetchType.LAZY)
    private List<PrivateMessage> privateMessages;

    
    public User() {
        super();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassHash() {
        return this.passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public Date getRegDate() {
        return this.regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getLastLogDate() {
        return this.lastLogDate;
    }

    public void setLastLogDate(Date lastLogDate) {
        this.lastLogDate = lastLogDate;
    }
    
    public User.Type getType() {
        return type;
    }
    
    public void setType(User.Type type) {
        this.type = type;
    }

    public List<PrivateMessage> getPrivateMessages() {
        return privateMessages;
    }

    public void setPrivateMessages(List<PrivateMessage> privateMessages) {
        this.privateMessages = privateMessages;
    }
}
