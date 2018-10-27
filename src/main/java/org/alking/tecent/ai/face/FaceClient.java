package org.alking.tecent.ai.face;

import org.alking.tecent.ai.domain.Resource;

import java.io.IOException;

public interface FaceClient {

    int FACE_DETECT_TYPE_NORMAL = 0;
    int FACE_DETECT_TYPE_BIG = 1;

    FaceDetectReply detect(Resource resource, int type) throws IOException;

    MultiFaceReply multiDetect(Resource resource) throws IOException;
}
