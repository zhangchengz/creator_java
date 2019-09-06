package com.tlf.creator.service.user.product;

import com.tlf.creator.entity.user.product.Document;
import com.tlf.creator.vo.DocumentVO;

/**
 * interface for service
 *
 * @author zhangc
 * @date 2019/9/5
 */
public interface DocumentService {

    DocumentVO selectDocumentByVersion(String versionId);

    boolean addDocument(Document document);

    boolean deleteDocument(String id);
}
