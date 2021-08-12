package com.slasher.slasherproductions.entiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "registers_to_ph")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class RegisterToPH {

    @EmbeddedId
    private RegisterToPHFK idRegistersToPH;

    private LocalDateTime date;

}
