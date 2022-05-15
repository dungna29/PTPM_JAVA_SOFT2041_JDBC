/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ViewModels.QLProduct;
import java.util.List;

/**
 *
 * @author Phong
 */
public interface IManageProductService {
    
    List<QLProduct> getProducts(int position, int pageSize);
    
    QLProduct getProductById(long id);
    
    QLProduct createNewProduct(QLProduct product);
    
    QLProduct updateProductById(QLProduct product);
    
    long deleteProductById(long id);
    
    long countAllProducts();
}
