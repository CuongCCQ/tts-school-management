package api;

import java.sql.Timestamp;
import java.util.Date;

/**
 * AbstractAccount entity provides the base persistence definition of the
 * Account entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAccount implements java.io.Serializable {

	// Fields

	private Integer accountId;
	private String userName;
	private String passWord;
	private Integer staffId;
	private Date lastLogin;
	private Short type;

	// Constructors

	/** default constructor */
	public AbstractAccount() {
	}

	/** minimal constructor */
	public AbstractAccount(Integer accountId, String userName, String passWord) {
		this.accountId = accountId;
		this.userName = userName;
		this.passWord = passWord;
	}

	/** full constructor */
	public AbstractAccount(Integer accountId, String userName, String passWord,
			Integer staffId, Date lastLogin, Short type) {
		this.accountId = accountId;
		this.userName = userName;
		this.passWord = passWord;
		this.staffId = staffId;
		this.lastLogin = lastLogin;
		this.type = type;
	}

	// Property accessors

	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

}