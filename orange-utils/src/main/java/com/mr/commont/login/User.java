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

    @Field("t_user_id")
    private Integer tUserId;
    @Field("user_id")
    private Integer userId;
    @Field("user_name")
    private String userName;
    @Field("user_phone")
    private String userPhone;
    @Field("user_sex")
    private Integer userSex;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Field("user_birthday")
    private Date userBirthday;
    @Field("user_level")
    private Integer userLevel;
    @Field("user_status")
    private Integer userStatus;

    public String getuserBirthdayStr(){
        if(userBirthday != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(userBirthday);
        }
        return "";
    }

}

