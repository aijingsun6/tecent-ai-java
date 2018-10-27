package org.alking.tecent.ai.face.identify;

import org.alking.tecent.ai.domain.Image;

import java.io.IOException;
import java.util.List;

public interface FaceIdentifyClient {

    FaceIdentifyReply identify(Image image, String groupId, int topN) throws IOException;

    FaceNewPersonReply newPerson(Image image, List<String> groups, String personId, String personName, String tag) throws IOException;

    FaceDelPersonReply delPerson(String personId) throws IOException;

    FaceAddReply addFace(String personId, List<Image> images, String tag) throws IOException;

    FaceDelReply delFace(String personId, List<String> faceIds) throws IOException;

    FacePersonInfoSetReply setPersonInfo(String personId, String personName, String tag) throws IOException;

    FacePersonInfoReply getPersonInfo(String personId) throws IOException;

    FaceGroupIdsReply groupIds() throws IOException;

    FacePersonIdsReply findPersonIdsByGroupId(String groupId) throws IOException;

    FaceIdsReply findFaceIdsByPersonId(String personId) throws IOException;

    FaceInfoReply faceInfo(String faceId) throws IOException;
}
