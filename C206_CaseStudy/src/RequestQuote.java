
public class RequestQuote {
	
	private String proptype;
	private int area;
	private String name;
	private String NumEmail;
	private double budget;
	private String enddate;
	private String renotype;
	private int rooms;
	private int toilets;
	private String renostyle;
	private String req;
	
	public RequestQuote(String proptype,int area,String name,String NumEmail,double budget,String enddate,String renotype,int rooms,int toilets,String renostyle,String req) {
		this.proptype = proptype;
		this.area = area;
		this.name = name;
		this.NumEmail = NumEmail;
		this.budget = budget;
		this.enddate = enddate;
		this.renotype = renotype;
		this.rooms = rooms;
		this.toilets = toilets;
		this.renostyle = renostyle;
		this.req = req;
	}

	public String getproptype() {
		return proptype;
	}

	public void setproptype(String proptype) {
		this.proptype = proptype;
	
	}

	public int getarea() {
		return area;
	}

	public void setarea(int area) {
		this.area = area;
	}
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	
	}


	public String getNumEmail() {
		return NumEmail;
	}

	public void NumEmail(String NumEmail) {
		this.NumEmail = NumEmail;
	
	}

	public double getbudget() {
		return budget;
	}

	public void setbudget(double budget) {
		this.budget = budget;
	
	}

	public String getenddate() {
		return enddate;
	}

	public void setenddate(String enddate) {
		this.enddate = enddate;
	}
	
	public String getrenotype() {
		return renotype;
	}

	public void setrenotype(String renotype) {
		this.renotype = renotype;
	
	}

	public int getrooms() {
		return rooms;
	}

	public void setrooms(int rooms) {
		this.rooms = rooms;
	}

	public int gettoilets() {
		return toilets;
	}

	public void settoilets(int toilets) {
		this.toilets = toilets;
	
	}
	
	public String getrenostyle() {
		return renostyle;
	}

	public void setrenostyle(String renostyle) {
		this.renostyle = renostyle;
	
	}
	
	public String getreq() {
		return req;
	}

	public void setreq(String req) {
		this.req = req;
	
	}
	
}	
	
