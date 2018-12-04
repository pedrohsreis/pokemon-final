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
public class ValorInvalidoException extends RuntimeException{
    public ValorInvalidoException(){
        super("Valor inválido");
    }
    public void showMessage(){
        System.out.println("Valor inválido");
    }
}
