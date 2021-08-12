package com.slasher.slasherproductions.entiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instruments")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Instrument {

    @Id
    @Column(name = "id_instrument")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInstrument;

    @Column(length = 25)
    private String name;

}
