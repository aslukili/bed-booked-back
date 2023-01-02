package org.loukili.bedbooker.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
  @SequenceGenerator(name = "role_seq")
  @Column(name = "id", nullable = false)
  private Long id;

  @OneToMany(mappedBy = "role", cascade = CascadeType.DETACH, orphanRemoval = true)
  private List<User> users = new ArrayList<>();

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
