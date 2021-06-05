package com.tennessee.project_navi;

public class WriteInfo {
    private String title;
    private String Contents;
    private String publisher;

    public WriteInfo(String title, String Contents, String publisher){
        this.title = title;
        this.Contents = Contents;
        this.publisher = publisher;

    }

    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getContents(){
        return this.Contents;
    }
    public void setContents(String Contents){
        this.Contents = Contents;
    }

    public String getPublisher(){
        return this.publisher;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

}
