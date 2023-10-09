package recipes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipes.entities.User;
import recipes.repository.UserRepository;
import recipes.service.RegisterService;
import recipes.web.exception.UserAlreadyExistsException;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository repository;

    @Autowired
    public RegisterServiceImpl(UserRepository userRepository) {
        this.repository = userRepository;
    }

    /**
     * method receives and saves the User entity with data mapped from the UserDto (name and encrypted password),
     * @param user the prepared User entity to save to the database.
     * @throws UserAlreadyExistsException if user already exists.
     */
    @Override
    public void registerUser(User user) throws UserAlreadyExistsException {
        if (repository.existsByUsername(user.getUsername())) {
            throw new UserAlreadyExistsException();
        }
        repository.save(user);
    }
}