package ja.oop.interfaces;


public class SwitchableWorker {

	private ISwitchable iSwitchable;

	public SwitchableWorker(ISwitchable iSwitchable) {
		this.iSwitchable = iSwitchable;
	}

	public ISwitchable getiSwitchable() {
		return iSwitchable;
	}

	public void setiSwitchable(ISwitchable iSwitchable) {
		this.iSwitchable = iSwitchable;
	}

	public void turnOn() {
		iSwitchable.turnOn();
	}

	public void turnOff() {
		iSwitchable.turnOff();
	}

	public void turnMiddle() {
		iSwitchable.turnMiddle();
	}
}
