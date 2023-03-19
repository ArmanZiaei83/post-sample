package com.example.interviewtask.application.user.use_cases;

import com.example.interviewtask.application.user.dto.CreateUserDto;
import com.example.interviewtask.application.user.repository.UserRepository;
import com.example.interviewtask.domain.user.Role;
import com.example.interviewtask.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository repository;
    private PasswordEncoder encoder;

    @Autowired
    public CreateUserUseCaseImpl(UserRepository repository,
                                 PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public Integer execute(CreateUserDto dto) {
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
