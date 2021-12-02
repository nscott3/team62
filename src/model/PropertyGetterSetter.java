package model;

import javax.swing.JButton;

public class PropertyGetterSetter {
    private String title;
    private String name;
    private String address;
    private String OverallScore;
    private JButton infoBtn;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the overallScore
	 */
	public String getOverallScore() {
		return OverallScore;
	}
	/**
	 * @param overallScore the overallScore to set
	 */
	public void setOverallScore(String overallScore) {
		OverallScore = overallScore;
	}
	/**
	 * @return the infoBtn
	 */
	public JButton getInfoBtn() {
		return infoBtn;
	}
	/**
	 * @param infoBtn the infoBtn to set
	 */
	public void setInfoBtn(JButton infoBtn) {
		this.infoBtn = infoBtn;
	}
}