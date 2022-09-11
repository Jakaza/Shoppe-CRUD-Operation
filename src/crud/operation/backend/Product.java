package crud.operation.backend;

/**
 *
 * @author Jakaza G Chauke
 */
public class Product {
    private String product_name;
    private String product_code;
    private Integer product_id;
    private double product_price;
    private String product_type;
    private String description;
    private boolean status;
    
    public Product(){
        this.product_name = "No Product Name";
        this.product_code = "0000";
        this.product_id = 000000;
        this.product_price = 0.00;
        this.product_type = "No Product Type";
        this.description = "No Product Description";
        this.status = true;
    }
    
    public Product(String product_name, String product_code,Integer product_id, double product_price){
        this.product_name = product_name;
        this.product_code = product_code;
        this.product_id = product_id;
        this.product_price = product_price;
        this.status = true;
    }

    public Product(String product_name, String product_code, Integer product_id, double product_price, String product_type, String description) {
        this.product_name = product_name;
        this.product_code = product_code;
        this.product_id = product_id;
        this.product_price = product_price;
        this.product_type = product_type;
        this.description = description;
        this.status = true;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{\n" + "product_name: " + product_name + ", product_code: " + product_code + ", product_id: " + product_id + ", product_price: " + product_price + ", product_type: " + product_type + ", description: " + description + ", status: " + status + '}';
    }
    
}
