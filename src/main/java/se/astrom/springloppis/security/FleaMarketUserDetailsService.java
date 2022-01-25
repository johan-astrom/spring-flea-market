package se.astrom.springloppis.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.astrom.springloppis.entity.UserEntity;
import se.astrom.springloppis.repository.UserRepository;

@Service
public class FleaMarketUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public FleaMarketUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null){
            throw new UsernameNotFoundException("Can't find user with username " + username);
        }
        return new FleaMarketUserPrincipal(userEntity);
    }
}
