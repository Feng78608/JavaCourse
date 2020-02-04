package JavaBean;

import java.sql.Timestamp;
import java.util.Date;

public class Reader {
    private int rdID;
    private String rdName;
    private String rdSex;     //rdSex='男';
    private int rdType;
    private String rdDept;
    private String rdPhone;
    private String rdEmail;
    private Timestamp rdDateReg;
    private String rdPhoto;
    private String rdStatus;
    private int rdBorrowQty;
    private String rdPwd;
    private int rdAdminRoles;


    public int getRdType() {
        return rdType;
    }

    public String getRdSex() {
        return rdSex;
    }

    public Timestamp getRdDateReg() {
        return rdDateReg;
    }

    public int getRdAdminRoles() {
        return rdAdminRoles;
    }

    public int getRdBorrowQty() {
        return rdBorrowQty;
    }

    public int getRdID() {
        return rdID;
    }

    public String getRdDept() {
        return rdDept;
    }

    public String getRdEmail() {
        return rdEmail;
    }

    public String getRdName() {
        return rdName;
    }

    public String getRdPhone() {
        return rdPhone;
    }

    public String getRdPhoto() {
        return rdPhoto;
    }

    public String getRdPwd() {
        return rdPwd;
    }

    public String getRdStatus() {
        return rdStatus;
    }

    public void setRdType(int rdType) {
        this.rdType = rdType;
    }

    public void setRdAdminRoles(int rdAdminRoles) {
        this.rdAdminRoles = rdAdminRoles;
    }

    public void setRdBorrowQty(int rdBorrowQty) {
        this.rdBorrowQty = rdBorrowQty;
    }

    public void setRdDateReg(Timestamp rdDateReg) {
        this.rdDateReg = rdDateReg;
    }

    public void setRdDept(String rdDept) {
        this.rdDept = rdDept;
    }

    public void setRdEmail(String rdEmail) {
        this.rdEmail = rdEmail;
    }

    public void setRdID(int rdID) {
        this.rdID = rdID;
    }

    public void setRdName(String rdName) {
        this.rdName = rdName;
    }

    public void setRdPhone(String rdPhone) {
        this.rdPhone = rdPhone;
    }

    public void setRdPhoto(String rdPhoto) {
        this.rdPhoto = rdPhoto;
    }

    public void setRdPwd(String rdPwd) {
        this.rdPwd = rdPwd;
    }

    public void setRdSex(String rdSex) {
        this.rdSex = rdSex;
    }

    public void setRdStatus(String rdStatus) {
        this.rdStatus = rdStatus;
    }
}
