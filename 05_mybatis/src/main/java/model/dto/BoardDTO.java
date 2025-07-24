package model.dto;

import java.sql.Timestamp;

public class BoardDTO {

  private int bid;
  private UserDTO user;
  private String title;
  private String content;
  private Timestamp created_at;
  private Timestamp modified_at;
  
  public BoardDTO() {
    // TODO Auto-generated constructor stub
  }

  public BoardDTO(int bid, UserDTO user, String title, String content, Timestamp created_at, Timestamp modified_at) {
    super();
    this.bid = bid;
    this.user = user;
    this.title = title;
    this.content = content;
    this.created_at = created_at;
    this.modified_at = modified_at;
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

  public Timestamp getCreated_at() {
    return created_at;
  }

  public void setCreated_at(Timestamp created_at) {
    this.created_at = created_at;
  }

  public Timestamp getModified_at() {
    return modified_at;
  }

  public void setModified_at(Timestamp modified_at) {
    this.modified_at = modified_at;
  }

  @Override
  public String toString() {
    return "BoardDTO [bid=" + bid + ", user=" + user + ", title=" + title + ", content=" + content + ", created_at="
        + created_at + ", modified_at=" + modified_at + "]";
  }
  
  
}
