/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividadeluciano;

import javax.swing.JTextField;
import java.util.logging.Logger;

/**
 *
 * @author silvio Collioni
 */
public class Cronometro implements Runnable {

    private JTextField painelDeContagem;
    private Thread thread;
    
    private boolean stop;
    private int contagem;
    
    public Cronometro(JTextField painelDeContagem) {
        this.painelDeContagem = painelDeContagem;
    }

    public void start() {
        
      
        if (this.thread != null) {
            if (this.thread.isAlive()) {     
                  return;
            }else{
                this.thread = new Thread(this);    
            }
        } else {
            this.thread = new Thread(this);  
        }
        this.stop = false;
        painelDeContagem.setText("0");
        this.thread.start();
    }

    public void stop() {
        this.stop = true;
        this.contagem = Integer.parseInt(painelDeContagem.getText());
    }

    public int getContagem() {
        return this.contagem;
    }

    @Override
    public void run() {
        int i = Integer.parseInt(painelDeContagem.getText());
        while (!this.stop) {
            painelDeContagem.setText(Integer.toString(i));
            i++;
            if (i == 20) {
                i = 0;
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
        }
    }

}
