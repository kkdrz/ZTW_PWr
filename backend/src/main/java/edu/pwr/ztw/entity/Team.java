package edu.pwr.ztw.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private byte[] avatar;
    @NotBlank
    private String name;
    @ManyToOne
    private User playerOne;
    @ManyToOne
    private User playerTwo;
    @OneToMany
    private Set<Match> matches;
    @ManyToMany
    private Set<Tournament> tournaments;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false,updatable = false)
    private Date createdDate;

    public Team(long id, byte[] avatar, String name, User playerOne, User playerTwo, Set<Match> matches, Set<Tournament> tournaments, Date createdDate) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.matches = matches;
        this.tournaments = tournaments;
        this.createdDate = createdDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(User playerOne) {
        this.playerOne = playerOne;
    }

    public User getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(User playerTwo) {
        this.playerTwo = playerTwo;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @PrePersist
    private void onCreate(){
        this.setCreatedDate(new Timestamp((new Date()).getTime()));
    }
}
