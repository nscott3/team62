package view;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ReviewButtonCellRenderer implements TableCellRenderer {
    private final JButton button = new JButton();
    private final Object[][] contents;

    public ReviewButtonCellRenderer(String text, Object[][] contents) {
        button.setText(text);
        this.contents = contents;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column) {
        if (contents[row][column - 1] == "Accepted") {
            return button;
        } else {
            return null;
        }
    }
}
