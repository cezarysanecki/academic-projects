package pl.csanecki.AITSI.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.csanecki.AITSI.entity.User;
import pl.csanecki.AITSI.repository.RoleRepository;
import pl.csanecki.AITSI.repository.UserRepository;
import pl.csanecki.AITSI.service.impl.UserServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {
    @Mock
    private UserRepository mockUserRepository;

    @Mock
    private RoleRepository mockRoleRepository;

    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    private UserService userServiceUnderTest;
    private User user;

    @Before
    public void setUp() {
        initMocks(this);
        userServiceUnderTest = new UserServiceImpl(mockUserRepository, mockRoleRepository, mockBCryptPasswordEncoder);

        user = new User();
        user.setId(1);
        user.setFirstName("Cezary");
        user.setLastName("Sanecki");
        user.setEmail("csanecki@gmail.com");

        Mockito.when(mockUserRepository.save(any())).thenReturn(user);
        Mockito.when(mockUserRepository.findByEmail(anyString())).thenReturn(user);
    }


    @Test
    public void testFindUserByEmail() {
        final String email = "csanecki@gmail.com";
        final User result = userServiceUnderTest.findUserByEmail(email);

        assertEquals(email, result.getEmail());
    }

    @Test
    public void testSaveUser() {
        final String email = "csanecki@gmail.com";

        User result = userServiceUnderTest.saveUser(user);

        assertEquals(email, result.getEmail());
    }
}
