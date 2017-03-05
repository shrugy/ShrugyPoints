package git.mmdhashemian.shrugypoints.permissions;

/**
 * Class contain permission nodes
 * 
 * @author Mohammad_Hashemian
 *
 */
public enum PermissionNode {
	LOOK(".look"),
	GIVE(".give"),
	GIVEALL(".giveall"),
	TAKE(".take"),
	TAKEALL(".takeall"),
	SET(".set"),
	SETALL(".setall"),
	SPY(".spy"),
	PAY(".pay"),
	RESET(".reset"),
	LEADERS(".leaders"),
	RANK(".rank"),
	ME(".me"),
	HISTORY(".history"),
	SOUNDPLAY(".soundplay"),
	FIREWORKRECEIVE(".fireworkreceive"),
	BROADCAST(".broadcast"),
	BROADCASTAUTO(".broadcastAUTO"),
	RELOAD(".reload"),
	UPDATE(".update");
	
	/**
	 * Permission nodes field
	 */
	private String permissionnode;
	
	/**
	 * Permission prefix
	 */
	private String prefix = "shrugypoints";
	
	/**
	 * Private constructor
	 * @param permnode Permission node
	 */
	PermissionNode(String permnode) {
		this.permissionnode = prefix + permnode;
	}
	
	/**
	 * Get the full permission path
	 * @return permission node full path
	 */
	public String getNode() {
		return permissionnode;
	}
	

}
