/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModels.Product;
import Repositories.IProductRepository;
import Repositories.ProductRepository;
import ViewModels.QLProduct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phong
 */
public class ManageProductService implements IManageProductService {

  private final IProductRepository _iProductRepository;
  private List<QLProduct> _lstQlProduct;

  public ManageProductService() {
    _iProductRepository = new ProductRepository();
    _lstQlProduct = new ArrayList<>();
  }

  @Override
  public List<QLProduct> getProducts(int position, int pageSize) {
    _lstQlProduct = new ArrayList<>();
    var product = _iProductRepository.findAll(position, pageSize);
    for (Product x : product) {
      _lstQlProduct.add(new QLProduct(x.getId(), x.getName(), x.getPrice(), x.getCategory()));
    }
    return _lstQlProduct;
  }

  @Override
  public QLProduct getProductById(long id) {
    var x = _iProductRepository.findById(id);
    return new QLProduct(x.getId(), x.getName(), x.getPrice(), x.getCategory());
  }

  @Override
  public QLProduct createNewProduct(QLProduct product) {
    product.setId(null);
    var x = _iProductRepository.save(new Product(product.getId(), product.getName(), product.getPrice(), product.getCategory()));
    return new QLProduct(x.getId(), x.getName(), x.getPrice(), x.getCategory());
  }

  @Override
  public QLProduct updateProductById(QLProduct product) {
      var x = _iProductRepository.save(new Product(product.getId(), product.getName(), product.getPrice(), product.getCategory()));
    return new QLProduct(x.getId(), x.getName(), x.getPrice(), x.getCategory());
  }

  @Override
  public long deleteProductById(long id) {
    return _iProductRepository.delete(id);
  }

  @Override
  public long countAllProducts() {
    return _iProductRepository.totalCount();
  }

}
