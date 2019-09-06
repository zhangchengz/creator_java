package com.tlf.creator.service.user.product.impl;

import com.tlf.creator.config.UploadPathBean;
import com.tlf.creator.dao.user.product.DocumentMapper;
import com.tlf.creator.dao.user.product.VersionMapper;
import com.tlf.creator.entity.user.product.Document;
import com.tlf.creator.entity.user.product.Version;
import com.tlf.creator.service.user.product.DocumentService;
import com.tlf.creator.vo.DocumentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * class for interface implementation
 *
 * @author zhangc
 * @date 2019/9/5
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private UploadPathBean uploadPathBean;

    @Autowired
    private DocumentMapper documentMapper;

    @Autowired
    private VersionMapper versionMapper;

    @Override
    public DocumentVO selectDocumentByVersion(String versionId) {
        List<Document> documents = documentMapper.selectByVersion(versionId);
        for(Document document:documents){
            document.setPath(uploadPathBean.getDocumentDownload()+document.getPath());
        }
        Version version = versionMapper.selectByPrimaryKey(versionId);
        String bulletin = null;
        if(version!=null){
            bulletin = version.getBulletin();
        }
        DocumentVO documentVO = new DocumentVO(bulletin,documents);
        return documentVO;
    }

    @Override
    public boolean addDocument(Document document) {
        int insert = documentMapper.insert(document);
        if(insert>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteDocument(String id) {
        Document document = documentMapper.selectByPrimaryKey(id);
        if(document==null){
            return false;
        }
        File file = new File(uploadPathBean.getDocumentUpload()+document.getPath());
        if(file.exists()){
            file.delete();
        }
        int delete = documentMapper.deleteByPrimaryKey(id);
        if(delete>0){
            return true;
        }
        return false;
    }

}
