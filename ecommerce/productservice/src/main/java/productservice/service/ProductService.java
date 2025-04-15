package productservice.service;

import productservice.dto.ProductDto;

public interface ProductService {
    ProductDto saveProduct(ProductDto product);
}
