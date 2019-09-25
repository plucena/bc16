/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.util.Objects;
import org.hyperledger.fabric.contract.annotation.Property;


@DataType()
public class StorageDevice {

    @Property()
    private String storageDeviceID;
    private String storageDeviceTypeID;
    private String latitude;
    private String longitude;
    private String label;
    private String controlKey;
    private String controlValue;
    private String seal;


    public StorageDevice() {
    }

    public StorageDevice(String storageDeviceID, String storageDeviceTypeID, String latitude, String longitude, String label, String controlKey, String controlValue, String seal) {
        this.storageDeviceID = storageDeviceID;
        this.storageDeviceTypeID = storageDeviceTypeID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.label = label;
        this.controlKey = controlKey;
        this.controlValue = controlValue;
        this.seal = seal;
    }

    public String getStorageDeviceID() {
        return this.storageDeviceID;
    }

    public void setStorageDeviceID(String storageDeviceID) {
        this.storageDeviceID = storageDeviceID;
    }

    public String getStorageDeviceTypeID() {
        return this.storageDeviceTypeID;
    }

    public void setStorageDeviceTypeID(String storageDeviceTypeID) {
        this.storageDeviceTypeID = storageDeviceTypeID;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getControlKey() {
        return this.controlKey;
    }

    public void setControlKey(String controlKey) {
        this.controlKey = controlKey;
    }

    public String getControlValue() {
        return this.controlValue;
    }

    public void setControlValue(String controlValue) {
        this.controlValue = controlValue;
    }

    public String getSeal() {
        return this.seal;
    }

    public void setSeal(String seal) {
        this.seal = seal;
    }

    public StorageDevice storageDeviceID(String storageDeviceID) {
        this.storageDeviceID = storageDeviceID;
        return this;
    }

    public StorageDevice storageDeviceTypeID(String storageDeviceTypeID) {
        this.storageDeviceTypeID = storageDeviceTypeID;
        return this;
    }

    public StorageDevice latitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public StorageDevice longitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public StorageDevice label(String label) {
        this.label = label;
        return this;
    }

    public StorageDevice controlKey(String controlKey) {
        this.controlKey = controlKey;
        return this;
    }

    public StorageDevice controlValue(String controlValue) {
        this.controlValue = controlValue;
        return this;
    }

    public StorageDevice seal(String seal) {
        this.seal = seal;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StorageDevice)) {
            return false;
        }
        StorageDevice storageDevice = (StorageDevice) o;
        return Objects.equals(storageDeviceID, storageDevice.storageDeviceID) && Objects.equals(storageDeviceTypeID, storageDevice.storageDeviceTypeID) && Objects.equals(latitude, storageDevice.latitude) && Objects.equals(longitude, storageDevice.longitude) && Objects.equals(label, storageDevice.label) && Objects.equals(controlKey, storageDevice.controlKey) && Objects.equals(controlValue, storageDevice.controlValue) && Objects.equals(seal, storageDevice.seal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storageDeviceID, storageDeviceTypeID, latitude, longitude, label, controlKey, controlValue, seal);
    }

    @Override
    public String toString() {
        return "{" +
            " storageDeviceID='" + getStorageDeviceID() + "'" +
            ", storageDeviceTypeID='" + getStorageDeviceTypeID() + "'" +
            ", latitude='" + getLatitude() + "'" +
            ", longitude='" + getLongitude() + "'" +
            ", label='" + getLabel() + "'" +
            ", controlKey='" + getControlKey() + "'" +
            ", controlValue='" + getControlValue() + "'" +
            ", seal='" + getSeal() + "'" +
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
