package org.alking.tecent.ai;

import org.alking.tecent.ai.domain.Resource;
import org.alking.tecent.ai.face.*;
import org.alking.tecent.ai.impl.OKHttpClient;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FaceClientImplTest extends BaseTest {

    private final FaceClientImpl client = new FaceClientImpl(APP_ID,APP_KEY,new OKHttpClient());

    @Test
    public void testFaceDetect() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/face_detect.jpg";
        Resource resource = new Resource(Resource.RES_TYPE_HTTP,url);
        FaceDetectReply reply = client.detect(resource,FaceClient.FACE_MODE_BIG);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }

    @Test
    public void testMultiFaceDetect() throws IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/multiface.jpg";
        Resource resource = new Resource(Resource.RES_TYPE_HTTP,url);
        FaceMultiReply reply = client.multiDetect(resource);
        Assert.assertEquals(new Integer(0),reply.getRet());
        Assert.assertEquals(4, reply.getData().getFaces().size());
    }

    @Test
    public void testCrossAgeDetect() throws IOException {
        final String sourceUrl = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/face_crossage_source.jpg";
        final Resource sourceRes = new Resource(Resource.RES_TYPE_HTTP,sourceUrl);

        final String targetUrl = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/face_crossage_target.jpg";
        final Resource targetRes = new Resource(Resource.RES_TYPE_HTTP,targetUrl);
        FaceCrossAgeReply reply = client.crossAge(sourceRes,targetRes);
        Assert.assertEquals(new Integer(0),reply.getRet());

    }

    @Test
    public void testShape() throws  IOException {
        String url = "https://raw.githubusercontent.com/aijingsun6/tecent-ai-java/master/doc/face_detect.jpg";
        Resource resource = new Resource(Resource.RES_TYPE_HTTP,url);
        FaceShapeReply reply = client.shape(resource,FaceClient.FACE_MODE_BIG);
        Assert.assertEquals(new Integer(0),reply.getRet());
    }
}
