package org.hibernate_test.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;


// Благодаря аннотации @Embedded во время сохранения объекта Hibernate поймет,
// что поля класса UserAddress нужно обрабатывать как поля самого класса User.
@Data
@Embeddable
public class Accaunts {

    @Column(length = 50)
    private String firstAcaunt;
    @Column(length = 50)
    private String SecondAcaunt;

    public Accaunts(String firstAcaunt, String secondAcaunt) {
        this.firstAcaunt = firstAcaunt;
        SecondAcaunt = secondAcaunt;
    }

    public Accaunts() {
    }
}

//  user.setAccaunts(new Accaunts("first", "second"));
//        dto.updateUser(user);


