/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.example;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;
import org.json.JSONObject;


@DataType()
public class Soybeans {

    @Property()
    private String farm;

    @Property()
    private String harvest_date;

    public Soybeans(){
    }

    public String getHarvest_date() {
        return harvest_date;
    }

    public void setHarvest_date(String harvest_date) {
        this.harvest_date = harvest_date;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public String toJSONString() {
        return new JSONObject(this).toString();
    }

    public static Soybeans fromJSONString(String json) {
        String farm = new JSONObject(json).getString("farm");
        String harvest_date = new JSONObject(json).getString("harvest_date");
        Soybeans asset = new Soybeans();
        asset.setFarm(farm);
        asset.setHarvest_date(harvest_date);
        return asset;
    }
}
