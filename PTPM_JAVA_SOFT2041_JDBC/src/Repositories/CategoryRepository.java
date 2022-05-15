/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import DomainModels.Category;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author PTPM
 */
public class CategoryRepository implements ICategoryRepository {

  final String INSERT_SQL = "INSERT INTO [dbo].[Category] ([Id],[Name])VALUES(?,?)";
  final String UPDATE_SQL = "UPDATE [dbo].[Category] SET [Name] = ? WHERE [Id] = ?";
  final String DELETE_SQL = "DELETE FROM [dbo].[Category] WHERE [Id] = ?";
  final String SELECT_BY_SQL = "SELECT * FROM [dbo].[Category] WHERE [Id] = ?";
  final String SELECT_ALL_SQL = "SELECT * FROM [dbo].[Category]";  

  public CategoryRepository() {
    
  }

  @Override
  public List<Category> findAll() {
    return getSelectSql(SELECT_ALL_SQL);
  }
   @Override
  public Category getCategoryById(long id) {
    return getSelectSql(SELECT_BY_SQL, id).get(0);
  }

  private List<Category> getSelectSql(String sql, Object... args) {
    try {
      List<Category> lstcategories = new ArrayList<>();
      ResultSet rs = DBConnection.getDataFromQuery(sql, args);
      while (rs.next()) {
        lstcategories.add(new Category(rs.getLong(1), rs.getNString(2)));
      }
      return lstcategories;
    } catch (SQLException ex) {
      throw new RuntimeException();
    }
  }
}
