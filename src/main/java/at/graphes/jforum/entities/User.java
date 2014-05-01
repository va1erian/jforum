package at.graphes.jforum.entities;

import java.io.Serializable;
import java.util.Date;

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
    private String nickname;
    private String email;
    private String passHash;
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogDate;
    @Enumerated(EnumType.STRING)
    private User.Type type;
    private static final long serialVersionUID = 1L;

    public User() {
        super();
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


}
