package productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import productservice.dto.ProductDto;
import productservice.entity.Product;
import productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/save")
    public ProductDto save(@RequestBody ProductDto product){
        return productService.saveProduct(product);
    }
}
