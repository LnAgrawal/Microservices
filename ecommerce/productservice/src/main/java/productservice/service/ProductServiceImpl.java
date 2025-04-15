package productservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import productservice.dto.Order;
import productservice.dto.ProductDto;
import productservice.entity.Product;
import productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ApiClient apiClient;

    /*@Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }*/

    @Override
    @CircuitBreaker(name = "product-save", fallbackMethod = "fallBackMethodForProduct")
    public ProductDto saveProduct(ProductDto productDto) {

        Product product = new Product();
        product.setName(productDto.getProductName());

        Order objOrder = new Order();
        objOrder.setName(productDto.getOrderName());
        objOrder.setPrice(productDto.getPrice());
        objOrder.setQuantity(productDto.getQuantity());


        Product resProduct = productRepository.save(product);

        //Order resOrder = restTemplate.postForObject("http://localhost:8282/order/save", objOrder, Order.class);
        Order resOrder = apiClient.saveOrder(objOrder);
        ProductDto resProductDto = new ProductDto();
        resProductDto.setProductId(resProduct.getId());
        resProductDto.setProductName(resProduct.getName());
        resProductDto.setOrderId(resOrder.getId());
        resProductDto.setOrderName(resOrder.getName());
        resProductDto.setQuantity(resOrder.getQuantity());
        resProductDto.setPrice(resOrder.getPrice());
        resProductDto.setTansactionId(resOrder.getTransactionId());
        resProductDto.setStatus(resOrder.getStatus());
        return resProductDto;
    }

    public ProductDto fallBackMethodForProduct(ProductDto product, Exception e){
        return new ProductDto(0, product.getProductName(),0, product.getOrderName(), product.getQuantity(),
                product.getPrice(), null, "Product Service is down") ;
    }
}
