package com.yami.shop.security.admin.dto;

import com.yami.shop.security.common.dto.AuthenticationDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 后台登录
 * @author 菠萝凤梨
 * @date 2022/3/28 14:57
 */
@Data
public class CaptchaAuthenticationDTO extends AuthenticationDTO {

    @Schema(description = "验证码，兼容旧版登录请求" ,requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String captchaVerification;
}
