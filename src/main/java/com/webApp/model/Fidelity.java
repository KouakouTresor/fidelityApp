package com.webApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.io.Serializable;

@Document
@NoArgsConstructor
@Data
public class Fidelity implements Serializable {
    @Serial
    private static final long serialVersionUID = -7003022118077818002L;

    @Field("points")
    private int points;
    @Field("lastshop")
    private String lastshop;
}
