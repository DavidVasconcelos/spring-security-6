package com.udemy.springsecuritysection13.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authorities")
public class Authority implements Serializable {

  @Serial
  private static final long serialVersionUID = -7207797102112336520L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
  @ToString.Exclude
  private Customer customer;

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Authority authority)) {
      return false;
    }
    return Objects.equals(id, authority.id) && Objects.equals(name,
        authority.name) && Objects.equals(customer, authority.customer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, customer);
  }
}