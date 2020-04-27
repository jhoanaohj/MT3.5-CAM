package dashboard.main.Model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity7 {

	@Id
	private String terminalId;
	@Column
	private Boolean esdmsInstalled;
	@Column
	private Date esdmsDate;
	@Column
	private Boolean cppInstalled;
	@Column
	private Date cppDate; 
	@Column
	private Boolean tmdInstalled;
	@Column
	private Date tmdDate; 


	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public Boolean getEsdmsInstalled() {
		return esdmsInstalled;
	}

	public void setEsdmsInstalled(Boolean esdmsInstalled) {
		this.esdmsInstalled = esdmsInstalled;
	}

	public Date getEsdmsDate() {
		return esdmsDate;
	}

	public void setEsdmsDate(Date esdmsDate) {
		this.esdmsDate = esdmsDate;
	}

	public Boolean getCppInstalled() {
		return cppInstalled;
	}

	public void setCppInstalled(Boolean cppInstalled) {
		this.cppInstalled = cppInstalled;
	}

	public Date getCppDate() {
		return cppDate;
	}

	public void setCppDate(Date cppDate) {
		this.cppDate = cppDate;
	}

	public Boolean getTmdInstalled() {
		return tmdInstalled;
	}

	public void setTmdInstalled(Boolean tmdInstalled) {
		this.tmdInstalled = tmdInstalled;
	}

	public Date getTmdDate() {
		return tmdDate;
	}

	public void setTmdDate(Date tmdDate) {
		this.tmdDate = tmdDate;
	}

	public TabEntity7(String termId, Boolean esdmsInstall, Date esdmsDte, Boolean cppInstall, Date cppDte, Boolean tmdInstall, Date tmdDte) {
		super();
		this.terminalId = termId;
		this.esdmsInstalled = esdmsInstall;
		this.esdmsDate = esdmsDte;
		this.cppInstalled = cppInstall;
		this.cppDate = cppDte;
		this.tmdInstalled = tmdInstall;
		this.tmdDate = tmdDte;
		
		
	}

	public TabEntity7() {
	}
}