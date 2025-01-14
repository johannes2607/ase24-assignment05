package de.unibayreuth.se.taskboard.business.ports;

import de.unibayreuth.se.taskboard.business.domain.User;
import de.unibayreuth.se.taskboard.business.exceptions.UserNotFoundException;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void clear();
    @NonNull
    User create(@NonNull User user);
    @NonNull
    List<User> getAll();
    @NonNull
    User getById(@NonNull UUID id) throws UserNotFoundException;
}
