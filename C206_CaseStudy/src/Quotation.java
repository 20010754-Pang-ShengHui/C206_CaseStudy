import java.time.LocalDate;

public class Quotation {
	
	private int reqid;
	private int quotid;
	private String categ;
	private String descrip;
	private double price;
	private String desname;
	private LocalDate startdate;
	private double totalamt;
	
	public Quotation(int reqid, int quotid, String categ, String descrip, double price, String desname, LocalDate startdate, double totalamt) {
		this.reqid = reqid;
		this.quotid = quotid;
		this.categ = categ;
		this.descrip = descrip;
		this.price = price;
		this.desname = desname;
		this.startdate = startdate;
		this.totalamt = totalamt;
	}

	public int getReqid() {
		return reqid;
	}

	public void setReqid(int reqid) {
		this.reqid = reqid;
	}

	public int getQuotid() {
		return quotid;
	}

	public void setQuotid(int quotid) {
		this.quotid = quotid;
	}

	public String getCateg() {
		return categ;
	}

	public void setCateg(String categ) {
		this.categ = categ;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDesname() {
		return desname;
	}

	public void setDesname(String desname) {
		this.desname = desname;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public double getTotalamt() {
		return totalamt;
	}

	public void setTotalamt(double totalamt) {
		this.totalamt = totalamt;
	}

}
