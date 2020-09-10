package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.exceptions.EntryNotFoundException;
import ch.zli.m223.punchclock.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    UserRepository userRepository;

    public SessionService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User signUp(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntryNotFoundException();
        }
    }

    public User updateUser(User user) {

            if(userRepository.findById(user.getId()).isPresent()) {
                if(user.getPassword() != null){
                    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
                }
                return userRepository.saveAndFlush(user);
            }
            throw new EntryNotFoundException();

    }
}
