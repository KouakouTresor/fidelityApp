package com.webApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clients implements Serializable {
    @Serial
    private static final long serialVersionUID = -664869542688675108L;
    @Id
    private String id;
    @Field("code")
    private String code;
    @Field("name")
    private String name;
    @Field("address")
    private String address;
    @Field("telephone")
    private String telephone;
    @Field("email")
    private String email;
    @Field("active")
    private boolean active;
    @Field("creationdate")
    private Date creationdate = new Date();
    @Field("fidelity")
    private Fidelity fidelity;


}
