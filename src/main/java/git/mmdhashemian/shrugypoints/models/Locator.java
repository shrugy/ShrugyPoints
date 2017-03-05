package git.mmdhashemian.shrugypoints.models;

/**
 * Variable locator
 * 
 * @author Mohammad_Hashemian.
 */
public enum Locator {
	SERVICENAME("%sname%"),
	CHANGETYPE("%ctype%"),
	SOURCEPLAYERNAME("%sourcepname%"),
	TARGETPLAYERNAME("%targetpname%"),
	PREVIOUSAMOUNT("%preamount%"),
	NEWAMOUNT("%newamount%"),
	BALANCE("%balance%"),
	PERMISSION("%permission%");
	
	/**
	 * Locator field
	 */
	private String Locator;
	
	/**
	 * Private constructor
	 * @param locator
	 */
	private Locator(String locator) {
		this.Locator = locator;
	}
	
	/**
	 *  Get the locator
	 * @return Locator
	 */
	public String getLocator() {
		return Locator;
	}
}
