package com146.HOME.CA.BE.web.controller;


import com146.HOME.CA.BE.domain.common.file.UploadFile;
import com146.HOME.CA.BE.domain.common.file.svc.UploadFileSVC;
import com146.HOME.CA.BE.web.api.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriUtils;

import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/attach")
public class AttachFileController {
  private final UploadFileSVC uploadFileSVC;

  //첨부파일 다운로드
  @GetMapping("/down/{fid}")
  public ResponseEntity<Resource> downLoadAttach(
      @PathVariable("fid") Long uploadfileId
  ) throws MalformedURLException {

    UploadFile metaInofOfuploadFile = uploadFileSVC.findFileByFileNum(uploadfileId);
    Resource resource = new UrlResource(getStoreFilePath(metaInofOfuploadFile));
    //한글파일명 깨짐 방지를위한 인코딩
    String encodeUploadFileName = UriUtils.encode(metaInofOfuploadFile.getUploadFileName(), StandardCharsets.UTF_8);
    //Http응답 메세지 헤더에 첨부파일이 있음을 알림
    String contentDisposition = "attachment; filename="+ encodeUploadFileName;

    return ResponseEntity.ok()  //응답코드 200
        .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
        .body(resource);
  }

  //이미지 뷰
  @GetMapping("/view/{fid}")
  public ResponseEntity<Resource> viewAttach(
      @PathVariable("fid") Long uploadfileId
  ) throws MalformedURLException {

    UploadFile metaInofOfuploadFile = uploadFileSVC.findFileByFileNum(uploadfileId);
    Resource resource = new UrlResource(getStoreFilePath(metaInofOfuploadFile));
    //한글파일명 깨짐 방지를위한 인코딩
    String encodeUploadFileName = UriUtils.encode(metaInofOfuploadFile.getUploadFileName(), StandardCharsets.UTF_8);
    //Http응답 메세지 헤더에 첨부파일이 있음을 알림
    String contentDisposition = "attachment; filename="+ encodeUploadFileName;

    return ResponseEntity.ok()  //응답코드 200
        .body(resource);
  }

  //파일시스템내에 물리적인 경로가져오기
  private String getStoreFilePath(UploadFile metaInofOfuploadFile) {
    StringBuffer storeFilePath = new StringBuffer();
    storeFilePath.append("file:")
        .append(uploadFileSVC.getFullPath(metaInofOfuploadFile.getCateNum()))
        .append(metaInofOfuploadFile.getStoreFileName());
    return storeFilePath.toString();
  }

  //첨부파일 삭제-단건
  @ResponseBody
  @DeleteMapping("/{fid}")
  public ApiResult<String> deleteFileByFid(
      @PathVariable Long fid) {
    int affectedRow = uploadFileSVC.deleteFileByFileNum(fid);

    ApiResult<String> result = null;
    if(affectedRow == 1){
      result = new ApiResult<>("00", "success", null);
    }else{
      result = new ApiResult<>("99", "fail", null);
    }
    return result;
  }
}
