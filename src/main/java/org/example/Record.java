/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.util.Date;
import java.util.Objects;
import org.hyperledger.fabric.contract.annotation.Property;


@DataType()
public class Record {

    @Property()

    private String recordI;
    private String seasonID;
    private String processID;
    private String companyID;
    private String personInChargeID;
    private String storageDeviceOriginID;
    private DateTime sentDateTime;
    private DateTime recordDateTime;


    public Record() {
    }

    public Record(String recordI, String seasonID, String processID, String companyID, String personInChargeID, String storageDeviceOriginID, DateTime sentDateTime, DateTime recordDateTime) {
        this.recordI = recordI;
        this.seasonID = seasonID;
        this.processID = processID;
        this.companyID = companyID;
        this.personInChargeID = personInChargeID;
        this.storageDeviceOriginID = storageDeviceOriginID;
        this.sentDateTime = sentDateTime;
        this.recordDateTime = recordDateTime;
    }

    public String getRecordI() {
        return this.recordI;
    }

    public void setRecordI(String recordI) {
        this.recordI = recordI;
    }

    public String getSeasonID() {
        return this.seasonID;
    }

    public void setSeasonID(String seasonID) {
        this.seasonID = seasonID;
    }

    public String getProcessID() {
        return this.processID;
    }

    public void setProcessID(String processID) {
        this.processID = processID;
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

    public String getStorageDeviceOriginID() {
        return this.storageDeviceOriginID;
    }

    public void setStorageDeviceOriginID(String storageDeviceOriginID) {
        this.storageDeviceOriginID = storageDeviceOriginID;
    }

    public Date getSentDateTime() {
        return this.sentDateTime;
    }

    public void setSentDateTime(Date sentDateTime) {
        this.sentDateTime = sentDateTime;
    }

    public Date getRecordDateTime() {
        return this.recordDateTime;
    }

    public void setRecordDateTime(Date recordDateTime) {
        this.recordDateTime = recordDateTime;
    }

    public Record recordI(String recordI) {
        this.recordI = recordI;
        return this;
    }

    public Record seasonID(String seasonID) {
        this.seasonID = seasonID;
        return this;
    }

    public Record processID(String processID) {
        this.processID = processID;
        return this;
    }

    public Record companyID(String companyID) {
        this.companyID = companyID;
        return this;
    }

    public Record personInChargeID(String personInChargeID) {
        this.personInChargeID = personInChargeID;
        return this;
    }

    public Record storageDeviceOriginID(String storageDeviceOriginID) {
        this.storageDeviceOriginID = storageDeviceOriginID;
        return this;
    }

    public Record sentDateTime(Date sentDateTime) {
        this.sentDateTime = sentDateTime;
        return this;
    }

    public Record recordDateTime(Date recordDateTime) {
        this.recordDateTime = recordDateTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Record)) {
            return false;
        }
        Record record = (Record) o;
        return Objects.equals(recordI, record.recordI) && Objects.equals(seasonID, record.seasonID) && Objects.equals(processID, record.processID) && Objects.equals(companyID, record.companyID) && Objects.equals(personInChargeID, record.personInChargeID) && Objects.equals(storageDeviceOriginID, record.storageDeviceOriginID) && Objects.equals(sentDateTime, record.sentDateTime) && Objects.equals(recordDateTime, record.recordDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordI, seasonID, processID, companyID, personInChargeID, storageDeviceOriginID, sentDateTime, recordDateTime);
    }

    @Override
    public String toString() {
        return "{" +
            " recordI='" + getRecordI() + "'" +
            ", seasonID='" + getSeasonID() + "'" +
            ", processID='" + getProcessID() + "'" +
            ", companyID='" + getCompanyID() + "'" +
            ", personInChargeID='" + getPersonInChargeID() + "'" +
            ", storageDeviceOriginID='" + getStorageDeviceOriginID() + "'" +
            ", sentDateTime='" + getSentDateTime() + "'" +
            ", recordDateTime='" + getRecordDateTime() + "'" +
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
