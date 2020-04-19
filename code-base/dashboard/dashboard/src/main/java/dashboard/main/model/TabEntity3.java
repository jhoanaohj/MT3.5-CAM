package dashboard.main.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity3 {

	@Id
	private Date acquisitionDate;
	@Column
	private Date operationalDate;
	@Column
	private Date deliveryDate;
	@Column
	private Date installationDate; //should change DATE if gonna be added
	@Column
	private Date datePulled;
	@Column
	private String reasonPulled;
	@Column
	private String locationPulled;
	
	
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

	public Date getDatePulled() {
		return datePulled;
	}

	public void setDatePulled(Date datePulled) {
		this.datePulled = datePulled;
	}

	public String getReasonPulled() {
		return reasonPulled;
	}

	public void setReasonPulled(String reasonPulled) {
		this.reasonPulled = reasonPulled;
	}

	public String getLocationPulled() {
		return locationPulled;
	}

	public void setLocationPulled(String locationPulled) {
		this.locationPulled = locationPulled;
	}

	public TabEntity3(Date acqDate, Date operateDate, Date deliverDate, Date installDate, Date datePull, String reasonPull,
			String locationPull) {
		super();
		this.acquisitionDate = acqDate;
		this.operationalDate = operateDate;
		this.deliveryDate = deliverDate;
		this.installationDate = installDate;
		this.datePulled = datePull;
		this.reasonPulled = reasonPull;
		this.locationPulled = locationPull;
		
	}

	public TabEntity3() {
	}
}