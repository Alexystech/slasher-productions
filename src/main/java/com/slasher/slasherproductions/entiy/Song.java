package com.slasher.slasherproductions.entiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "songs")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Song {

    @EmbeddedId
    private SongFK idSong;

    @Column(length = 30)
    private String name;

    private LocalDateTime date;
    private String soundTrack;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_album", referencedColumnName = "id_album", insertable = false, updatable = false)
    @ToString.Exclude
    private Album album;

}
