package dashboard.main.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity2 {

	@Id
	private String terminalId;
	@Column
	private Date operationStart;
	@Column
	private Date operationEnd;
	@Column
	private Date createDate;
	@Column
	private Date updateDate; //should change DATE if gonna be updated
	@Column
	private String address;
	@Column
	private String region_iso_code;
	@Column
	private String province_iso_code;
	@Column
	private String rating;
	@Column
	private Boolean stand_alone_branch;
	@Column
	private String poNumber;
	

	
	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public Date getOperationStart() {
		return operationStart;
	}

	public void setOperationStart(Date operationStart) {
		this.operationStart = operationStart;
	}

	public Date getOperationEnd() {
		return operationEnd;
	}

	public void setOperationEnd(Date operationEnd) {
		this.operationEnd = operationEnd;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegion_iso_code() {
		return region_iso_code;
	}

	public void setRegion_iso_code(String region_iso_code) {
		this.region_iso_code = region_iso_code;
	}

	public String getProvince_iso_code() {
		return province_iso_code;
	}

	public void setProvince_iso_code(String province_iso_code) {
		this.province_iso_code = province_iso_code;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Boolean getStand_alone_branch() {
		return stand_alone_branch;
	}

	public void setStand_alone_branch(Boolean stand_alone_branch) {
		this.stand_alone_branch = stand_alone_branch;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public TabEntity2(String termId, Date operateStart, Date operateEnd, Date createDte, Date updateDte, String add, String region,
			String province, String rate, Boolean stand, String poNum) {
		super();
		this.terminalId = termId;
		this.operationStart = operateStart;
		this.operationEnd = operateEnd;
		this.createDate = createDte;
		this.updateDate = updateDte;
		this.address = add;
		this.region_iso_code = region;
		this.province_iso_code = province;
		this.rating = rate;
		this.stand_alone_branch = stand;
		this.poNumber = poNum;
		
	}

	public TabEntity2() {
	}
}
	
	
	
	
	
	
	

