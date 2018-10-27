package org.alking.tecent.ai.face;

import org.alking.tecent.ai.domain.Resource;

import java.io.IOException;

public interface FaceClient {

    int FACE_MODE_NORMAL = 0;

    int FACE_MODE_BIG = 1;

    FaceDetectReply detect(Resource resource, int mode) throws IOException;

    FaceMultiReply multiDetect(Resource resource) throws IOException;

    FaceCrossAgeReply crossAge(Resource resource, Resource target) throws IOException;

    FaceShapeReply shape(Resource resource, int mode) throws IOException;

    FaceCompareReply compare(Resource a, Resource b) throws IOException;

    FaceIdentifyReply identify(Resource res, String groupId, int topN) throws IOException;
}
