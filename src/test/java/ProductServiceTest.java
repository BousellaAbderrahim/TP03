

import org.example.exo3.ApiCallException;
import org.example.exo3.Product;
import org.example.exo3.ProductApiClient;
import org.example.exo3.ProductService;
import org.junit.jupiter.api.Test;

import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class ProductServiceTest {

    @Test
    public void testRetrieveProduct_successfulRetrieval() {
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        String productId = "product-123";
        when(mockApiClient.getProduct(productId)).thenReturn(new Product(productId));
        ProductService productService = new ProductService(mockApiClient);
        Product retrievedProduct = productService.getProduct(productId);

        verify(mockApiClient).getProduct(productId);
    }

    @Test
    public void testRetrieveProduct_dataFormatException() {
        // Arrange
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        String invalidProductId = "invalid-format";
        when(mockApiClient.getProduct(anyString())).thenThrow(new RuntimeException(new DataFormatException("incompatible data format")));
        ProductService productService = new ProductService(mockApiClient);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> productService.getProduct(invalidProductId));
    }

    @Test
    public void testRetrieveProduct_apiCallFailure() {
        // Arrange
        ProductApiClient mockApiClient = mock(ProductApiClient.class);
        String apiFailureProductId = "api-failure";
        when(mockApiClient.getProduct(anyString())).thenThrow(new RuntimeException(new ApiCallException("API call failure")));
        ProductService productService = new ProductService(mockApiClient);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> productService.getProduct(apiFailureProductId));
    }
}
