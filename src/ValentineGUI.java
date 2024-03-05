import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ValentineGUI extends JFrame {
    private int noCount = 0;
    private JLabel label;
    private JPanel panel;
    private boolean yesPressed = false;

    public ValentineGUI() {
        
        label = new JLabel("Will you be my Valentine?");
        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.add(label, BorderLayout.CENTER);
        panel.add(yesButton);
        panel.add(noButton);
    
        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Valentine's Day");
        setSize(250, 200);
        setVisible(true);

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yesPressed = true;
                label.setText("WOOOOO!!! I LOVE YOU POOKIE!!!");
                yesButton.setVisible(false);
                noButton.setVisible(false);
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noCount++;
                noButton.setText(getNoButtonText());
                checkAndClose();
            }
        });
    }

    private String getNoButtonText() {
        String[] phrases = {
                "No", "Are you sure?", "What if I asked really nicely?", "Pretty please",
                "With a chocolate rice cake on top", "What about a matcha frostie", "PLEASE POOKIE",
                "But :*(", "I am going to die", "Yep im dead", "ok ur talking to lexi's ghost",
                "please babe", ":(((", "PRETTY PLEASE", "Estoy muerto", "No :("
        };

        return phrases[Math.min(noCount, phrases.length - 1)];
    }

    private void checkAndClose() {
        if (noCount >= 15 || yesPressed) {
            dispose(); // Close the window
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        new ValentineGUI();
    }
}

