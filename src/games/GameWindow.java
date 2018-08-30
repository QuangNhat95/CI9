package games;

import inputs.InputManager;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    GameCanvas canvas;

    public GameWindow() {

        //tao su kien trong window
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //Setup di chuyen dung ban phim
        this.addKeyListener(new KeyAdapter() {


            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println("keyPressed");
                InputManager.instance.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //System.out.println("keyReleased");
                InputManager.instance.keyReleased(e);
            }
        });

//Setup games.GameWindow

        this.setSize(600, 800);//Kich thuoc man hinh
        this.setResizable(false);  //Setup ko cho ng dung keo dan man hinh
        this.setTitle("Micro"); //Setup ten cung khung chuong trinh
        //Set up canvas
        canvas = new GameCanvas();

        this.setContentPane(canvas); //gan canvas vao window
        this.setLocationRelativeTo(null); //can chinh khung vao giua
        this.setVisible(true); // khoi tao khung chuong trinh


    }


//Loop for all program

    public void mainLoop() {
        long lastTimeRender = 0;//Thoi gian cuoi cung
        long currentTime=0;//Thoi gian b hien tai
        while (true) {
            currentTime = System.nanoTime();//1/60s equal 17 minisecon
            if (currentTime - lastTimeRender >= 17_000_000) {
                canvas.run();
                canvas.render();

                lastTimeRender = currentTime;
            }


        }

    }


}
