package com.mythical.heroes.game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Andrei on 3/22/2016.
 */
public class Window extends Canvas {

    public Window(Game game, int fps){

        JFrame frame = new JFrame("Mythical Heroes - FPS:"+fps);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(new Dimension((int)screenSize.getWidth(), (int)screenSize.getHeight()));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}
