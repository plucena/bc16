/*
 * SPDX-License-Identifier: Apache License 2.0
 */

package org.example;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.charset.StandardCharsets;

import org.hyperledger.fabric.contract.Context;
import org.hyperledger.fabric.shim.ChaincodeStub;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public final class ImageContractTest {

    @Nested
    class AssetExists {
        @Test
        public void noProperAsset() {

            ImageContract contract = new  ImageContract();
            Context ctx = mock(Context.class);
            ChaincodeStub stub = mock(ChaincodeStub.class);
            when(ctx.getStub()).thenReturn(stub);

            when(stub.getState("10001")).thenReturn(new byte[] {});
            boolean result = contract.ImageExists(ctx,"10001");

            assertFalse(result);
        }

        @Test
        public void assetExists() {

            ImageContract contract = new  ImageContract();
            Context ctx = mock(Context.class);
            ChaincodeStub stub = mock(ChaincodeStub.class);
            when(ctx.getStub()).thenReturn(stub);

            when(stub.getState("10001")).thenReturn(new byte[] {42});
            boolean result = contract.ImageExists(ctx,"10001");

            assertTrue(result);

        }

        @Test
        public void noKey() {
            ImageContract contract = new  ImageContract();
            Context ctx = mock(Context.class);
            ChaincodeStub stub = mock(ChaincodeStub.class);
            when(ctx.getStub()).thenReturn(stub);

            when(stub.getState("10002")).thenReturn(null);
            boolean result = contract.ImageExists(ctx,"10002");

            assertFalse(result);

        }

    }

    @Nested
    class AssetCreates {

        /* @Test
        public void newAssetCreate() {
            ImageContract contract = new  ImageContract();
            Context ctx = mock(Context.class);
            ChaincodeStub stub = mock(ChaincodeStub.class);
            when(ctx.getStub()).thenReturn(stub);

            String json = "{\"value\":\"TheImage\"}";

            contract.createImage(ctx, "10001", "100001", "https://example.image.com", "7629aab780");

            verify(stub).putState("10001", json.getBytes(UTF_8));
        }
 */
        @Test
        public void alreadyExists() {
            ImageContract contract = new  ImageContract();
            Context ctx = mock(Context.class);
            ChaincodeStub stub = mock(ChaincodeStub.class);
            when(ctx.getStub()).thenReturn(stub);

            when(stub.getState("10002")).thenReturn(new byte[] { 42 });

            Exception thrown = assertThrows(RuntimeException.class, () -> {
                contract.createImage(ctx, "10002", "100002", "https://example2.image.com", "27812acdd09");
            });

            assertEquals(thrown.getMessage(), "The asset 10002 already exists");

        }

    }

    @Test
    public void assetRead() {
        ImageContract contract = new  ImageContract();
        Context ctx = mock(Context.class);
        ChaincodeStub stub = mock(ChaincodeStub.class);
        when(ctx.getStub()).thenReturn(stub);

        Image asset = new  Image("1111", "100001", "https://example.image.com", "7629aab780" );
        

        String json = asset.toJSONString();
        when(stub.getState("10001")).thenReturn(json.getBytes(StandardCharsets.UTF_8));

        Image returnedAsset = contract.readImage(ctx, "10001");

        assertEquals(returnedAsset.getS3ImageSHASum(), asset.getS3ImageSHASum());
        assertEquals(returnedAsset.getS3ImageURL(), asset.getS3ImageURL());
        assertEquals(returnedAsset.getStorageDeviceID(), asset.getStorageDeviceID());
    }

    @Nested
    class AssetUpdates {
        /* @Test
        public void updateExisting() {
            ImageContract contract = new  ImageContract();
            Context ctx = mock(Context.class);
            ChaincodeStub stub = mock(ChaincodeStub.class);
            when(ctx.getStub()).thenReturn(stub);
            when(stub.getState("10001")).thenReturn(new byte[] { 42 });

            contract.updateImage(ctx, "10001", "789000", "https://alteredimage.example.com", "729cc3445df");

            String json = "{\"value\":\"updates\"}";
            verify(stub).putState("10001", json.getBytes(UTF_8));
        } */

        @Test
        public void updateMissing() {
            ImageContract contract = new  ImageContract();
            Context ctx = mock(Context.class);
            ChaincodeStub stub = mock(ChaincodeStub.class);
            when(ctx.getStub()).thenReturn(stub);

            when(stub.getState("10001")).thenReturn(null);

            Exception thrown = assertThrows(RuntimeException.class, () -> {
                contract.updateImage(ctx, "10001", "736127", "https://alteredimage.example.com", "729cc3445df");
            });

            assertEquals(thrown.getMessage(), "The asset 10001 does not exist");
        }

    }

    @Test
    public void assetDelete() {
        ImageContract contract = new  ImageContract();
        Context ctx = mock(Context.class);
        ChaincodeStub stub = mock(ChaincodeStub.class);
        when(ctx.getStub()).thenReturn(stub);
        when(stub.getState("10001")).thenReturn(null);

        Exception thrown = assertThrows(RuntimeException.class, () -> {
            contract.deleteImage(ctx, "10001");
        });

        assertEquals(thrown.getMessage(), "The asset 10001 does not exist");
    }

}
