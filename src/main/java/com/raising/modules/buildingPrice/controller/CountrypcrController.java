package com.raising.modules.buildingPrice.controller;

import com.raising.modules.buildingPrice.entity.cityEntity;
import com.raising.modules.buildingPrice.entity.provinceEntity;
import com.raising.modules.buildingPrice.entity.regionEntity;
import com.raising.modules.buildingPrice.service.InfodataService;
import com.raising.modules.buildingPrice.service.PricehistorynewService;
import com.raising.modules.buildingPrice.service.RegioninfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.raising.framework.controller.BaseController;
import com.raising.framework.entity.ResultVo;
import com.raising.framework.mybaits.Page;

import com.raising.modules.buildingPrice.entity.CountrypcrEntity;
import com.raising.modules.buildingPrice.service.CountrypcrService;

import java.util.ArrayList;
import java.util.List;

/**
 *  控制器
 * @author litongzhe
 * @createTime 2019-03-15 16:02:46
 */
@RestController
@RequestMapping("/buildingPrice/countrypcr")
public class CountrypcrController extends BaseController {

    @Autowired
    private CountrypcrService countrypcrService;
    @Autowired
    private PricehistorynewService pricehistorynewService;
    @Autowired
    private RegioninfoService regioninfoService;
    @Autowired
    private InfodataService infodataService;

    /**
     * 分页 - 查询
     * @author litongzhe
     * @datetime 2019-03-15 16:02:46
     * @param page
     * @param countrypcr
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:countrypcr:select")
    @GetMapping("/page")
    public ResultVo page(CountrypcrEntity countrypcr,Page<CountrypcrEntity> page) {
        page.setEntity(countrypcr);
        ResultVo resultVo = countrypcrService.getPage(page);
        ResultVo.entityNull(resultVo);
        return resultVo;
    }

    /**
     * 详情 - 查询
     * @author litongzhe
     * @datetime 2019-03-15 16:02:46
     * @param id 
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:countrypcr:select")
    @GetMapping("/info")
    public ResultVo info(@RequestParam("id") String id) {
        return countrypcrService.get(id);
    }

    /**
     * 新增 - 插入
     * @author litongzhe
     * @datetime 2019-03-15 16:02:46
     * @param countrypcr
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:countrypcr:insert")
    @PostMapping("/insert")
    public ResultVo insert(CountrypcrEntity countrypcr) {
        CountrypcrEntity insert = new CountrypcrEntity();
        //赋值至 insert 对象
        insert.setProvince(countrypcr.getProvince());
        insert.setCity(countrypcr.getCity());
        insert.setRegion(countrypcr.getRegion());
        insert.setId(countrypcr.getId());
        ResultVo resultVo = countrypcrService.insert(insert);
        resultVo.setData(insert.getId());
        return resultVo;
    }

    /**
     * 更新
     * @author litongzhe
     * @datetime 2019-03-15 16:02:46
     * @param countrypcr
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:countrypcr:update")
    @PostMapping("/update")
    public ResultVo update(CountrypcrEntity countrypcr) {
        CountrypcrEntity update = new CountrypcrEntity();
        //赋值至 update 对象
        update.setProvince(countrypcr.getProvince());
        update.setCity(countrypcr.getCity());
        update.setRegion(countrypcr.getRegion());
        update.setId(countrypcr.getId());
        return countrypcrService.update(update);
    }

    /**
     * 删除
     * @author litongzhe
     * @datetime 2019-03-15 16:02:46
     * @param id 
     * @return ResultVo
     */
    // @RequiresPermissions("buildingPrice:countrypcr:delete")
    @PostMapping("/delete")
    public ResultVo delete(@RequestParam("id") String id) {
        return countrypcrService.delete(id);
    }
    /**
     * 全国省市区名
     *
     * @return ResultVo
     * @author litongzhe
     * @datetime 2019年3月15日15点11分
     */
    @GetMapping("/PCRInfo")
    @PostMapping("/PCRInfo")
    public void PCRInfo() {
        provinceEntity provincePCR = new provinceEntity();
        List<provinceEntity> proentities = (List<provinceEntity>)pricehistorynewService.getProvince().getData();

        List<String> provinces = new ArrayList<>();
        for(provinceEntity e:proentities){
            provinces.add(e.getProvince());
        }
        cityEntity cityPCR = new cityEntity();
        regionEntity regionPCR = new regionEntity();
        CountrypcrEntity countryPCR = new CountrypcrEntity();
        for(String p:provinces){
            cityPCR.setProvince(p);
            List<cityEntity> cityentities = (List<cityEntity>)pricehistorynewService.getCity(cityPCR).getData();
            for(cityEntity c:cityentities){
                String city = c.getCity();
                regionPCR.setProvince(p);
                regionPCR.setCity(city);
                List<regionEntity> regionentities = (List<regionEntity>)pricehistorynewService.getRegion(regionPCR).getData();
                for(regionEntity r:regionentities){
                    String region = r.getCitylevel();
                    if(!region.equals("无")){
                        countryPCR.setProvince(p);
                        countryPCR.setCity(city);
                        countryPCR.setRegion(region);
                        ResultVo resultVo = insert(countryPCR);
                    }
                }
            }
        }
    }
}
