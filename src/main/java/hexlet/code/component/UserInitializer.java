package hexlet.code.component;

import hexlet.code.model.User;
import hexlet.code.repository.UserRepository;
import io.sentry.Sentry;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor_ = @__(@Autowired))
public class UserInitializer implements ApplicationRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String email = "hexlet@example.com";
        String password = "qwerty";
        User user = new User();
        user.setEmail(email);
        user.setPasswordDigest(passwordEncoder.encode(password));

        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            Sentry.captureException(e);
        }


    }
}
