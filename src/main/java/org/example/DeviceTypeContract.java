/*
 * SPDX-License-Identifier: Apache-2.0
 */
package org.example;



import java.util.Date;
import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contact;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.License;
import org.hyperledger.fabric.contract.annotation.Transaction;
import static java.nio.charset.StandardCharsets.UTF_8;

@Contract(name = "DeviceTypeContract",
    info = @Info(title = "DeviceType contract",
                description = "My Smart Contract",
                version = "0.0.1",
                license =
                        @License(name = "Apache-2.0",
                                url = ""),
                                contact =  @Contact(email = "AgrichainNew@example.com",
                                                name = "AgrichainNew",
                                                url = "http://AgrichainNew.me")))
@Default
public class DeviceTypeContract implements ContractInterface {
    public  DeviceTypeContract() {

    }
    @Transaction()
    public boolean DeviceTypeExists(Context ctx, String DeviceTypeId) {
        byte[] buffer = ctx.getStub().getState(DeviceTypeId);
        return (buffer != null && buffer.length > 0);
    }

    @Transaction()
    public void createDeviceType(Context ctx, String deviceTypeID, String deviceTypeLabel, String companyId) {
        boolean exists = DeviceTypeExists(ctx,deviceTypeID);
        if (exists) {
            throw new RuntimeException("The asset "+deviceTypeID+" already exists");
        }
        DeviceType asset = new DeviceType();

        asset.setDeviceTypeID(deviceTypeID);
        asset.setDeviceTypeLabel(deviceTypeLabel);
        asset.setCompanyId(companyId);
        
        ctx.getStub().putState(deviceTypeID, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public DeviceType readDeviceType(Context ctx, String DeviceTypeId) {
        boolean exists = DeviceTypeExists(ctx,DeviceTypeId);
        if (!exists) {
            throw new RuntimeException("The asset "+DeviceTypeId+" does not exist");
        }

        DeviceType newAsset = DeviceType.fromJSONString(new String(ctx.getStub().getState(DeviceTypeId),UTF_8));
        return newAsset;
    }

    @Transaction()
    public void updateDeviceType(Context ctx, String deviceTypeID, String deviceTypeLabel, String companyId) {
        boolean exists = DeviceTypeExists(ctx, deviceTypeID);
        if (!exists) {
            throw new RuntimeException("The asset "+deviceTypeID+" does not exist");
        }
        DeviceType asset = new DeviceType();

        asset.setDeviceTypeID(deviceTypeID);
        asset.setDeviceTypeLabel(deviceTypeLabel);
        asset.setCompanyId(companyId);
        
        ctx.getStub().putState(deviceTypeID, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public void deleteDeviceType(Context ctx, String DeviceTypeId) {
        boolean exists = DeviceTypeExists(ctx,DeviceTypeId);
        if (!exists) {
            throw new RuntimeException("The asset "+DeviceTypeId+" does not exist");
        }
        ctx.getStub().delState(DeviceTypeId);
    }

}
