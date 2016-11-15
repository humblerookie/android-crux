package com.hr.crux.core.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GResult {

    @SerializedName("predictions")
    public List<GooglePlacesResult> predictions;

    @SerializedName("status")
    public String status;

    public List<GooglePlacesResult> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<GooglePlacesResult> predictions) {
        this.predictions = predictions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class GooglePlacesResult {

        @SerializedName("description")
        public String description;

        @SerializedName("id")
        public String id;

        @SerializedName("place_id")
        public String placeId;

        @SerializedName("reference")
        public String reference;

        @SerializedName("formatted_address")
        public String address;

        @SerializedName("geometry")
        public Geometry geometry;

        @SerializedName("icon")
        public String icon;

        @SerializedName("name")
        public String name;

        @SerializedName("types")
        public List<String> types = new ArrayList<String>();

        @SerializedName("terms")
        public ArrayList<Terms> terms;


        public static class Terms {

            @SerializedName("offset")
            public int offset;

            @SerializedName("value")
            public String value;

            public int getOffset() {
                return offset;
            }

            public void setOffset(int offset) {
                this.offset = offset;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }

        public static class Geometry {

            @SerializedName("location")
            public HashMap<String, Double> location;

            public HashMap<String, Double> getLocation() {
                return location;
            }

            public void setLocation(HashMap<String, Double> location) {
                this.location = location;
            }


        }


        /**
         * @return The description
         */
        public String getDescription() {
            return description;
        }

        /**
         * @param description The description
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * @return The id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return The placeId
         */
        public String getPlaceId() {
            return placeId;
        }

        /**
         * @param placeId The place_id
         */
        public void setPlaceId(String placeId) {
            this.placeId = placeId;
        }

        /**
         * @return The reference
         */
        public String getReference() {
            return reference;
        }

        /**
         * @param reference The reference
         */
        public void setReference(String reference) {
            this.reference = reference;
        }

        /**
         * @return The types
         */
        public List<String> getTypes() {
            return types;
        }

        /**
         * @param types The types
         */
        public void setTypes(List<String> types) {
            this.types = types;
        }

        public Geometry getGeometry() {
            return geometry;
        }

        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<Terms> getTerms() {
            return terms;
        }

        public void setTerms(ArrayList<Terms> terms) {
            this.terms = terms;
        }

    }
}
