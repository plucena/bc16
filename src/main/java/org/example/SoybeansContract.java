/*
 * SPDX-License-Identifier: Apache-2.0
 */
package org.example;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.contract.annotation.Contact;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.License;
import static java.nio.charset.StandardCharsets.UTF_8;

@Contract(name = "SoybeansContract",
    info = @Info(title = "Soybeans contract",
                description = "My Smart Contract",
                version = "0.0.1",
                license =
                        @License(name = "Apache-2.0",
                                url = ""),
                                contact =  @Contact(email = "bc16@example.com",
                                                name = "bc16",
                                                url = "http://bc16.me")))
@Default
public class SoybeansContract implements ContractInterface {
    public  SoybeansContract() {

    }
    @Transaction()
    public boolean soybeansExists(Context ctx, String soybeansId) {
        byte[] buffer = ctx.getStub().getState(soybeansId);
        return (buffer != null && buffer.length > 0);
    }

    @Transaction()
    public void createSoybeans(Context ctx, String soybeansId, String farm, String harvest_date) {
        boolean exists = soybeansExists(ctx,soybeansId);
        if (exists) {
            throw new RuntimeException("The asset "+soybeansId+" already exists");
        }
        Soybeans asset = new Soybeans();
        asset.setFarm(farm);
        asset.setHarvest_date(harvest_date);
        ctx.getStub().putState(soybeansId, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public Soybeans readSoybeans(Context ctx, String soybeansId) {
        boolean exists = soybeansExists(ctx,soybeansId);
        if (!exists) {
            throw new RuntimeException("The asset "+soybeansId+" does not exist");
        }

        Soybeans newAsset = Soybeans.fromJSONString(new String(ctx.getStub().getState(soybeansId),UTF_8));
        return newAsset;
    }

    @Transaction()
    public void updateSoybeans(Context ctx, String soybeansId, String farm, String harvest_date) {
        boolean exists = soybeansExists(ctx,soybeansId);
        if (!exists) {
            throw new RuntimeException("The asset "+soybeansId+" does not exist");
        }
        Soybeans asset = new Soybeans();
        asset.setFarm(farm);
        asset.setHarvest_date(harvest_date);
     

        ctx.getStub().putState(soybeansId, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public void deleteSoybeans(Context ctx, String soybeansId) {
        boolean exists = soybeansExists(ctx,soybeansId);
        if (!exists) {
            throw new RuntimeException("The asset "+soybeansId+" does not exist");
        }
        ctx.getStub().delState(soybeansId);
    }

}
