package com.veigar.model;

/**
 * Created by Administrator on 2017/12/5.
 */
public class DrivingLicense {
    private int id;
    private String carNum;
    private String carType;
    private String carProperty;
    private String carBrand;
    private String carIdentificantionCode;
    private String carEngineNum;
    private String registerDate;
    private String issuingDate;
    private String loadNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarProperty() {
        return carProperty;
    }

    public void setCarProperty(String carProperty) {
        this.carProperty = carProperty;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getIssuingDate() {
        return issuingDate;
    }

    public void setIssuingDate(String issuingDate) {
        this.issuingDate = issuingDate;
    }

    public String getLoadNum() {
        return loadNum;
    }

    public void setLoadNum(String loadNum) {
        this.loadNum = loadNum;
    }

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

    public DrivingLicense(int id, String carNum, String carType, String carProperty, String carBrand, String carIdentificantionCode, String carEngineNum, String registerDate, String issuingDate, String loadNum) {
        this.id = id;
        this.carNum = carNum;
        this.carType = carType;
        this.carProperty = carProperty;
        this.carBrand = carBrand;
        this.carIdentificantionCode = carIdentificantionCode;
        this.carEngineNum = carEngineNum;
        this.registerDate = registerDate;
        this.issuingDate = issuingDate;
        this.loadNum = loadNum;
    }
}
