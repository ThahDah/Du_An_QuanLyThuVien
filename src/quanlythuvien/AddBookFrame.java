package quanlythuvien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AddBookFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idField;
	private JButton returnButton;
	private JLabel lblNewLabel;
	private JTextField nameField;
	private JLabel nameLable;
	private JLabel authorLable;
	private JTextField authorField;
	private JLabel dateLable;
	private JTextField dateField;
	private JLabel lblNewLabel_1;

	 	AddBookFrame(Menu m) {
	 	setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			
		idField = new JTextField();
		idField.setBounds(107, 59, 133, 27);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(AddBookFrame.this,"Đã thêm thành công!");
				idField.setText("");
				nameField.setText("");
				authorField.setText("");
				dateField.setText("");
			}
		});
		addButton.setBounds(289, 126, 88, 31);
		contentPane.add(addButton);
		
		returnButton = new JButton("Back");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.setVisible(true);
				dispose();
			}
		});
		returnButton.setBounds(338, 230, 88, 22);
		contentPane.add(returnButton);
		
		lblNewLabel = new JLabel("Mã sách:");
		lblNewLabel.setBounds(31, 59, 69, 27);
		contentPane.add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(107, 109, 133, 27);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		nameLable = new JLabel("Tên sách:");
		nameLable.setBounds(31, 109, 69, 27);
		contentPane.add(nameLable);
		
		authorLable = new JLabel("Tác giả:");
		authorLable.setBounds(31, 160, 69, 27);
		contentPane.add(authorLable);
		
		authorField = new JTextField();
		authorField.setBounds(107, 160, 133, 27);
		contentPane.add(authorField);
		authorField.setColumns(10);
		
		dateLable = new JLabel("Ngày xuất bản:");
		dateLable.setBounds(10, 208, 101, 27);
		contentPane.add(dateLable);
		
		dateField = new JTextField();
		dateField.setBounds(107, 208, 133, 27);
		contentPane.add(dateField);
		dateField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Nhập thông tin sách");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(107, 13, 230, 35);
		contentPane.add(lblNewLabel_1);
		
		
		
	}
}
