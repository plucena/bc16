/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.util.Objects;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;

public class StorageDeviceType {
    private String storageDeviceTypeID;
    private String storageDeviceTypeLabel;
    private String companyID;

    public StorageDeviceType() {
    }

    public StorageDeviceType(String storageDeviceTypeID, String storageDeviceTypeLabel, String companyID) {
        this.storageDeviceTypeID = storageDeviceTypeID;
        this.storageDeviceTypeLabel = storageDeviceTypeLabel;
        this.companyID = companyID;
    }

    public String getStorageDeviceTypeID() {
        return this.storageDeviceTypeID;
    }

    public void setStorageDeviceTypeID(String storageDeviceTypeID) {
        this.storageDeviceTypeID = storageDeviceTypeID;
    }

    public String getStorageDeviceTypeLabel() {
        return this.storageDeviceTypeLabel;
    }

    public void setStorageDeviceTypeLabel(String storageDeviceTypeLabel) {
        this.storageDeviceTypeLabel = storageDeviceTypeLabel;
    }

    public String getCompanyID() {
        return this.companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public StorageDeviceType storageDeviceTypeID(String storageDeviceTypeID) {
        this.storageDeviceTypeID = storageDeviceTypeID;
        return this;
    }

    public StorageDeviceType storageDeviceTypeLabel(String storageDeviceTypeLabel) {
        this.storageDeviceTypeLabel = storageDeviceTypeLabel;
        return this;
    }

    public StorageDeviceType companyID(String companyID) {
        this.companyID = companyID;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StorageDeviceType)) {
            return false;
        }
        StorageDeviceType storageDeviceType = (StorageDeviceType) o;
        return Objects.equals(storageDeviceTypeID, storageDeviceType.storageDeviceTypeID)
                && Objects.equals(storageDeviceTypeLabel, storageDeviceType.storageDeviceTypeLabel)
                && Objects.equals(companyID, storageDeviceType.companyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storageDeviceTypeID, storageDeviceTypeLabel, companyID);
    }

    @Override
    public String toString() {
        return "{" + " storageDeviceTypeID='" + getStorageDeviceTypeID() + "'" + ", storageDeviceTypeLabel='"
                + getStorageDeviceTypeLabel() + "'" + ", companyID='" + getCompanyID() + "'" + "}";
    }

    public String toJSONString() {
        return new JSONObject(this).toString();
    }

    public static StorageDeviceType fromJSONString(String json) {
        String parameterOne = new JSONObject(json).getString("storageDeviceTypeID");
        String parameterTwo = new JSONObject(json).getString("storageDeviceTypeLabel");
        String parameterThree = new JSONObject(json).getString("companyID");

        StorageDeviceType storagedevicetype = new StorageDeviceType(parameterOne, parameterTwo, parameterThree);

        return storagedevicetype;
    }

}
