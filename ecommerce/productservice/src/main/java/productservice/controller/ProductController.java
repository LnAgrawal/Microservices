package productservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/save")
    public ProductDto save(@RequestBody ProductDto product) throws JsonProcessingException {
        System.out.println("Save product: "+ new ObjectMapper().writeValueAsString(product));
        log.info("Save product: "+ new ObjectMapper().writeValueAsString(product));
        return productService.saveProduct(product);
    }
}
