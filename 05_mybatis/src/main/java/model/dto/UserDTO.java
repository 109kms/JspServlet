package model.dto;

public class UserDTO {

  private int uid;
  private String email;
  private String password;
  private String nickname;
  
  public UserDTO() {
    // TODO Auto-generated constructor stub
  }

  public UserDTO(int uid, String email, String password, String nickname) {
    super();
    this.uid = uid;
    this.email = email;
    this.password = password;
    this.nickname = nickname;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  @Override
  public String toString() {
    return "UserDTO [uid=" + uid + ", email=" + email + ", password=" + password + ", nickname=" + nickname + "]";
  }
  
}
