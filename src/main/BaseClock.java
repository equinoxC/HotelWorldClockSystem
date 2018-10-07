package main;

/**
* @author Jialei Chen 10165101278
* @version 2018-10-05
* This class is a superclass for CityClock and PhoneClock to get the current time. 
*/

public abstract class BaseClock {
	/**保存与UTC时间的时差*/
    protected int utcOffset;
    /**返回值为整形，无参数
     * 由子类CityClock和Phone Clock实现，分别得到手机调整后各城市的时间和当前手机的时间*/
    public abstract int getTime();
}
