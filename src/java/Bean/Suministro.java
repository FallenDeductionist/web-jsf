package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Mario
 */

@ManagedBean(name = "suministro", eager = true)
@RequestScoped

public class Suministro {
    
    private int code;
    private String company;
    private int ruc;
    
    public Suministro(){
        
    }
    
    public Suministro(int code, String company, int ruc){
        
        this.code = code;
        this.company = company;
        this.ruc = ruc;
        
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
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the ruc
     */
    public int getRuc() {
        return ruc;
    }

    /**
     * @param ruc the ruc to set
     */
    public void setRuc(int ruc) {
        this.ruc = ruc;
    }
    
}