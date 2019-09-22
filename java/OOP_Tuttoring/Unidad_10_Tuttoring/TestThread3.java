/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unidad_10_Tuttoring;

/**
 *
 * @author User
 */
class TestThread3 extends Thread {
public void run(){
System.out.println("Running");
System.out.println("Done");
}
private void xxx(){
System.out.println("In xxx");
}
  public static void main(String args[]){
  TestThread3 ttt = new TestThread3();
  ttt.xxx();
  ttt.start();
  }
}