/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

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


    public Image(String storageDeviceImageID, String storageDeviceID, String s3ImageURL, String s3ImageSHASum){
    }

  
    public String toJSONString() {
        return new JSONObject(this).toString();
    }

    
}
