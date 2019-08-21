package com.tlf.creatorcourse.controller.component;

import cn.hutool.core.io.FileTypeUtil;
import com.tlf.creatorcourse.common.JsonResult;
import com.tlf.creatorcourse.common.JsonRet;
import com.tlf.creatorcourse.config.UploadPathBean;
import com.tlf.creatorcourse.constants.Constants;
import com.tlf.creatorcourse.entity.component.Component;
import com.tlf.creatorcourse.entity.component.ComponentGroup;
import com.tlf.creatorcourse.exception.OperatingException;
import com.tlf.creatorcourse.po.ComponentPO;
import com.tlf.creatorcourse.req.BaseReq;
import com.tlf.creatorcourse.req.ComponentReq;
import com.tlf.creatorcourse.service.component.IComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public JsonResult getComponentGroup(@RequestBody BaseReq req) throws OperatingException {
        List<ComponentGroup> componentGroups = componentService.selectAllComponentGroup();
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", componentGroups);
    }

    /**
     * 根据id获取元件信息
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_component_by_id", method = RequestMethod.POST)
    public JsonResult getComponentById(@RequestBody ComponentReq req) throws OperatingException {
        String componentId = req.getComponentId();
        Component component = componentService.queryComponentById(componentId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", component);
    }

    /**
     * 查询所有元件组和元件
     *
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_group_and_component", method = RequestMethod.POST)
    public JsonResult getGroupAndComponent(@RequestBody BaseReq req) throws OperatingException {
        List<ComponentPO> list = componentService.queryGroupAndComponent();
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", list);
    }

    /**
     * 根据元件组获取元件
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_component_by_group", method = RequestMethod.POST)
    public JsonResult getComponentByGroup(@RequestBody ComponentReq req) throws OperatingException {
        String groupId = req.getGroupId();
        List<Component> components = componentService.queryComponentByGroup(groupId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", components);
    }

    /**
     * 修改元件介绍
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_component_introduction", method = RequestMethod.POST)
    public JsonResult modifyComponentIntroduction(@RequestBody ComponentReq req) throws OperatingException {
        String componentId = req.getComponentId();
        String introduction = req.getIntroduction();
        componentService.modifyComponentIntroduction(introduction, componentId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 修改元件参数
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_component_parameter", method = RequestMethod.POST)
    public JsonResult modifyComponentParameter(@RequestBody ComponentReq req) throws OperatingException {
        String componentId = req.getComponentId();
        String parameter = req.getParameter();
        componentService.updateComponentParameter(parameter, componentId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 元件重命名
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "rename_component", method = RequestMethod.POST)
    public JsonResult renameComponent(@RequestBody ComponentReq req) throws OperatingException {
        String name = req.getName();
        String componentId = req.getComponentId();
        componentService.updateComponentGroupName(name, componentId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 元件删除
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "delete_component", method = RequestMethod.POST)
    public JsonResult deleteComponent(@RequestBody ComponentReq req) throws OperatingException {
        String componentId = req.getComponentId();
        componentService.deleteComponentById(componentId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 元件搜索
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "search_component", method = RequestMethod.POST)
    public JsonResult searchComponent(@RequestBody ComponentReq req) throws OperatingException {
        String name = req.getName();
        List<ComponentPO> components = componentService.searchComponent(name);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", components);
    }

    /**
     * 添加元件
     *
     * @return
     */
    @RequestMapping(value = "add_component", method = RequestMethod.POST)
    public JsonRet addComponent(@RequestBody ComponentReq req) {
        Component component = new Component();
        String id = UUID.randomUUID().toString();
        component.setId(id);
        try {
            component.setName(req.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        component.setGroupId(req.getGroupId());
        component.setIntroduction(req.getIntroduction());
        component.setParameter(req.getParameter());
        component.setVendor(req.getVendor());
        byte[] icon = req.getIcon();
        byte[] schematic = req.getSchematic();
        InputStream iconIn = new ByteArrayInputStream(icon);
        ByteArrayInputStream schematicIn = new ByteArrayInputStream(schematic);
        String iconType = FileTypeUtil.getType(iconIn);
        String schematicType = FileTypeUtil.getType(schematicIn);
        String iconName = UUID.randomUUID().toString() + "." + iconType;
        String schematicName = UUID.randomUUID().toString() + "." + schematicType;
        String iconPath = "component_icon/" + iconName;
        String schematicPath = "component_schematic/" + schematicName;
        Path path1 = Paths.get(uploadPathBean.getUploadPath() + iconPath);
        Path path2 = Paths.get(uploadPathBean.getUploadPath() + schematicPath);
        try {
            Files.write(path1, icon);
            Files.write(path2, schematic);
            component.setIcon(iconPath);
            component.setSchematic(schematicPath);
            componentService.addComponent(component);
        } catch (IOException | OperatingException e) {
            e.printStackTrace();
            return new JsonRet(Constants.CODE_FAIL, "FAIL", null, null);
        }
        return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", null, null);
    }

    /**
     * 添加元件组
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "add_component_group", method = RequestMethod.POST)
    public JsonRet addComponentGroup(@RequestBody ComponentReq req) {
        String groupName = req.getGroupName();
        String groupId = UUID.randomUUID().toString();
        ComponentGroup componentGroup = new ComponentGroup();
        componentGroup.setId(groupId);
        componentGroup.setName(groupName);
        boolean add = componentService.addComponentGroup(componentGroup);
        if (add) {
            return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", null, null);
        } else {
            return new JsonRet(Constants.CODE_FAIL, "FAIL", null, null);
        }
    }

    /**
     * 删除元件组
     *
     * @param req
     * @return
     */
    @PostMapping(value = "delete_component_group")
    public JsonRet deleteComponentGroup(@RequestBody ComponentReq req) {
        String groupId = req.getGroupId();
        boolean b = componentService.deleteComponentGroup(groupId);
        if (b) {
            return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", null, null);
        } else {
            return new JsonRet(Constants.CODE_FAIL, "FAIL", null, null);
        }
    }

    /**
     * 修改元件模型
     *
     * @param req
     * @return
     */
    @PostMapping(value = "modify_component_model")
    public JsonRet modifyComponentModel(@RequestBody ComponentReq req) {
        String type = req.getType();
        String id = req.getId();
        boolean b = componentService.updateComponentModel(type, id);
        if (b) {
            return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", null, null);
        } else {
            return new JsonRet(Constants.CODE_FAIL, "FAIL", null, null);
        }
    }

}
