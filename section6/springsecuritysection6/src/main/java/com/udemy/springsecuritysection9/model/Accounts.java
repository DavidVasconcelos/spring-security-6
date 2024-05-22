package com.udemy.springsecuritysection9.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "accounts")
public class Accounts implements Serializable {

  @Serial
  private static final long serialVersionUID = -8733555459758870926L;

  @Id
  @Column(name = "account_number")
  private Integer accountNumber;

  @Column(name = "customer_id")
  private Integer customerId;

  @Column(name = "account_type")
  private String accountType;

  @Column(name = "branch_address")
  private String branchAddress;

  @JsonSerialize(using = LocalDateSerializer.class)
  @Column(name = "create_dt")
  private LocalDate createDt;

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Accounts accounts)) {
      return false;
    }
    return accountNumber == accounts.accountNumber && customerId == accounts.customerId
        && Objects.equals(accountType, accounts.accountType) && Objects.equals(
        branchAddress, accounts.branchAddress) && Objects.equals(createDt,
        accounts.createDt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, customerId, accountType, branchAddress, createDt);
  }
}