package com.slasher.slasherproductions.entiy;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class SongFK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id_author_fk")
    private Long idAuthor;

    @Column(name = "id_musical_group_fk")
    private Long idMusicalGroup;

}
