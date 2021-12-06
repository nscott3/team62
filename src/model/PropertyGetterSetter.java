package model;

import view.InfoButton;

public class PropertyGetterSetter {
    private String title;
    private String description;
    private String location;
    private boolean breakfast;
    private String OverallScore;
    private String startDate;
    private String endDate;
    private String availability;
    private InfoButton infoBtn;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }
    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * @return provides breakfast
     */
    public boolean getBreakfast() {
        return breakfast;
    }
    /**
     * @param breakfast the provides breakfast to set
     */
    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
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
     * @return the availability
     */
    public String getAvailability() {
        return availability;
    }
    /**
     * @param availability the availability to set
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }
    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }
    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }
    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    /**
     * @return the infoBtn
     */
    public InfoButton getInfoBtn() {
        return infoBtn;
    }
    /**
     * @param infoBtn the infoBtn to set
     */
    public void setInfoBtn(InfoButton infoBtn) {
        this.infoBtn = infoBtn;
    }
}
