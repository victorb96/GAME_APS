/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_aps;


import JPlay.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author Victor
 */
public class Nave extends Sprite{
    
    public Nave(String nave){
        super(nave);
        
        if("NavePrincipal.png".equals(nave)){
            
            //tempo de troca de frames
            setTimeChangeFrame(1);
            //velocidade de locomoção na tela
            setVelocityX(5);
            //Define posição da nave na tela 
            setPosition(575, 600);
            
            
            
        }else{
            
            setTimeChangeFrame(1);
            setVelocityX(5);
            setPosition(575, 25);
            
        }

    }

    
}
