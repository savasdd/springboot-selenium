package com.selenium.service.impl;

import com.selenium.base.repository.BaseRepository;
import com.selenium.base.service.BaseService;
import com.selenium.dto.ProductDto;
import com.selenium.entity.Product;
import com.selenium.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductServiceImpl extends BaseService<ProductDto, Product> {

    @Autowired
    private ProductRepository repository;

    @Override
    public BaseRepository<Product> getRepository() {
        return repository;
    }

    @Override
    public ProductDto listDto(Product entity) {
        ProductDto dto=new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setCount(entity.getCount());
        dto.setType(entity.getType());
        return dto;
    }

    @Override
    public ProductDto entityToDto(Product entity) {
        ProductDto dto=new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setCount(entity.getCount());
        dto.setType(entity.getType());
        return dto;
    }

    @Override
    public Product dtoToEntity(ProductDto dto) {
        if(dto.getId()!=null){
            var models=this.getRepository().findById(dto.getId());
            var newModel=models.map(val->{
                val.setName(dto.getName());
                val.setCount(dto.getCount());
                val.setPrice(dto.getPrice());
                val.setType(dto.getType());
                return val;
            });

            return newModel.get();
        }

        Product model=new Product();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setPrice(dto.getPrice());
        model.setCount(dto.getCount());
        model.setType(dto.getType());
        model.setVersion(0L);
        return model;
    }

    @Override
    public Page<ProductDto> queryPageble(ProductDto search, Pageable pageable) {
        return null;
    }


}
