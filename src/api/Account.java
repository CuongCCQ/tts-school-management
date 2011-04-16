package api;


import java.util.Date;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */
public class Account extends AbstractAccount implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** minimal constructor */
	public Account(Integer accountId, String userName, String passWord) {
		super(accountId, userName, passWord);
	}

	/** full constructor */
	public Account(Integer accountId, String userName, String passWord,
			Integer staffId, Date lastLogin, Short type) {
		super(accountId, userName, passWord, staffId, lastLogin, type);
	}

}
