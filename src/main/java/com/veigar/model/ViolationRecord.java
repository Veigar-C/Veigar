package com.veigar.model;

/**
 * Created by Administrator on 2017/12/6.
 */
public class ViolationRecord {
    private String carNum;
    private String vContent;
    private String vDate;
    private String vState;
    private int vPoints;
    private String vAddress;

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

    public ViolationRecord(String carNum, String vDate, String vContent, String vState, int vPoints, String vAddress) {
        this.carNum = carNum;
        this.vContent = vContent;
        this.vDate = vDate;
        this.vState = vState;
        this.vPoints = vPoints;
        this.vAddress = vAddress;
    }

    @Override
    public String toString() {
        return "ViolationRecord{" +
                "carNum='" + carNum + '\'' +
                ", vContent='" + vContent + '\'' +
                ", vDate='" + vDate + '\'' +
                ", vState='" + vState + '\'' +
                ", vPoints=" + vPoints +
                ", vAddress='" + vAddress + '\'' +
                '}';
    }
}
