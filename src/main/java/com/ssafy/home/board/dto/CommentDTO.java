package com.ssafy.home.board.dto;

public class CommentDTO {
    private int no;
    private int bno;
    private String userId;
    private String content;
    private String writeDate;

    public CommentDTO(int no, int bno, String userId, String content, String writeDate) {
        this.no = no;
        this.bno = bno;
        this.userId = userId;
        this.content = content;
        this.writeDate = writeDate;
    }

    public CommentDTO() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }

    @Override
    public String toString() {
        return "[ " +
                "no=" + no +
                ", bno=" + bno +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", writeDate='" + writeDate + '\'' +
                ']';
    }
}
