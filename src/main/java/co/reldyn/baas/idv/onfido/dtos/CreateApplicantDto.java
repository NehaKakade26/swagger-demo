package co.reldyn.baas.idv.onfido.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CreateApplicantDto {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private String id;

        @JsonProperty("created_at")
        private String createdAt;

        private boolean sandbox;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        private String email;

        private String dob;

        @JsonProperty("delete_at")
        private String deleteAt;

        private String href;

        @JsonProperty("id_numbers")
        private List<String> idNumbers;

        @JsonProperty("phone_number")
        private String phoneNumber;

        private Address address;

        private Location location;

        /** Nested Address DTO. */
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Address {
            @JsonProperty("flat_number")
            private String flatNumber;

            @JsonProperty("building_number")
            private String buildingNumber;

            @JsonProperty("building_name")
            private String buildingName;

            private String street;

            @JsonProperty("sub_street")
            private String subStreet;

            private String town;

            private String state;

            private String postcode;

            private String country;

            private String line1;

            private String line2;

            private String line3;
        }

        /** Nested Location DTO. */
        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Location {
            @JsonProperty("ip_address")
            private String ipAddress;

            @JsonProperty("country_of_residence")
            private String countryOfResidence;
        }
    }
}
