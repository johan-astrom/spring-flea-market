package se.astrom.springloppis.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import se.astrom.springloppis.entity.UserEntity;
import se.astrom.springloppis.repository.UserRepository;

public class FleaMarketUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public FleaMarketUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loudUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null){
            System.out.println("Can't find user with username " + username);
        }
        return new
    }
}
