/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Pedro
 */
public class PokemonBrinquedo extends Pokemon implements Serializable{
    private float price;
    private String som;


    
    PokemonBrinquedo(float price, String som, ListaBrinquedo lista){
        this.price = price;
        this.som = som;
        lista.addBrinquedo(this);
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the som
     */
    public String getSom() {
        return som;
    }

    /**
     * @param som the som to set
     */
    public void setSom(String som) {
        this.som = som;
    }

}
