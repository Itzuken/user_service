package com.example.user_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserRequestDTO {

    @NotBlank(message = "Name not null")
    private String name;

    @NotBlank(message = "Email not null")
    @Email(message = "valid Email")
    private String email;

    @NotNull(message = "Age not null")
    @Min(value = 0, message = "Age > 0")
    private Integer age;

    public UserRequestDTO() {}

    public UserRequestDTO(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
