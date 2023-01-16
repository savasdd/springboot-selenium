package com.selenium.base.service;

import com.selenium.base.repository.BaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public abstract class BaseService<D,E> {

    public abstract BaseRepository<E> getRepository();
    public abstract D listDto(E entity);
    public abstract D entityToDto(E entity);
    public abstract E dtoToEntity(D dto);

    //public abstract S seachDto(E entity);


    public D findById(String id){
        E model=this.getRepository().findById(UUID.fromString(id)).orElseThrow(()-> new NotFoundException());
        D dto=entityToDto(model);
        log.info("find by id: "+id);
        return dto;
    }

    public Page<D> findAllPageable(Pageable pageable){
        Page<E> model=this.getRepository().findAll(pageable);
        List<D> list =model.get().map(val->listDto(val)).collect(Collectors.toList());
        Page<D> pages=new PageImpl<D>(list,pageable, model.getTotalElements());
        log.info("find by page");
        return pages;
    }

    public List<D> findAll(){
        List<E> model=this.getRepository().findAll();
        List<D> list= model.stream().map(val->listDto(val)).collect(Collectors.toList());
        log.info("find all: "+list.size());
        return list;
    }

    public D saveOrUpdate(D dto){
        E model=this.getRepository().save(dtoToEntity(dto));
        D newDto=entityToDto(model);
        log.info("save/update: ");
        return newDto;
    }


    public D deleteById(String id){
        D dto=findById(id);
        this.getRepository().deleteById(UUID.fromString(id));
        log.info("delete by id: "+id);
        return dto;
    }

    public abstract Page<D> queryPageble(D search, Pageable pageable);
}
