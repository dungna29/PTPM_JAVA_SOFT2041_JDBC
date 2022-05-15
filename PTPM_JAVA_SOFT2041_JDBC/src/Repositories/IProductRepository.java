/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;


import DomainModels.Product;
import java.util.List;

/**
 *
 * @author Phong
 */
public interface IProductRepository {
    
    List<Product> findAll(int position, int pageSize);
    
    Product findById(long id);
    
    Product save(Product product);
    
    long delete(long id);
    
    long totalCount();
}
