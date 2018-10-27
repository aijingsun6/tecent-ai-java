package org.alking.tecent.ai.face.identify;

import org.alking.tecent.ai.domain.Image;

import java.io.IOException;
import java.util.List;

public interface FaceIdentifyClient {

    FaceIdentifyReply identify(Image res, String groupId, int topN) throws IOException;

    FaceInfoReply info(String faceId) throws IOException;

    FacePersonNewReply personNew(Image image, List<String> groups, String personId, String personName, String tag) throws IOException;
}
