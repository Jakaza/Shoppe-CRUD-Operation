package crud.operation.backend;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Jakaza G Chauke
 */
public interface ProductManagement {
    
    public void addProduct(String sql, Product product)throws SQLException;
    public void deleteProduct(String sql, Integer product_id)throws SQLException;
    public void updateProduct(String sql, Integer product_id) throws SQLException;
    public void updateProduct(String sql, String product_code) throws SQLException;
    public List<Product> getAllProduct(String sql)throws SQLException;
    public Product getProduct(String sql, Integer product_id)throws SQLException;
    
}
