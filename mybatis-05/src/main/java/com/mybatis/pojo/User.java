package com.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: User
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/10/10 18:24
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String NAME;
    private String password;

}
