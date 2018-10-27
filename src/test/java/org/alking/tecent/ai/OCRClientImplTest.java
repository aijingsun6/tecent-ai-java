package org.alking.tecent.ai;

import org.alking.tecent.ai.domain.Image;
import org.alking.tecent.ai.impl.OKHttpClient;
import org.alking.tecent.ai.ocr.OCRClient;
import org.alking.tecent.ai.ocr.OCRClientImpl;
import org.alking.tecent.ai.ocr.OCRIDCardReply;
import org.alking.tecent.ai.ocr.OCRItemListReply;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class OCRClientImplTest extends BaseTest {

    private OCRClient client = new OCRClientImpl(APP_ID,APP_KEY,new OKHttpClient());

    public OCRClientImplTest(){
    }

    @Test
    public void testGeneralHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/gene_ocr_APPLE.png";
        Image image = new Image(Image.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.general(image);
        Assert.assertEquals(new Integer(0),reply.getRet());
        Assert.assertEquals(1,reply.getData().getItems().size());
        Assert.assertEquals("APPLE",reply.getData().getItems().get(0).getItemString());
    }

    @Test
    public void testIdCardHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_id_card.jpg";
        Image image = new Image(Image.RES_TYPE_HTTP,url);
        OCRIDCardReply reply = client.idCard(image,OCRClient.ID_CARD_TYPE_FRONT);
        Assert.assertEquals("440524198701010014",reply.getData().getId());
    }

    @Test
    public void testVehicleHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_vehicle.jpg";
        Image image = new Image(Image.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.vehicleLicense(image);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }

    @Test
    public void testDriveHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_drive.jpg";
        Image image = new Image(Image.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.driveLicense(image);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }

    @Test
    public void testBizHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_biz.jpg";
        Image image = new Image(Image.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.biz(image);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }

    @Test
    public void testBankCardHttp() throws  IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_bank_card.jpg";
        Image image = new Image(Image.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.bankCard(image);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }

    @Test
    public void testHandWriteHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_hand_write.jpg";
        Image image = new Image(Image.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.handWrite(image);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }

    @Test
    public void testCarPlateHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_car_plate.jpg";
        Image image = new Image(Image.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.carPlate(image);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }

    @Test
    public void testBCHttp() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/ocr_bc.jpg";
        Image image = new Image(Image.RES_TYPE_HTTP,url);
        OCRItemListReply reply = client.businessCard(image);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }
}
