package de.unibayreuth.se.taskboard.business.impl;

import de.unibayreuth.se.taskboard.business.domain.User;
import de.unibayreuth.se.taskboard.business.exceptions.UserNotFoundException;
import de.unibayreuth.se.taskboard.business.ports.UserPersistenceService;
import de.unibayreuth.se.taskboard.business.ports.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserPersistenceService userPersistenceService;

    @Override
    public void clear() {
        userPersistenceService.clear();
    }

    @Override
    public User create(User user) {
        return userPersistenceService.upsert(user);
    }

    @Override
    public List<User> getAll() {
        return userPersistenceService.getAll();
    }

    @Override
    public User getById(UUID id) throws UserNotFoundException {
        if (userPersistenceService.getById(id).isPresent())
            return userPersistenceService.getById(id).get();
        throw new UserNotFoundException("User with ID " + id + "does not exist!");
    }
}
