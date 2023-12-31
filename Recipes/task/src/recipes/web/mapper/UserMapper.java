package recipes.web.mapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import recipes.entities.User;
import recipes.web.dto.UserDto;

/**
 * mapper to map received UserDto on register to a User entity, hereby encoding the raw password.
 */
@Component
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * map the Dto to the entity and encode the password hereby.
     */
    public User toEntity(UserDto dto) {
        return new User().setUsername(dto.email())
                .setPassword(passwordEncoder.encode(dto.password()));
    }
}
