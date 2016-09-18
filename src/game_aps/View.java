package game_aps;

import JPlay.GameImage;
import JPlay.Keyboard;
import JPlay.Sound;
import JPlay.Window;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victor
 */
public class View {
    
    public void TelaI(){
        
        //Criando janela principal
        Window janela = new Window(800, 600);
        GameImage plano;
        plano = new GameImage("Menu.png");
        //Lendo teclado
        Keyboard teclado = janela.getKeyboard();
        Sound musica = new Sound("metalslug.wav");
        musica.play();
        musica.setRepeat(true);
        boolean executar = true;
        
        while(executar){
            
            plano.draw();
            janela.display();
            //condição para entra no jogo qnd aperta enter
            if(teclado.keyDown(Keyboard.ENTER_KEY)){
                JOptionPane.showMessageDialog(null, "No ano de 2154 onde o planeta terra o qual outrora já foi devastado pelos\n" 
                        +"próprios seres humanos e sua poluição agora prospera e floresce, agora a terra está cada vez mais fértil, as\n" 
                        +"arvores crescem cada vez mais o planeta a cada ano que se passa se torna mais conhecido como “o planeta verde\n”" 
                        +"do que como o “planeta azul”, mas é em tempos de felicidade que o mal nos alcança, então, logo uma outra raça a\n" 
                        +"qual ainda não havíamos conhecido invade o planeta em busca de um lugar para colonizar e é ai que você capitão da\n" 
                        +"nave Viperterra terá de entrar em ação.");
                JOptionPane.showMessageDialog(null, "CONTROLE NAVE ALIEN: A - ESQUERDA, D - DIREITA, ESPAÇO - ATIRA");
                JOptionPane.showMessageDialog(null, "CONTROLE NAVE TERRAQUEA: DIRECIONAIS, CTRL - ATIRA");
                //Motor jogo = new Motor();
                executar = false;
            }else{
                if(teclado.keyDown(Keyboard.ESCAPE_KEY)){
                    executar = false;
                    System.exit(0);
                }
            }
            
        }
        musica.stop();
        Motor jogo = new Motor();
    }
        
        
    
    

    
    
}
