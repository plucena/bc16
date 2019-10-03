/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;

@DataType()
public class Record {

    @Property()

    private String recordID;
    private String seasonID;
    private String processID;
    private String companyID;
    private String personInChargeID;
    private String storageDeviceOriginID;
    private String sentDateTime;
    private String recordDateTime;

    public Record() {
    }

    public Record(String recordID, String seasonID, String processID, String companyID, String personInChargeID,
            String storageDeviceOriginID, String sentDateTime, String recordDateTime) {
        this.recordID = recordID;
        this.seasonID = seasonID;
        this.processID = processID;
        this.companyID = companyID;
        this.personInChargeID = personInChargeID;
        this.storageDeviceOriginID = storageDeviceOriginID;
        this.sentDateTime = sentDateTime;
        this.recordDateTime = recordDateTime;
    }

    public String getRecordID() {
        return this.recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
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

    public String getSentDateTime() {
        return this.sentDateTime;
    }

    public void setSentDateTime(String sentDateTime) {
        this.sentDateTime = sentDateTime;
    }

    public String getRecordDateTime() {
        return this.recordDateTime;
    }

    public void setRecordDateTime(String recordDateTime) {
        this.recordDateTime = recordDateTime;
    }

    public Record recordID(String recordID) {
        this.recordID = recordID;
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

    public Record sentDateTime(String sentDateTime) {
        this.sentDateTime = sentDateTime;
        return this;
    }

    public Record recordDateTime(String recordDateTime) {
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
        return Objects.equals(recordID, record.recordID) && Objects.equals(seasonID, record.seasonID)
                && Objects.equals(processID, record.processID) && Objects.equals(companyID, record.companyID)
                && Objects.equals(personInChargeID, record.personInChargeID)
                && Objects.equals(storageDeviceOriginID, record.storageDeviceOriginID)
                && Objects.equals(sentDateTime, record.sentDateTime)
                && Objects.equals(recordDateTime, record.recordDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordID, seasonID, processID, companyID, personInChargeID, storageDeviceOriginID,
                sentDateTime, recordDateTime);
    }

    @Override
    public String toString() {
        return "{" + " recordID='" + getRecordID() + "'" + ", seasonID='" + getSeasonID() + "'" + ", processID='"
                + getProcessID() + "'" + ", companyID='" + getCompanyID() + "'" + ", personInChargeID='"
                + getPersonInChargeID() + "'" + ", storageDeviceOriginID='" + getStorageDeviceOriginID() + "'"
                + ", sentDateTime='" + getSentDateTime() + "'" + ", recordDateTime='" + getRecordDateTime() + "'" + "}";
    }

    public String toJSONString() {
        return new JSONObject(this).toString();
    }

    public static Record fromJSONString(String json) {
        String recordID = new JSONObject(json).getString("recordID");
        String seasonID = new JSONObject(json).getString("seasonID");
        String processID = new JSONObject(json).getString("processID");
        String companyID = new JSONObject(json).getString("companyID");
        String personInChargeID = new JSONObject(json).getString("personInChargeID");
        String storageDeviceOriginID = new JSONObject(json).getString("storageDeviceOriginID");
        String sendDateTime = new JSONObject(json).getString("sendDateTime");
        String recordDateTime = new JSONObject(json).getString("recordDateTime");

        Record asset = new Record();

        asset.setRecordID(recordID);
        asset.setCompanyID(companyID);
        asset.setSeasonID(seasonID);
        asset.setProcessID(processID);
        asset.setPersonInChargeID(personInChargeID);
        asset.storageDeviceOriginID(storageDeviceOriginID);
        asset.setSentDateTime(sendDateTime);
        asset.setRecordDateTime(recordDateTime);

        return asset;
    }
}
