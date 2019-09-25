/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.util.Objects;
import org.hyperledger.fabric.contract.annotation.Property;


@DataType()
public class Season {

    @Property()
    private String seasonID;
    private String companyID;
    private String personInChargeID;
    private DateTime sentDateTime;
    private DateTime cordDateTime;


    public Season() {
    }

    public Season(String seasonID, String companyID, String personInChargeID, DateTime sentDateTime, DateTime cordDateTime) {
        this.seasonID = seasonID;
        this.companyID = companyID;
        this.personInChargeID = personInChargeID;
        this.sentDateTime = sentDateTime;
        this.cordDateTime = cordDateTime;
    }

    public String getSeasonID() {
        return this.seasonID;
    }

    public void setSeasonID(String seasonID) {
        this.seasonID = seasonID;
    }

    public String getCompanyID() {
        return this.companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getPersonInChargeID() {
        return this.personInChargeID;
    }

    public void setPersonInChargeID(String personInChargeID) {
        this.personInChargeID = personInChargeID;
    }

    public DateTime getSentDateTime() {
        return this.sentDateTime;
    }

    public void setSentDateTime(DateTime sentDateTime) {
        this.sentDateTime = sentDateTime;
    }

    public DateTime getCordDateTime() {
        return this.cordDateTime;
    }

    public void setCordDateTime(DateTime cordDateTime) {
        this.cordDateTime = cordDateTime;
    }

    public Season seasonID(String seasonID) {
        this.seasonID = seasonID;
        return this;
    }

    public Season companyID(String companyID) {
        this.companyID = companyID;
        return this;
    }

    public Season personInChargeID(String personInChargeID) {
        this.personInChargeID = personInChargeID;
        return this;
    }

    public Season sentDateTime(DateTime sentDateTime) {
        this.sentDateTime = sentDateTime;
        return this;
    }

    public Season cordDateTime(DateTime cordDateTime) {
        this.cordDateTime = cordDateTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Season)) {
            return false;
        }
        Season season = (Season) o;
        return Objects.equals(seasonID, season.seasonID) && Objects.equals(companyID, season.companyID) && Objects.equals(personInChargeID, season.personInChargeID) && Objects.equals(sentDateTime, season.sentDateTime) && Objects.equals(cordDateTime, season.cordDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seasonID, companyID, personInChargeID, sentDateTime, cordDateTime);
    }

    @Override
    public String toString() {
        return "{" +
            " seasonID='" + getSeasonID() + "'" +
            ", companyID='" + getCompanyID() + "'" +
            ", personInChargeID='" + getPersonInChargeID() + "'" +
            ", sentDateTime='" + getSentDateTime() + "'" +
            ", cordDateTime='" + getCordDateTime() + "'" +
            "}";
    }

    public String toJSONString() {
        return new JSONObject(this).toString();
    }

    public static Soybeans fromJSONString(String json) {
        String value = new JSONObject(json).getString("value");
        Soybeans asset = new Soybeans();
        asset.setValue(value);
        return asset;
    }
}
