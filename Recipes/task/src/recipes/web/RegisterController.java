package recipes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipes.service.RegisterService;
import recipes.web.dto.UserDto;
import recipes.web.mapper.UserMapper;
import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/register")
public class RegisterController {

    private final RegisterService service;
    private final UserMapper mapper;

    @Autowired
    public RegisterController(RegisterService service,
                              UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    /**
     * register endpoint - unauthenticated (!).
     * @param userDto dto containing provided user email (=username) and raw password
     * @return empty response 200(OK) on successful register, 400(BadRequest) if dto validation fails or user exists
     */
    @PostMapping
    public ResponseEntity<Void> registerUser(@Valid @RequestBody UserDto userDto) {
        service.registerUser(mapper.toEntity(userDto));
        return ok().build();
    }
}