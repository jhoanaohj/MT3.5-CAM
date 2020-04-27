package dashboard.main.Model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity3 {

	@Id
	private String terminalId;
	@Column
	private Date acquisitionDate;
	@Column
	private Date operationalDate;
	@Column
	private Date deliveryDate;
	@Column
	private Date installationDate; //should change DATE if gonna be added
	@Column
	private Date date_pulled_out;
	@Column
	private String reason_for_pull_out;
	@Column
	private String location_after_pull_out;
	

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public Date getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public Date getOperationalDate() {
		return operationalDate;
	}

	public void setOperationalDate(Date operationalDate) {
		this.operationalDate = operationalDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getInstallationDate() {
		return installationDate;
	}

	public void setInstallationDate(Date installationDate) {
		this.installationDate = installationDate;
	}

	public Date getDate_pulled_out() {
		return date_pulled_out;
	}

	public void setDate_pulled_out(Date date_pulled_out) {
		this.date_pulled_out = date_pulled_out;
	}

	public String getReason_for_pull_out() {
		return reason_for_pull_out;
	}

	public void setReason_for_pull_out(String reason_for_pull_out) {
		this.reason_for_pull_out = reason_for_pull_out;
	}

	public String getLocation_after_pull_out() {
		return location_after_pull_out;
	}

	public void setLocation_after_pull_out(String location_after_pull_out) {
		this.location_after_pull_out = location_after_pull_out;
	}

	public TabEntity3(String termId, Date acqDate, Date operateDate, Date deliverDate, Date installDate, Date datePull, String reasonPull,
			String locationPull) {
		super();
		this.terminalId = termId;
		this.acquisitionDate = acqDate;
		this.operationalDate = operateDate;
		this.deliveryDate = deliverDate;
		this.installationDate = installDate;
		this.date_pulled_out = datePull;
		this.reason_for_pull_out = reasonPull;
		this.location_after_pull_out = locationPull;
		
	}

	public TabEntity3() {
	}
}