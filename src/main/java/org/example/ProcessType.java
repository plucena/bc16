/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.util.Objects;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;

@DataType()
public class ProcessType {

    // Properties of the asset
    @Property()
    private String processTypeID;
    private String companyID;
    private String languageKeyLabel;

    public ProcessType() {
    }

    public ProcessType(String processTypeID, String companyID, String languageKeyLabel) {
        this.processTypeID = processTypeID;
        this.companyID = companyID;
        this.languageKeyLabel = languageKeyLabel;
    }

    public String getProcessTypeID() {
        return this.processTypeID;
    }

    public void setProcessTypeID(String processTypeID) {
        this.processTypeID = processTypeID;
    }

    public String getCompanyID() {
        return this.companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getLanguageKeyLabel() {
        return this.languageKeyLabel;
    }

    public void setLanguageKeyLabel(String languageKeyLabel) {
        this.languageKeyLabel = languageKeyLabel;
    }

    public ProcessType processTypeID(String processTypeID) {
        this.processTypeID = processTypeID;
        return this;
    }

    public ProcessType companyID(String companyID) {
        this.companyID = companyID;
        return this;
    }

    public ProcessType languageKeyLabel(String languageKeyLabel) {
        this.languageKeyLabel = languageKeyLabel;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProcessType)) {
            return false;
        }
        ProcessType processType = (ProcessType) o;
        return Objects.equals(processTypeID, processType.processTypeID)
                && Objects.equals(companyID, processType.companyID)
                && Objects.equals(languageKeyLabel, processType.languageKeyLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processTypeID, companyID, languageKeyLabel);
    }

    @Override
    public String toString() {
        return "{" + " processTypeID='" + getProcessTypeID() + "'" + ", companyID='" + getCompanyID() + "'"
                + ", languageKeyLabel='" + getLanguageKeyLabel() + "'" + "}";
    }

    public String toJSONString() {
        return new JSONObject(this).toString();
    }
    public static ProcessType fromJSONString(String json) {
        String parameterOne = new JSONObject(json).getString("processTypeID");
        String parameterTwo = new JSONObject(json).getString("companyID");
        String parameterThree = new JSONObject(json).getString("languageKeyLabel");

        ProcessType person = new ProcessType(parameterOne, parameterTwo, parameterThree);

        return person;
    }

}
