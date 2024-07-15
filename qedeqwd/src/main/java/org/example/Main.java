package org.example;// Java program to create three buttons
// with caption OK, SUBMIT, CANCEL
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Main {
    Boolean clicked = false;

    Main()
    {
        JFrame f = new JFrame();
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(1, 12, 400, 800);
        JButton b1 = new JButton("OK");
        f.add(b1);

        // Button 2 created
        // Submit button
        JButton b2 = new JButton("SUBMIT");
        b2.setBounds(160, 375, 80, 50);
        f.add(b2);

        // Button 3 created
        // Cancel button
        JButton b3 = new JButton("CANCEL");
        b3.setBounds(160, 650, 80, 50);
        f.add(b3);

        f.setSize(400, 800);
        f.setLayout(null);
        f.setVisible(true);
    }

    private JButton getjButton(JLayeredPane layeredPane) {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 400, 800);
        // Button 1 created
        // OK button
        JButton b1 = new JButton("OK");
        b1.setBounds(160, 100, 80, 50);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicked = !clicked;
                b1.setText(clicked ? "Clicked" : "OK");
            }

        });
        return b1;
    }

    public static void main(String a[]) { new Main(); }
}
