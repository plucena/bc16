/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.util.Objects;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;


@DataType()
public class RecordStructureValue {

    @Property()
    private String recordStructureValueID;
    private String recordID;
    private String structureID;
    private String recordValue;


    public RecordStructureValue() {
    }

    public RecordStructureValue(String recordStructureValueID, String recordID, String structureID, String recordValue) {
        this.recordStructureValueID = recordStructureValueID;
        this.recordID = recordID;
        this.structureID = structureID;
        this.recordValue = recordValue;
    }

    public String getRecordStructureValueID() {
        return this.recordStructureValueID;
    }

    public void setRecordStructureValueID(String recordStructureValueID) {
        this.recordStructureValueID = recordStructureValueID;
    }

    public String getRecordID() {
        return this.recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getStructureID() {
        return this.structureID;
    }

    public void setStructureID(String structureID) {
        this.structureID = structureID;
    }

    public String getRecordValue() {
        return this.recordValue;
    }

    public void setRecordValue(String recordValue) {
        this.recordValue = recordValue;
    }

    public RecordStructureValue recordStructureValueID(String recordStructureValueID) {
        this.recordStructureValueID = recordStructureValueID;
        return this;
    }

    public RecordStructureValue recordID(String recordID) {
        this.recordID = recordID;
        return this;
    }

    public RecordStructureValue structureID(String structureID) {
        this.structureID = structureID;
        return this;
    }

    public RecordStructureValue recordValue(String recordValue) {
        this.recordValue = recordValue;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RecordStructureValue)) {
            return false;
        }
        RecordStructureValue recordStructureValue = (RecordStructureValue) o;
        return Objects.equals(recordStructureValueID, recordStructureValue.recordStructureValueID) && Objects.equals(recordID, recordStructureValue.recordID) && Objects.equals(structureID, recordStructureValue.structureID) && Objects.equals(recordValue, recordStructureValue.recordValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordStructureValueID, recordID, structureID, recordValue);
    }

    @Override
    public String toString() {
        return "{" +
            " recordStructureValueID='" + getRecordStructureValueID() + "'" +
            ", recordID='" + getRecordID() + "'" +
            ", structureID='" + getStructureID() + "'" +
            ", recordValue='" + getRecordValue() + "'" +
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
