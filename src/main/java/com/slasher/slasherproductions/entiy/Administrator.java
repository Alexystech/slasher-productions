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
@Table(name = "administrators")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdministrator;

    @Column(name = "user_name", length = 20)
    private String userName;

    private String password;

    @Column(length = 50)
    private String email;

    @Column(length = 20)
    private String name;

    @Column(name = "last_name", length = 20)
    private String lastName;

    private Byte age;

}
