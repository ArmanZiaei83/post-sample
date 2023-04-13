package com.example.interviewtask.application.user.use_case;

import com.example.interviewtask.application.user.dto.CreateUserDto;
import com.example.interviewtask.domain.user.Role;
import com.example.interviewtask.domain.user.User;
import com.example.interviewtask.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCase {
    private final UserRepository repository;
    private PasswordEncoder encoder;

    @Autowired
    public CreateUserUseCase(UserRepository repository,
                             PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public String execute(CreateUserDto dto) {
        var user = User.builder()
                .firstname(dto.getFirstName())
                .lastname(dto.getLastName())
                .password(encoder.encode(dto.getPassword()))
                .email(dto.getEmail())
                .isPremium(dto.isPremium())
                .build();
        if (user.isPremium()) user.setRole(Role.PremiumUser);
        else user.setRole(Role.User);

        return repository.save(user);
    }
}
