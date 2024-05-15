package com.udemy.springsecuritysection6.model;

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
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cards")
public class Cards implements Serializable {

  @Serial
  private static final long serialVersionUID = 2966834034922636357L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "card_id")
  private Integer cardId;

  @Column(name = "customer_id")
  private Integer customerId;

  @Column(name = "card_number")
  private String cardNumber;

  @Column(name = "card_type")
  private String cardType;

  @Column(name = "total_limit")
  private Integer totalLimit;

  @Column(name = "amount_used")
  private Integer amountUsed;

  @Column(name = "available_amount")
  private Integer availableAmount;

  @JsonSerialize(using = LocalDateSerializer.class)
  @Column(name = "create_dt")
  private LocalDate createDt;

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Cards cards)) {
      return false;
    }
    return cardId == cards.cardId && customerId == cards.customerId
        && totalLimit == cards.totalLimit
        && amountUsed == cards.amountUsed && availableAmount == cards.availableAmount
        && Objects.equals(cardNumber, cards.cardNumber) && Objects.equals(
        cardType, cards.cardType) && Objects.equals(createDt, cards.createDt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cardId, customerId, cardNumber, cardType, totalLimit, amountUsed,
        availableAmount, createDt);
  }
}