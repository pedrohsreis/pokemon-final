/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

/**
 *
 * @author Pedro
 */

import java.util.ArrayList;

public class ListaBrinquedo {
    private ArrayList<PokemonBrinquedo> pokemonsBrinquedo;

    public ListaBrinquedo() {
        this.pokemonsBrinquedo = new ArrayList<PokemonBrinquedo>();
    }
    
    public PokemonBrinquedo getBrinquedo(int indice){
        return pokemonsBrinquedo.get(indice);
    }
    public void getLista(){
        for(int i = 0; i < pokemonsBrinquedo.size(); i++){
            System.out.println(i + " - " + pokemonsBrinquedo.get(i).getNome());
        }
    }
    public void addBrinquedo(PokemonBrinquedo pokemon){
        pokemonsBrinquedo.add(pokemon);
    }
    
    
}
