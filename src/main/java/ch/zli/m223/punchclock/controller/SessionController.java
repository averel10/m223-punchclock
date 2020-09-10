package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.repository.UserRepository;
import ch.zli.m223.punchclock.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class SessionController {
    SessionService sessionService;

    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers(){
        return sessionService.getAllUsers();
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") Long id){
        sessionService.deleteUser(id);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User signUp(@Valid @RequestBody User user) {
        return sessionService.signUp(user);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User updateEntry(@Valid @RequestBody User user) {
        return sessionService.updateUser(user);
    }

}
