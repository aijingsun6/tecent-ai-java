package org.alking.tecent.ai.ocr;

import org.alking.tecent.ai.BaseTest;
import org.alking.tecent.ai.domain.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class OCRClientImplTest extends BaseTest {

    private OCRClient client = new OCRClientImpl(APP_ID,APP_KEY);

    public OCRClientImplTest(){
    }

    @Test
    public void testGeneralHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/gene_ocr_APPLE.png";
        Resource resource = new Resource(Resource.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.general(resource);
        Assert.assertEquals(new Integer(0),reply.getRet());
        Assert.assertEquals(1,reply.getData().getItems().size());
        Assert.assertEquals("APPLE",reply.getData().getItems().get(0).getItemString());
    }

    @Test
    public void testIdCardHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_id_card.jpg";
        Resource resource = new Resource(Resource.RES_TYPE_HTTP,url);
        OCRIDCardReply reply = client.idCard(resource,OCRClient.ID_CARD_TYPE_FRONT);
        Assert.assertEquals("440524198701010014",reply.getData().getId());
    }

    @Test
    public void testVehicleHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_vehicle.jpg";
        Resource resource = new Resource(Resource.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.vehicleLicense(resource);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }

    @Test
    public void testDriveHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_drive.jpg";
        Resource resource = new Resource(Resource.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.driveLicense(resource);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }

    @Test
    public void testBizHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_biz.jpg";
        Resource resource = new Resource(Resource.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.biz(resource);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }

    @Test
    public void testBankCardHttp() throws  IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_bank_card.jpg";
        Resource resource = new Resource(Resource.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.bankCard(resource);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }

    @Test
    public void testHandWriteHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_hand_write.jpg";
        Resource resource = new Resource(Resource.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.handWrite(resource);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }

    @Test
    public void testCarPlateHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_car_plate.jpg";
        Resource resource = new Resource(Resource.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.carPlate(resource);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }
}
