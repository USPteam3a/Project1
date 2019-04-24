import java.util.Comparator;

public class RegistrationSort implements Comparator<Object> {
    public int compare(Object obj1, Object obj2) {
	return ((RegistrationForm) obj1).compareTo(((RegistrationForm) obj2));
    }
}