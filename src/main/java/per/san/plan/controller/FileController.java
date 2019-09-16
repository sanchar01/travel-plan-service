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
import per.san.plan.domain.File;
import per.san.plan.service.IFileService;
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
@RequestMapping("/v1/file")
public class FileController {

    @Autowired
    IFileService iFileService;

    @ApiOperation(value = "新增")
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody File file) {
    return new ResponseEntity<>(iFileService.add(file), HttpStatus.OK);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iFileService.deleteByPrimaryKey(id), HttpStatus.OK);
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(iFileService.deleteBatch(ids), HttpStatus.OK);
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public ResponseEntity<Integer> update(@RequestBody File file) {
        return new ResponseEntity<>(iFileService.update(file), HttpStatus.OK);
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public ResponseEntity<PageInfo<File>> pageQuery(
            PageRequest pageRequest,
            @RequestParam(required = false) String fileName,
            @RequestParam(required = false) java.math.BigDecimal fileSize,
            @RequestParam(required = false) String fileType,
            @RequestParam(required = false) String fileUrl,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Integer isDeleted
            ) {
        File file = new File();
        file.setFileName(fileName);
        file.setFileSize(fileSize);
        file.setFileType(fileType);
        file.setFileUrl(fileUrl);
        file.setUserId(userId);
        return new ResponseEntity<>(iFileService.pageQuery(pageRequest, file), HttpStatus.OK);
    }

    @ApiOperation(value = "查询list")
    @GetMapping
    public ResponseEntity<List<File>> queryList(
            @RequestParam(required = false) String fileName,
            @RequestParam(required = false) java.math.BigDecimal fileSize,
            @RequestParam(required = false) String fileType,
            @RequestParam(required = false) String fileUrl,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) Integer isDeleted
            ) {
        File file = new File();
        file.setFileName(fileName);
        file.setFileSize(fileSize);
        file.setFileType(fileType);
        file.setFileUrl(fileUrl);
        file.setUserId(userId);
        return new ResponseEntity<>(iFileService.queryList(file), HttpStatus.OK);
    }

    @ApiOperation(value = "根据ID查询")
    @GetMapping("/{id}")
    public ResponseEntity<File> queryById(
        @PathVariable("id") Long id) {
        return new ResponseEntity<>(iFileService.queryById(id), HttpStatus.OK);
    }
}
