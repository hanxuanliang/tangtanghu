package com.hxl.tangtang.dto.user;

import com.hxl.autoconfigure.validator.annotation.EqualField;
import com.hxl.autoconfigure.validator.annotation.LongList;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 负责注册的前端对象接受
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/22 16:20
 */
@Data
@NoArgsConstructor
@EqualField(srcField = "password", dstField = "confirmPassword")
public class RegisterDTO {

    @NotBlank(message = "{user.register.username.not-blank}")
    @Size(min = 6, max = 16, message = "{user.register.username.size}")
    private String username;

    @LongList(allowBlank = true, message = "{user.register.group-ids.long-list}")
    private List<Long> groupIds;

    @Email(message = "{email}")
    private String email;

    @NotBlank(message = "{password.new-password.not-blank}")
    @Pattern(regexp = "^[A-Za-z0-9_*&$#@]{6,22}$", message = "{password.new-password.pattern}")
    private String password;

    @NotBlank(message = "{password.confirm-password.not-blank}")
    private String confirmPassword;

}
