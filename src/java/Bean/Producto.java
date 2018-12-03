package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Mario
 */

@ManagedBean(name = "producto", eager = true)
@RequestScoped

public class Producto {
    
    private int code;
    private String name;
    private double price;
    private int stock;
    private int warehouse;
    private int supply;

    public Producto(){
        
    }
    
    public Producto(int code, String name, double price, int stock, int warehouse, int supply){
        
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.warehouse = warehouse;
        this.supply = supply;
        
    }
    
    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the warehouse
     */
    public int getWarehouse() {
        return warehouse;
    }

    /**
     * @param warehouse the warehouse to set
     */
    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }

    /**
     * @return the supply
     */
    public int getSupply() {
        return supply;
    }

    /**
     * @param supply the supply to set
     */
    public void setSupply(int supply) {
        this.supply = supply;
    }
    
    
}
