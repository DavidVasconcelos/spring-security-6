package com.udemy.springsecuritysection6.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "customer")
public class Customer implements Serializable {

  @Serial
  private static final long serialVersionUID = 5053912389361163379L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customer_id", nullable = false)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "mobile_number")
  private String mobileNumber;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Column(name = "pwd")
  private String pwd;

  @Column(name = "role")
  private String role;

  @JsonSerialize(using = LocalDateSerializer.class)
  @Column(name = "create_dt")
  private LocalDate createDt;

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Customer customer)) {
      return false;
    }
    return Objects.equals(id, customer.id) && Objects.equals(name, customer.name)
        && Objects.equals(email, customer.email) && Objects.equals(mobileNumber,
        customer.mobileNumber) && Objects.equals(pwd, customer.pwd)
        && Objects.equals(role, customer.role) && Objects.equals(createDt,
        customer.createDt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, mobileNumber, pwd, role, createDt);
  }
}