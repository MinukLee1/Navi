package com.tennessee.project_navi;

import java.util.Date;

public class WriteInfo {
    private String title;
    private String Contents;
    private String publisher;
    private Date date;

    public WriteInfo(String title, String Contents, String publisher, Date date) {
        this.title = title;
        this.Contents = Contents;
        this.publisher = publisher;
        this.date = date;

    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return this.Contents;
    }

    public void setContents(String Contents) {
        this.Contents = Contents;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;


        public Date getDate () {
            return this.date;
        }
        public void setDate (Date date){
            this.date = date;
        }


    }
}
