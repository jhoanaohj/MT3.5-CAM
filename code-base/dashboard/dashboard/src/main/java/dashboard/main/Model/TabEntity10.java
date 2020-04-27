package dashboard.main.Model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_inventory")
public class TabEntity10 {

	@Id
	private Boolean cTopperSignage;
	@Column
	private Boolean cTopperTimer;
	@Column
	private Boolean cStandardStickers;
	@Column
	private Boolean cTopperPadlock; 
	@Column
	private Boolean cTophatchPadlock; 


	public Boolean getcTopperSignage() {
		return cTopperSignage;
	}

	public void setcTopperSignage(Boolean cTopperSignage) {
		this.cTopperSignage = cTopperSignage;
	}

	public Boolean getcTopperTimer() {
		return cTopperTimer;
	}

	public void setcTopperTimer(Boolean cTopperTimer) {
		this.cTopperTimer = cTopperTimer;
	}

	public Boolean getcStandardStickers() {
		return cStandardStickers;
	}

	public void setcStandardStickers(Boolean cStandardStickers) {
		this.cStandardStickers = cStandardStickers;
	}

	public Boolean getcTopperPadlock() {
		return cTopperPadlock;
	}

	public void setcTopperPadlock(Boolean cTopperPadlock) {
		this.cTopperPadlock = cTopperPadlock;
	}

	public Boolean getcTophatchPadlock() {
		return cTophatchPadlock;
	}

	public void setcTophatchPadlock(Boolean cTophatchPadlock) {
		this.cTophatchPadlock = cTophatchPadlock;
	}

	public TabEntity10(Boolean signage, Boolean timer, Boolean stickers, Boolean vesPadlock, Boolean topPadlock) {
		super();
		this.cTopperSignage = signage;
		this.cTopperTimer = timer;
		this.cStandardStickers = stickers;
		this.cTopperPadlock = vesPadlock;
		this.cTophatchPadlock = topPadlock;
		
	}

	public TabEntity10() {
	}

}
