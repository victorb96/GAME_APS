  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_aps;

import JPlay.GameImage;
import JPlay.Keyboard;
import JPlay.Sound;
import JPlay.Window;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public final class Motor {
    
        
    Window janela; 
    GameImage plano;
    Keyboard teclado;
    Nave navep;
    Nave navei; 
    Sound musica;
    Controlador_Tiros tirop;
    Controlador_Tiros tiroi;
    GameImage lifenp;
    GameImage lifeni;
        
    public Motor(){
        
        IniObjects();
        run();
        
    }
    
    private void IniObjects(){
        janela = new Window(1150, 1100);
        plano = new GameImage("fundo.png");
        teclado = janela.getKeyboard();
        navep = new Nave("NavePrincipal.png");
        navei =  new Nave("NaveInimiga.png");
        musica = new Sound("musica.wav");
        tirop = new Controlador_Tiros();
        tiroi = new Controlador_Tiros();
        lifeni = new GameImage("Lifebarni.png");
        lifenp = new GameImage("Lifebarnp.png");
        lifenp.setPosition(navep.x+550, navep.y-10);
        lifeni.setPosition(navei.x-550, navei.y+10);
        teclado.addKey(KeyEvent.VK_A, Keyboard.DETECT_EVERY_PRESS);
        teclado.addKey(KeyEvent.VK_D, Keyboard.DETECT_EVERY_PRESS);
        teclado.addKey(KeyEvent.VK_SPACE, Keyboard.DETECT_INITIAL_PRESS_ONLY);
        teclado.addKey(KeyEvent.VK_CONTROL, Keyboard.DETECT_INITIAL_PRESS_ONLY);
    }
    
    
    private void run(){
        
        musica.play();
        musica.setRepeat(true);

        
        while(teclado.keyDown(Keyboard.ESCAPE_KEY) == false){
            
            plano.draw();
            lifeni.draw();
            lifenp.draw();
            navep.draw();
            navei.draw();   
            navei.moveX(KeyEvent.VK_A, KeyEvent.VK_D);
            navep.moveX();
            tirop.draw("navep");
            tiroi.draw("navei");
            janela.display(); 
            
            
            if(teclado.keyDown(KeyEvent.VK_CONTROL)){
                
                tirop.addT(navep.x+51, navep.y-10);
                
                
            }else{
                if(teclado.keyDown(KeyEvent.VK_SPACE)){
                    
                    tiroi.addT(navei.x+51, navei.y+100);
              
                }
                
                verificadorDeDano();
            }
            
        }
        System.exit(0);
    }
    
    private void verificadorDeDano(){
        
        if(naveAtaque(navep, tiroi)){
            lifenp.height -= 10;
        }else{
            if(naveAtaque(navei, tirop)){
                lifeni.height -= 10;
            }else{
                if(lifeni.height == 0){
                    JOptionPane.showMessageDialog(null, "Nave Terráquea Venceu!!!");
                    
                    System.exit(0);
                }else{
                    if(lifenp.height == 0){
                        JOptionPane.showMessageDialog(null, "Nave Alien Venceu!!!");
                        
                        System.exit(0);
                    }
                }
            }
        }
        
    }
    
    private boolean naveAtaque(Nave nave, Controlador_Tiros tiroI){
        
        boolean naveDanificada = false;
        
        for(int i=0; i<tiroI.quantidadeTiros(); i++){
            
            Tiro tiro = tiroI.remover();
            
            if(tiro.collided(nave) == false){
                tiroI.addT(tiro);
            }else{
                new Sound("explosão.wav").play();
                naveDanificada = true;
            }
        }
        return naveDanificada;
    }

}
