package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InfoButton {
    public JButton jb;
    private int index;

    public InfoButton(ActionListener actionListener) {
        jb = new JButton();
        jb.addActionListener(actionListener);
    }

    public InfoButton() {
        jb = new JButton();
    }

    public void setActionListener (ActionListener actionListener) {
        jb.addActionListener(actionListener);
    }
}