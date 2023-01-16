package com.selenium.api;

import com.selenium.base.controller.BaseController;
import com.selenium.base.service.BaseService;
import com.selenium.dto.ProductDto;
import com.selenium.entity.Product;
import com.selenium.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/products")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class ProductController extends BaseController<ProductDto, Product> {

    @Autowired
    private ProductService service;

    @Override
    public BaseService<ProductDto, Product> getService() {
        return service.getService();
    }


    @PostMapping(value = "/test")
    public void test(@RequestBody ProductDto dto){
        System.out.println(dto);
    }
}
