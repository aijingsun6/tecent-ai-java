package org.alking.tecent.ai.face.identify;

import org.alking.tecent.ai.HttpClient;
import org.alking.tecent.ai.domain.Image;
import org.alking.tecent.ai.impl.BaseClient;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class FaceIdentifyClientImpl extends BaseClient implements FaceIdentifyClient {

    private static final String FACE_IDENTIFY_URL = "https://api.ai.qq.com/fcgi-bin/face/face_faceidentify";

    private static final String FACE_PERSON_NEW_URL = "https://api.ai.qq.com/fcgi-bin/face/face_newperson";

    private static final String SIGN_FIELD_GROUP_ID = "group_id";

    private static final String SIGN_FIELD_TOP_N = "topn";

    private static final String SIGN_FIELD_PERSON_ID = "person_id";

    private static final String SIGN_FIELD_GROUP_ID_LIST = "group_ids";

    private static final String SIGN_FIELD_PERSON_NAME = "person_name";

    private static final String SIGN_FIELD_TAG = "tag";

    private static final int TOP_N_MIN = 1;

    private static final int TOP_N_MAX = 10;

    public FaceIdentifyClientImpl(String appId, String appKey, HttpClient httpClient) {
        super(appId, appKey, httpClient);
    }


    @Override
    public FaceIdentifyReply identify(Image res, String groupId, int topN) throws IOException {
        if(StringUtils.isEmpty(groupId)){
            throw new IllegalArgumentException("invalid param groupId");
        }

        if(topN < TOP_N_MIN || topN > TOP_N_MAX){
            throw new IllegalArgumentException("param topN out of range [1,10]");
        }
        final String base64 = parseSourceData(res);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE,base64);
        map.put(SIGN_FIELD_GROUP_ID,groupId);
        map.put(SIGN_FIELD_TOP_N,String.valueOf(topN));
        return normalReq(FACE_IDENTIFY_URL,map,FaceIdentifyReply.class);
    }

    @Override
    public FaceInfoReply info(String faceId) throws IOException {
        return null;
    }

    @Override
    public FacePersonNewReply personNew(Image image, List<String> groups, String personId, String personName, String tag) throws IOException {
        if(image == null){
            throw new IllegalArgumentException("invalid param image.");
        }
        if(groups == null || groups.isEmpty()){
            throw new IllegalArgumentException("invalid param groups.");
        }
        if(StringUtils.isEmpty(personId ) || StringUtils.isEmpty(personName)){
            throw new IllegalArgumentException("invalid param personId or personName.");
        }
        final String base64 = parseSourceData(image);
        final TreeMap<String, String> map = new TreeMap<>();
        map.put(SIGN_FIELD_IMAGE,base64);
        map.put(SIGN_FIELD_GROUP_ID_LIST,String.join("|",groups));
        map.put(SIGN_FIELD_PERSON_ID,personId);
        map.put(SIGN_FIELD_PERSON_NAME,personName);
        if(!StringUtils.isEmpty(tag)){
            map.put(SIGN_FIELD_TAG,tag);
        }
        return normalReq(FACE_PERSON_NEW_URL,map,FacePersonNewReply.class);
    }
}
