package com.gexingw.mall.user.app.vo.web.mall.auth;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gexingw.mall.common.core.constant.DateTimeConstant;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/8/26 15:59
 */
@Data
public class WebMallAuthInfoVO implements Serializable {

    private Long id;

    private Long authUserId;

    private String nickname;

    @JsonFormat(pattern = DateTimeConstant.STD_DATE_TIME_FORMAT)
    private LocalDateTime createTime;

}
