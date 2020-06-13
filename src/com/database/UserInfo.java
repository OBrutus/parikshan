package com.database;

import java.sql.Date;

public class UserInfo {
	private String prn="N/A";
    private String rc_no="N/A";
    private Date admission_date;
    private String name="N/A";
    private String year="N/A";
    private String branch="N/A";
    private String local_address;
    private String perm_address;
    private String hostelBlock="N/A";
    private boolean feesPaid;

    public UserInfo(String prn,
                String rc_no,
                Date admission_date,
                String name,
                String year,
                String branch,
                String local_address,
                String perm_address,
                boolean feesPaid){
        this.prn=prn;
        this.rc_no=rc_no;
        this.admission_date=admission_date;
        this.name=name;
        this.year=year;
        this.branch=branch;
        this.local_address=local_address;
        this.perm_address=perm_address;
        this.feesPaid=feesPaid;
    }

    public void setter(String prn,
                String rc_no,
                Date admission_date,
                String name,
                String year,
                String branch,
                String local_address,
                String perm_address,
                boolean feesPaid){
        this.prn=prn;
        this.rc_no=rc_no;
        this.admission_date=admission_date;
        this.name=name;
        this.year=year;
        this.branch=branch;
        this.local_address=local_address;
        this.perm_address=perm_address;
        this.feesPaid=feesPaid;
    }
    
    public String getprn()
    {
        return prn;
    }
    
    public String getrcn()
    {
        return rc_no;
    }

    public Date getAdmdate()
    {
        return admission_date;
    }

    public String getName()
    {
        return name;
    }

    public String getYear()
    {
        return year;
    }
    
    public String getBranch()
    {
        return branch;
    }

    public String getLocAddr()
    {
        return local_address;
    }

    public String getPermAddr()
    {
        return perm_address;
    }
    public boolean getFeesPaid()
    {
        return feesPaid;
    }
    public String getHostelBlock() {
    	return hostelBlock;
    }
    void setHostelBlock(String i) {
    	this.hostelBlock=i;
    }
    void setprn(String prn)
    {
        this.prn=prn;
    }
    
    void setrcn(String rc_no)
    {
        this.rc_no=rc_no;
    }

    void setAdmdate(Date admission_date)
    {
        this.admission_date=admission_date;
    }

    void setName(String name)
    {
        this.name=name;
    }

    void setYear(String year)
    {
        this.year=year;
    }
    
    void setBranch(String branch)
    {
        this.branch=branch;
    }

    void setLocAddr(String local_address)
    {
        this.local_address = local_address;
    }

    void setPermAddr(String perm_address)
    {
        this.perm_address=perm_address;
    }
    void setFeesPaid(boolean feesPaid)
    {
        this.feesPaid=feesPaid;
    }

}
