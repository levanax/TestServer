package cn.levana.at.vo;


public class LoginFields {

	private String placeholder;
	private String isRequired;
	
	public LoginFields() {
		super();
	}
	
	public LoginFields(String placeholder, String isRequired) {
		super();
		this.placeholder = placeholder;
		this.isRequired = isRequired;
	}
	
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	public String getIsRequired() {
		return isRequired;
	}
	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}
	
}
