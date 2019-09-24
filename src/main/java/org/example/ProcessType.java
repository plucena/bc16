/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;

@DataType()
public class ProcessType {
    
    //Properties of the asset
    @Property()
    private String processTypeID;
    private String companyID;
    private String languageKeyLabel;

    //Constructor of the asset
    public ProcessType(String processTypeID, String companyID, String languageKeyLabel){
        this.processTypeID = processTypeID;
        this.companyID = companyID;
        this.languageKeyLabel = languageKeyLabel;
    }

    public String getProcessTypeID() {
        return processTypeID;
    }

    public void setProcessTypeID(String value) {
        this.processTypeID = value;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String value) {
        this.companyID = value;
    }

    public String getLanguageKeyLabel() {
        return languageKeyLabel;
    }

    public void setLanguageKeyLabel(String value) {
        this.languageKeyLabel = value;
    }

    public String toJSONString() {
        return new JSONObject(this).toString();
    }

    public static Process fromJSONStringProcessTypeID(String json) {
        String value = new JSONObject(json).getString("proccesTypeID");
        Process asset = new ProcessType();
        asset.setProcessTypeID(value);
        return asset;
    }

    public static Process fromJSONStringProcessLabel(String json) {
        String value = new JSONObject(json).getString("proccesTypeID");
        Soybeans asset = new Soybeans();
        asset.setProcessTypeID(value);
        return asset;
    }
}
