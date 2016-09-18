/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_aps;

/**
 *
 * @author Victor
 */

import JPlay.*;
import java.util.LinkedList;


public class Controlador_Tiros{
    
    
    LinkedList<Tiro> objeto = new LinkedList<>();
    
    public void addT(double x, double y){
        
        Tiro tiro = new Tiro(x, y);
        new Sound("tiro.wav").play();
        addT(tiro);
       
    }
   
    
    public void addT(Tiro tiro){
        
        objeto.addLast(tiro);
        
    }
    
    public void draw(String atirador){
        
        for(int i=0; i<objeto.size(); i++){
            
            Tiro tiro = objeto.removeFirst();
            tiro.draw();
            tiro.MoveT(atirador);
            objeto.addLast(tiro);
            
        }
    }
    
    public int quantidadeTiros(){
        return objeto.size();
    }
    
    public Tiro remover(){
        return objeto.removeFirst();
    }
}
