package com.mythical.heroes.game;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Andrei on 3/22/2016.
 */
public class Game extends Canvas implements Runnable {

    private boolean isRunning = false;
    private Thread thread;
    private int fps;

    public Game() {
        new Window(this, fps);
    }

    public void run() {

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(isRunning)
                render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                this.fps = frames;
                System.out.println(frames);
                frames = 0;
            }
        }
        stop();
    }

    public synchronized void start() {

        thread = new Thread(this);
        thread.start();
        this.isRunning = true;
    }
    public synchronized void stop() {

        try{
            thread.join();
            this.isRunning = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void tick() {

    }

    private void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if(bufferStrategy == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.dispose();
        bufferStrategy.show();
    }

    public static void main(String args[]){
        new Game();
    }
}
