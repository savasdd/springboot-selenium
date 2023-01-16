package com.selenium.base.controller;

import com.selenium.base.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

public abstract class BaseController<D,E> {

    public abstract BaseService<D,E> getService();

    @GetMapping("/{id}")
    public D findById(@PathVariable("id") String id){
        return this.getService().findById(id);
    }

    @GetMapping
    public Page<D> findAllPageable(Pageable pageable){
        return this.getService().findAllPageable(pageable);
    }

    @GetMapping("/all")
    public List<D> findAll(){
        return this.getService().findAll();
    }

    @Transactional
    @PostMapping
    public D saveOrUpdate(@RequestBody @Validated D dto){
        return this.getService().saveOrUpdate(dto);
    }

    @DeleteMapping("/{id}")
    public D deleteById(@PathVariable("id") String id){
        return this.getService().deleteById(id);
    }

    @GetMapping("/query")
    public Page<D> queryPageble(@RequestBody D search,Pageable pageable){
        return this.getService().queryPageble(search,pageable);
    }



}
