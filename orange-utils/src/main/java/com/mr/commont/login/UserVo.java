package com.mr.commont.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by 师利梅 on 2019/5/9.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVo {

    private String userName;
    private String userPhone;
}
