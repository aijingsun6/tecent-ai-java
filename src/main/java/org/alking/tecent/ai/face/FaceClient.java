package org.alking.tecent.ai.face;

import org.alking.tecent.ai.domain.Image;
import org.alking.tecent.ai.face.identify.FaceIdentifyReply;
import org.alking.tecent.ai.face.identify.FacePersonNewReply;

import java.io.IOException;
import java.util.List;

public interface FaceClient {

    int FACE_MODE_NORMAL = 0;

    int FACE_MODE_BIG = 1;

    FaceDetectReply detect(Image image, int mode) throws IOException;

    FaceMultiReply multiDetect(Image image) throws IOException;

    FaceCrossAgeReply crossAge(Image image, Image target) throws IOException;

    FaceShapeReply shape(Image image, int mode) throws IOException;

    FaceCompareReply compare(Image a, Image b) throws IOException;

    FaceIdentifyReply identify(Image res, String groupId, int topN) throws IOException;

    FaceVerifyReply verify(Image res, String personId) throws IOException;

    FacePersonNewReply personNew(Image image, List<String> groups, String personId, String personName, String tag) throws IOException;
}
