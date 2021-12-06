package model;

import java.sql.Date;

public class ChargeBandInfo {
    private int propertyID;
    private Date startDate;
    private Date endDate;
    private double pricePerNight;
    private double serviceCharge;
    private double cleaningCharge;

    public ChargeBandInfo(int propertyIDC, Date startDateC, Date endDateC, double pricePerNightC, double serviceChargeC, double cleaningChargeC) {
        propertyID = propertyIDC;
        startDate = startDateC;
        endDate = endDateC;
        pricePerNight = pricePerNightC;
        serviceCharge = serviceChargeC;
        cleaningCharge = cleaningChargeC;
    }
    public ChargeBandInfo(Date startDateC, Date endDateC, double pricePerNightC, double serviceChargeC, double cleaningChargeC) {
        startDate = startDateC;
        endDate = endDateC;
        pricePerNight = pricePerNightC;
        serviceCharge = serviceChargeC;
        cleaningCharge = cleaningChargeC;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public double getCleaningCharge() {
        return cleaningCharge;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }
}
