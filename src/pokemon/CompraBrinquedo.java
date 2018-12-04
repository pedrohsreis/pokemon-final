/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class CompraBrinquedo implements Serializable{
    private float valorTotal;
    private int qtd;
    private int qtdFinal;
    private ArrayList<PokemonBrinquedo> pokemon = new ArrayList<PokemonBrinquedo>();
    ArrayList<CompraBrinquedo> compras = new ArrayList<CompraBrinquedo>();
    
    CompraBrinquedo(ListaBrinquedo lista) throws FileNotFoundException, IOException{
        
        qtdFinal = 0;
        int menu;
        Scanner scan = new Scanner(System.in);
        valorTotal = 0;
        System.out.println("Escolha um pokémon para comprar. (Digite um número negativo para sair do menu de compra)");
        lista.getLista();
        menu = scan.nextInt();
        while(menu >= 0){
            
            
            
            if(menu >= 0){
                System.out.println("Informe a quantidade do pokémon desejado.");
                qtd = scan.nextInt();
                try{
                    if(qtd < 0){
                        throw new ValorInvalidoException();
                    }
                }
                catch(ValorInvalidoException error){
                    error.showMessage();
                }
                qtdFinal+=qtd;
                pokemon.add(lista.getBrinquedo(menu));
                valorTotal += qtd * lista.getBrinquedo(menu).getPrice();
                compras.add(this);
                
                System.out.println("");
                System.out.println("Pokemón selecionado: " + lista.getBrinquedo(menu).getNome());
                System.out.println("Total Parcial: " + valorTotal);
                System.out.println("Quantidade: " + qtd);
                System.out.println("");
                qtd = 0;
            }
            System.out.println("Escolha um pokémon para comprar. (Digite um número negativo para sair do menu de compra)");
            lista.getLista();
            menu = scan.nextInt();
        }
        System.out.println("Compra encerrada. Valor total: " + valorTotal);
        FileOutputStream arquivo = new FileOutputStream("compras.tmp");
        ObjectOutputStream arquivoob = new ObjectOutputStream(arquivo);
        arquivoob.writeObject(compras);
        arquivoob.close();
    }
    public void visualizaUltimaCompra() throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream arquivo = new FileInputStream("compras.tmp");
        ObjectInputStream arquivoob = new ObjectInputStream(arquivo);
        ArrayList<CompraBrinquedo> ultimaVenda = (ArrayList<CompraBrinquedo>) arquivoob.readObject();
        arquivoob.close();
        for(int i = 0; i < ultimaVenda.get(0).getPokemon().size(); i++)
            System.out.println("Pokémon comprado: " + ultimaVenda.get(0).getPokemon().get(i).getNome());
        System.out.println("Quantidade total comprada: " + ultimaVenda.get(0).getQtdFinal());
        System.out.println("Valor do pedido: " + ultimaVenda.get(0).getValorTotal());
        System.out.println("");
        
    }

    /**
     * @return the valorTotal
     */
    public float getValorTotal() {
        return valorTotal;
    }

    /**
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @return the pokemon
     */
    public ArrayList<PokemonBrinquedo> getPokemon() {
        return pokemon;
    }

    /**
     * @return the qtdFinal
     */
    public int getQtdFinal() {
        return qtdFinal;
    }

    /**
     * @return the pokemon
     */

    
}
