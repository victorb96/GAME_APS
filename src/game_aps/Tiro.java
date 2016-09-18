/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_aps;

import JPlay.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Victor
 */
public class Tiro extends Sprite{
    
    
    public Tiro(double x, double y){
        
        super("tiro.png", 7);
        setTimeChangeFrame(10);
        setVelocityY(9);
        
        this.x = x;
        this.y = y;
        
    }
    
    public void MoveT(String atirador){
        
       switch(atirador){
            
            case "navep":
                moveToUp();
                break;
                
            case "navei":
                moveToDown();
                break;
            
            default:
                JOptionPane.showMessageDialog(null, "ERROR");
                break;
        }   
    }
    
}