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
@Table(name = "musical_groups")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MusicalGroup {

    @Id
    @Column(name = "id_musical_group")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMusicalGroup;

    @Column(length = 20)
    private String name;

}
