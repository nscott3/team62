package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import model.ObjectTableModel;
import model.PropertyGetterSetter;

public class SearchView extends JFrame{
	private JTextField tfLcation;
	private JTextField tfStartDate;
	private JTextField tfEndDate;
	private JTextField tfSearch;
	
    public SearchView() {
    	setResizable(false);
    	setPreferredSize(new Dimension(1200, 720/12*9));
	    setSize(1200, 720/12*9);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HomeBreaks Plc");
		
    	JTable table = new JTable(createObjectDataModel());
    	table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        table.setAutoCreateRowSorter(true);
        table.setLocation(200,300);

        InfoButtonCellRenderer renderer = new InfoButtonCellRenderer("More Information");
        table.getColumn("Specific Information").setCellRenderer(renderer);

        InfoButtonCellEditor editor = new InfoButtonCellEditor();
        table.getColumn("Specific Information").setCellEditor(editor);

        table.addMouseListener(new JTableButtonMouseListener(table));
        
        PaginationDataProvider<PropertyGetterSetter> dataProvider = createDataProvider(this);
        PaginatedTableDecorator<PropertyGetterSetter> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 20);
        getContentPane().add(paginatedDecorator.getContentPanel());
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        

        
        JLabel lblTitle = new JLabel("Welcome to HomeBreaks Plc!");
        lblTitle.setBounds(0, 0, 1186, 45);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 38));
        panel.add(lblTitle);
        
        JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.SOUTH);
        
        JLabel lblLocation = new JLabel("Location");
        panel_1.add(lblLocation);
        
        tfLcation = new JTextField();
        panel_1.add(tfLcation);
        tfLcation.setColumns(10);
        
        JLabel lbldate = new JLabel("     Date");
        panel_1.add(lbldate);
        
        tfStartDate = new JTextField();
        tfStartDate.setText("DD/MM/YY");
        panel_1.add(tfStartDate);
        tfStartDate.setColumns(10);
        
        JLabel lblwave = new JLabel("~");
        panel_1.add(lblwave);
        
        tfEndDate = new JTextField();
        tfEndDate.setText("DD/MM/YY");
        panel_1.add(tfEndDate);
        tfEndDate.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("           Q");
        panel_1.add(lblNewLabel);
        
        tfSearch = new JTextField();
        tfSearch.setText("Search keyword...");
        panel_1.add(tfSearch);
        tfSearch.setColumns(20);
        
        JButton btnSearch = new JButton("Search");
        panel_1.add(btnSearch);
        
        JLabel lblNewLabel_1 = new JLabel("          ");
        panel_1.add(lblNewLabel_1);
        
        JButton btnHome = new JButton("Home");
        panel_1.add(btnHome);
        
        JButton btnLogOut = new JButton("Log out");
        panel_1.add(btnLogOut);
		
        setLocationRelativeTo(null);
        setVisible(true);
        
        btnHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new GuestView();
				setVisible(false);
			}
		});
        
        btnLogOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainView();
				JOptionPane.showMessageDialog(null, "Log out!");
				setVisible(false);
			}
		});
        
        btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SearchView();
				setVisible(false);
			}
        	
        });
    }
    
    private static TableModel createObjectDataModel() {
        return new ObjectTableModel<PropertyGetterSetter>() {
            @Override
            public Object getValueAt(PropertyGetterSetter property, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return property.getTitle();
                    case 1:
                        return property.getName();
                    case 2:
                        return property.getAddress();
                    case 3:
                        return property.getOverallScore();
                    case 4:
                        return property.getInfoBtn();
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 5;
            }
            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return "Title";
                    case 1:
                        return "Host Name";
                    case 2:
                        return "Address";
                    case 3:
                        return "Overall Score";
                    case 4:
                    	return "Specific Information";
                }
                return null;
            }
        };
    }

    private static PaginationDataProvider<PropertyGetterSetter> createDataProvider(SearchView parent) {
    	
        final List<PropertyGetterSetter> list = new ArrayList<>();
        
        for (int i = 1; i <= 500; i++) {
            PropertyGetterSetter e = new PropertyGetterSetter();
            e.setTitle("Title" + i);
            e.setName("Name" + i);
            e.setAddress("Address " + i);
            e.setOverallScore("Overall Score" + i);
            e.setInfoBtn(new InfoButton(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            new MainView();
                            parent.setVisible(false);
                        }
                    }
            ));
            list.add(e);
        }

        return new PaginationDataProvider<PropertyGetterSetter>() {
            @Override
            public int getTotalRowCount() {
                return list.size();
            }

            @Override
            public List<PropertyGetterSetter> getRows(int startIndex, int endIndex) {
                return list.subList(startIndex, endIndex);
            }
        };
    }
    
    private static class JTableButtonMouseListener extends MouseAdapter {
        private final JTable table;

        public JTableButtonMouseListener(JTable table) {
            this.table = table;
        }

        public void mouseClicked(MouseEvent e) {
            int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the column of the button
            int row = e.getY()/table.getRowHeight(); //get the row of the button

            // Checking the row or column is valid or not
            if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
                Object value = table.getValueAt(row, column);

                if (value instanceof InfoButton) {
                    /*perform a click event*/
                    System.out.println("test");
                    ((InfoButton)value).jb.doClick();
                }
            }
        }
    }
}