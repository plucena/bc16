/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import java.util.Objects;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;

@DataType()
public class Image {

    @Property()
    private String storageDeviceImageID;
    private String storageDeviceID;
    private String s3ImageURL;
    private String s3ImageSHASum;

    public Image() {
    }

    public Image(String storageDeviceImageID, String storageDeviceID, String s3ImageURL, String s3ImageSHASum) {
        this.storageDeviceImageID = storageDeviceImageID;
        this.storageDeviceID = storageDeviceID;
        this.s3ImageURL = s3ImageURL;
        this.s3ImageSHASum = s3ImageSHASum;
    }

    public String getStorageDeviceImageID() {
        return this.storageDeviceImageID;
    }

    public void setStorageDeviceImageID(String storageDeviceImageID) {
        this.storageDeviceImageID = storageDeviceImageID;
    }

    public String getStorageDeviceID() {
        return this.storageDeviceID;
    }

    public void setStorageDeviceID(String storageDeviceID) {
        this.storageDeviceID = storageDeviceID;
    }

    public String getS3ImageURL() {
        return this.s3ImageURL;
    }

    public void setS3ImageURL(String s3ImageURL) {
        this.s3ImageURL = s3ImageURL;
    }

    public String getS3ImageSHASum() {
        return this.s3ImageSHASum;
    }

    public void setS3ImageSHASum(String s3ImageSHASum) {
        this.s3ImageSHASum = s3ImageSHASum;
    }

    public Image storageDeviceImageID(String storageDeviceImageID) {
        this.storageDeviceImageID = storageDeviceImageID;
        return this;
    }

    public Image storageDeviceID(String storageDeviceID) {
        this.storageDeviceID = storageDeviceID;
        return this;
    }

    public Image s3ImageURL(String s3ImageURL) {
        this.s3ImageURL = s3ImageURL;
        return this;
    }

    public Image s3ImageSHASum(String s3ImageSHASum) {
        this.s3ImageSHASum = s3ImageSHASum;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Image)) {
            return false;
        }
        Image image = (Image) o;
        return Objects.equals(storageDeviceImageID, image.storageDeviceImageID)
                && Objects.equals(storageDeviceID, image.storageDeviceID)
                && Objects.equals(s3ImageURL, image.s3ImageURL) && Objects.equals(s3ImageSHASum, image.s3ImageSHASum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storageDeviceImageID, storageDeviceID, s3ImageURL, s3ImageSHASum);
    }

    @Override
    public String toString() {
        return "{" + " storageDeviceImageID='" + getStorageDeviceImageID() + "'" + ", storageDeviceID='"
                + getStorageDeviceID() + "'" + ", s3ImageURL='" + getS3ImageURL() + "'" + ", s3ImageSHASum='"
                + getS3ImageSHASum() + "'" + "}";
    }

    public String toJSONString() {
        return new JSONObject(this).toString();
    }

    public static Image fromJSONString(String json) {
        String parameterOne = new JSONObject(json).getString("storageDeviceImageID");
        String parameterTwo = new JSONObject(json).getString("storageDeviceID");
        String parameterThree = new JSONObject(json).getString("s3ImageURL");
        String parameterFour = new JSONObject(json).getString("s3ImageSHASum");

        Image image = new Image(parameterOne, parameterTwo, parameterThree, parameterFour);

        return image;
    }

}
