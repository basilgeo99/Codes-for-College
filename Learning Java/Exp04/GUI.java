/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BASIL.LOE.Exp04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 1761002
 */
public class GUI {

    public GUI() {

        JFrame f = new JFrame("Test GUI");
        final JPanel p = new JPanel();
        
        final JLabel t = new JLabel();

        JButton red = new JButton("Red");

        JButton blue = new JButton("Blue");
        
        p.add(red);
        p.add(blue);
        p.add(t);

        f.setSize(640, 480);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(p);

        red.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                p.setBackground(Color.red);
                t.setText("Color is Red now");
            }
        });

        blue.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                p.setBackground(Color.blue);
                t.setText("Color is Blue now");
            }
        });
    }

    public static void main(String[] args) {
        new GUI();
    }

}
