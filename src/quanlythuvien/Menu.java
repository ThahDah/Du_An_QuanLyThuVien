package quanlythuvien;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
//	private Container container;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 477, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton addBookButton = new JButton("Thêm sách");
		addBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				setVisible(false);
				new AddBookFrame(Menu.this);
			}
		});
		addBookButton.setBounds(10, 268, 136, 45);
		contentPane.add(addBookButton);
		
		JButton addMemberButton = new JButton("Thêm thành viên");
		addMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AddMemberFrame(Menu.this);
			}
		});
		addMemberButton.setBounds(317, 267, 136, 47);
		contentPane.add(addMemberButton);
		
		JLabel titleLabel = new JLabel("THƯ VIỆN SỐ");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(118, 11, 174, 41);
		contentPane.add(titleLabel);
		
		table = new JTable();
		table.setBounds(28, 51, 425, 206);
		contentPane.add(table);
		
		

	}
}
