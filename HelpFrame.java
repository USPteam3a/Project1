
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
	String information = "������ �� ���������� �� ����������� ������������";
	information += "\n���������: ����� ������, ���, 3� �����, 3-�� ����,";
	information += "\n���. ����� 61662162 � ����� �������, ���, 3� �����,";
	information += "\n3-�� ����,���. ����� 61662161.";
	information += "\n���������� ����� �� �������� �������. ���� ����������� ��";
	information += "\n����, ��� ����������� �� ����� ���������, ������ �������";
	information += "\n�� ������ ��������� ������� �� ���� ����.";
	information += "\n��� ����������� �� ����� �������� ����, ������� ������ ����,";
	information += "\n����� ��������� � � � �������� �� �������� ����.";
	information += "\n��� ����������� �� ����� ������, ������ ����������� ������";
	information += "\n�� �����, �������� �� ���� ���� �� �������, ������� � ����� �� ";
	information += "\n���������. ";

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
