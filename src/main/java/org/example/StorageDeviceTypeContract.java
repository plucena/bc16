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

@Contract(name = "StorageDeviceTypeContract",
    info = @Info(title = "StorageDeviceType contract",
                description = "My Smart Contract",
                version = "0.0.1",
                license =
                        @License(name = "Apache-2.0",
                                url = ""),
                                contact =  @Contact(email = "AgrichainNew@example.com",
                                                name = "AgrichainNew",
                                                url = "http://AgrichainNew.me")))
@Default
public class StorageDeviceTypeContract implements ContractInterface {
    public  StorageDeviceTypeContract() {

    }
    @Transaction()
    public boolean StorageDeviceTypeExists(Context ctx, String StorageDeviceTypeId) {
        byte[] buffer = ctx.getStub().getState(StorageDeviceTypeId);
        return (buffer != null && buffer.length > 0);
    }

    @Transaction()
    public void createStorageDeviceType(Context ctx, String StorageDeviceTypeId, String storageDeviceTypeLabel, String companyID) {
        boolean exists = StorageDeviceTypeExists(ctx,StorageDeviceTypeId);
        if (exists) {
            throw new RuntimeException("The asset "+StorageDeviceTypeId+" already exists");
        }
        StorageDeviceType asset = new StorageDeviceType();

        asset.setStorageDeviceTypeID(StorageDeviceTypeId);
        asset.setStorageDeviceTypeLabel(storageDeviceTypeLabel);
        asset.setCompanyID(companyID);

        ctx.getStub().putState(StorageDeviceTypeId, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public StorageDeviceType readStorageDeviceType(Context ctx, String StorageDeviceTypeId) {
        boolean exists = StorageDeviceTypeExists(ctx,StorageDeviceTypeId);
        if (!exists) {
            throw new RuntimeException("The asset "+StorageDeviceTypeId+" does not exist");
        }

        StorageDeviceType newAsset = StorageDeviceType.fromJSONString(new String(ctx.getStub().getState(StorageDeviceTypeId),UTF_8));
        return newAsset;
    }

    @Transaction()
    public void updateStorageDeviceType(Context ctx, String StorageDeviceTypeId, String storageDeviceTypeLabel, String companyID) {
        boolean exists = StorageDeviceTypeExists(ctx,StorageDeviceTypeId);
        if (!exists) {
            throw new RuntimeException("The asset "+StorageDeviceTypeId+" does not exist");
        }
        StorageDeviceType asset = new StorageDeviceType();

        asset.setStorageDeviceTypeID(StorageDeviceTypeId);
        asset.setStorageDeviceTypeLabel(storageDeviceTypeLabel);
        asset.setCompanyID(companyID);

        ctx.getStub().putState(StorageDeviceTypeId, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public void deleteStorageDeviceType(Context ctx, String StorageDeviceTypeId) {
        boolean exists = StorageDeviceTypeExists(ctx,StorageDeviceTypeId);
        if (!exists) {
            throw new RuntimeException("The asset "+StorageDeviceTypeId+" does not exist");
        }
        ctx.getStub().delState(StorageDeviceTypeId);
    }

}
