package model.dto;

import java.sql.Timestamp;

public class BoardDTO {

  private int bid;
  private UserDTO user;
  private String title;
  private String content;
  private Timestamp createdAt;
  private Timestamp modifiedAt;
  
  public BoardDTO() {
    // TODO Auto-generated constructor stub
  }

  public BoardDTO(int bid, UserDTO user, String title, String content, Timestamp createdAt, Timestamp modifiedAt) {
    super();
    this.bid = bid;
    this.user = user;
    this.title = title;
    this.content = content;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
  }

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
