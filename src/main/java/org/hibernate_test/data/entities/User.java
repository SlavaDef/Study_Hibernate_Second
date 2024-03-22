package org.hibernate_test.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

// Благодаря аннотации @Embedded во время сохранения объекта Hibernate поймет,
// что поля класса UserAddress нужно обрабатывать как поля самого класса User.

@Entity
@Data
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    @Access(value = AccessType.FIELD)
    private Long userId;
    @Column(name = "FIRST_NAME")
    private String first_name;
    @Column(name = "LAST_NAME")
    private String last_name;
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthdate;
    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;
    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;
    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_DATE", updatable = false)
    private Date createDate;
    @Column(name = "CREATED_BY", updatable = false)
    private String createdBy;
    @Embedded
    public Accaunts accaunts;
    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE, fetch = FetchType.EAGER) // orphanRemoval = true,
    private List<Address> addressList = new ArrayList<>();

    // cascade = CascadeType.MERGE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


    public User() {
    }

    public User(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public User(String first_name, String last_name, Date birthdate, Date lastUpdatedDate, String lastUpdatedBy, Date createDate, String createdBy) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.birthdate = birthdate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.createDate = createDate;
        this.createdBy = createdBy;
    }
}
