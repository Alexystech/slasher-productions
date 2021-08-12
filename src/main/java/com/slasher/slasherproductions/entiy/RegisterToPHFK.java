package com.slasher.slasherproductions.entiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class RegisterToPHFK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id_ceo_fk")
    private Long idCEO;

    @Column(name = "id_producer_house_fk")
    private Long idProducerHouse;

}
