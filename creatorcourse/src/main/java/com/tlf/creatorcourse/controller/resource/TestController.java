package com.tlf.creatorcourse.controller.resource;

import com.alibaba.fastjson.JSONObject;
import com.tlf.creatorcourse.common.JsonResult;
import com.tlf.creatorcourse.constants.Constants;
import com.tlf.creatorcourse.req.DownloadReq;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping
@CrossOrigin
public class TestController {

    @RequestMapping(value = "download_test",method = RequestMethod.POST)
    public ResponseEntity<byte[]> download(@RequestBody DownloadReq req) throws IOException {
        String url = req.getUrl();
        URL uri =  new URL(url);
        String name = req.getName();
        File file = FileUtils.toFile(uri);
        System.out.println();
        name = new String(name.getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", name);
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "get_json",method = RequestMethod.POST)
    public JsonResult getJson(@RequestBody String js){
        JSONObject jsonObject = JSONObject.parseObject(js);
        Object url = jsonObject.get("url");
        if(url==null){
            return new JsonResult(Constants.CODE_FAIL,"url can not be null",null);
        }
        return null;
    }
}
