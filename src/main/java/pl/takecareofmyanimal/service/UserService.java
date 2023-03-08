package pl.takecareofmyanimal.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.takecareofmyanimal.model.User;
import pl.takecareofmyanimal.repo.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        existingUser.setUserName(updatedUser.getUserName());
        existingUser.setName(updatedUser.getName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setCity(updatedUser.getCity());
        existingUser.setPhone(updatedUser.getPhone());
        existingUser.setAdverts(updatedUser.getAdverts());

        userRepository.save(existingUser);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
