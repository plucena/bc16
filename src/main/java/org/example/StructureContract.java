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

@Contract(name = "StructureContract",
    info = @Info(title = "Structure contract",
                description = "My Smart Contract",
                version = "0.0.1",
                license =
                        @License(name = "Apache-2.0",
                                url = ""),
                                contact =  @Contact(email = "AgrichainNew@example.com",
                                                name = "AgrichainNew",
                                                url = "http://AgrichainNew.me")))
@Default
public class StructureContract implements ContractInterface {
    public  StructureContract() {

    }
    @Transaction()
    public boolean StructureExists(Context ctx, String StructureId) {
        byte[] buffer = ctx.getStub().getState(StructureId);
        return (buffer != null && buffer.length > 0);
    }

    @Transaction()
    public void createStructure(Context ctx, String StructureId, String processID, String structureKey, String structureType) {
        boolean exists = StructureExists(ctx,StructureId);
        if (exists) {
            throw new RuntimeException("The asset "+StructureId+" already exists");
        }
        Structure asset = new Structure();

        asset.setProcessID(processID);
        asset.setStructureID(StructureId);
        asset.structureKey(structureKey);
        asset.setStructureType(structureType);

        ctx.getStub().putState(StructureId, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public Structure readStructure(Context ctx, String StructureId) {
        boolean exists = StructureExists(ctx,StructureId);
        if (!exists) {
            throw new RuntimeException("The asset "+StructureId+" does not exist");
        }

        Structure newAsset = Structure.fromJSONString(new String(ctx.getStub().getState(StructureId),UTF_8));
        return newAsset;
    }

    @Transaction()
    public void updateStructure(Context ctx, String StructureId, String processID, String structureKey, String structureType) {
        boolean exists = StructureExists(ctx,StructureId);
        if (!exists) {
            throw new RuntimeException("The asset "+StructureId+" does not exist");
        }
        Structure asset = new Structure();
        
        asset.setProcessID(processID);
        asset.setStructureID(StructureId);
        asset.structureKey(structureKey);
        asset.setStructureType(structureType);

        ctx.getStub().putState(StructureId, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public void deleteStructure(Context ctx, String StructureId) {
        boolean exists = StructureExists(ctx,StructureId);
        if (!exists) {
            throw new RuntimeException("The asset "+StructureId+" does not exist");
        }
        ctx.getStub().delState(StructureId);
    }

}
