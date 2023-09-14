package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightService {

    public List<Flight> checkDepartureTime(List<Flight> flights) {
        List<Flight> approvedFlights = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getSegments().get(0).getDepartureDate().isAfter(LocalDateTime.now())) {
                approvedFlights.add(f);
            }
        }
        return approvedFlights;
    }

    /**
     * Так как сегмент, в котором время прилета раньше времени вылета является ошибкой (при условии, что мы рассматриваем
     * их в рамках одного часового пояса) было бы логично вынести эту проверку в метод .createFlight() при создании перелета.
     * Это позволит нам не использовать вложенный цикл и не нагружать программу, так как наборы перелтов могут быть очень большими.
     * Но так как в задаче указано, что правила задаются динамически, метод находится здесь.
     */
    public List<Flight> checkArrivalIsBeforeDeparture(List<Flight> flights) {
        List<Flight> approvedFlights = new ArrayList<>();
        for (Flight f : flights) {
            boolean flightIsOk = true;
            for (Segment s : f.getSegments()) {
                if (s.getArrivalDate().isBefore(s.getDepartureDate())) {
                    flightIsOk = false;
                }
            }
            if (flightIsOk) approvedFlights.add(f);
        }
        return approvedFlights;
    }

    public List<Flight> checkGroundTimeIsMoreThanHours(List<Flight> flights, Integer groundTime) {
        List<Flight> approvedFlights = new ArrayList<>();
        for (Flight f : flights) {
            Duration duration = Duration.ofMinutes(0);
            LocalDateTime lastArrival = f.getSegments().get(0).getArrivalDate();
            for (int i = 1; i < f.getSegments().size(); i++) {
                duration = duration.plus(Duration.between(lastArrival, f.getSegments().get(i).getDepartureDate()));
                lastArrival = f.getSegments().get(i).getArrivalDate();
            }
            if (null != groundTime && duration.toHours() <= groundTime) {
                approvedFlights.add(f);
            }
        }
        return approvedFlights;
    }
}
