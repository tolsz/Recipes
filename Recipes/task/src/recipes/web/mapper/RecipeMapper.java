package recipes.web.mapper;

import org.springframework.stereotype.Component;
import recipes.entities.Recipe;
import recipes.entities.User;
import recipes.web.dto.RecipeDto;

/**
 * Manually implemented entity <-> dto mapper.
 */
@Component
public class RecipeMapper {

    public RecipeDto toDto(Recipe recipe) {
        return new RecipeDto(recipe.getName(), recipe.getCategory(), recipe.getDateTime(),
                recipe.getDescription(), recipe.getIngredients(), recipe.getDirections());
    }

    public Recipe toEntity(RecipeDto recipeDto, User user) {
        return new Recipe().setName(recipeDto.name())
                .setCategory(recipeDto.category())
                .setDescription(recipeDto.description())
                .setIngredients(recipeDto.ingredients())
                .setDirections(recipeDto.directions())
                .setCreator(user);
    }
}
