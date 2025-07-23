package model.dto;

import java.sql.Timestamp;

/*
 * DTO
 * 
 * 1. Data Transfer Object(DTO)
 * 2. 데이터를 전송하기 위해 사용하는 객체입니다.
 * 3. 주로 웹 애플리케이션에서 컨트롤러, 서비스, 레파지토리(DAO) 등의 계층 구조를 가진 시스템에서
 *    각 계층이 데이터를 주고 받을 때 사용합니다.
 * 4. 주요 특징
 *    1) 데이터를 저장할 필드와 이에 접근하는 Getter/Setter로 구성됩니다. (비즈니스 로직은 포함하지 않습니다.)
 *    2) 필요한 데이터만 전달할 수 있어 민감한 정보 노출을 방지할 수 있습니다.
 *    3) 도메인 모델(예: JPA 엔티티) 대신 DTO를 사용하면 계층 간 결합도를 낮춰 각 계층의 독립성을 높일 수 있습니다.
 *    4) 네트워크 전송, API 응답 등의 경우에 직렬화(예: JSON)가 쉽게 처리되도록 구성합니다.
 * 5. 주요 사용 예시
 *    1) API 응답 객체
 *    2) 쿼리 결과 전달하는 객체
 */

public class BoardDTO {

  private int bid;
  private UserDTO user;  //----- uid, nickname 관리
  private String title;
  private String content;
  private Timestamp createdAt;  //----- MySQL's TIMESTAMP 타입은 java.sql.Timestamp 클래스 타입으로 처리합니다.
  private Timestamp modifiedAt;

  public int getBid() {
    return bid;
  }
  public void setBid(int bid) {
    this.bid = bid;
  }
  public UserDTO getUser() {
    return user;
  }
  public void setUser(UserDTO user) {
    this.user = user;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Timestamp getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }
  public Timestamp getModifiedAt() {
    return modifiedAt;
  }
  public void setModifiedAt(Timestamp modifiedAt) {
    this.modifiedAt = modifiedAt;
  }
  @Override
  public String toString() {
    return "BoardDTO [bid=" + bid + ", user=" + user + ", title=" + title + ", content=" + content + ", createdAt="
        + createdAt + ", modifiedAt=" + modifiedAt + "]";
  }



}
