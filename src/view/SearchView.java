package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.table.TableModel;

import model.*;
import model.Property;

public class SearchView extends JFrame{
	private JTextField tfLocation;
	private JTextField tfStartDate;
	private JTextField tfEndDate;
	private JTextField tfSearch;
	
    public SearchView(PersonInfo personInfo, GuestInfo guestInfo, String location, String startDate, String endDate) {
    	setResizable(false);
    	setPreferredSize(new Dimension(1200, 720/12*9));
	    setSize(1200, 720/12*9);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("HomeBreaks Plc");
		
    	JTable table = new JTable(createObjectDataModel());
    	table.setFont(new Font("SansSerif", Font.PLAIN, 12));
        table.setAutoCreateRowSorter(true);
        table.setLocation(200,300);

        InfoButtonCellRenderer renderer = new InfoButtonCellRenderer("More Information");
        table.getColumn("Specific Information").setCellRenderer(renderer);

        InfoButtonCellEditor editor = new InfoButtonCellEditor();
        table.getColumn("Specific Information").setCellEditor(editor);

        table.addMouseListener(new JTableButtonMouseListener(table));
        
        PaginationDataProvider<PropertyGetterSetter> dataProvider = createDataProvider(this, location, startDate, endDate, personInfo, guestInfo);
        PaginatedTableDecorator<PropertyGetterSetter> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 20);
        getContentPane().add(paginatedDecorator.getContentPanel());
        
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        

        
        JLabel lblTitle = new JLabel("Welcome to HomeBreaks Plc!");
        lblTitle.setBounds(0, 0, 1186, 45);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 38));
        panel.add(lblTitle);
        
        JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.SOUTH);
        
        JLabel lblLocation = new JLabel("Location");
        panel_1.add(lblLocation);
        
        tfLocation = new JTextField();
        tfLocation.setText(location);
        panel_1.add(tfLocation);
        tfLocation.setColumns(10);
        
        JLabel lbldate = new JLabel("     Date");
        panel_1.add(lbldate);
        
        tfStartDate = new JTextField();
        tfStartDate.setText(startDate);
        panel_1.add(tfStartDate);
        tfStartDate.setColumns(10);
        
        JLabel lblwave = new JLabel("~");
        panel_1.add(lblwave);
        
        tfEndDate = new JTextField();
        tfEndDate.setText(endDate);
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
				new GuestView(personInfo, guestInfo);
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
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                boolean formatted = false;
                try {
                    format.setLenient(false);
                    format.parse(tfStartDate.getText());
                    format.parse(tfEndDate.getText());
                    formatted = true;
                }
                catch(ParseException ex){
                    formatted = false;
                }
                if (formatted) {
                    new SearchView(personInfo, guestInfo, tfLocation.getText(), tfStartDate.getText(), tfEndDate.getText()).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please write valid dates in YYYY-MM-DD format!", "Error!", JOptionPane.DEFAULT_OPTION);
                }
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
                        return property.getDescription();
                    case 2:
                        return property.getLocation();
                    case 3:
                        return property.getBreakfast();
                    case 4:
                        return property.getOverallScore();
                    case 5:
                        return property.getInfoBtn();
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 6;
            }
            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return "Title";
                    case 1:
                        return "Description";
                    case 2:
                        return "Location";
                    case 3:
                        return "Provides Breakfast";
                    case 4:
                        return "Overall Score";
                    case 5:
                    	return "Specific Information";
                }
                return null;
            }
        };
    }

    private static PaginationDataProvider<PropertyGetterSetter> createDataProvider(SearchView parent, String location, String startDate, String endDate, PersonInfo personInfo, GuestInfo guestInfo) {
    	
        final List<PropertyGetterSetter> list = new ArrayList<>();
        List<PropertyInfo> properties = null;
        try {
            Connection conn = DBAccess.connect();
            properties = Property.getProperties(conn, location, java.sql.Date.valueOf(startDate), java.sql.Date.valueOf(endDate));
        } finally {
            DBAccess.disconnect();
        }
        if (properties != null) {
            for (PropertyInfo property : properties ) {
                PropertyGetterSetter e = new PropertyGetterSetter();
                e.setTitle(property.getName());
                e.setDescription(property.getDescription());
                e.setLocation(property.getLocation());
                e.setBreakfast(property.getIsBreakfast());
                e.setOverallScore(String.valueOf(property.getReviewRating()));
                e.setInfoBtn(new InfoButton(
                        new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                new SpecificInformationView(personInfo, guestInfo, property, startDate, endDate);
                                parent.setVisible(false);
                            }
                        }
                ));
                list.add(e);
            }
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
                    ((InfoButton)value).jb.doClick();
                }
            }
        }
    }
}