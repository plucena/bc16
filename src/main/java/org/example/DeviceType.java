/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.util.Objects;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;

@DataType()
public class DeviceType {

    @Property()
    private String deviceTypeID;
    private String deviceTypeLabel;
    private String companyId;

    public DeviceType() {
    }

    public DeviceType(String deviceTypeID, String deviceTypeLabel, String companyId) {
        this.deviceTypeID = deviceTypeID;
        this.deviceTypeLabel = deviceTypeLabel;
        this.companyId = companyId;
    }

    public String getDeviceTypeID() {
        return this.deviceTypeID;
    }

    public void setDeviceTypeID(String deviceTypeID) {
        this.deviceTypeID = deviceTypeID;
    }

    public String getDeviceTypeLabel() {
        return this.deviceTypeLabel;
    }

    public void setDeviceTypeLabel(String deviceTypeLabel) {
        this.deviceTypeLabel = deviceTypeLabel;
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public DeviceType deviceTypeID(String deviceTypeID) {
        this.deviceTypeID = deviceTypeID;
        return this;
    }

    public DeviceType deviceTypeLabel(String deviceTypeLabel) {
        this.deviceTypeLabel = deviceTypeLabel;
        return this;
    }

    public DeviceType companyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DeviceType)) {
            return false;
        }
        DeviceType deviceType = (DeviceType) o;
        return Objects.equals(deviceTypeID, deviceType.deviceTypeID)
                && Objects.equals(deviceTypeLabel, deviceType.deviceTypeLabel)
                && Objects.equals(companyId, deviceType.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceTypeID, deviceTypeLabel, companyId);
    }

    @Override
    public String toString() {
        return "{" + " deviceTypeID='" + getDeviceTypeID() + "'" + ", deviceTypeLabel='" + getDeviceTypeLabel() + "'"
                + ", companyId='" + getCompanyId() + "'" + "}";
    }

    public String toJSONString() {
        return new JSONObject(this).toString();
    }

    public static DeviceType fromJSONString(String json) {
        String parameterOne = new JSONObject(json).getString("deviceTypeID");
        String parameterTwo = new JSONObject(json).getString("deviceTypeLabel");
        String parameterThree = new JSONObject(json).getString("companyID");

        DeviceType devicetype = new DeviceType(parameterOne, parameterTwo, parameterThree);

        return devicetype;
    }

}
