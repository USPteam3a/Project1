import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class RegistrationSystem extends RegistrationSort {

    private List<RegistrationForm> system = new ArrayList<RegistrationForm>();

    public RegistrationSystem() {
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/anika", "root", "");
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    String query = "SELECT * FROM registration AS reg " + "INNER JOIN room AS r ON reg.room_id = r.room_id "
		    + "INNER JOIN roomtype AS rt ON r.type_id = rt.type_id " + "ORDER BY reg.reg_id ASC";
	    ps = c.prepareStatement(query);
	    rs = ps.executeQuery();
	    while (rs.next()) {
		system.add(new RegistrationForm(rs.getString("reg.name"), rs.getString("reg.phone"),
			rs.getString("reg.country"), rs.getString("reg.city"), rs.getString("reg.date"),
			Integer.parseInt(rs.getString("reg.nights")), Integer.parseInt(rs.getString("r.room_number")),
			rs.getString("rt.room_type"), Double.parseDouble(rs.getString("rt.room_price"))));
	    }
	    c.close();

	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Не може да се усъществи връзка с база данни!");
	}
    }

    public String toString(String date) {
	String s = "";
	// Collections.sort(system, new RegistrationSort());
	// Collections.reverse(system);
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	sdf.setLenient(false);
	Date current = new Date();
	try {
	    current = sdf.parse(date);
	} catch (ParseException e) {
	    JOptionPane.showMessageDialog(null, "Грешен формат на дата!\nМоля използвайте дд-ММ-гггг!");
	}
	Date min = new Date();
	Date max = new Date();

	for (int i = 0; i < system.size(); i++) {
	    min = system.get(i).getArrival();
	    max = system.get(i).getLastDay();
	    if (current.equals(min) || current.equals(max)) {
		s += "\n" + system.get(i).toString();
	    } else if (current.after(min) && current.before(max)) {
		s += "\n" + system.get(i).toString();
	    }
	}
	if (s == "") {
	    JOptionPane.showMessageDialog(null, "Няма резервации за въведената дата!");
	}

	return s;
    }

    public double dailySum(String date) {
	double dailySum = 0.00;
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	Date current = new Date();
	try {
	    current = sdf.parse(date);
	} catch (ParseException e) {
	    JOptionPane.showMessageDialog(null, "Грешен формат на дата!\nМоля използвайте дд-ММ-гггг!");
	}
	for (int i = 0; i < system.size(); i++) {
	    if (system.get(i).getLastDay().equals(current))
		dailySum += system.get(i).getCheckSum();
	}
	if (dailySum == 0) {
	    JOptionPane.showMessageDialog(null, "Няма направен оборот за въведената дата!");
	}

	return dailySum;
    }

    public String freeRooms(String date) {
	String freeRooms = "\n [101] [102] [103] [104] [105] [106] [107] [108] [109] [110]"
		+ "\n [201] [202] [203] [204] [205] [206] [207] [208] [209] [210]"
		+ "\n [301] [302] [303] [304] [305] [306] [307] [308] [309] [310]";

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	Date current = new Date();
	try {
	    current = sdf.parse(date);
	} catch (ParseException e) {
	    JOptionPane.showMessageDialog(null, "Грешен формат на дата!\nМоля използвайте дд-ММ-гггг!");
	}
	Date min = new Date();
	Date max = new Date();

	for (int i = 0; i < system.size(); i++) {

	    min = system.get(i).getArrival();
	    max = system.get(i).getLastDay();
	    // if (current.equals(min) || current.equals(max)) {
	    if (current.equals(min)) {
		String temp = Integer.toString(system.get(i).getRoomNumber());
		if (freeRooms.contains(temp)) {
		    freeRooms = freeRooms.replace(temp, " X ");
		}
	    } else if (current.after(min) && current.before(max)) {
		String temp = Integer.toString(system.get(i).getRoomNumber());
		if (freeRooms.contains(temp)) {
		    freeRooms = freeRooms.replace(temp, " X ");
		}
	    }

	}
	return freeRooms;
    }

}
