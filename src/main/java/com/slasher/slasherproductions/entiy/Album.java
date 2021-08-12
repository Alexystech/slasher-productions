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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "albums")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Album {

    @Id
    @Column(name = "id_album")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlbum;

    @Column(length = 20)
    private String name;

    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "id_ceo_fk", referencedColumnName = "id_ceo_fk", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "id_producer_house_fk", referencedColumnName = "id_producer_house_fk", nullable = false, insertable = false, updatable = false)
    })
    @ToString.Exclude
    private RegisterToPH registerToPH;

}
