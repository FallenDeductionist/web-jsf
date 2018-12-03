package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Mario
 */

@ManagedBean(name = "almacen", eager = true)
@RequestScoped

public class Almacen {
    
    private int code;
    private String district;
    private String responsible;
    
    
    public Almacen(){
        
    }
    
    public Almacen(int code, String district, String responsible){
        
        this.code = code;
        this.district = district;
        this.responsible = responsible;
        
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
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the responsible
     */
    public String getResponsible() {
        return responsible;
    }

    /**
     * @param responsible the responsible to set
     */
    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }
    
    
    
}
