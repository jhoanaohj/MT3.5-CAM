package dashboard.main.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity2 {

	@Id
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
	private String regionCode;
	@Column
	private String provinceCode;
	@Column
	private String rating;
	@Column
	private Boolean standAlone;
	@Column
	private String poNumber;
	
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
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public Boolean getStandAlone() {
		return standAlone;
	}
	public void setStandAlone(Boolean standAlone) {
		this.standAlone = standAlone;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	
	public TabEntity2(Date operateStart, Date operateEnd, Date createDte, Date updateDte, String add, String region,
			String province, String rate, Boolean stand, String poNum) {
		super();
		this.operationStart = operateStart;
		this.operationEnd = operateEnd;
		this.createDate = createDte;
		this.updateDate = updateDte;
		this.address = add;
		this.regionCode = region;
		this.provinceCode = province;
		this.rating = rate;
		this.standAlone = stand;
		this.poNumber = poNum;
		
	}

	public TabEntity2() {
	}
}
	
	
	
	
	
	
	

