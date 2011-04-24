package api;

import java.util.Date;

/**
 * AbstractStaff entity provides the base persistence definition of the Staff
 * entity. @author MyEclipse Persistence Tools
 */
public abstract class AbstractStaff implements java.io.Serializable {

    // Fields
    private Integer staffId;
    private String staffCode;
    private String address;
    private String phoneNumber;
    private Boolean sex;
    private String email;
    private byte[] photo;
    private String name;
    private Date dateOfBirth;
    private Integer adminType;
    private String passWord;

    public Integer getAdminType() {
        return adminType;
    }

    public void setAdminType(Integer adminType) {
        this.adminType = adminType;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Constructors
    /** default constructor */
    public AbstractStaff() {
    }

    /** minimal constructor */
    public AbstractStaff(Integer staffId, String name) {
        this.staffId = staffId;
        this.name = name;
    }

    public AbstractStaff(String name) {
        this.name = name;
    }

    /** full constructor */
    // Property accessors
    public Integer getStaffId() {
        return this.staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffCode() {
        return this.staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getSex() {
        return this.sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return this.photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
