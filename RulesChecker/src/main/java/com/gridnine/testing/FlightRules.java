package com.gridnine.testing;

class FlightRules {

    private Boolean departureIsBeforeNow;
    private Boolean arrivalIsBeforeDeparture;
    private Boolean groundTimeIsMoreThanHours;
    private Integer groundTime;

    FlightRules() {
    }

    public Boolean getDepartureIsBeforeNow() {
        return departureIsBeforeNow;
    }

    public Boolean getArrivalIsBeforeDeparture() {
        return arrivalIsBeforeDeparture;
    }

    public Boolean getGroundTimeIsMoreThanHours() {
        return groundTimeIsMoreThanHours;
    }

    public Integer getGroundTime() {
        return groundTime;
    }

    static class Builder {

        private final FlightRules flightRules;

        public Builder() {
            flightRules = new FlightRules();
        }

        public Builder withDepartureIsBeforeNow() {
            flightRules.departureIsBeforeNow = true;
            return this;
        }

        public Builder withArrivalIsBeforeDeparture() {
            flightRules.arrivalIsBeforeDeparture = true;
            return this;
        }

        public Builder withGroundTimeIsMoreThanHours(Integer groundTime) {
            flightRules.groundTimeIsMoreThanHours = true;
            flightRules.groundTime = groundTime;
            return this;
        }

        public FlightRules build() {
            return flightRules;
        }
    }
}
