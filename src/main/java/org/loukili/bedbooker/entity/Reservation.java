package org.loukili.bedbooker.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
  @SequenceGenerator(name = "reservation_seq")
  @Column(name = "id", nullable = false)
  private Long id;

  @Temporal(TemporalType.DATE)
  @Column(name = "start_date", nullable = false)
  private Date startDate;

  @Temporal(TemporalType.DATE)
  @Column(name = "end_date", nullable = false)
  private Date endDate;

  @Column(name = "created_at", nullable = false)
  private Timestamp createdAt;

  @Column(name = "updated_at", nullable = false)
  private Timestamp updatedAt;

  @Column(name = "is_not_canceled", nullable = false)
  private Boolean isNotCanceled = false;

  @ManyToOne(cascade = CascadeType.DETACH, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne(cascade = CascadeType.DETACH, optional = false)
  @JoinColumn(name = "room_id", nullable = false)
  private Room room;

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Boolean getIsNotCanceled() {
    return isNotCanceled;
  }

  public void setIsNotCanceled(Boolean isNotCanceled) {
    this.isNotCanceled = isNotCanceled;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
