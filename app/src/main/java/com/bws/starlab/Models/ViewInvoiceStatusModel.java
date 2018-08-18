package com.bws.starlab.Models;

/**
 * Created by BWS on 07/05/2018.
 */

public class ViewInvoiceStatusModel {

    String billingCodeandDate;
    String time;
    String rate;
    String total;
    String discription;

    public String getBillingCodeandDate() {
        return billingCodeandDate;
    }

    public void setBillingCodeandDate(String billingCodeandDate) {
        this.billingCodeandDate = billingCodeandDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }


}
