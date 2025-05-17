package com.customer.pojo;

public class Customer {

	private int cid;
	private String cname;
	private String cemail;
	private String ccontact;
	private String caddress;
	private String cpass;
	private String ctype;
	
	public Customer() {
		super();
	}

	public Customer(String cname, String cemail, String ccontact, String caddress, String cpass, String ctype) {
		super();
		this.cname = cname;
		this.cemail = cemail;
		this.ccontact = ccontact;
		this.caddress = caddress;
		this.cpass = cpass;
		this.ctype = ctype;
	}

	public Customer(int cid, String cname, String cemail, String ccontact, String caddress, String cpass,
			String ctype) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cemail = cemail;
		this.ccontact = ccontact;
		this.caddress = caddress;
		this.cpass = cpass;
		this.ctype = ctype;
	}

	
	public Customer(String cname, String cemail, String ccontact, String caddress, String cpass) {
		super();
		this.cname = cname;
		this.cemail = cemail;
		this.ccontact = ccontact;
		this.caddress = caddress;
		this.cpass = cpass;
	}
	
	

	public Customer(int cid, String cname, String cemail, String ccontact, String caddress, String cpass) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cemail = cemail;
		this.ccontact = ccontact;
		this.caddress = caddress;
		this.cpass = cpass;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", ccontact=" + ccontact
				+ ", caddress=" + caddress + ", cpass=" + cpass + ", ctype=" + ctype + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCcontact() {
		return ccontact;
	}

	public void setCcontact(String ccontact) {
		this.ccontact = ccontact;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	

	
	
}
