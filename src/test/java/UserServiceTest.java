


import org.example.exo1.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class UserServiceTest {

    @Test
    void testGetUserById() {
        UserRepository mockUserRepo = mock(UserRepository.class);
        UserService userSvc = new UserService(mockUserRepo);

        // Configuration du mock pour retourner un utilisateur spécifique quand findUserById est appelé
        long testUserId = 1;
        User testUser = new User(testUserId, "boussela  abderrahim");
        when(mockUserRepo.findUserById(testUserId)).thenReturn(testUser);

        // Appel de la méthode à tester
        User actualUser = userSvc.getUserById(testUserId);

        // Vérification que le résultat est celui attendu
        assertEquals(testUser, actualUser);

        // Vérification que findUserById est appelé avec le bon argument
        verify(mockUserRepo).findUserById(testUserId);
    }
}
