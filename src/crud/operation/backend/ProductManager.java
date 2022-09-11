package crud.operation.backend;

import crud.operation.sql.DBConnection;
import crud.operation.sql.ProductConstants;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jakaza G Chauke
 */
public class ProductManager implements ProductManagement , ProductConstants{
    
    private DBConnection connection;

    @Override
    public void addProduct(String sql, Product product) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(sql);
        statement.setInt(1, product.getProduct_id());
        statement.setString(2, product.getProduct_name());
        statement.setString(3, product.getProduct_code());
        statement.setString(4, product.getProduct_type());
        statement.setString(5, product.getDescription());
        statement.setDouble(6, product.getProduct_price());
        statement.setBoolean(7, product.isStatus());
        statement.executeUpdate();
    }

    @Override
    public void deleteProduct(String sql, Integer product_id) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(sql);
        statement.setInt(1, product_id);
        statement.executeUpdate();
    }

    @Override
    public void updateProduct(String sql, Integer product_id) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(sql);
        statement.setInt(1, product_id);
        statement.executeUpdate();
    }

    @Override
    public void updateProduct(String sql, String product_code) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(sql);
        statement.setString(1, product_code);
        statement.executeUpdate();
    }

    @Override
    public List<Product> getAllProduct(String sql) throws SQLException {
        List<Product> products_list = new ArrayList<>();
        String product_name, product_code, product_type, description;
        Double product_price;
        boolean status;
        int product_id;

        try (PreparedStatement statement = connection.getConnection().prepareStatement(sql)) {
            ResultSet productsSet = statement.executeQuery();
            while(productsSet.next()){
                product_id = productsSet.getInt(ProductConstants.COLUMN_ID);
                product_name = productsSet.getString(ProductConstants.COLUMN_NAME);
                product_code = productsSet.getString(ProductConstants.COLUMN_CODE);
                product_type = productsSet.getString(ProductConstants.COLUMN_TYPE);
                description = productsSet.getString(ProductConstants.COLUMN_DESCRIPTION);
                product_price = productsSet.getDouble(ProductConstants.COLUMN_PRICE);
                status = productsSet.getBoolean(ProductConstants.COLUMN_STATUS);
                
                Product product = new Product(product_name, product_code,product_id, product_price,product_type, description,status);
                products_list.add(product); 
            }
        }
        return products_list;
    }

    @Override
    public Product getProduct(String sql, Integer target_product_id ) throws SQLException {
        Product product = null;
        String product_name, product_code, product_type, description;
        Double product_price;
        boolean status;
        int product_id;
        
        try (PreparedStatement statement = connection.getConnection().prepareStatement(sql)) {
            statement.setInt(1, target_product_id);
            ResultSet productSet = statement.executeQuery();
            
            if(productSet.next()){
                product_id = productSet.getInt(ProductConstants.COLUMN_ID);
                product_name = productSet.getString(ProductConstants.COLUMN_NAME);
                product_code = productSet.getString(ProductConstants.COLUMN_CODE);
                product_type = productSet.getString(ProductConstants.COLUMN_TYPE);
                description = productSet.getString(ProductConstants.COLUMN_DESCRIPTION);
                product_price = productSet.getDouble(ProductConstants.COLUMN_PRICE);
                status = productSet.getBoolean(ProductConstants.COLUMN_STATUS);
                
                product = new Product(product_name, product_code,product_id, product_price,product_type, description,status);     
            }
        }
        
        return product;
    }
    
}
