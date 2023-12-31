package recipes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.entities.Recipe;
import recipes.repository.RecipeRepository;
import recipes.service.RecipeService;
import recipes.web.exception.NotOwnerException;
import recipes.web.exception.RecipeNotFoundException;

import java.util.List;
import java.util.function.Consumer;

/**
 * service layer class for serving "api/recipe" endpoints
 */
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Recipe getById(long id) throws RecipeNotFoundException {
        return repository.findById(id).orElseThrow(() -> createNotFoundException(id));
    }

    @Override
    public List<Recipe> searchByCategory(String searchText) {
        return repository.findAllByCategoryEqualsIgnoreCaseOrderByDateTimeDesc(searchText);
    }

    @Override
    public List<Recipe> searchByName(String searchText) {
        return repository.findAllByNameContainsIgnoreCaseOrderByDateTimeDesc(searchText);
    }

    @Override
    public Recipe add(Recipe recipe) {
        return repository.save(recipe);
    }

    @Override
    public void delete(long id, String username) throws RecipeNotFoundException, NotOwnerException {
        repository.findById(id)
                .ifPresentOrElse(recipe -> executeIfOwnerOrThrow(recipe, repository::delete, username),
                        () -> { throw createNotFoundException(id); });
    }

    @Override
    public void update(long id, Recipe updateRecipe, String username)
            throws RecipeNotFoundException, NotOwnerException  {
        repository.findById(id)
                .ifPresentOrElse(recipe -> executeIfOwnerOrThrow(recipe, getUpdateAction(updateRecipe), username),
                        () -> { throw createNotFoundException(id); });
    }

    private Consumer<Recipe> getUpdateAction(Recipe updateRecipe) {
        return recipe -> {
            updateRecipe.setId(recipe.getId());
            repository.save(updateRecipe);
        };
    }

    private void executeIfOwnerOrThrow(Recipe recipe, Consumer<Recipe> action, String username)
            throws NotOwnerException {
        if (recipe.getCreator().getUsername().equals(username)) {
            action.accept(recipe);
        } else {
            throw new NotOwnerException();
        }
    }

    private RecipeNotFoundException createNotFoundException(long id) {
        return new RecipeNotFoundException("recipe with id %d not found".formatted(id));
    }
}
