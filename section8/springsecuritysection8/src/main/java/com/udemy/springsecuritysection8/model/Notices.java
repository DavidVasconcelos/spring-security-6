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
@Table(name = "notice_details")
public class Notices implements Serializable {

  @Serial
  private static final long serialVersionUID = -6116242750168391223L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "notice_id")
  private Integer noticeId;

  @Column(name = "notice_summary")
  private String noticeSummary;

  @Column(name = "notice_details")
  private String noticeDetails;

  @JsonSerialize(using = LocalDateSerializer.class)
  @Column(name = "notice_beg_dt")
  private LocalDate noticeBegDt;

  @JsonSerialize(using = LocalDateSerializer.class)
  @Column(name = "notice_end_dt")
  private LocalDate noticeEndDt;

  @JsonSerialize(using = LocalDateSerializer.class)
  @Column(name = "create_dt")
  private LocalDate createDt;

  @JsonSerialize(using = LocalDateSerializer.class)
  @Column(name = "update_dt")
  private LocalDate updateDt;

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Notices notices)) {
      return false;
    }
    return noticeId == notices.noticeId && Objects.equals(noticeSummary,
        notices.noticeSummary) && Objects.equals(noticeDetails, notices.noticeDetails)
        && Objects.equals(noticeBegDt, notices.noticeBegDt) && Objects.equals(
        noticeEndDt, notices.noticeEndDt) && Objects.equals(createDt, notices.createDt)
        && Objects.equals(updateDt, notices.updateDt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(noticeId, noticeSummary, noticeDetails, noticeBegDt, noticeEndDt, createDt,
        updateDt);
  }
}