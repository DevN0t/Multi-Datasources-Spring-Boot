package org.devnot.multidatabase.modules.user.dto;

public record UserDTO(Integer id, String username, String password, Boolean enabled) {
}
