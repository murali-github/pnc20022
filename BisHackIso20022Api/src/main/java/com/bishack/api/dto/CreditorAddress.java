package com.bishack.api.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"department",
"sub_department",
"street_name",
"building_number",
"building_name",
"floor",
"post_box",
"room",
"post_code",
"town_name",
"town_location_name",
"district_name",
"country_sub_division",
"country",
"address_line"
})
public class CreditorAddress {

@JsonProperty("department")
private String department;
@JsonProperty("sub_department")
private String subDepartment;
@JsonProperty("street_name")
private String streetName;
@JsonProperty("building_number")
private String buildingNumber;
@JsonProperty("building_name")
private String buildingName;
@JsonProperty("floor")
private String floor;
@JsonProperty("post_box")
private String postBox;
@JsonProperty("room")
private String room;
@JsonProperty("post_code")
private String postCode;
@JsonProperty("town_name")
private String townName;
@JsonProperty("town_location_name")
private String townLocationName;
@JsonProperty("district_name")
private String districtName;
@JsonProperty("country_sub_division")
private String countrySubDivision;
@JsonProperty("country")
private String country;
@JsonProperty("address_line")
private List<String> addressLine = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("department")
public String getDepartment() {
return department;
}

@JsonProperty("department")
public void setDepartment(String department) {
this.department = department;
}

@JsonProperty("sub_department")
public String getSubDepartment() {
return subDepartment;
}

@JsonProperty("sub_department")
public void setSubDepartment(String subDepartment) {
this.subDepartment = subDepartment;
}

@JsonProperty("street_name")
public String getStreetName() {
return streetName;
}

@JsonProperty("street_name")
public void setStreetName(String streetName) {
this.streetName = streetName;
}

@JsonProperty("building_number")
public String getBuildingNumber() {
return buildingNumber;
}

@JsonProperty("building_number")
public void setBuildingNumber(String buildingNumber) {
this.buildingNumber = buildingNumber;
}

@JsonProperty("building_name")
public String getBuildingName() {
return buildingName;
}

@JsonProperty("building_name")
public void setBuildingName(String buildingName) {
this.buildingName = buildingName;
}

@JsonProperty("floor")
public String getFloor() {
return floor;
}

@JsonProperty("floor")
public void setFloor(String floor) {
this.floor = floor;
}

@JsonProperty("post_box")
public String getPostBox() {
return postBox;
}

@JsonProperty("post_box")
public void setPostBox(String postBox) {
this.postBox = postBox;
}

@JsonProperty("room")
public String getRoom() {
return room;
}

@JsonProperty("room")
public void setRoom(String room) {
this.room = room;
}

@JsonProperty("post_code")
public String getPostCode() {
return postCode;
}

@JsonProperty("post_code")
public void setPostCode(String postCode) {
this.postCode = postCode;
}

@JsonProperty("town_name")
public String getTownName() {
return townName;
}

@JsonProperty("town_name")
public void setTownName(String townName) {
this.townName = townName;
}

@JsonProperty("town_location_name")
public String getTownLocationName() {
return townLocationName;
}

@JsonProperty("town_location_name")
public void setTownLocationName(String townLocationName) {
this.townLocationName = townLocationName;
}

@JsonProperty("district_name")
public String getDistrictName() {
return districtName;
}

@JsonProperty("district_name")
public void setDistrictName(String districtName) {
this.districtName = districtName;
}

@JsonProperty("country_sub_division")
public String getCountrySubDivision() {
return countrySubDivision;
}

@JsonProperty("country_sub_division")
public void setCountrySubDivision(String countrySubDivision) {
this.countrySubDivision = countrySubDivision;
}

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonProperty("address_line")
public List<String> getAddressLine() {
return addressLine;
}

@JsonProperty("address_line")
public void setAddressLine(List<String> addressLine) {
this.addressLine = addressLine;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}