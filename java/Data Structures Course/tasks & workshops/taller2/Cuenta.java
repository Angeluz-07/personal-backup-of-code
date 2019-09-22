/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures.taller2;

/**
 *
 * @author User
 */
public class Cuenta {
    float saldo;
    public  Cuenta(){
    }
    public Cuenta(float saldo){
        this.saldo=saldo;
    }
    
    public void ingresar(float c){
        this.saldo+=c;
    }
    public void extraer(float c){
        this.saldo-=c;
    }
    public float getSaldo(){
        return this.saldo;
    }
}
