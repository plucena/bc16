/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.util.Date;
import java.util.Objects;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.*;
import org.json.JSONObject;

@DataType()
public class Season {

    @Property()
    private String seasonID;
    private String companyID;
    private String personInChargeID;
    private String sentDateTime;
    private String cordDateTime;
    private Soybeans soybean;

    public Season() {
    }

    public Season(String seasonID, String companyID, String personInChargeID, String sentDateTime, String cordDateTime, Soybeans soybean) {
        this.seasonID = seasonID;
        this.companyID = companyID;
        this.personInChargeID = personInChargeID;
        this.sentDateTime = sentDateTime;
        this.cordDateTime = cordDateTime;
        this.soybean = soybean;
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

    public String getSentDateTime() {
        return this.sentDateTime;
    }

    public void setSentDateTime(String sentDateTime) {
        this.sentDateTime = sentDateTime;
    }

    public String getCordDateTime() {
        return this.cordDateTime;
    }

    public void setCordDateTime(String cordDateTime) {
        this.cordDateTime = cordDateTime;
    }

    public Soybeans getSoybean() {
        return this.soybean;
    }

    public void setSoybean(Soybeans soybean) {
        this.soybean = soybean;
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

    public Season sentDateTime(String sentDateTime) {
        this.sentDateTime = sentDateTime;
        return this;
    }

    public Season cordDateTime(String cordDateTime) {
        this.cordDateTime = cordDateTime;
        return this;
    }

    public Season soybean(Soybeans soybean) {
        this.soybean = soybean;
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
        return Objects.equals(seasonID, season.seasonID) && Objects.equals(companyID, season.companyID) && Objects.equals(personInChargeID, season.personInChargeID) && Objects.equals(sentDateTime, season.sentDateTime) && Objects.equals(cordDateTime, season.cordDateTime) && Objects.equals(soybean, season.soybean);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seasonID, companyID, personInChargeID, sentDateTime, cordDateTime, soybean);
    }

    @Override
    public String toString() {
        return "{" +
            " seasonID='" + getSeasonID() + "'" +
            ", companyID='" + getCompanyID() + "'" +
            ", personInChargeID='" + getPersonInChargeID() + "'" +
            ", sentDateTime='" + getSentDateTime() + "'" +
            ", cordDateTime='" + getCordDateTime() + "'" +
            ", soybean='" + getSoybean() + "'" +
            "}";
    }

   

    public String toJSONString() {
        return new JSONObject(this).toString();
    }

    public static Season fromJSONString(String json) {
        String parameterOne = new JSONObject(json).getString("seasonID");
        String parameterTwo = new JSONObject(json).getString("companyID");
        String parameterThree = new JSONObject(json).getString("personInChargeID");
        String parameterFour = new JSONObject(json).getString("sentDateTime");
        String parameterFive = new JSONObject(json).getString("cordDateTime");

        String soybeanParamOne = new JSONObject(json).getJSONObject("soybean").getString("value");

        Soybeans soja = new Soybeans();
        soja.setValue(soybeanParamOne);

        Season season = new Season(parameterOne, parameterTwo, parameterThree, parameterFour, parameterFive,
                soja);

        return season;
    }
}
