package view;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class InfoButtonCellRenderer implements TableCellRenderer {
    private final JButton button = new JButton();

    public InfoButtonCellRenderer(String text) {
        button.setText(text);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column) {
        return button;
    }
}
