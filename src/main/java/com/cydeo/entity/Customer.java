package com.cydeo.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer extends BaseEntity{

    private String firstName;
    private String lastName;
    private String userName;
    private String email;

}
