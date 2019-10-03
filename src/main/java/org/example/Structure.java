/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.util.Objects;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;
import org.hyperledger.fabric.contract.annotation.DataType;

@DataType()
public class Structure {

    @Property()
    private String StructureID;
    private String processID;
    private String structureKey;
    private String structureType;


    public Structure() {
    }

    public Structure(String StructureID, String processID, String structureKey, String structureType) {
        this.StructureID = StructureID;
        this.processID = processID;
        this.structureKey = structureKey;
        this.structureType = structureType;
    }

    public String getStructureID() {
        return this.StructureID;
    }

    public void setStructureID(String StructureID) {
        this.StructureID = StructureID;
    }

    public String getProcessID() {
        return this.processID;
    }

    public void setProcessID(String processID) {
        this.processID = processID;
    }

    public String getStructureKey() {
        return this.structureKey;
    }

    public void setStructureKey(String structureKey) {
        this.structureKey = structureKey;
    }

    public String getStructureType() {
        return this.structureType;
    }

    public void setStructureType(String structureType) {
        this.structureType = structureType;
    }

    public Structure StructureID(String StructureID) {
        this.StructureID = StructureID;
        return this;
    }

    public Structure processID(String processID) {
        this.processID = processID;
        return this;
    }

    public Structure structureKey(String structureKey) {
        this.structureKey = structureKey;
        return this;
    }

    public Structure structureType(String structureType) {
        this.structureType = structureType;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Structure)) {
            return false;
        }
        Structure structure = (Structure) o;
        return Objects.equals(StructureID, structure.StructureID) && Objects.equals(processID, structure.processID) && Objects.equals(structureKey, structure.structureKey) && Objects.equals(structureType, structure.structureType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(StructureID, processID, structureKey, structureType);
    }

    @Override
    public String toString() {
        return "{" +
            " StructureID='" + getStructureID() + "'" +
            ", processID='" + getProcessID() + "'" +
            ", structureKey='" + getStructureKey() + "'" +
            ", structureType='" + getStructureType() + "'" +
            "}";
    }

    public String toJSONString() {
        return new JSONObject(this).toString();
    }

    public static Structure fromJSONString(String json) {
        String structureID = new JSONObject(json).getString("StructureID");
        String processID = new JSONObject(json).getString("processID");
        String structureKey = new JSONObject(json).getString("structureKey");
        String structureType = new JSONObject(json).getString("structureType");

        Structure asset = new Structure();

        asset.setProcessID(processID);
        asset.setStructureID(structureID);
        asset.structureKey(structureKey);
        asset.setStructureType(structureType);

        return asset;
    }
}
