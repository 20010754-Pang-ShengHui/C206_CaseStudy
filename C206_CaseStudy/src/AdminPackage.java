
public class AdminPackage {
	

		private int PackCode;
		private String PackDesc;
		private String PackStart;
		private String PackEnd;
		private int PackAmt;
		
		public AdminPackage(int PackCode, String PackDesc, String PackStart, String PackEnd, int PackAmt) {
			this.PackCode = PackCode;
			this.PackDesc = PackDesc;
			this.PackStart = PackStart;
			this.PackEnd = PackEnd;
			this.PackAmt = PackAmt;
		}

		public int getPackCode() {
			return PackCode;
		}

		public String getPackDesc() {
			return PackDesc;
		}

		public String getPackStart() {
			return PackStart;
		}

		public String getPackEnd() {
			return PackEnd;
		}

		public int getPackAmt() {
			return PackAmt;
		}

		public void setPackCode(int packCode) {
			PackCode = packCode;
		}

		public void setPackDesc(String packDesc) {
			PackDesc = packDesc;
		}

		public void setPackStart(String packStart) {
			PackStart = packStart;
		}

		public void setPackEnd(String packEnd) {
			PackEnd = packEnd;
		}

		public void setPackAmt(int packAmt) {
			PackAmt = packAmt;
		}

		 
}

	