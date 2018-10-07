package main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelWorldClocksTest {
    private HotelWorldClockSystem hotelWorldClockSystem;
    private PhoneClock phoneClock;

    @Before
    public void initialize() {
        this.hotelWorldClockSystem = new HotelWorldClockSystem();
        this.phoneClock = new PhoneClock(8);
    }

    @Test
    public void the_time_of_clock_London_should_be_2_after_the_phone_clock_is_set_to_9_Beijing_time() {
        // Arrange
        CityClock londonClock = new CityClock(1);
        hotelWorldClockSystem.attach(londonClock);

        // Act
        phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
        phoneClock.setTime(9);

        // Assert
        assertEquals(2, londonClock.getTime());
    }

    @Test
    public void the_time_of_clock_NewYork_should_be_21_after_the_phone_clock_is_set_to_9_Beijing_time() {
        // Arrange
        CityClock newYorkClock = new CityClock(-4);
        hotelWorldClockSystem.attach(newYorkClock);

        // Act
        phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
        phoneClock.setTime(9);

        // Assert
        assertEquals(21, newYorkClock.getTime());
    }

    @Test
    public void the_time_of_clock_London_and_NewYork_should_be_2_and_21_respectively_after_the_phone_clock_is_set_to_9_Beijing_time() {
        // Arrange
        CityClock londonClock = new CityClock(1);
        CityClock newYorkClock = new CityClock(-4);
        hotelWorldClockSystem.attach(londonClock);
        hotelWorldClockSystem.attach(newYorkClock);

        // Act
        phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
        phoneClock.setTime(9);

        // Assert
        assertEquals(2, londonClock.getTime());
        assertEquals(21, newYorkClock.getTime());
    }
    
    @Test
    public void the_time_of_clock_Moscow_should_be_4_after_the_phone_clock_is_set_to_9_Beijing_time() {
        // Arrange
        CityClock moscowClock = new CityClock(3);
        hotelWorldClockSystem.attach(moscowClock);

        // Act
        phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
        phoneClock.setTime(9);

        // Assert
        assertEquals(4, moscowClock.getTime());
    }

    @Test
    public void the_time_of_clock_Sydney_should_be_11_after_the_phone_clock_is_set_to_9_Beijing_time() {
        // Arrange
        CityClock sydneyClock = new CityClock(10);
        hotelWorldClockSystem.attach(sydneyClock);

        // Act
        phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
        phoneClock.setTime(9);

        // Assert
        assertEquals(11, sydneyClock.getTime());
    }
    
    @Test
    public void the_time_of_the_phone_clock_should_be_set_correctly_after_its_setTime_method_is_invoked() {
        // Arrange
        // Act
        phoneClock.setTime(9);

        // Assert
        assertEquals(9, phoneClock.getTime());
    }

}
