package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InfoButton {
    public JButton jb;
    public InfoButton(ActionListener actionListener) {
        jb = new JButton();
        jb.addActionListener(actionListener);
    }
}