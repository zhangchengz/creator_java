package com.tlf.creatorcourse.utils;

import com.tlf.creatorcourse.config.UploadPathBean;
import com.tlf.creatorcourse.dao.coursestudy.MaterialMapper;
import com.tlf.creatorcourse.dao.resource.ResourceMapper;
import com.tlf.creatorcourse.dao.simulationresource.SimulationResourceMapper;
import com.tlf.creatorcourse.dao.template.SimTemplateMapper;
import com.tlf.creatorcourse.entity.coursestudy.Material;
import com.tlf.creatorcourse.entity.resource.Resource;
import com.tlf.creatorcourse.entity.resource.Resources;
import com.tlf.creatorcourse.entity.simulation.SimulationResource;
import com.tlf.creatorcourse.entity.template.SimTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileUtil {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private MaterialMapper materialMapper;

    @Autowired
    private SimulationResourceMapper simulationResourceMapper;

    @Autowired
    private SimTemplateMapper simTemplateMapper;

    @Autowired
    private UploadPathBean uploadPathBean;

    public Resource copyFile(String fileId, String stem) throws IOException {
        String path = null;
        String name = null;
        Material material = materialMapper.selectMaterialById(fileId);
        Resources resources = resourceMapper.queryResourceById(fileId);
        SimulationResource simulationResource = simulationResourceMapper.selectByPrimaryKey(fileId);
        SimTemplate simTemplate = simTemplateMapper.selectByPrimaryKey(fileId);
        if (material != null) {
            path = material.getPath();
            name = material.getName();
        }
        if (resources != null) {
            path = resources.getPath();
            name = resources.getName();
        }
        if (simulationResource != null) {
            path = simulationResource.getPath();
            name = simulationResource.getName();
        }
        if(simTemplate!=null){
            path=simTemplate.getPath();
            name=simTemplate.getName();
        }
        if (path == null) {
            return null;
        }
        String[] split = path.split("/");
        String group = split[0];

        String suffix = path.substring(path.lastIndexOf("."));
        String id = UUID.randomUUID().toString();

        File upload = new File(uploadPathBean.getUploadPath() + "/" + group);
        if (!upload.exists()) {
            upload.mkdirs();
        }
        String url = uploadPathBean.getUploadPath() + path;
        File file = ResourceUtils.getFile(url);
        Path path2 = Paths.get(upload.getAbsolutePath() + "/" + id + suffix);
        Files.copy(file.toPath(), path2);
        Resources resources1 = new Resources();
        resources1.setId(id);
        resources1.setName(name);
        resources1.setPath(group + "/" + id + suffix);
        resourceMapper.addResource(resources1);
        return new Resource(id, name, group + "/" + id + suffix);
    }



}
