package com.udemy.springsecuritysection8.model;

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
@Table(name="loans")
public class Loans implements Serializable {

	@Serial
	private static final long serialVersionUID = -431402114681737731L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_number")
	private Integer loanNumber;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "start_dt")
	private LocalDate startDt;

	@Column(name = "loan_type")
	private String loanType;

	@Column(name = "total_loan")
	private Integer totalLoan;

	@Column(name = "amount_paid")
	private Integer amountPaid;

	@Column(name = "outstanding_amount")
	private Integer outstandingAmount;

	@JsonSerialize(using = LocalDateSerializer.class)
	@Column(name = "create_dt")
	private LocalDate createDt;

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof final Loans loans)) {
			return false;
		}
    return loanNumber == loans.loanNumber && customerId == loans.customerId
				&& totalLoan == loans.totalLoan && amountPaid == loans.amountPaid
				&& outstandingAmount == loans.outstandingAmount && Objects.equals(startDt,
				loans.startDt) && Objects.equals(loanType, loans.loanType)
				&& Objects.equals(createDt, loans.createDt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(loanNumber, customerId, startDt, loanType, totalLoan, amountPaid,
				outstandingAmount, createDt);
	}
}