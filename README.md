# tecent-ai-java
[腾讯AI](https://ai.qq.com/) API JAVA实现

### 计划实现功能
##### OCR
- [x] 身份证OCR (```OCRClient.idCard(...)```)
- [x] 行驶证驾驶证OCR (```OCRClient.vehicleLicense(...)|OCRClient.driveLicense(...)```)
- [x] 通用OCR (```OCRClient.general(...)```)
- [x] 营业执照OCR (```OCRClient.biz(...)```)
- [x] 银行卡OCR (```OCRClient.bankCard(...)```)
- [x] 手写体OCR (```OCRClient.handWrite(...)```)
- [x] 车牌OCR (```OCRClient.carPlate(...)```)
- [x] 名片OCR (```OCRClient.businessCard(...)```)
##### 人脸识别
- [x] 人脸检测与分析 (```FaceClient.detect(...)```)
- [x] 多人脸检测 (```FaceClient.multiDetect(...)```)
- [x] 跨年龄人脸识别 (```FaceClient.crossAge(...)```)
- [x] 五官定位 (```FaceClient.shape(...)```)
- [x] 人脸对比 (```FaceClient.compare(...)```)
- [x] 人脸搜索
  - [x] 人脸搜索 (```FaceIdentifyClient.identify(...)```)
  - [x] 个体创建 (```FaceIdentifyClient.newPerson(...)```)
  - [x] 删除个体 (```FaceIdentifyClient.delPerson(...)```)
  - [x] 增加人脸 (```FaceIdentifyClient.addFace(...)```)
  - [x] 删除人脸 (```FaceIdentifyClient.delFace(...)```)
  - [x] 设置信息 (```FaceIdentifyClient.setPersonInfo(...)```)
  - [x] 获取信息 (```FaceIdentifyClient.getPersonInfo(...)```)
  - [x] 获取组列表 (```FaceIdentifyClient.groupIds(...)```)
  - [x] 获取个体列表 (```FaceIdentifyClient.findPersonIdsByGroupId(...)```)
  - [x] 获取人脸列表 (```FaceIdentifyClient.findFaceIdsByPersonId(...)```)
  - [x] 获取人脸信息 (```FaceIdentifyClient.faceInfo(...)```)
- [x] 人脸验证 (```FaceClient.verify(...)```)

### 测试用例