package com.veigar.model;

/**
 * Created by Administrator on 2017/12/5.
 */
public class DrivingLicense {
    private String carNum;
    private String carType;
    private String carIdentificantionCode;
    private String carEngineNum;

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarIdentificantionCode() {
        return carIdentificantionCode;
    }

    public void setCarIdentificantionCode(String carIdentificantionCode) {
        this.carIdentificantionCode = carIdentificantionCode;
    }

    public String getCarEngineNum() {
        return carEngineNum;
    }

    public void setCarEngineNum(String carEngineNum) {
        this.carEngineNum = carEngineNum;
    }

    public DrivingLicense(String carNum, String carType, String carIdentificantionCode, String carEngineNum) {
        this.carNum = carNum;
        this.carType = carType;
        this.carIdentificantionCode = carIdentificantionCode;
        this.carEngineNum = carEngineNum;
    }

    public DrivingLicense(){

    }

    @Override
    public String toString() {
        return "DrivingLicense{" +
                "carNum='" + carNum + '\'' +
                ", carType='" + carType + '\'' +
                ", carIdentificantionCode=" + carIdentificantionCode +
                ", carEngineNum=" + carEngineNum +
                '}';
    }
}
