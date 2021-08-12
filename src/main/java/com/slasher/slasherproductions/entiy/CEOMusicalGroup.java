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
@Table(name = "ceo_musical_groups")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class CEOMusicalGroup {

    @Id
    @Column(name = "id_ceo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCEO;

    @Column(length = 20)
    private String name;

    @Column(name = "last_name", length = 20)
    private String lastName;

    @Column(length = 50)
    private String email;

    @Column(length = 10)
    private String cellphone;

}
