package com.tlf.creator.controller.curriculum.component;

import cn.hutool.core.io.FileTypeUtil;
import com.tlf.creator.common.JsonResult;
import com.tlf.creator.config.UploadPathBean;
import com.tlf.creator.common.Constants;
import com.tlf.creator.entity.curriculum.component.Component;
import com.tlf.creator.entity.curriculum.component.ComponentGroup;
import com.tlf.creator.exception.OperatingException;
import com.tlf.creator.permission.AuthToken;
import com.tlf.creator.po.ComponentPO;
import com.tlf.creator.req.ComponentReq;
import com.tlf.creator.service.curriculum.component.IComponentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@CrossOrigin
public class ComponentLibraryController {

    @Autowired
    private IComponentService componentService;

    @Autowired
    private UploadPathBean uploadPathBean;

    /**
     * 查询元件组
     *
     * @return
     */
    @RequestMapping(value = "get_component_group", method = RequestMethod.POST)
    public JsonResult getComponentGroup(HttpServletRequest request) throws OperatingException {
        String courseId = request.getHeader("Cube-Domain");
        List<ComponentGroup> componentGroups = componentService.selectAllComponentGroup(courseId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS",null, componentGroups);
    }

    /**
     * 根据id获取元件信息
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_component_by_id", method = RequestMethod.POST)
    public JsonResult getComponentById(@RequestBody ComponentReq req,HttpServletRequest request) throws OperatingException {
        String componentId = req.getComponentId();
        String courseId = request.getHeader("Cube-Domain");
        Component component = componentService.queryComponentById(courseId,componentId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS",null, component);
    }

    /**
     * 查询所有元件组和元件
     *
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_group_and_component", method = RequestMethod.POST)
    public JsonResult getGroupAndComponent(HttpServletRequest request) throws OperatingException {
        String courseId = request.getHeader("Cube-Domain");
        List<ComponentPO> list = componentService.queryGroupAndComponent(courseId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", list.size(), list);
    }

    /**
     * 根据元件组获取元件
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_component_by_group", method = RequestMethod.POST)
    public JsonResult getComponentByGroup(@RequestBody ComponentReq req,HttpServletRequest request) throws OperatingException {
        String groupId = req.getGroupId();
        String courseId = request.getHeader("Cube-Domain");
        List<Component> components = componentService.queryComponentByGroup(courseId,groupId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS",null, components);
    }

    /**
     * 修改元件介绍
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_component_introduction", method = RequestMethod.POST)
    @AuthToken(role_name = "teacher")
    public JsonResult modifyComponentIntroduction(@RequestBody ComponentReq req,HttpServletRequest request) throws OperatingException {
        String componentId = req.getComponentId();
        String introduction = req.getIntroduction();
        String courseId = request.getHeader("Cube-Domain");
        componentService.modifyComponentIntroduction(courseId,introduction, componentId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS",null, null);
    }

    /**
     * 修改元件参数
     *
     * @param req
     * @return
     * @throws OperatingException
     */
//    @RequestMapping(value = "modify_component_parameter", method = RequestMethod.POST)
//    public JsonResult modifyComponentParameter(@RequestBody ComponentReq req) throws OperatingException {
//        String componentId = req.getComponentId();
//        String parameter = req.getParameter();
//        componentService.updateComponentParameter(parameter, componentId);
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
//    }

    /**
     * 元件重命名
     *
     * @param req
     * @return
     * @throws OperatingException
     */
//    @RequestMapping(value = "rename_component", method = RequestMethod.POST)
//    public JsonResult renameComponent(@RequestBody ComponentReq req) throws OperatingException {
//        String name = req.getName();
//        String componentId = req.getComponentId();
//        componentService.updateComponentGroupName(name, componentId);
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
//    }

    /**
     * 元件删除
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "delete_component", method = RequestMethod.POST)
    @AuthToken(role_name = "teacher")
    public JsonResult deleteComponent(@RequestBody ComponentReq req,HttpServletRequest request) throws OperatingException {
        String courseId = request.getHeader("Cube-Domain");
        String componentId = req.getComponentId();
        componentService.deleteComponentById(courseId,componentId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS",null, null);
    }

    /**
     * 元件搜索
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "search_component", method = RequestMethod.POST)
    public JsonResult searchComponent(@RequestBody ComponentReq req,HttpServletRequest request) throws OperatingException {
        String name = req.getName();
        String courseId = request.getHeader("Cube-Domain");
        List<ComponentPO> components = componentService.searchComponent(courseId,name);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS",null, components);
    }

    /**
     * 添加元件
     *
     * @return
     */
    @RequestMapping(value = "add_component", method = RequestMethod.POST)
    @AuthToken(role_name = "teacher")
    public JsonResult addComponent(HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        Component component = new Component();
        String id = UUID.randomUUID().toString();
        component.setId(id);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile schematic = multipartRequest.getFile("schematic");
        MultipartFile icon = multipartRequest.getFile("icon");
        byte[] schematicBytes = new byte[0];
        byte[] iconBytes = new byte[0];
        try {
            if (schematic != null) {
                schematicBytes = schematic.getBytes();
            }
            if (icon != null) {
                iconBytes = icon.getBytes();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = multipartRequest.getParameter("name");
        String groupId = multipartRequest.getParameter("groupId");
        String introduction = multipartRequest.getParameter("introduction");
        String parameter = multipartRequest.getParameter("parameter");
        String vendor = multipartRequest.getParameter("vendor");
        component.setName(name);
        component.setGroupId(groupId);
        component.setIntroduction(introduction);
        component.setParameter(parameter);
        component.setVendor(vendor);
        InputStream iconIn = new ByteArrayInputStream(iconBytes);
        ByteArrayInputStream schematicIn = new ByteArrayInputStream(schematicBytes);
        String iconType = FileTypeUtil.getType(iconIn);
        String schematicType = FileTypeUtil.getType(schematicIn);
        String iconName = UUID.randomUUID().toString() + "." + iconType;
        String schematicName = UUID.randomUUID().toString() + "." + schematicType;
        String iconPath = "component_icon/" + iconName;
        String schematicPath = "component_schematic/" + schematicName;
        Path path1 = Paths.get(uploadPathBean.getUploadPath() + iconPath);
        Path path2 = Paths.get(uploadPathBean.getUploadPath() + schematicPath);
        try {
            Files.write(path1, iconBytes);
            Files.write(path2, schematicBytes);
            component.setIcon(iconPath);
            component.setSchematic(schematicPath);
            componentService.addComponent(courseId,component);
        } catch (IOException | OperatingException e) {
            e.printStackTrace();
            return new JsonResult(Constants.CODE_FAIL, "FAIL", null, null);
        }
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
    }

    /**
     * 添加元件组
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "add_component_group", method = RequestMethod.POST)
    @AuthToken(role_name = "teacher")
    public JsonResult addComponentGroup(@RequestBody ComponentReq req,HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        String groupName = req.getGroupName();
        if(StringUtils.isBlank(groupName)){
            return new JsonResult(Constants.CODE_FAIL, "元件组名称不能为空", null, null);
        }
        String groupId = UUID.randomUUID().toString();
        ComponentGroup componentGroup = new ComponentGroup();
        componentGroup.setId(groupId);
        componentGroup.setName(groupName);
        boolean add = componentService.addComponentGroup(courseId,componentGroup);
        if (add) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
        } else {
            return new JsonResult(Constants.CODE_FAIL, "FAIL", null, null);
        }
    }

    /**
     * 删除元件组
     *
     * @param req
     * @return
     */
    @PostMapping(value = "delete_component_group")
    @AuthToken(role_name = "teacher")
    public JsonResult deleteComponentGroup(@RequestBody ComponentReq req,HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        String groupId = req.getGroupId();
        boolean b = componentService.deleteComponentGroup(courseId,groupId);
        if (b) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
        } else {
            return new JsonResult(Constants.CODE_FAIL, "FAIL", null, null);
        }
    }

    /**
     * 修改元件模型
     *
     * @param req
     * @return
     */
    @PostMapping(value = "modify_component_model")
    @AuthToken(role_name = "teacher")
    public JsonResult modifyComponentModel(@RequestBody ComponentReq req,HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        String type = req.getType();
        String id = req.getId();
        if(StringUtils.isBlank(id)||StringUtils.isBlank(type)){
            return new JsonResult(Constants.CODE_FAIL, "请勿输入空值", null, null);
        }
        boolean b = componentService.updateComponentModel(courseId,type, id);
        if (b) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
        } else {
            return new JsonResult(Constants.CODE_FAIL, "FAIL", null, null);
        }
    }

}
