package com.raising.modules.PersonUser.controller;

import com.raising.framework.entity.ResultCode;
import com.raising.framework.shiro.util.JWTUtil;
import com.raising.modules.PersonUser.entity.PersonUserEntity;
import com.raising.modules.PersonUser.service.PersonUserService;
import com.raising.modules.buildingPrice.entity.InfodataEntity;
import com.raising.modules.buildingPrice.service.InfodataService;
import com.raising.modules.cityInfo.entity.CityinfoEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raising.framework.controller.BaseController;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;

import com.raising.modules.PersonUser.entity.UserBuildingEntity;
import com.raising.modules.PersonUser.service.UserBuildingService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author fsd
 * @createTime 2019-03-16 16:06:16
 */
@RestController
@RequestMapping("/PersonUser/userBuilding")
public class UserBuildingController extends BaseController {

    @Autowired
    private UserBuildingService userBuildingService;

    @Autowired
    private PersonUserService personUserService;

    @Autowired
    private InfodataService infodataService;

    /**
     * 分页 - 查询
     *
     * @param page
     * @param userBuilding
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-16 16:06:16
     */
    // @RequiresPermissions("PersonUser:userBuilding:select")
    @GetMapping("/page")
    public ResultVo page(UserBuildingEntity userBuilding, Page<UserBuildingEntity> page) {
        page.setEntity(userBuilding);
        ResultVo resultVo = userBuildingService.getPage(page);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

    /**
     * 详情 - 查询
     *
     * @param id
     * @param userid
     * @param buildingid
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-16 16:06:16
     */
    // @RequiresPermissions("PersonUser:userBuilding:select")
    @GetMapping("/info")
    public ResultVo info(@RequestParam("id") String id, @RequestParam("userid") String userid, @RequestParam("buildingid") String buildingid) {
        return userBuildingService.get(id);
    }

    /**
     * 新增 - 插入
     *
     * @param userBuilding
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-16 16:06:16
     */
    // @RequiresPermissions("PersonUser:userBuilding:insert")
    @PostMapping("/insert")
    public ResultVo insert(UserBuildingEntity userBuilding) {
        UserBuildingEntity insert = new UserBuildingEntity();
        //赋值至 insert 对象
        insert.setId(userBuilding.getId());
        insert.setUserid(userBuilding.getUserid());
        insert.setBuildingid(userBuilding.getBuildingid());
        ResultVo resultVo = userBuildingService.insert(insert);
        resultVo.setData(insert.getId());
        resultVo.setData(insert.getUserid());
        resultVo.setData(insert.getBuildingid());
        return resultVo;
    }

    @PostMapping("/collect")
    public ResultVo collect(@RequestParam("token") String token, @RequestParam("buildId") String buildId) {
        //获取token中的用户名，并查找用户，得到用户的id号
        String userName = JWTUtil.getUsername(token);
        PersonUserEntity searchPue = new PersonUserEntity();
        searchPue.setUsername(userName.split("-")[0]);
        PersonUserEntity pue = (PersonUserEntity) personUserService.getByParam(searchPue).getData();
        String userId = pue.getId();
        UserBuildingEntity insert = new UserBuildingEntity();
        //赋值至 insert 对象
        insert.setUserid(userId);
        insert.setBuildingid(buildId);
        ResultVo resultVo = userBuildingService.insert(insert);
        return resultVo;

    }

    /**
     * 更新
     *
     * @param userBuilding
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-16 16:06:16
     */
    // @RequiresPermissions("PersonUser:userBuilding:update")
    @PostMapping("/update")
    public ResultVo update(UserBuildingEntity userBuilding) {
        UserBuildingEntity update = new UserBuildingEntity();
        //赋值至 update 对象
        update.setId(userBuilding.getId());
        update.setUserid(userBuilding.getUserid());
        update.setBuildingid(userBuilding.getBuildingid());
        return userBuildingService.update(update);
    }

    /**
     * 删除
     *
     * @param id
     * @param userid
     * @param buildingid
     * @return ResultVo
     * @author fsd
     * @datetime 2019-03-16 16:06:16
     */
    // @RequiresPermissions("PersonUser:userBuilding:delete")
    @GetMapping("/delete")
    public ResultVo delete(@RequestParam("id") String id, @RequestParam("userid") String userid, @RequestParam("buildingid") String buildingid) {
        return userBuildingService.delete(id);
    }

    /**
     * 返回用户的历史记录
     *
     * @param token
     * @return
     * @author fsd
     */
    @GetMapping("/userhistory")
    public ResultVo getUserHistory(@RequestParam("token") String token, Page<UserBuildingEntity> page2) {
        //获取token中的用户名，并查找用户，得到用户的id号
        String userName = JWTUtil.getUsername(token);
        PersonUserEntity searchPue = new PersonUserEntity();
        searchPue.setUsername(userName.split("-")[0]);
        PersonUserEntity pue = (PersonUserEntity) personUserService.getByParam(searchPue).getData();
        String userId = pue.getId();
        //利用用户id,获取访问过的楼盘id
        UserBuildingEntity userBuildingEntity = new UserBuildingEntity();
        userBuildingEntity.setUserid(userId);
        page2.setEntity(userBuildingEntity);
        Page page = (Page) userBuildingService.getPage(page2).getData();
        List<UserBuildingEntity> userBuildingEntities = (page).getResults();
        //获取历史访问 所有相对应的 楼盘信息
        List<InfodataEntity> userHistoryBuilds = new ArrayList<>();
        InfodataEntity infoe = new InfodataEntity();
        for (UserBuildingEntity e : userBuildingEntities) {
            infoe.setId(e.getBuildingid());
            userHistoryBuilds.add((InfodataEntity) infodataService.getByParam(infoe).getData());
        }
        //将数据格式话 返回前台
        List<Object> structResult = new ArrayList<>();
        for (InfodataEntity e : userHistoryBuilds) {
            Map<String, String> oneResult = new HashMap<>();
            oneResult.put("id", e.getId());
            oneResult.put("xiaoqu", e.getXiaoqu());
            oneResult.put("propertyaddress", e.getPropertyaddress());
            oneResult.put("area", e.getArea());
            oneResult.put("projectFeatures", e.getProjectfeatures());
            oneResult.put("price", e.getPrice());
            oneResult.put("picture", e.getDate());
            oneResult.put("region", e.getRegion());
            structResult.add(oneResult);
        }
        Page<Object> page1 = new Page<>();
        page1.setTotalRecord(page.getTotalRecord());
        page1.setPageNo(page.getPageNo());
        page1.setPageSize(page.getPageSize());
        page1.setResults(structResult);

        return new ResultVo(ResultCode.OK, page1);
    }
}
