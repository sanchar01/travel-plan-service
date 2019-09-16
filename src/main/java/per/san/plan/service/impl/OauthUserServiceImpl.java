package per.san.plan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.common.utils.HttpRequest;
import per.san.common.utils.page.PageHelper;
import per.san.common.utils.page.PageRequest;
import per.san.plan.domain.OauthUser;
import per.san.plan.mapper.OauthUserMapper;
import per.san.plan.service.IOauthUserService;

import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author sanchar
 * @date 2019-09-13 08:21
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2019-09-13 08:21
 */
@Service
public class OauthUserServiceImpl implements IOauthUserService {

    private static final String APPID = "wx4f16e5470403ed18";
    private static final String SECRET = "9d17cd0af58384b7c2115818bb465921";
    private static final String JSURL = "https://api.weixin.qq.com/sns/jscode2session";

    @Autowired
    private OauthUserMapper oauthUserMapper;

    @Override
    public Integer add(OauthUser oauthUser) {
        return oauthUserMapper.insertSelective(oauthUser);
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {
        return oauthUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatch(List<Long> ids) {
        return oauthUserMapper.deleteBatch(ids);
    }

    @Override
    public Integer update(OauthUser oauthUser) {
        return oauthUserMapper.updateByPrimaryKeySelective(oauthUser);
    }

    @Override
    public PageInfo<OauthUser> pageQuery(PageRequest pageRequest, OauthUser oauthUser) {
        return PageHelper.doPage(pageRequest, () -> oauthUserMapper.select(oauthUser));
    }

    @Override
    public List<OauthUser> queryList(OauthUser oauthUser) {
        return oauthUserMapper.select(oauthUser);
    }

    @Override
    public OauthUser queryById(Long id) {
        return oauthUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public String getOpenId(String jsCode) {
        String param = "appid=" + APPID + "&secret=" + SECRET + "&js_code=" + jsCode + "&grant_type=authorization_code";
        String res = HttpRequest.get(param, JSURL);
        Map<String,String> openInfo = (Map<String,String>) JSONObject.parse(res);
        String openId = openInfo.get("openid") == null ? "" : openInfo.get("openid");
        return openId;
    }

    @Override
    public OauthUser queryByOpenId(String openId) {
        OauthUser oauthUser = new OauthUser();
        oauthUser.setOpenId(openId);
        return oauthUserMapper.selectOne(oauthUser);
    }
}
