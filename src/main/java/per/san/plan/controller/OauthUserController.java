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
import per.san.plan.domain.OauthUser;
import per.san.plan.service.IOauthUserService;
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
@RequestMapping("/v1/oauth/user")
public class OauthUserController {

    @Autowired
    IOauthUserService iOauthUserService;

    @ApiOperation(value = "新增")
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody OauthUser oauthUser) {
    return new ResponseEntity<>(iOauthUserService.add(oauthUser), HttpStatus.OK);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Long id) {
        return new ResponseEntity<>(iOauthUserService.deleteByPrimaryKey(id), HttpStatus.OK);
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/batch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody List<Long> ids) {
        return new ResponseEntity<>(iOauthUserService.deleteBatch(ids), HttpStatus.OK);
    }

    @ApiOperation(value = "更新")
    @PutMapping
    public ResponseEntity<Integer> update(@RequestBody OauthUser oauthUser) {
        return new ResponseEntity<>(iOauthUserService.update(oauthUser), HttpStatus.OK);
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public ResponseEntity<PageInfo<OauthUser>> pageQuery(
            PageRequest pageRequest,
            @RequestParam(required = false) String nickName,
            @RequestParam(required = false) Integer gender,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String province,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String avatarUrl,
            @RequestParam(required = false) String openId,
            @RequestParam(required = false) Integer isDeleted
            ) {
        OauthUser oauthUser = new OauthUser();
        oauthUser.setNickName(nickName);
        oauthUser.setGender(gender);
        oauthUser.setLanguage(language);
        oauthUser.setCountry(country);
        oauthUser.setProvince(province);
        oauthUser.setCity(city);
        oauthUser.setAvatarUrl(avatarUrl);
        oauthUser.setOpenId(openId);
        return new ResponseEntity<>(iOauthUserService.pageQuery(pageRequest, oauthUser), HttpStatus.OK);
    }

    @ApiOperation(value = "查询list")
    @GetMapping
    public ResponseEntity<List<OauthUser>> queryList(
            @RequestParam(required = false) String nickName,
            @RequestParam(required = false) Integer gender,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String province,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String avatarUrl,
            @RequestParam(required = false) String openId,
            @RequestParam(required = false) Integer isDeleted
            ) {
        OauthUser oauthUser = new OauthUser();
        oauthUser.setNickName(nickName);
        oauthUser.setGender(gender);
        oauthUser.setLanguage(language);
        oauthUser.setCountry(country);
        oauthUser.setProvince(province);
        oauthUser.setCity(city);
        oauthUser.setAvatarUrl(avatarUrl);
        oauthUser.setOpenId(openId);
        return new ResponseEntity<>(iOauthUserService.queryList(oauthUser), HttpStatus.OK);
    }

    @ApiOperation(value = "根据ID查询")
    @GetMapping("/{id}")
    public ResponseEntity<OauthUser> queryById(
        @PathVariable("id") Long id) {
        return new ResponseEntity<>(iOauthUserService.queryById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "根据jsCode获取openId")
    @GetMapping("/openid")
    public ResponseEntity<String> getOpenId(
        @RequestParam("jsCode") String jsCode) {
        return new ResponseEntity<>(iOauthUserService.getOpenId(jsCode), HttpStatus.OK);
    }

    @ApiOperation(value = "根据openId查询")
    @GetMapping("/openid/info")
    public ResponseEntity<OauthUser> queryByOpenId(
            @RequestParam("openId") String openId) {
        return new ResponseEntity<>(iOauthUserService.queryByOpenId(openId), HttpStatus.OK);
    }
}
