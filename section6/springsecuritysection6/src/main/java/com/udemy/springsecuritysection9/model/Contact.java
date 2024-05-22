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
@Table(name = "contact_messages")
public class Contact implements Serializable {

  @Serial
  private static final long serialVersionUID = 6089247439847277893L;

  @Id
  @Column(name = "contact_id")
  private String contactId;

  @Column(name = "contact_name")
  private String contactName;

  @Column(name = "contact_email")
  private String contactEmail;

  @Column(name = "subject")
  private String subject;

  @Column(name = "message")
  private String message;

  @JsonSerialize(using = LocalDateSerializer.class)
  @Column(name = "create_dt")
  private LocalDate createDt;

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Contact contact)) {
      return false;
    }
    return Objects.equals(contactId, contact.contactId) && Objects.equals(
        contactName, contact.contactName) && Objects.equals(contactEmail,
        contact.contactEmail) && Objects.equals(subject, contact.subject)
        && Objects.equals(message, contact.message) && Objects.equals(createDt,
        contact.createDt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactId, contactName, contactEmail, subject, message, createDt);
  }
}
