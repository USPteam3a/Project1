import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class RegistrationForm {
    private String name;
    private String phone;
    private String country;
    private String city;
    private Date date;
    private int nights;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private int roomNumber;
    private String roomType;
    private double roomPrice;

    public RegistrationForm() {
	this.name = "Undefined";
	this.phone = "Undefined";
	this.country = "Undefined";
	this.city = "Undefined";
	this.nights = 0;
	this.roomNumber = 0;
	this.roomType = "Undefined";
	this.roomPrice = 0.00;
    }

    public RegistrationForm(String name, String phone, String country, String city, String date, int nights,
	    int roomNumber, String roomType, double roomPrice) {
	StandardCharsets.UTF_8.name();
	this.name = name;
	this.phone = phone;
	this.country = country;
	this.city = city;
	this.nights = nights;
	this.roomNumber = roomNumber;
	this.roomType = roomType;
	this.roomPrice = roomPrice;
	try {
	    this.date = sdf.parse(date);
	} catch (ParseException e) {
	    JOptionPane.showMessageDialog(null, "Грешен формат на дата!\nМоля използвайте дд-ММ-гггг!");
	}
    }

    public String getName() {
	return name;
    }

    public String getPhone() {
	return phone;
    }

    public String getCountry() {
	return country;
    }

    public String getCity() {
	return city;
    }

    public String getDate() {
	return sdf.format(date);
    }

    public int getNights() {
	return nights;
    }

    public int getRoomNumber() {
	return roomNumber;
    }

    public String getRoomType() {
	return roomType;
    }

    public double getRoomPrice() {
	return roomPrice;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public void setDate(String date) {
	StandardCharsets.UTF_8.name();
	try {
	    this.date = sdf.parse(date);
	} catch (ParseException e) {
	    JOptionPane.showMessageDialog(null, "Грешен формат на дата!\nМоля използвайте дд-ММ-гггг!");
	}
    }

    public void setNights(int nights) {
	this.nights = nights;
    }

    public void setRoomNumber(int roomNumber) {
	this.roomNumber = roomNumber;
    }

    public void setRoomType(String roomType) {
	this.roomType = roomType;
    }

    public void setRoomPrice(double roomPrice) {
	this.roomPrice = roomPrice;
    }

    public String toString() {
	StandardCharsets.UTF_8.name();
	return "Име: " + getName() + "\nТелефон: " + getPhone() + "\nДържава: " + getCountry() + "\nГрад: " + getCity()
		+ "\nДата на пристигане: " + getDate() + "\nНощувки: " + getNights() + "\nНомер на стая: "
		+ getRoomNumber() + "\nТип на стая: " + getRoomType() + "\nЦена на стая: "
		+ String.format("%.2f", getRoomPrice()) + "$\n";
    }

    public double getCheckSum() {
	if (getRoomNumber() != 0) {

	    return getNights() * getRoomPrice();
	} else
	    return 0;
    }

    public int compareTo(Object a) {
	if (this.getCheckSum() < ((RegistrationForm) a).getCheckSum())
	    return -1;
	if (this.getCheckSum() > ((RegistrationForm) a).getCheckSum())
	    return 1;
	return 0;
    }

    public Date getArrival() {
	return date;
    }

    public Date getLastDay() {
	StandardCharsets.UTF_8.name();
	String startDate = sdf.format(date);
	Calendar calendar = Calendar.getInstance();
	try {
	    calendar.setTime(sdf.parse(startDate));
	} catch (ParseException e) {
	    JOptionPane.showMessageDialog(null, "Грешен формат на дата!\nМоля използвайте дд-ММ-гггг!");
	}
	calendar.add(Calendar.DATE, getNights()); // number of days to add
	startDate = sdf.format(calendar.getTime()); // StartDate is now the new date
	Date lastDay = new Date();
	try {
	    lastDay = sdf.parse(startDate);
	} catch (ParseException e) {
	    JOptionPane.showMessageDialog(null, "Грешен формат на дата!\nМоля използвайте дд-ММ-гггг!");
	}
	return lastDay;
    }
}
