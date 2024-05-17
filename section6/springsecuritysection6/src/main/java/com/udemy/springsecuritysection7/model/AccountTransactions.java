package com.udemy.springsecuritysection7.model;

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
@Table(name = "account_transactions")
public class AccountTransactions implements Serializable {

  @Serial
  private static final long serialVersionUID = -8787795629200080788L;

  @Id
  @Column(name = "transaction_id")
  private String transactionId;

  @Column(name = "account_number")
  private Integer accountNumber;

  @Column(name = "customer_id")
  private Integer customerId;

  @JsonSerialize(using = LocalDateSerializer.class)
  @Column(name = "transaction_dt")
  private LocalDate transactionDt;

  @Column(name = "transaction_summary")
  private String transactionSummary;

  @Column(name = "transaction_type")
  private String transactionType;

  @Column(name = "transaction_amt")
  private Integer transactionAmt;

  @Column(name = "closing_balance")
  private Integer closingBalance;

  @JsonSerialize(using = LocalDateSerializer.class)
  @Column(name = "create_dt")
  private LocalDate createDt;

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final AccountTransactions that)) {
      return false;
    }
    return accountNumber == that.accountNumber && customerId == that.customerId
        && transactionAmt == that.transactionAmt && closingBalance == that.closingBalance
        && Objects.equals(transactionId, that.transactionId) && Objects.equals(
        transactionDt, that.transactionDt) && Objects.equals(transactionSummary,
        that.transactionSummary) && Objects.equals(transactionType, that.transactionType)
        && Objects.equals(createDt, that.createDt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionId, accountNumber, customerId, transactionDt, transactionSummary,
        transactionType, transactionAmt, closingBalance, createDt);
  }
}