package com.mr.commont.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 师利梅 on 2019/5/5.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {


    private Integer tUserId;
    private Integer userId;
    private String userName;
    private String userPhone;
    private Integer userSex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date userBirthday;
    private Integer userLevel;
    private Integer userStatus;

    public String getuserBirthdayStr(){
        if(userBirthday != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(userBirthday);
        }
        return "";
    }

}

