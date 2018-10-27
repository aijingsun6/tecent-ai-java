package org.alking.tecent.ai.face.identify;

import org.alking.tecent.ai.HttpClient;
import org.alking.tecent.ai.domain.Image;
import org.alking.tecent.ai.impl.BaseClient;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FaceIdentifyClientImpl extends BaseClient implements FaceIdentifyClient {

    private static final String FACE_IDENTIFY_URL = "https://api.ai.qq.com/fcgi-bin/face/face_faceidentify";

    private static final String FACE_PERSON_NEW_URL = "https://api.ai.qq.com/fcgi-bin/face/face_newperson";

    private static final String FACE_DEL_PERSON_URL = "https://api.ai.qq.com/fcgi-bin/face/face_delperson";

    private static final String FACE_ADD_URL = "https://api.ai.qq.com/fcgi-bin/face/face_addface";

    private static final String FACE_DEL_URL = "https://api.ai.qq.com/fcgi-bin/face/face_delface";

    private static final String FACE_SET_PERSON_INFO_URL = "https://api.ai.qq.com/fcgi-bin/face/face_setinfo";

    private static final String FACE_GET_PERSON_INFO_URL = "https://api.ai.qq.com/fcgi-bin/face/face_getinfo";

    private static final String FACE_GET_GROUP_IDS_URL = "https://api.ai.qq.com/fcgi-bin/face/face_getgroupids";

    private static final String FACE_GET_PERSON_IDS_URL = "https://api.ai.qq.com/fcgi-bin/face/face_getpersonids";

    private static final String FACE_GET_FACE_IDS_URL = "https://api.ai.qq.com/fcgi-bin/face/face_getfaceids";

    private static final String FACE_GET_FACE_INFO_URL = "https://api.ai.qq.com/fcgi-bin/face/face_getfaceinfo";

    private static final String SIGN_FIELD_GROUP_ID = "group_id";

    private static final String SIGN_FIELD_TOP_N = "topn";

    private static final String SIGN_FIELD_PERSON_ID = "person_id";

    private static final String SIGN_FIELD_GROUP_ID_LIST = "group_ids";

    private static final String SIGN_FIELD_PERSON_NAME = "person_name";

    private static final String SIGN_FIELD_TAG = "tag";

    private static final String SIGN_FIELD_FACE_ID = "face_id";

    private static final String SIGN_FIELD_FACE_ID_LIST = "face_ids";

    private static final String SIGN_FIELD_IMAGES = "images";

    private static final int TOP_N_MIN = 1;

    private static final int TOP_N_MAX = 10;

    public FaceIdentifyClientImpl(String appId, String appKey, HttpClient httpClient) {
        super(appId, appKey, httpClient);
    }

    @Override
    public FaceIdentifyReply identify(Image image, String groupId, int topN) throws IOException {
        if (StringUtils.isEmpty(groupId)) {
            throw new IllegalArgumentException("invalid param groupId");
        }

        if (topN < TOP_N_MIN || topN > TOP_N_MAX) {
            throw new IllegalArgumentException("param topN out of range [1,10]");
        }
        final String base64 = parseBase64(image);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        map.put(SIGN_FIELD_GROUP_ID, groupId);
        map.put(SIGN_FIELD_TOP_N, String.valueOf(topN));
        return normalReq(FACE_IDENTIFY_URL, map, FaceIdentifyReply.class);
    }

    @Override
    public FaceNewPersonReply newPerson(Image image, List<String> groups, String personId, String personName, String tag) throws IOException {
        if (image == null) {
            throw new IllegalArgumentException("invalid param image.");
        }
        if (groups == null || groups.isEmpty()) {
            throw new IllegalArgumentException("invalid param groups.");
        }
        if (StringUtils.isEmpty(personId) || StringUtils.isEmpty(personName)) {
            throw new IllegalArgumentException("invalid param personId or personName.");
        }
        final String base64 = parseBase64(image);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE, base64);
        map.put(SIGN_FIELD_GROUP_ID_LIST, String.join("|", groups));
        map.put(SIGN_FIELD_PERSON_ID, personId);
        map.put(SIGN_FIELD_PERSON_NAME, personName);
        if (!StringUtils.isEmpty(tag)) {
            map.put(SIGN_FIELD_TAG, tag);
        }
        return normalReq(FACE_PERSON_NEW_URL, map, FaceNewPersonReply.class);
    }

    @Override
    public FaceDelPersonReply delPerson(String personId) throws IOException {
        if(StringUtils.isEmpty(personId)){
            throw new IllegalArgumentException("invalid param personId");
        }
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_PERSON_ID,personId);
        return normalReq(FACE_DEL_PERSON_URL, map, FaceDelPersonReply.class);
    }

    @Override
    public FaceAddReply addFace(String personId, List<Image> images, String tag) throws IOException {
        if(StringUtils.isEmpty(personId)){
            throw new IllegalArgumentException("invalid param personId");
        }
        if(StringUtils.isEmpty(tag)){
            throw new IllegalArgumentException("invalid param tag");
        }
        if(images == null || images.isEmpty()){
            throw new IllegalArgumentException("invalid param images");
        }
        List<String> base64s = new ArrayList<>(images.size());
        for(Image image: images){
            base64s.add(parseBase64(image));
        }
        String join = String.join("|",base64s);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_PERSON_ID,personId);
        map.put(SIGN_FIELD_IMAGES,join);
        map.put(SIGN_FIELD_TAG,tag);
        return normalReq(FACE_ADD_URL, map, FaceAddReply.class);
    }

    @Override
    public FaceDelReply delFace(String personId, List<String> faceIds) throws IOException {
        if(StringUtils.isEmpty(personId)){
            throw new IllegalArgumentException("invalid param personId");
        }
        if(faceIds == null || faceIds.isEmpty()){
            throw new IllegalArgumentException("invalid param faceIds");
        }
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_PERSON_ID,personId);
        map.put(SIGN_FIELD_FACE_ID_LIST, String.join("|", faceIds));
        return normalReq(FACE_DEL_URL, map, FaceDelReply.class);
    }

    @Override
    public FacePersonInfoSetReply setPersonInfo(String personId, String personName, String tag) throws IOException {
        if (StringUtils.isEmpty(personId)) {
            throw new IllegalArgumentException("invalid param personId");
        }
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_PERSON_ID, personId);
        if(!StringUtils.isEmpty(personName)){
            map.put(SIGN_FIELD_PERSON_NAME,personName);
        }
        if(!StringUtils.isEmpty(tag)){
            map.put(SIGN_FIELD_TAG,tag);
        }
        return normalReq(FACE_SET_PERSON_INFO_URL, map, FacePersonInfoSetReply.class);
    }

    @Override
    public FacePersonInfoReply getPersonInfo(String personId) throws IOException {
        if (StringUtils.isEmpty(personId)) {
            throw new IllegalArgumentException("invalid param personId");
        }
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_PERSON_ID, personId);
        return normalReq(FACE_GET_PERSON_INFO_URL, map, FacePersonInfoReply.class);
    }

    @Override
    public FaceGroupIdsReply groupIds() throws IOException {
        final TreeMap<String, String> map = new TreeMap<>();
        return normalReq(FACE_GET_GROUP_IDS_URL, map, FaceGroupIdsReply.class);
    }

    @Override
    public FacePersonIdsReply findPersonIdsByGroupId(String groupId) throws IOException {
        if (StringUtils.isEmpty(groupId)) {
            throw new IllegalArgumentException("invalid param groupId");
        }
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_GROUP_ID, groupId);
        return normalReq(FACE_GET_PERSON_IDS_URL, map, FacePersonIdsReply.class);
    }

    @Override
    public FaceIdsReply findFaceIdsByPersonId(String personId) throws IOException {
        if (StringUtils.isEmpty(personId)) {
            throw new IllegalArgumentException("invalid param personId");
        }
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_PERSON_ID, personId);
        return normalReq(FACE_GET_FACE_IDS_URL, map, FaceIdsReply.class);
    }

    @Override
    public FaceInfoReply faceInfo(String faceId) throws IOException {
        if (StringUtils.isEmpty(faceId)) {
            throw new IllegalArgumentException("invalid param faceId");
        }
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_FACE_ID, faceId);
        return normalReq(FACE_GET_FACE_INFO_URL, map, FaceInfoReply.class);
    }
}
