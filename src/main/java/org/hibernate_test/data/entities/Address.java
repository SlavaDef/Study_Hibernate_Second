package org.hibernate_test.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phone;

    private String address;

    private String email;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Address() {
    }

    public Address(String phone, String address, String email) {
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

}
