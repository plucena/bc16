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

@Contract(name = "ImageContract",
    info = @Info(title = "Image contract",
                description = "My Smart Contract",
                version = "0.0.1",
                license =
                        @License(name = "Apache-2.0",
                                url = ""),
                                contact =  @Contact(email = "AgrichainNew@example.com",
                                                name = "AgrichainNew",
                                                url = "http://AgrichainNew.me")))
@Default
public class ImageContract implements ContractInterface {
    public  ImageContract() {

    }
    @Transaction()
    public boolean ImageExists(Context ctx, String ImageId) {
        byte[] buffer = ctx.getStub().getState(ImageId);
        return (buffer != null && buffer.length > 0);
    }

    @Transaction()
    public void createImage(Context ctx, String storageDeviceImageID, String storageDeviceID, String s3ImageURL, String s3ImageSHASum) {
        boolean exists = ImageExists(ctx,storageDeviceImageID);
        if (exists) {
            throw new RuntimeException("The asset "+storageDeviceImageID+" already exists");
        }
        Image asset = new Image();

        asset.setStorageDeviceImageID(storageDeviceImageID);
        asset.setStorageDeviceID(storageDeviceID);
        asset.setS3ImageURL(s3ImageURL);
        asset.setS3ImageSHASum(s3ImageSHASum);
        
        ctx.getStub().putState(storageDeviceImageID, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public Image readImage(Context ctx, String ImageId) {
        boolean exists = ImageExists(ctx,ImageId);
        if (!exists) {
            throw new RuntimeException("The asset "+ImageId+" does not exist");
        }

        Image newAsset = Image.fromJSONString(new String(ctx.getStub().getState(ImageId),UTF_8));
        return newAsset;
    }

    @Transaction()
    public void updateImage(Context ctx, String storageDeviceImageID, String storageDeviceID, String s3ImageURL, String s3ImageSHASum) {
        boolean exists = ImageExists(ctx,storageDeviceImageID);
        if (!exists) {
            throw new RuntimeException("The asset "+storageDeviceImageID+" does not exist");
        }
        Image asset = new Image();

        asset.setStorageDeviceImageID(storageDeviceImageID);
        asset.setStorageDeviceID(storageDeviceID);
        asset.setS3ImageURL(s3ImageURL);
        asset.setS3ImageSHASum(s3ImageSHASum);
        

        ctx.getStub().putState(storageDeviceImageID, asset.toJSONString().getBytes(UTF_8));
    }

    @Transaction()
    public void deleteImage(Context ctx, String ImageId) {
        boolean exists = ImageExists(ctx,ImageId);
        if (!exists) {
            throw new RuntimeException("The asset "+ImageId+" does not exist");
        }
        ctx.getStub().delState(ImageId);
    }

}
