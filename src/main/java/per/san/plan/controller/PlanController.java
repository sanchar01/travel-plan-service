package per.san.plan.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.san.common.utils.page.PageRequest;
import per.san.plan.domain.Plan;
import per.san.plan.service.IPlanService;

import java.util.Date;
import java.util.List;

/**
 * description: 
 *
 * @author sanchar
 * @date 2019-09-13 08:21
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2019-09-13 08:21
 */
@RestController
@RequestMapping("/v1/plan")
public class PlanController {

    @Autowired
    IPlanService iPlanService;

    @ApiOperation(value = "新增")
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody Plan plan) {
    return new ResponseEntity<>(iPlanService.add(plan), HttpStatus.OK);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iPlanService.deleteByPrimaryKey(id), HttpStatus.OK);
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(iPlanService.deleteBatch(ids), HttpStatus.OK);
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public ResponseEntity<Integer> update(@RequestBody Plan plan) {
        return new ResponseEntity<>(iPlanService.update(plan), HttpStatus.OK);
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public ResponseEntity<PageInfo<Plan>> pageQuery(
            PageRequest pageRequest,
            @RequestParam(required = false) String planName,
            @RequestParam(required = false) Long planDays,
            @RequestParam(required = false) Date startDate,
            @RequestParam(required = false) String permission,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Integer isDeleted
            ) {
        Plan plan = new Plan();
        plan.setPlanName(planName);
        plan.setPlanDays(planDays);
        plan.setStartDate(startDate);
        plan.setPermission(permission);
        plan.setStatus(status);
        plan.setUserId(userId);
        return new ResponseEntity<>(iPlanService.pageQuery(pageRequest, plan), HttpStatus.OK);
    }

    @ApiOperation(value = "查询list")
    @GetMapping
    public ResponseEntity<List<Plan>> queryList(
            @RequestParam(required = false) String planName,
            @RequestParam(required = false) Long planDays,
            @RequestParam(required = false) Date startDate,
            @RequestParam(required = false) String permission,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Integer page
            ) {
        Plan plan = new Plan();
        plan.setPlanName(planName);
        plan.setPlanDays(planDays);
        plan.setStartDate(startDate);
        plan.setPermission(permission);
        plan.setStatus(status);
        plan.setUserId(userId);
        plan.setPage(page);
        return new ResponseEntity<>(iPlanService.queryList(plan), HttpStatus.OK);
    }

    @ApiOperation(value = "根据ID查询")
    @GetMapping("/{id}")
    public ResponseEntity<Plan> queryById(
        @PathVariable("id") Long id) {
        return new ResponseEntity<>(iPlanService.queryById(id), HttpStatus.OK);
    }
}
