/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.util.Date;
import java.util.Objects;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;

@DataType()
public class PersonInCharge {

    @Property()

    private String personInChargeID;
    private String companyID;
    private String name;
    private String email;
    private String publicKey;
    private DateTime createdDateTime;


    public PersonInCharge() {
    }

    public PersonInCharge(String personInChargeID, String companyID, String name, String email, String publicKey, 
            DateTime createdDateTime) {
        this.personInChargeID = personInChargeID;
        this.companyID = companyID;
        this.name = name;
        this.email = email;
        this.publicKey = publicKey;
        this.createdDateTime = createdDateTime;
    }

    public String getPersonInChargeID() {
        return this.personInChargeID;
    }

    public void setPersonInChargeID(String personInChargeID) {
        this.personInChargeID = personInChargeID;
    }

    public String getCompanyID() {
        return this.companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public Date getCreatedDateTime() {
        return this.createdDateTime;
    }

    public void setCreatedDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public PersonInCharge personInChargeID(String personInChargeID) {
        this.personInChargeID = personInChargeID;
        return this;
    }

    public PersonInCharge companyID(String companyID) {
        this.companyID = companyID;
        return this;
    }

    public PersonInCharge name(String name) {
        this.name = name;
        return this;
    }

    public PersonInCharge email(String email) {
        this.email = email;
        return this;
    }

    public PersonInCharge publicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public PersonInCharge createdDateTime(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PersonInCharge)) {
            return false;
        }
        PersonInCharge personInCharge = (PersonInCharge) o;
        return Objects.equals(personInChargeID, personInCharge.personInChargeID) && Objects.equals(companyID, personInCharge.companyID) && Objects.equals(name, personInCharge.name) && Objects.equals(email, personInCharge.email) && Objects.equals(publicKey, personInCharge.publicKey) && Objects.equals(createdDateTime, personInCharge.createdDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personInChargeID, companyID, name, email, publicKey, createdDateTime);
    }

    @Override
    public String toString() {
        return "{" +
            " personInChargeID='" + getPersonInChargeID() + "'" +
            ", companyID='" + getCompanyID() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", publicKey='" + getPublicKey() + "'" +
            ", createdDateTime='" + getCreatedDateTime() + "'" +
            "}";
    }


    public static Soybeans fromJSONString(String json) {
        String value = new JSONObject(json).getString("value");
        Soybeans asset = new Soybeans();
        asset.setValue(value);
        return asset;
    }
}
