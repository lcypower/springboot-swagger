package com.example.springframework.controller;

import com.example.springframework.dto.MainDTO;
import com.example.springframework.exception.CustomException;
import com.example.springframework.exception.Errors;
import com.example.springframework.service.MainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Api(tags = "이거슨 메인API들")
@RestController
@RequestMapping("/api/main")
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final MainService mainService;

    @ApiOperation(value = "이거슨 전체 조회 API구염", notes = "여기에는 뭔가를 줄줄줄 쓰는거 같은데예")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, value = "이거슨아이디염"),
            @ApiImplicitParam(name = "name", required = true, value = "이거슨이름이염"),
            @ApiImplicitParam(name = "level", required = true, value = "이거슨레베루염"),
            @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer access_token")
    })
    @GetMapping("/get-all")
    public ResponseEntity<Object> getMainAll(@ModelAttribute MainDTO.mainRequest param){
        log.info("Controller in~");
        MainDTO.mainResponse response = this.mainService.getParam(param);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-param")
    public ResponseEntity<Object> getMainParam(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("level") int level){
        // 강제로 Exception 발생!
        throw new CustomException(Errors.INTERNAL_SERVER_ERROR);
//        MainDTO.mainResponse param = new MainDTO.mainResponse();
//        param.setId(id);
//        param.setName(name);
//        param.setLevel(level);
//        return new ResponseEntity(param, HttpStatus.OK);
    }

    @GetMapping("/get-path/{pathvalue}")
    public ResponseEntity<Object> getMainPath(@PathVariable("pathvalue") String pathvalue){
        MainDTO.mainResponse param = new MainDTO.mainResponse();
        param.setId(pathvalue);
        return new ResponseEntity(param, HttpStatus.OK);
    }

    @ApiOperation(value = "이거슨 json 포스트로 처리하는 api예염", notes = "설명 설명 설명")
    @PostMapping("/post")
    public ResponseEntity<Object> postMain(@RequestBody MainDTO.mainRequest param){
        return ResponseEntity.created(URI.create("/post/" + param.getId())).build();
    }

    @PutMapping("/put")
    public ResponseEntity<Object> putMain(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PatchMapping("/patch")
    public ResponseEntity<Object> patchMain() { return new ResponseEntity(HttpStatus.OK); }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteMain(){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
