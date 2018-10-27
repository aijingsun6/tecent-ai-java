package org.alking.tecent.ai;


import org.alking.tecent.ai.face.identify.FaceGroupIdsReply;
import org.alking.tecent.ai.face.identify.FaceIdentifyClientImpl;
import org.alking.tecent.ai.impl.OKHttpClient;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FaceIdentifyClientImplTest extends BaseTest {

    private final FaceIdentifyClientImpl client = new FaceIdentifyClientImpl(APP_ID,APP_KEY,new OKHttpClient());

    @Test
    public void testGroupIds() throws IOException {
        FaceGroupIdsReply reply = client.groupIds();
        Assert.assertEquals(new Integer(0), reply.getRet());
    }
}
