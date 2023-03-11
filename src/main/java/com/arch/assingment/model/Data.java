package com.arch.assingment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@lombok.Data
public class Data {

    public int id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;
}
