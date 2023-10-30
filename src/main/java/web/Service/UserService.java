package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;
import web.repository.UserRepository;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService{
    private final UserRepository userRepository;

    private static int USERS_COUNT;
    List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++USERS_COUNT, "Malyuta", "Skuratov"));
        users.add(new User(++USERS_COUNT, "Benedict", "Kemberbench"));
        users.add(new User(++USERS_COUNT, "Ignasio", "Iglesias"));
        users.add(new User(++USERS_COUNT, "Wroclaw", "Magdenischwili"));
        users.add(new User(++USERS_COUNT, "Alex", "Petrov"));
    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(int id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElse(null);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update (int id, User updatedUser) {
        updatedUser.setId(id);
        userRepository.save(updatedUser);
    }

    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void addDefaultUsers() {
        userRepository.saveAll(users);
    }
}
