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
@Table(name = "producer_houses")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ProducerHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducerHouse;

    @Column(length = 30)
    private String name;

}
