
import java.awt.SystemColor;
import java.nio.charset.StandardCharsets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class HelpFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public HelpFrame() {
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 450, 256);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	StandardCharsets.UTF_8.name();
	String information = "Проект по Управление на софтуерното производство";
	information += "\nИзготвили: Аника Пенева, СИТ, 3а група, 3-ти курс,";
	information += "\nфак. номер 61662162 и Йоана Иванова, СИТ, 3а група,";
	information += "\n3-ти курс,фак. номер 61662161.";
	information += "\nПрограмата служи за хотелска система. След въвеждането на";
	information += "\nдата, при натискането на бутон Настанени, излиза справка";
	information += "\nза всички настанени клиенти за тази дата.";
	information += "\nПри натискането на бутон Свободни стаи, показва всички стаи,";
	information += "\nзаети маркирани с Х и свободни за въведена дата.";
	information += "\nПри натискането на бутон Оборот, излиза направеният оборот";
	information += "\nза денят, изчислен на база сума за престой, платена в денят на ";
	information += "\nнапускане. ";

	JTextArea textArea = new JTextArea();
	textArea.setBackground(SystemColor.menu);
	textArea.setEditable(false);
	textArea.setBounds(10, 11, 414, 190);
	textArea.setText(information);
	JScrollPane scrollpane = new JScrollPane(textArea);
	scrollpane.setBounds(10, 11, 414, 190);
	contentPane.add(scrollpane);
    }
}
