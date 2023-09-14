package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FlightService service = new FlightService();
        List<Flight> flights = FlightBuilder.createFlights();
        FlightRules flightRules = new FlightRules.Builder()
                .withDepartureIsBeforeNow()
                .withArrivalIsBeforeDeparture()
                .withGroundTimeIsMoreThanHours(2)
                .build();

        if (flightRules.getDepartureIsBeforeNow()) {
            List<Flight> approvedFlights = service.checkDepartureTime(flights);
            System.out.println("Полеты, прошедшие проверку \"вылет до текущего момента времени\":");
            if (approvedFlights.isEmpty()) {
                System.out.println("не найдено.");
            } else {
                for (Flight f : approvedFlights) {
                    System.out.println(f);
                }
            }
        }

        if (flightRules.getArrivalIsBeforeDeparture()) {
            List<Flight> approvedFlights = service.checkArrivalIsBeforeDeparture(flights);
            System.out.println("Полеты, прошедшие проверку \"имеются сегменты с датой прилета раньше даты вылета\":");
            if (approvedFlights.isEmpty()) {
                System.out.println("не найдено.");
            } else {
                for (Flight f : approvedFlights) {
                    System.out.println(f);
                }
            }
        }

        if (flightRules.getGroundTimeIsMoreThanHours()) {
            List<Flight> approvedFlights = service.checkGroundTimeIsMoreThanHours(flights, flightRules.getGroundTime());
            System.out.println("Полеты, прошедшие проверку \"общее время, проведенное на земле, превышает " + flightRules.getGroundTime() + " часа\":");
            if (approvedFlights.isEmpty()) {
                System.out.println("не найдено.");
            } else {
                for (Flight f : approvedFlights) {
                    System.out.println(f);
                }
            }
        }
    }
}