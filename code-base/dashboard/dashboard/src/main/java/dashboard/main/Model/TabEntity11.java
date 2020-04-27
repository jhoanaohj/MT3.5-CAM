package dashboard.main.Model;

import javax.persistence.Column;
import javax.persistence.Id;

public class TabEntity11 {
	
	@Id
	private Boolean cPowerBox;
	@Column
	private Boolean cCassettes;
	@Column
	private Boolean cSampleMBTCCards;
	@Column
	private String hddCapacity;
	
	public Boolean getcPowerBox() {
		return cPowerBox;
	}
	public void setcPowerBox(Boolean cPowerBox) {
		this.cPowerBox = cPowerBox;
	}
	public Boolean getcCassettes() {
		return cCassettes;
	}
	public void setcCassettes(Boolean cCassettes) {
		this.cCassettes = cCassettes;
	}
	public Boolean getcSampleMBTCCards() {
		return cSampleMBTCCards;
	}
	public void setcSampleMBTCCards(Boolean cSampleMBTCCards) {
		this.cSampleMBTCCards = cSampleMBTCCards;
	}
	public String getHdd_capacity() {
		return hddCapacity;
	}
	public void setHdd_capacity(String hdd_capacity) {
		this.hddCapacity = hdd_capacity;
	} 
	
	public TabEntity11 (Boolean cpowerBox, Boolean cassettes, Boolean sampleMBTC, String hdd) {
		super();
		this.cPowerBox = cpowerBox;
		this.cCassettes = cassettes;
		this.cSampleMBTCCards = sampleMBTC;
		this.hddCapacity = hdd;
	}
	
	public TabEntity11 () {	
	}

}
