/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;


import DomainModels.Category;
import java.util.List;
/**
 *
 * @author PTPM
 */
public interface ICategoryRepository {
    
    List<Category> findAll();
    Category getCategoryById(long id);
}
