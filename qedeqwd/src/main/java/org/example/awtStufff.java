package org.example;

import java.awt.*;

 class awtStufff {



        awtStufff()
        {
            Frame f = new Frame();

            // Button 1 created
            // OK button
            Button b1 = new Button("OK");
            b1.setBounds(160, 100, 80, 50);
            f.add(b1);

            // Button 2 created
            // Submit button
            Button b2 = new Button("SUBMIT");
            b2.setBounds(160, 375, 80, 50);
            f.add(b2);

            // Button 3 created
            // Cancel button
            Button b3 = new Button("CANCEL");
            b3.setBounds(160, 650, 80, 50);
            f.add(b3);

            f.setSize(400, 800);
            f.setLayout(null);
            f.setVisible(true);
        }

        public static void main(String a[]) { new org.example.awtStufff(); }
    }

