package com.myfirstproj.demo.hello.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
@Entity(name="user_details")

public class User {
    @NotNull(message="id can't be null")
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;

@JsonProperty("user_name")
@Size(min=2, max =10, message="name should be greater than 2 to 10 chars length")
    private String name;

@Past(message="date can't be a date in the present or future")
    private LocalDate dob;
}
