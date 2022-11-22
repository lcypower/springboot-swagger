package com.example.springframework.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



public class MainDTO {

    @Data
    @ApiModel(value = "MainDTO : 정보", description = "아이디, 이름, 레벨")
    public static class mainRequest {
        @ApiModelProperty(value = "아이디", example = "lcy")
        private String id;
        @ApiModelProperty(value = "이름", example = "Azewtgqwg23213!@4")
        private String name;
        @ApiModelProperty(value = "비밀번호", example = "1234")
        private int level;
    }

    @Data
    public static class mainResponse {
        private String id;
        private String name;
        private int level;
    }
}
