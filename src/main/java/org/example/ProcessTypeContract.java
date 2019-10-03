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

@Contract(name = "ProcessTypeContract",
    info = @Info(title = "ProcessType contract",
                description = "My Smart Contract",
                version = "0.0.1",
                license =
                        @License(name = "Apache-2.0",
                                url = ""),
                                contact =  @Contact(email = "AgrichainNew@example.com",
                                                name = "AgrichainNew",
                                                url = "http://AgrichainNew.me")))
@Default
public class ProcessTypeContract implements ContractInterface {
    public  ProcessTypeContract() {

    }
    @Transaction()
    public boolean ProcessTypeExists(Context ctx, String ProcessTypeId) {
        byte[] buffer = ctx.getStub().getState(ProcessTypeId);
        return (buffer != null && buffer.length > 0);
    }

    @Transaction()
    public void createProcessType(Context ctx, String ProcessTypeId, String companyID, String languageKeyLabel) {
        boolean exists = ProcessTypeExists(ctx,ProcessTypeId);
        if (exists) {
            throw new RuntimeException("The asset "+ProcessTypeId+" already exists");
        }
        ProcessType asset = new ProcessType();

        asset.setProcessTypeID(ProcessTypeId);
        asset.setCompanyID(companyID);
        asset.setLanguageKeyLabel(languageKeyLabel);

        ctx.getStub().putState(ProcessTypeId, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public ProcessType readProcessType(Context ctx, String ProcessTypeId) {
        boolean exists = ProcessTypeExists(ctx,ProcessTypeId);
        if (!exists) {
            throw new RuntimeException("The asset "+ProcessTypeId+" does not exist");
        }

        ProcessType newAsset = ProcessType.fromJSONString(new String(ctx.getStub().getState(ProcessTypeId),UTF_8));
        return newAsset;
    }

    @Transaction()
    public void updateProcessType(Context ctx, String ProcessTypeId, String newProcessID, String newCompanyID, String newLanguageKeyLabel) {
        boolean exists = ProcessTypeExists(ctx,ProcessTypeId);
        if (!exists) {
            throw new RuntimeException("The asset "+ProcessTypeId+" does not exist");
        }
        ProcessType asset = new ProcessType();

        asset.setProcessTypeID(newProcessID);
        asset.setCompanyID(newCompanyID);
        asset.setLanguageKeyLabel(newLanguageKeyLabel);

        ctx.getStub().putState(ProcessTypeId, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public void deleteProcessType(Context ctx, String ProcessTypeId) {
        boolean exists = ProcessTypeExists(ctx,ProcessTypeId);
        if (!exists) {
            throw new RuntimeException("The asset "+ProcessTypeId+" does not exist");
        }
        ctx.getStub().delState(ProcessTypeId);
    }

}
