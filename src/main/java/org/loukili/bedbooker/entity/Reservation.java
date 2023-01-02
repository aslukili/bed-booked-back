package org.loukili.bedbooker.entity;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
  @SequenceGenerator(name = "reservation_seq")
  @Column(name = "id", nullable = false)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
