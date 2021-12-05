package view;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class RatingPanel extends JPanel {

    private JLabel label = new JLabel();
    private JRadioButton rb1 = new JRadioButton("1");
    private JRadioButton rb2 = new JRadioButton("2");
    private JRadioButton rb3 = new JRadioButton("3");
    private JRadioButton rb4 = new JRadioButton("4");
    private JRadioButton rb5 = new JRadioButton("5");
    private ButtonGroup buttonGroup = new ButtonGroup();

    public RatingPanel(String title, int rating, boolean editable) {
        buttonGroup.add(rb1);
        buttonGroup.add(rb2);
        buttonGroup.add(rb3);
        buttonGroup.add(rb4);
        buttonGroup.add(rb5);

        Enumeration<AbstractButton> enumeration = buttonGroup.getElements();
        while (enumeration.hasMoreElements()) {
            enumeration.nextElement().setEnabled(editable);
        }

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(rb1);
        buttonPanel.add(rb2);
        buttonPanel.add(rb3);
        buttonPanel.add(rb4);
        buttonPanel.add(rb5);

        switch (rating) {
            case 1:
                rb1.setSelected(true);
                break;
            case 2:
                rb2.setSelected(true);
                break;
            case 3:
                rb3.setSelected(true);
                break;
            case 4:
                rb4.setSelected(true);
                break;
            case 5:
                rb5.setSelected(true);
                break;
        }
        label.setText(title);

        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setLayout(new BorderLayout());
        add(label, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    public int getRating() {
        if (rb1.isSelected()) {
            return 1;
        } else if (rb2.isSelected()) {
            return 2;
        } else if (rb3.isSelected()) {
            return 3;
        } else if (rb4.isSelected()) {
            return 4;
        } else if (rb5.isSelected()) {
            return 5;
        } else {
            return 0;
        }
    }

}
