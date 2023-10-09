package recipes.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * immutable web-layer DTO as carrier for user register requests.
 */
public record UserDto(@NotNull @Pattern(regexp = "\\w+(\\.\\w+){0,2}@\\w+\\.\\w+") String email,
                      @NotBlank @Size(min = 8) String password
) { }
