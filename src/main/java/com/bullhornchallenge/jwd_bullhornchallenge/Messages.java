package com.bullhornchallenge.jwd_bullhornchallenge;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

    @Entity
    public class Messages {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @NotNull
        @Size(min=3)
        private String msg;

        @NotNull
        @Size(min=10)
        private String content;

        @NotNull
        @Size(min=3)
        private String sentby;

        @NotNull
        @Min(8)
        private String posteddate;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSentby() {
            return sentby;
        }

        public void setSentby(String sentby) {
            this.sentby = sentby;
        }

        public String getPosteddate() {
            return posteddate;
        }

        public void setPosteddate(String posteddate) {
            this.posteddate = posteddate;
        }
    }