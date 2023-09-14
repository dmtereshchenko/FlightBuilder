package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FlightServiceTest {
    FlightService service = new FlightService();

    @Test
    public void checkDepartureTimeWithEmptyList() {
        List<Flight> result = service.checkDepartureTime(new ArrayList<>());
        Assertions.assertEquals(result.size(), 0);
    }

    @Test
    public void checkDepartureTimeWithCorrectAndWrongData() {
        List<Flight> result = service.checkDepartureTime(FlightBuilder.getFlights());
        Assertions.assertEquals(result.size(), 5);
    }

    @Test
    public void checkArrivalIsBeforeDepartureWithEmptyList() {
        List<Flight> result = service.checkArrivalIsBeforeDeparture(new ArrayList<>());
        Assertions.assertEquals(result.size(), 0);
    }

    @Test
    public void checkArrivalIsBeforeDepartureWithCorrectAndWrongData() {
        List<Flight> result = service.checkDepartureTime(FlightBuilder.getFlights());
        Assertions.assertEquals(result.size(), 5);
    }

    @Test
    public void checkGroundTimeIsMoreThanHoursWithEmptyList() {
        List<Flight> result = service.checkGroundTimeIsMoreThanHours(new ArrayList<>(), 1);
        Assertions.assertEquals(result.size(), 0);
    }

    @Test
    public void checkGroundTimeIsMoreThanHoursWithNoGroundTime() {
        List<Flight> result = service.checkGroundTimeIsMoreThanHours(FlightBuilder.getFlights(), null);
        Assertions.assertEquals(result.size(), 0);
    }

    @Test
    public void checkGroundTimeIsMoreThanOneHour() {
        List<Flight> result = service.checkGroundTimeIsMoreThanHours(FlightBuilder.getFlights(), 1);
        Assertions.assertEquals(result.size(), 4);
    }

    @Test
    public void checkGroundTimeIsMoreThanThreeHours() {
        List<Flight> result = service.checkGroundTimeIsMoreThanHours(FlightBuilder.getFlights(), 3);
        Assertions.assertEquals(result.size(), 6);
    }
}
