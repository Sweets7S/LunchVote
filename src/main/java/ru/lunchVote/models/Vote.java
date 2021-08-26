package ru.lunchVote.models;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

// Sweets
@Entity
@Table(name = "VOTE")
@ToString
@NoArgsConstructor
public class Vote {

    public static final int START_SEQ = 100000;

    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private int id;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "CAFE_ID")
    private int cafeID;

    @Column(name = "TIME_VOTE")
    private LocalDateTime timeVote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCafeID() {
        return cafeID;
    }

    public void setCafeID(int cafeID) {
        this.cafeID = cafeID;
    }

    public LocalDateTime getTimeVote() {
        return timeVote;
    }

    public void setTimeVote(LocalDateTime timeVote) {
        this.timeVote = timeVote;
    }
}
