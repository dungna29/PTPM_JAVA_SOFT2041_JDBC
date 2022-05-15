/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import DomainModels.Category;
import Repositories.CategoryRepository;
import Repositories.ICategoryRepository;
import java.util.List;

/**
 *
 * @author Phong
 */
public class ManageCategoryService implements IManageCategoryService {

    private final ICategoryRepository repository;
    
    public ManageCategoryService() {
        repository = new CategoryRepository();
    }
    
    @Override
    public List<Category> getAllCategories() {
        return repository.findAll();
    }
    
}
