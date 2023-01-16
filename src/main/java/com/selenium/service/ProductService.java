package com.selenium.service;

import com.selenium.service.impl.ProductServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductServiceImpl service;
}
