package recipes.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * immutable web-layer DTO as carrier for recipes in REST - endpoints
 */
public record RecipeDto(@NotBlank String name,
                        @NotBlank String category,
                        LocalDateTime date,
                        @NotBlank String description,
                        @NotNull @Size(min = 1) List<String> ingredients,
                        @NotNull @Size(min = 1) List<String> directions
) { }
