package com.tlf.creator.controller.user.product;

import com.tlf.creator.aspect.AuthToken;
import com.tlf.creator.common.Constants;
import com.tlf.creator.common.JsonResult;
import com.tlf.creator.config.UploadPathBean;
import com.tlf.creator.entity.user.product.Document;
import com.tlf.creator.entity.user.product.Item;
import com.tlf.creator.entity.user.product.Version;
import com.tlf.creator.req.ProductReq;
import com.tlf.creator.service.user.product.DocumentService;
import com.tlf.creator.service.user.product.ItemService;
import com.tlf.creator.service.user.product.VersionService;
import com.tlf.creator.vo.DocumentVO;
import com.tlf.creator.vo.ItemVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

/**
 * controller for product
 *
 * @author zhangc
 * @date 2019/9/4
 */
@RestController
@RequestMapping
@CrossOrigin
public class ProductController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private VersionService versionService;

    @Autowired
    private UploadPathBean uploadPathBean;

    @Autowired
    private DocumentService documentService;

    @PostMapping(value = "get_item_and_version")
    @AuthToken(role_name = "product")
    public JsonResult getItemAndVersion(){
        List<ItemVO> list = itemService.selectItemAndVersion();
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,list);
    }

    @PostMapping(value = "add_item")
    @AuthToken(role_name = "product")
    public JsonResult addItem(@RequestBody ProductReq req){
        if(StringUtils.isBlank(req.getItemName())){
            return new JsonResult(Constants.CODE_FAIL,"名称不能为空",null,null);
        }
        Item item = new Item();
        String itemId = UUID.randomUUID().toString();
        item.setId(itemId);
        item.setName(req.getItemName());
        boolean insertItem = itemService.insertItem(item);
        if(insertItem){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
        }
        return new JsonResult(Constants.CODE_FAIL,"FAIL",null,null);
    }

    @PostMapping(value = "add_version")
    @AuthToken(role_name = "product")
    public JsonResult addVersion(@RequestBody ProductReq req){
        if(StringUtils.isBlank(req.getVersionName())||StringUtils.isBlank(req.getItemId())){
            return new JsonResult(Constants.CODE_FAIL,"id,名称不能为空",null,null);
        }
        String versionId = UUID.randomUUID().toString();
        Version version = new Version();
        version.setId(versionId);
        version.setItemId(req.getItemId());
        version.setName(req.getVersionName());
        version.setBulletin(req.getBulletin());
        boolean insertVersion = versionService.insertVersion(version);
        if(insertVersion){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
        }
        return new JsonResult(Constants.CODE_FAIL,"FAIL",null,null);
    }

    @PostMapping(value = "delete_item")
    @AuthToken(role_name = "product")
    public JsonResult deleteItem(@RequestBody ProductReq req){
        if(StringUtils.isBlank(req.getItemId())){
            return new JsonResult(Constants.CODE_FAIL,"id不能为空",null,null);
        }
        boolean deleteItem = itemService.deleteItem(req.getItemId());
        if(deleteItem){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
        }
        return new JsonResult(Constants.CODE_FAIL,"FAIL",null,null);
    }

    @PostMapping(value = "delete_version")
    @AuthToken(role_name = "product")
    public JsonResult deleteVersion(@RequestBody ProductReq req){
        if(StringUtils.isBlank(req.getVersionId())){
            return new JsonResult(Constants.CODE_FAIL,"id不能为空",null,null);
        }
        boolean deleteVersion = versionService.deleteVersion(req.getVersionId());
        if(deleteVersion){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
        }
        return new JsonResult(Constants.CODE_FAIL,"FAIL",null,null);
    }

    @PostMapping(value = "upload_document")
    @AuthToken(role_name = "product")
    public JsonResult uploadDocument(HttpServletRequest request){
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        MultipartFile file = params.getFile("document");
        String versionId = params.getParameter("versionId");
        if (file == null || file.isEmpty()) {
            return new JsonResult(Constants.CODE_FAIL, "文件为空", null, null);
        }
        String fileName = file.getOriginalFilename();
        long length = file.getSize();
        double size;
        String fileSize = null;
        if (length > 1024 * 1024 * 1024) {
            size = length * 1.00 / 1024 / 1024 / 1024;
            BigDecimal b = new BigDecimal(size);
            double dou = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            fileSize = dou + " GB";
        } else if (length < 1024 * 1024 * 1024 && length > 1024 * 1024) {
            size = length * 1.00 / 1024 / 1024;
            BigDecimal b = new BigDecimal(size);
            double dou = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            fileSize = dou + " MB";
        } else if (length < 1024 * 1024 && length > 1024) {
            size = length * 1.00 / 1024;
            BigDecimal b = new BigDecimal(size);
            double dou = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            fileSize = dou + " KB";
        } else if (length < 1024) {
            size = length;
            fileSize = size + " B";
        }
//        VersionPO versionPO = versionService.selectNameById(versionId);
//        if(versionPO==null){
//            return new JsonResult(Constants.CODE_FAIL, "版本不存在", null, null);
//        }
        String id = UUID.randomUUID().toString();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] bytes = new byte[0];
        String path = uploadPathBean.getDocumentUpload() ;
        File folder = new File(path);
        if(!folder.exists()){
            folder.mkdir();
        }
        Path documentPath = Paths.get(path+File.separator+id+"."+suffix);
        try {
            bytes = file.getBytes();
            Files.write(documentPath, bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonResult(Constants.CODE_FAIL,"出错了，请重试",null,null);
        }
        Document document = new Document();
        document.setId(id);
        document.setName(fileName);
        document.setSize(fileSize);
        document.setType(suffix);
        document.setVersionId(versionId);
        document.setPath(id+"."+suffix);
        boolean b = documentService.addDocument(document);
        if(b){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
        }else{
            return new JsonResult(Constants.CODE_FAIL,"FAIL",null,null);
        }
    }

    @PostMapping("get_document_by_version")
    @AuthToken(role_name = "product")
    public JsonResult getDocumentByVersion(@RequestBody ProductReq req){
        if(StringUtils.isBlank(req.getVersionId())){
            return new JsonResult(Constants.CODE_FAIL,"id不能为空",null,null);
        }
        DocumentVO documents = documentService.selectDocumentByVersion(req.getVersionId());
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,documents);
    }

    @PostMapping("delete_document")
    @AuthToken(role_name = "product")
    public JsonResult deleteDocument(@RequestBody ProductReq req){
        if(StringUtils.isBlank(req.getDocumentId())){
            return new JsonResult(Constants.CODE_FAIL,"id不能为空",null,null);
        }
        boolean b = documentService.deleteDocument(req.getDocumentId());
        if(b){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
        }else{
            return new JsonResult(Constants.CODE_FAIL,"FAIL",null,null);
        }
    }

    @PostMapping("modify_bulletin")
    @AuthToken(role_name = "product")
    public JsonResult modifyBulletin(@RequestBody ProductReq req){
        if(StringUtils.isBlank(req.getVersionId())){
            return new JsonResult(Constants.CODE_FAIL,"版本不能为空",null,null);
        }
        boolean b = versionService.updateVersion(req.getVersionId(),req.getBulletin());
        if(b){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
        }else{
            return new JsonResult(Constants.CODE_FAIL,"FAIL",null,null);
        }
    }

}
