/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import DomainModels.Category;
import DomainModels.Product;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author PTPM
 */
public class ProductRepository implements IProductRepository {

  final String INSERT_SQL = "INSERT INTO [dbo].[Product] ([Name],[Price],[Category_Id])VALUES(?,?,?)";
  final String UPDATE_SQL = "UPDATE [dbo].[Product] SET [Name] = ? WHERE [Id] = ?";
  final String DELETE_SQL = "DELETE FROM [dbo].[Product] WHERE [Id] = ?";
  final String SELECT_BY_SQL = "SELECT * FROM [dbo].[Product] WHERE [Id] = ?";
  final String SELECT_ALL_SQL = "SELECT * FROM [dbo].[Product]";
  private List<Product> _lstProduct;
  private ICategoryRepository _iCategoryRepository;

  public ProductRepository() {
    _lstProduct = new ArrayList<>();
    _iCategoryRepository = new CategoryRepository();
  }

  @Override
  public List<Product> findAll(int position, int pageSize) {
    _lstProduct = new ArrayList<>();
    return getSelectSql(SELECT_ALL_SQL);
  }

  @Override
  public Product findById(long id) {
    Product product;
    product = getSelectSql(SELECT_BY_SQL, id).get(0);
    return product;
  }

  @Override
  public Product save(Product product) {   
    DBConnection.ExcuteDungna(INSERT_SQL, product.getName(),product.getPrice(),product.getCategory().getId());
    return product;
  }

  @Override
  public long delete(long id) {
     DBConnection.ExcuteDungna(DELETE_SQL, id);
    return id;
  }

  @Override
  public long totalCount() {
    long total = 0;
    total = _lstProduct.size();
    return total;
  }

  private List<Product> getSelectSql(String sql, Object... args) {
    try {
      ResultSet rs = DBConnection.getDataFromQuery(sql, args);
      while (rs.next()) {      
        System.out.println(rs.getLong(4));
        _lstProduct.add(new Product(rs.getLong(1), rs.getNString(2), rs.getBigDecimal(3), _iCategoryRepository.getCategoryById(rs.getLong(4))));
      }
      return _lstProduct;
    } catch (SQLException ex) {
      throw new RuntimeException();
    }
  }
}
