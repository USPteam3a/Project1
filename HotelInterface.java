import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HotelInterface {

    private JFrame frame;
    private JProgressBar progressbar;
    private JTextField textField;

    /**
     * Launch the application.
     */

    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    HotelInterface window = new HotelInterface();
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
    public HotelInterface() {
	initialize();
    }

    public void loading() {
	progressbar.setStringPainted(true);
	progressbar.setValue(0);

	int timerDelay = 1;
	new javax.swing.Timer(timerDelay, new ActionListener() {
	    private int index = 0;
	    private int maxIndex = 100;

	    public void actionPerformed(ActionEvent e) {
		if (index < maxIndex) {
		    progressbar.setValue(index);
		    index++;
		} else {
		    progressbar.setValue(maxIndex);
		    ((javax.swing.Timer) e.getSource()).stop(); // stop the timer
		}
	    }
	}).start();

	progressbar.setValue(progressbar.getMinimum());
    }

    private void initialize() {
	StandardCharsets.UTF_8.name();
	frame = new JFrame("Hotel System");
	frame.setBounds(100, 100, 529, 353);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null); // set abstract layout

	JTextArea textArea = new JTextArea();
	textArea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
	textArea.setBackground(SystemColor.menu);
	textArea.setEditable(false);
	textArea.setBounds(10, 153, 499, 184);
	JScrollPane scrollpane = new JScrollPane(textArea);
	scrollpane.setBounds(10, 96, 499, 184);
	// scrollpane.getVerticalScrollBar().setValue(1);
	frame.getContentPane().add(scrollpane);

	progressbar = new JProgressBar();
	progressbar.setBounds(10, 54, 499, 31);
	frame.getContentPane().add(progressbar);

	JLabel lblEnterDate = new JLabel("Дата:");
	lblEnterDate.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
	lblEnterDate.setBounds(10, 12, 80, 31);
	frame.getContentPane().add(lblEnterDate);

	JButton btnNewButton = new JButton("Настанени");
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
	btnNewButton.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		loading();
		if (textField.getText().equals("")) {
		    JOptionPane.showMessageDialog(null, "Моля, изберете дата!");
		} else {
		    RegistrationSystem regSys = new RegistrationSystem();
		    textArea.setText(regSys.toString(textField.getText()));
		}
	    }
	});
	btnNewButton.setBounds(166, 12, 109, 31);
	frame.getContentPane().add(btnNewButton);

	JButton btnFreeRooms = new JButton("Свободни стаи");
	btnFreeRooms.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		loading();
		if (textField.getText().equals("")) {
		    JOptionPane.showMessageDialog(null, "Моля, изберете дата!");
		} else {
		    RegistrationSystem regSys = new RegistrationSystem();
		    textArea.setText(regSys.freeRooms(textField.getText().toString()));
		}
	    }
	});
	btnFreeRooms.setFont(new Font("Tahoma", Font.PLAIN, 11));
	btnFreeRooms.setBounds(285, 12, 123, 31);
	frame.getContentPane().add(btnFreeRooms);

	JButton btnCheck = new JButton("Оборот");
	btnCheck.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		loading();
		if (textField.getText().equals("")) {
		    JOptionPane.showMessageDialog(null, "Моля, изберете дата!");
		} else {
		    RegistrationSystem regSys = new RegistrationSystem();
		    String str = "Оборотът, направен за избраният ден, е: " + regSys.dailySum(textField.getText());
		    textArea.setText(str);
		}
	    }
	});
	btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 11));
	btnCheck.setBounds(418, 12, 80, 31);
	frame.getContentPane().add(btnCheck);

	textField = new JTextField("дд-ММ-гггг");
	textField.setBounds(52, 12, 93, 31);
	frame.getContentPane().add(textField);
	textField.setColumns(10);

	JMenuBar menuBar = new JMenuBar();
	frame.setJMenuBar(menuBar);

	JMenu mnNewMenu = new JMenu("Меню");
	menuBar.add(mnNewMenu);

	JMenuItem mntmHelp = new JMenuItem("Помощ");
	mntmHelp.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		HelpFrame help = new HelpFrame();
		help.setVisible(true);
	    }
	});
	mnNewMenu.add(mntmHelp);
    }
}
