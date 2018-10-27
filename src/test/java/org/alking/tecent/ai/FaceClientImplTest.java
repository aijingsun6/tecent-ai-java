package org.alking.tecent.ai;

import org.alking.tecent.ai.domain.Image;
import org.alking.tecent.ai.face.*;
import org.alking.tecent.ai.face.identify.FaceIdentifyReply;
import org.alking.tecent.ai.impl.OKHttpClient;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class FaceClientImplTest extends BaseTest {

    private final FaceClientImpl client = new FaceClientImpl(APP_ID,APP_KEY,new OKHttpClient());

    private final String DEF_GROUP = "group-def";

    private final String DEF_PERSON_ID = "person-id-def";

    private final String DEF_PERSON_NAME = "person-name-def";

    private final String DEF_IMAGE_URL = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/face_detect.jpg";

    private final Image DEF_IMAGE = new Image(Image.RES_TYPE_HTTP,DEF_IMAGE_URL);

    @Test
    public void testFaceDetect() throws IOException {
        FaceDetectReply reply = client.detect(DEF_IMAGE,FaceClient.FACE_MODE_BIG);
        Assert.assertEquals(new Integer(0),reply.getRet());
        Assert.assertEquals(1,reply.getData().getFaces().size());
    }

    @Test
    public void testMultiFaceDetect() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/multiface.jpg";
        Image image = new Image(Image.RES_TYPE_HTTP,url);
        FaceMultiReply reply = client.multiDetect(image);
        Assert.assertEquals(new Integer(0),reply.getRet());
        Assert.assertEquals(4, reply.getData().getFaces().size());
    }

    @Test
    public void testCrossAgeDetect() throws IOException {
        final String sourceUrl = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/face_crossage_source.jpg";
        final Image sourceRes = new Image(Image.RES_TYPE_HTTP,sourceUrl);

        final String targetUrl = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/face_crossage_target.jpg";
        final Image targetRes = new Image(Image.RES_TYPE_HTTP,targetUrl);
        FaceCrossAgeReply reply = client.crossAge(sourceRes,targetRes);
        Assert.assertEquals(new Integer(0),reply.getRet());

    }

    @Test
    public void testShape() throws  IOException {
        FaceShapeReply reply = client.shape(DEF_IMAGE,FaceClient.FACE_MODE_BIG);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }

    @Test
    public void testCompare() throws IOException {
        final Image a = new Image(Image.RES_TYPE_HTTP,"https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/face_compare_a.jpg");
        final Image b = new Image(Image.RES_TYPE_HTTP,"https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/face_compare_b.jpg");
        FaceCompareReply reply = client.compare(a,b);
        Assert.assertEquals(new Integer(0),reply.getRet());
        Assert.assertEquals(4.0f,reply.getData().getSimilarity(),0.01f);
    }
}
