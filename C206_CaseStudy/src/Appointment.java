import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
	
	private String uName;
	private LocalDate DoA;
	private LocalTime ToA;
	private String dName;
	private String Address;

	public Appointment(String un, LocalDate DoA,LocalTime ToA,String dn,String addr) {
		uName=un;
		this.DoA=DoA;
		this.ToA=ToA;
		dName=dn;
		Address=addr;
	}

	public String getuName() {
		return uName;
	}

	public LocalDate getDoA() {
		return DoA;
	}

	public LocalTime getToA() {
		return ToA;
	}

	public String getdName() {
		return dName;
	}

	public String getAddress() {
		return Address;
	}

	public void setDoA(LocalDate doA) {
		DoA = doA;
	}

	public void setToA(LocalTime toA) {
		ToA = toA;
	}

}
