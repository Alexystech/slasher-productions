package com.slasher.slasherproductions.entiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artists")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArtist;

    @Column(length = 20)
    private String name;

    @Column(name = "last_name", length = 20)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_instrument_fk", referencedColumnName = "id_instrument", nullable = false, updatable = false)
    @ToString.Exclude
    private Instrument instrument;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "musical_group_fk", referencedColumnName = "id_musical_group", nullable = false, updatable = false)
    @ToString.Exclude
    private MusicalGroup musicalGroup;

}
