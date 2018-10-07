package main;

/**
* @author Jialei Chen 10165101278
* @version 2018-10-05
* This class extends the class "BaseClock" to initialize the time difference of a city 
* where the phone locates and reset the time after changing via phone. 
*/

public class PhoneClock extends BaseClock {
	private HotelWorldClockSystem hotelWorldClockSystem;
	private int time;

	public PhoneClock(int utcOffset) {
		super.utcOffset = utcOffset;
	}

	/** 根据输入的手机时钟时间调整其他时钟 */
	public void setTime(int time) {
		this.time = time;
		if (this.hotelWorldClockSystem == null) {
			return;
		}
		for (CityClock cityClock : this.hotelWorldClockSystem.getClocks()) {
			cityClock.setUtcZeroTime(time - super.utcOffset);
		}
	}

	public void setHotelWorldClockSystem(HotelWorldClockSystem hotelWorldClockSystem) {
		this.hotelWorldClockSystem = hotelWorldClockSystem;
	}

	@Override
	public int getTime() {
		return this.time;
	}
}
