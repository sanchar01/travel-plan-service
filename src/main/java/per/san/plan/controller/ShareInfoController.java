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
import per.san.plan.domain.ShareInfo;
import per.san.plan.service.IShareInfoService;
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
@RequestMapping("/v1/share/info")
public class ShareInfoController {

    @Autowired
    IShareInfoService iShareInfoService;

    @ApiOperation(value = "新增")
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody ShareInfo shareInfo) {
    return new ResponseEntity<>(iShareInfoService.add(shareInfo), HttpStatus.OK);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iShareInfoService.deleteByPrimaryKey(id), HttpStatus.OK);
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(iShareInfoService.deleteBatch(ids), HttpStatus.OK);
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public ResponseEntity<Integer> update(@RequestBody ShareInfo shareInfo) {
        return new ResponseEntity<>(iShareInfoService.update(shareInfo), HttpStatus.OK);
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public ResponseEntity<PageInfo<ShareInfo>> pageQuery(
            PageRequest pageRequest,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) String content,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String permission
            ) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setUserId(userId);
        shareInfo.setContent(content);
        shareInfo.setAddress(address);
        shareInfo.setPermission(permission);
        return new ResponseEntity<>(iShareInfoService.pageQuery(pageRequest, shareInfo), HttpStatus.OK);
    }

    @ApiOperation(value = "查询list")
    @GetMapping
    public ResponseEntity<List<ShareInfo>> queryList(
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) String content,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Integer isShowLocation,
            @RequestParam(required = false) String permission,
            @RequestParam(required = false) Integer isDeleted
            ) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setUserId(userId);
        shareInfo.setContent(content);
        shareInfo.setAddress(address);
        shareInfo.setPermission(permission);
        return new ResponseEntity<>(iShareInfoService.queryList(shareInfo), HttpStatus.OK);
    }

    @ApiOperation(value = "根据ID查询")
    @GetMapping("/{id}")
    public ResponseEntity<ShareInfo> queryById(
        @PathVariable("id") Long id) {
        return new ResponseEntity<>(iShareInfoService.queryById(id), HttpStatus.OK);
    }
}
