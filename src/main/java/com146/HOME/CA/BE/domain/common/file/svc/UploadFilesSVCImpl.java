package com146.HOME.CA.BE.domain.common.file.svc;


import com146.HOME.CA.BE.domain.common.file.UploadFile;
import com146.HOME.CA.BE.domain.common.file.dao.UploadFileDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UploadFilesSVCImpl implements UploadFileSVC{

  private final UploadFileDAO uploadFileDAO;

  //첨부파일 저장될 파일시스템의 경로 application.properties에 정의
  @Value("${attach.root_dir}")
  private String ROOT_DIR;  //첨부파일 루트경로

  //업로드파일 처리-단건
  @Override
  public boolean addFile(int cateNum, Long boardNum, MultipartFile file) {
    try {
      UploadFile uploadFile = new UploadFile();
      uploadFile.setCateNum(cateNum);
      uploadFile.setBoardNum(boardNum);

      String originalFileName = file.getOriginalFilename();
      String storeFileName = createStoreFilename(originalFileName);
      uploadFile.setStoreFileName(storeFileName);
      uploadFile.setUploadFileName(originalFileName);

      uploadFile.setFileSize(file.getSize());
      uploadFile.setFileType(file.getContentType());

      //파일시스템에 물리적 파일 저장
      storeFile(uploadFile, file);
      //uploadfile 테이블에 첨부파일 메타정보 저장
      uploadFileDAO.addFile(uploadFile);

    }catch (Exception e){
      e.printStackTrace();
      return false;
    }
    return true;
  }

  //업로드파일 처리-여러건
  @Override
  public boolean addFile(int cateNum, Long boardNum, List<MultipartFile> files) {
    //1) uploadfile 테이블에 첨부파일 메타정보 저장
    //2) 파일시스템에 물리적 파일 저장
    try {
      List<UploadFile> uploadFiles = new ArrayList<>();

      for(MultipartFile file: files) {
        UploadFile uploadFile = new UploadFile();
        uploadFile.setCateNum(cateNum);
        uploadFile.setBoardNum(boardNum);

        String originalFileName = file.getOriginalFilename();
        String storeFileName = createStoreFilename(originalFileName);
        uploadFile.setStoreFileName(storeFileName);
        uploadFile.setUploadFileName(originalFileName);

        uploadFile.setFileSize(file.getSize());
        uploadFile.setFileType(file.getContentType());

        uploadFiles.add(uploadFile);
      }
      storeFiles(uploadFiles, files);
      uploadFileDAO.addFile(uploadFiles);
    }catch (Exception e){
      e.printStackTrace();
      return false;
    }
    return true;
  }

  //업로드파일 경로
  @Override
  public String getFullPath(int cateNum) {
    StringBuffer path = new StringBuffer();
    path = path.append(ROOT_DIR).append(cateNum).append("/");
    //경로가 없으면 생성
    createFolder(path.toString());
    log.info("파일저장위치={}", path.toString());
    return path.toString();
  }

  //업로드파일조회
  @Override
  public List<UploadFile> getFilesByCateNumWithBoardNum(int cateNum, Long boardNum) {
    return uploadFileDAO.getFilesByCateNumWithBoardNum(cateNum,boardNum);
  }
  //파일시스템에 물리적 파일 저장
  private void storeFile(UploadFile uploadFile, MultipartFile file) {
    try {
      file.transferTo(Path.of(getFullPath(uploadFile.getCateNum()), uploadFile.getStoreFileName()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  //파일시스템에 물리적 파일 저장
  private void storeFiles(List<UploadFile> uploadFiles, List<MultipartFile> files) {
    for (int i=0; i<uploadFiles.size(); i++) {
      storeFile(uploadFiles.get(i), files.get(i));
    }
  }

  //첨부파일조회
  @Override
  public UploadFile findFileByFileNum(Long fileNum) {
    return uploadFileDAO.findFileByfileNum(fileNum);
  }

  // 첨부파일 삭제 by file_num
  @Override
  public int deleteFileByFileNum(Long fileNum){

    //1)물리파일삭제
    UploadFile uploadFile = uploadFileDAO.findFileByfileNum(fileNum);
    deleteFile(uploadFile.getCateNum(), uploadFile.getStoreFileName());

    //2)메타정보삭제
    int affectedRow = uploadFileDAO.deleteFileByfileNum(fileNum);

    return affectedRow;
  }

  // 첨부파일 삭제 By cateNum, boardNum
  @Override
  public int deleteFileByCateNumWithBoardNum(int cateNum, Long boardNum){

    //1)물리파일삭제
    List<UploadFile> uploadFiles = uploadFileDAO.getFilesByCateNumWithBoardNum(cateNum, boardNum);
    for (UploadFile uploadFile : uploadFiles) {
      deleteFile(uploadFile.getCateNum(), uploadFile.getStoreFileName());
    }

    //2)메타정보삭제
    uploadFileDAO.deleteFileByCateNumWithBoardNum(cateNum, boardNum);

    return uploadFiles.size();
  }



  /**
   * 서버 보관 파일 삭제
   * @param cateNum
   * @param sfname
   * @return
   */
  private boolean deleteFile(int cateNum ,String sfname) {

    boolean isDeleted = false;

    File file = new File(getFullPath(cateNum)+sfname);

    if(file.exists()) {
      if(file.delete()) {
        isDeleted = true;
      }
    }

    return isDeleted;
  }

  private boolean deleteFiles(int cateNum, List<String> fnames ) {

    boolean isDeleted = false;
    int deletedFileCount = 0;

    for(String sfname : fnames) {
      if(deleteFile(cateNum, sfname)) {
        deletedFileCount++;
      };
    }

    if(deletedFileCount == fnames.size()) isDeleted = true;

    return isDeleted;
  }

  //폴더생성
  private void createFolder(String path) {
    File folder = new File(path);
    if(!folder.exists()){
      folder.mkdir();
    }
  }

  //임의파일명 생성
  private String createStoreFilename(String originalFile) {
    StringBuffer storeFileName = new StringBuffer();
    storeFileName.append(UUID.randomUUID().toString())
        .append(".")
        .append(extractExt(originalFile)); // xxx-yyy-zzz-ttt..
    return storeFileName.toString();
  }

  //확장자 추출
  private String extractExt(String originalFile) {
    int posOfExt =originalFile.lastIndexOf(".");
    String ext = originalFile.substring(posOfExt + 1);
    return ext;
  }

}
