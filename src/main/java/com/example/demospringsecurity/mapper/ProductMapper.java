package com.example.demospringsecurity.mapper;

import com.example.demospringsecurity.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {

    List<Product> selectAll();

    Product select(Long id);

    int insert(Product product);

    Long update(Product product);

    Long delete(Long id);


}
