package com.veigar.model;

/**
 * Created by Administrator on 2017/12/5.
 */
public class Driver {
    private int id;
    private String name;
    private String address;
    private String carNum;
    private String sex;
    private int idCard;
    private String birth_Date;
    private String issue_Date;
    private String permit_Type;
    private String expiration_Date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public String getBirth_Date() {
        return birth_Date;
    }

    public void setBirth_Date(String birth_Date) {
        this.birth_Date = birth_Date;
    }

    public String getIssue_Date() {
        return issue_Date;
    }

    public void setIssue_Date(String issue_Date) {
        this.issue_Date = issue_Date;
    }

    public String getPermit_Type() {
        return permit_Type;
    }

    public void setPermit_Type(String permit_Type) {
        this.permit_Type = permit_Type;
    }

    public String getExpiration_Date() {
        return expiration_Date;
    }

    public void setExpiration_Date(String expiration_Date) {
        this.expiration_Date = expiration_Date;
    }

    public Driver() {
    }

    public Driver(int id, String name, String address, String carNum, String sex, int idCard, String birth_Date, String issue_Date, String permit_Type, String expiration_Date) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.carNum = carNum;
        this.sex = sex;
        this.idCard = idCard;
        this.birth_Date = birth_Date;
        this.issue_Date = issue_Date;
        this.permit_Type = permit_Type;
        this.expiration_Date = expiration_Date;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", carNum='" + carNum + '\'' +
                ", sex='" + sex + '\'' +
                ", idCard=" + idCard +
                ", birth_Date='" + birth_Date + '\'' +
                ", issue_Date='" + issue_Date + '\'' +
                ", permit_Type='" + permit_Type + '\'' +
                ", expiration_Date='" + expiration_Date + '\'' +
                '}';
    }
}
