/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.util.Date;
import java.util.Objects;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;

public class agrichainProcess {
    private String processID;
    private String processLabel;
    private String companyID;
    private Structure[] structures;
    private Record[] records;

    public agrichainProcess() {
    }

    public agrichainProcess(String processID, String processLabel, String companyID, Structure[] structures,
            Record[] records) {
        this.processID = processID;
        this.processLabel = processLabel;
        this.companyID = companyID;
        this.structures = structures;
        this.records = records;
    }

    public String getProcessID() {
        return this.processID;
    }

    public void setProcessID(String processID) {
        this.processID = processID;
    }

    public String getProcessLabel() {
        return this.processLabel;
    }

    public void setProcessLabel(String processLabel) {
        this.processLabel = processLabel;
    }

    public String getCompanyID() {
        return this.companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public Structure[] getStructures() {
        return this.structures;
    }

    public void setStructures(Structure[] structures) {
        this.structures = structures;
    }

    public Record[] getRecords() {
        return this.records;
    }

    public void setRecords(Record[] records) {
        this.records = records;
    }

    public agrichainProcess processID(String processID) {
        this.processID = processID;
        return this;
    }

    public agrichainProcess processLabel(String processLabel) {
        this.processLabel = processLabel;
        return this;
    }

    public agrichainProcess companyID(String companyID) {
        this.companyID = companyID;
        return this;
    }

    public agrichainProcess structures(Structure[] structures) {
        this.structures = structures;
        return this;
    }

    public agrichainProcess records(Record[] records) {
        this.records = records;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof agrichainProcess)) {
            return false;
        }
        agrichainProcess agrichainProcess = (agrichainProcess) o;
        return Objects.equals(processID, agrichainProcess.processID)
                && Objects.equals(processLabel, agrichainProcess.processLabel)
                && Objects.equals(companyID, agrichainProcess.companyID)
                && Objects.equals(structures, agrichainProcess.structures)
                && Objects.equals(records, agrichainProcess.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processID, processLabel, companyID, structures, records);
    }

    @Override
    public String toString() {
        return "{" + " processID='" + getProcessID() + "'" + ", processLabel='" + getProcessLabel() + "'"
                + ", companyID='" + getCompanyID() + "'" + ", structures='" + getStructures() + "'" + ", records='"
                + getRecords() + "'" + "}";
    }

}
