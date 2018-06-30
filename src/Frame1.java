import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Frame1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("JSON CONVERTER");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnFromClipboard = new JButton("From CLIPBOARD");
		btnFromClipboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Clicked FrameClipboard");
			}
		});
		btnFromClipboard.setBounds(288, 75, 136, 58);
		frame.getContentPane().add(btnFromClipboard);
		
		JButton btnNewButton = new JButton("From Url");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new frameurl();
				System.out.println("Clicked FrameUrl");
			}
		});
		btnNewButton.setBounds(10, 75, 136, 58);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblJsonConverter = new JLabel("JSON CONVERTER");
		lblJsonConverter.setForeground(Color.ORANGE);
		lblJsonConverter.setHorizontalAlignment(SwingConstants.CENTER);
		lblJsonConverter.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblJsonConverter.setBounds(10, 11, 414, 53);
		frame.getContentPane().add(lblJsonConverter);
		
		JLabel lblNewLabel = new JLabel("Developed By Aditya Narayan");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 194, 193, 56);
		frame.getContentPane().add(lblNewLabel);
	}

}
