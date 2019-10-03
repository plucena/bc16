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

@Contract(name = "SeasonContract",
    info = @Info(title = "Season contract",
                description = "My Smart Contract",
                version = "0.0.1",
                license =
                        @License(name = "Apache-2.0",
                                url = ""),
                                contact =  @Contact(email = "AgrichainNew@example.com",
                                                name = "AgrichainNew",
                                                url = "http://AgrichainNew.me")))
@Default
public class SeasonContract implements ContractInterface {
    public  SeasonContract() {

    }
    @Transaction()
    public boolean SeasonExists(Context ctx, String SeasonId) {
        byte[] buffer = ctx.getStub().getState(SeasonId);
        return (buffer != null && buffer.length > 0);
    }

    @Transaction()
    public void createSeason(Context ctx, String seasonID, String companyID, String personInChargeID, String sentDateTime, String cordDateTime, String soybeanValue) {
        boolean exists = SeasonExists(ctx,seasonID);
        if (exists) {
            throw new RuntimeException("The asset "+seasonID+" already exists");
        }
        Season asset = new Season();

        asset.setSeasonID(seasonID);
        asset.setCompanyID(companyID);
        asset.setSentDateTime(sentDateTime);
        asset.setCordDateTime(cordDateTime);

        Soybeans soja = new Soybeans();
        soja.setValue(soybeanValue);
        asset.setSoybean(soja);

        ctx.getStub().putState(seasonID, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public Season readSeason(Context ctx, String SeasonId) {
        boolean exists = SeasonExists(ctx,SeasonId);
        if (!exists) {
            throw new RuntimeException("The asset "+SeasonId+" does not exist");
        }

        Season newAsset = Season.fromJSONString(new String(ctx.getStub().getState(SeasonId),UTF_8));
        return newAsset;
    }

    @Transaction()
    public void updateSeason(Context ctx, String seasonID, String companyID, String personInChargeID, String sentDateTime, String cordDateTime, String soybeanValue) {
        boolean exists = SeasonExists(ctx, seasonID);
        if (!exists) {
            throw new RuntimeException("The asset "+seasonID+" does not exist");
        }
        Season asset = new Season();

        asset.setSeasonID(seasonID);
        asset.setCompanyID(companyID);
        asset.setSentDateTime(sentDateTime);
        asset.setCordDateTime(cordDateTime);

        Soybeans soja = new Soybeans();
        soja.setValue(soybeanValue);
        asset.setSoybean(soja);
        

        ctx.getStub().putState(seasonID, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public void deleteSeason(Context ctx, String SeasonId) {
        boolean exists = SeasonExists(ctx,SeasonId);
        if (!exists) {
            throw new RuntimeException("The asset "+SeasonId+" does not exist");
        }
        ctx.getStub().delState(SeasonId);
    }

}
