package com.example.user_service.assembler;

import com.example.user_service.controllers.UserController;
import com.example.user_service.dto.UserResponseDTO;
import com.example.user_service.models.User;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<User, UserResponseDTO> {

    public UserAssembler() {
        super(UserController.class, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO toModel(User user) {
        UserResponseDTO userResponse = new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAge(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );

        // Добавляем HATEOAS ссылки
        userResponse.add(linkTo(methodOn(UserController.class).getUserById(user.getId())).withSelfRel());
        userResponse.add(linkTo(methodOn(UserController.class).updateUser(user.getId(), null)).withRel("update"));
        userResponse.add(linkTo(methodOn(UserController.class).deleteUser(user.getId())).withRel("delete"));
        userResponse.add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("users"));

        return userResponse;
    }
}