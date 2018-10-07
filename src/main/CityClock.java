package main;

/**
* @author Jialei Chen 10165101278
* @version 2018-10-05
* This class extends the class "BaseClock" to initialize the time difference of a city 
* and reset the time after changing via phone. 
*/

public class CityClock extends BaseClock{
    /**UTC时间*/
	private int utcZeroTime;

    public CityClock(int utcOffset) {
        super.utcOffset = utcOffset;
    }

    @Override
    public int getTime() {
        return (super.utcOffset + this.utcZeroTime + 24) % 24;
    }

    public void setUtcZeroTime(int utcZeroTime) {
        this.utcZeroTime = utcZeroTime;
    }
}
