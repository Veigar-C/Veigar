package com.veigar.model;

/**
 * Created by Administrator on 2017/12/6.
 */
public class ViolationRecord {
    private int id;
    private String carNum;
    private String vContent;
    private String vDate;
    private String vState;
    private int vPoints;
    private int vMoney;
    private int vSMoney;
    private String vAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getvContent() {
        return vContent;
    }

    public void setvContent(String vContent) {
        this.vContent = vContent;
    }

    public String getvDate() {
        return vDate;
    }

    public void setvDate(String vDate) {
        this.vDate = vDate;
    }

    public String getvState() {
        return vState;
    }

    public void setvState(String vState) {
        this.vState = vState;
    }

    public int getvPoints() {
        return vPoints;
    }

    public void setvPoints(int vPoints) {
        this.vPoints = vPoints;
    }

    public String getvAddress() {
        return vAddress;
    }

    public void setvAddress(String vAddress) {
        this.vAddress = vAddress;
    }

    public int getvMoney() {
        return vMoney;
    }

    public void setvMoney(int vMoney) {
        this.vMoney = vMoney;
    }

    public int getvSMoney() {
        return vSMoney;
    }

    public void setvSMoney(int vSMoney) {
        this.vSMoney = vSMoney;
    }

    public ViolationRecord(int id, String carNum, String vContent, String vDate, String vState, int vPoints, int vMoney, int vSMoney, String vAddress) {
        this.id = id;
        this.carNum = carNum;
        this.vContent = vContent;
        this.vDate = vDate;
        this.vState = vState;
        this.vPoints = vPoints;
        this.vMoney = vMoney;
        this.vSMoney = vSMoney;
        this.vAddress = vAddress;
    }

    public ViolationRecord() {
    }

}
