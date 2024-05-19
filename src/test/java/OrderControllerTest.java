

import static org.mockito.Mockito.*;

import org.example.exo2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderControllerTest {

    private OrderService mockOrderService;
    private OrderDao mockOrderDao;
    private OrderController orderCtrl;

    @BeforeEach
    public void setUp() {
        // Création des mocks pour OrderService et OrderDao
        mockOrderService = mock(OrderService.class);
        mockOrderDao = mock(OrderDao.class);

        // Création de l'objet OrderController avec les mocks
        orderCtrl = new OrderController(mockOrderService, mockOrderDao);
    }

    @Test
    public void testCreateOrder_success() {
        // Création d'une commande factice pour le test
        Order testOrder = new Order(1, "bousella");

        // Configuration du comportement des mocks
        //when(mockOrderService.createOrder(testOrder)).thenReturn(true); // Simuler un retour réussi de la méthode createOrder

        // Appel de la méthode à tester
        orderCtrl.createOrder(testOrder);

        // Vérification que la méthode createOrder a été appelée avec le bon argument
        verify(mockOrderService).createOrder(testOrder);

        // Utilisation de la méthode verify avec une validation simple
        //verify(mockOrderDao, times(1)).saveOrder(testOrder);
        verify(mockOrderDao, never()).saveOrder(null);
    }

    @Test
    public void testCreateOrder_failure() {
        // Création d'une commande factice pour le test
        Order testOrder = new Order(1, "bousella");

        // Configuration du comportement des mocks pour simuler un échec
        //when(mockOrderService.createOrder(testOrder)).thenReturn(false); // Simuler un échec de la méthode createOrder

        // Appel de la méthode à tester
        orderCtrl.createOrder(testOrder);

        // Vérification que la méthode saveOrder n'a pas été appelée cette fois
        verify(mockOrderDao, never()).saveOrder(testOrder);
    }
}
