package org.loukili.bedbooker.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
  @SequenceGenerator(name = "user_seq")
  @Column(name = "id", nullable = false)
  private Long id;

  @OneToMany(mappedBy = "user", cascade = CascadeType.DETACH)
  private List<Hotel> hotels = new ArrayList<>();

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @ManyToOne(cascade = CascadeType.DETACH, optional = false)
  @JoinColumn(name = "role_id", nullable = false)
  private Role role;

  @OneToMany(mappedBy = "user", cascade = CascadeType.DETACH)
  private List<Reservation> reservations = new ArrayList<>();

  public List<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public List<Hotel> getHotels() {
    return hotels;
  }

  public void setHotels(List<Hotel> hotels) {
    this.hotels = hotels;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
