package donnserstag;

public class TPerson {
	// interface
	// PROPERTIES
	private int FID;
	private String FName;
	private String FVorname;
	private String FTelNummer;
	private String FEmail;

	// implement
	// CONSTRUCTOR
	// @param to @property --> compile+
	public TPerson(int AID, String AName, String AVorname, String ATelNummer, String AEmail) {
		this.FID = AID;
		this.FName = AName;
		this.FVorname = AVorname;
		this.FTelNummer = ATelNummer;
		this.FEmail = AEmail;
	}

	// default constructor
	public TPerson() {
		this(0, "", "", "", "");
	}

	// ***********************************************************
	// PROPERTY READ id WRITE id
	public int getID() {
		return FID;
	}

	public void setID(int ID) {
		this.FID = ID;
	}

	// PROPERTIE read Name write Name
	public String getName() {
		return FName;
	}

	public void setName(String Name) {
		this.FName = Name;
	}

	// PROPERTIE read VorName write VorName
	public String getVorName() {
		return FVorname;
	}

	public void setVorName(String VorName) {
		this.FVorname = VorName;
	}

	// PROPERTIE read TelNummer write TelNummer
	public String getTelNummer() {
		return FTelNummer;
	}

	public void setTelNummer(String TelNummer) {
		this.FTelNummer = TelNummer;
	}

	// PROPERTIE read Email write Email
	public String getEmail() {
		return FEmail;
	}

	public void setEmail(String Email) {
		this.FEmail = Email;
	}
	
	public String getPersonValues() {
		 return this.FName + "; " + this.FVorname+ "; " + this.FTelNummer+ "; " + this.FEmail;
		
	}

}
