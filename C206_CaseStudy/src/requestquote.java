
public class requestquote {
	
	private String proptype;
	private int area;
	private String Name;
	private String NumEmail;
	private int budget;
	private String enddate;
	private String renotype;
	private int rooms;
	private int toilets;
	private String renostyle;
	private String req;
	
	public requestquote(String proptype,int area,String Name,String NumEmail,int budget,String enddate,String renotype,int rooms,int toilets,String renostyle,String req) {
		this.proptype = proptype;
		this.area = area;
		this.Name = Name;
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
		return Name;
	}

	public void setname(String name) {
		this.Name = name;
	
	}


	public String getNumEmail() {
		return NumEmail;
	}

	public void NumEmail(String NumEmail) {
		this.NumEmail = NumEmail;
	
	}

	public int getbudget() {
		return budget;
	}

	public void setbudget(int budget) {
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
	