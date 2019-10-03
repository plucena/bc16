/*
 * SPDX-License-Identifier: Apache-2.0
 */
package org.example;

import java.util.Date;
import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.contract.ContractInterface;
import org.hyperledger.fabric.contract.annotation.Contract;
import org.hyperledger.fabric.contract.annotation.Default;
import org.hyperledger.fabric.contract.annotation.Transaction;
import org.hyperledger.fabric.contract.annotation.Contact;
import org.hyperledger.fabric.contract.annotation.Info;
import org.hyperledger.fabric.contract.annotation.License;
import static java.nio.charset.StandardCharsets.UTF_8;

@Contract(name = "RecordContract", info = @Info(title = "Record contract", description = "My Smart Contract", version = "0.0.1", license = @License(name = "Apache-2.0", url = ""), contact = @Contact(email = "AgrichainNew@example.com", name = "AgrichainNew", url = "http://AgrichainNew.me")))
@Default
public class RecordContract implements ContractInterface {
    public RecordContract() {

    }

    @Transaction()
    public boolean RecordExists(Context ctx, String RecordId) {
        byte[] buffer = ctx.getStub().getState(RecordId);
        return (buffer != null && buffer.length > 0);
    }

    @Transaction()
    public void createRecord(Context ctx, String RecordId, String companyID, String seasonID, String processID,
            String personInChargeID, String storageDeviceOriginID, String sendDateTime, String recordDateTime) {
        boolean exists = RecordExists(ctx, RecordId);
        if (exists) {
            throw new RuntimeException("The asset " + RecordId + " already exists");
        }
        Record asset = new Record();

        asset.setRecordID(RecordId);
        asset.setCompanyID(companyID);
        asset.setSeasonID(seasonID);
        asset.setProcessID(processID);
        asset.setPersonInChargeID(personInChargeID);
        asset.storageDeviceOriginID(storageDeviceOriginID);
        asset.setSentDateTime(sendDateTime);
        asset.setRecordDateTime(recordDateTime);

        ctx.getStub().putState(RecordId, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public Record readRecord(Context ctx, String RecordId) {
        boolean exists = RecordExists(ctx, RecordId);
        if (!exists) {
            throw new RuntimeException("The asset " + RecordId + " does not exist");
        }

        Record newAsset = Record.fromJSONString(new String(ctx.getStub().getState(RecordId), UTF_8));
        return newAsset;
    }

    @Transaction()
    public void updateRecord(Context ctx, String RecordId, String companyID, String seasonID, String processID,
            String personInChargeID, String storageDeviceOriginID, String sendDateTime, String recordDateTime) {
        boolean exists = RecordExists(ctx, RecordId);
        if (!exists) {
            throw new RuntimeException("The asset " + RecordId + " does not exist");
        }
        Record asset = new Record();

        asset.setRecordID(RecordId);
        asset.setCompanyID(companyID);
        asset.setSeasonID(seasonID);
        asset.setProcessID(processID);
        asset.setPersonInChargeID(personInChargeID);
        asset.storageDeviceOriginID(storageDeviceOriginID);
        asset.setSentDateTime(sendDateTime);
        asset.setRecordDateTime(recordDateTime);

        ctx.getStub().putState(RecordId, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public void deleteRecord(Context ctx, String RecordId) {
        boolean exists = RecordExists(ctx, RecordId);
        if (!exists) {
            throw new RuntimeException("The asset " + RecordId + " does not exist");
        }
        ctx.getStub().delState(RecordId);
    }

}
