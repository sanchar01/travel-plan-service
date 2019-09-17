package per.san.plan.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.san.common.utils.page.PageHelper;
import per.san.common.utils.page.PageRequest;
import per.san.plan.domain.ShareInfo;
import per.san.plan.mapper.OauthUserMapper;
import per.san.plan.mapper.ShareInfoMapper;
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
@Service
public class ShareInfoServiceImpl implements IShareInfoService {

    @Autowired
    private ShareInfoMapper shareInfoMapper;

    @Autowired
    private OauthUserMapper oauthUserMapper;

    @Override
    public Integer add(ShareInfo shareInfo) {
        return shareInfoMapper.insertSelective(shareInfo);
    }

    @Override
    public Integer deleteByPrimaryKey(Long id) {
        return shareInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer deleteBatch(List<Long> ids) {
        return shareInfoMapper.deleteBatch(ids);
    }

    @Override
    public Integer update(ShareInfo shareInfo) {
        return shareInfoMapper.updateByPrimaryKeySelective(shareInfo);
    }

    @Override
    public PageInfo<ShareInfo> pageQuery(PageRequest pageRequest, ShareInfo shareInfo) {
        return PageHelper.doPage(pageRequest, () -> shareInfoMapper.select(shareInfo));
    }

    @Override
    public List<ShareInfo> queryList(ShareInfo shareInfo) {
        List<ShareInfo> shareInfoList = shareInfoMapper.queryList(shareInfo);
        shareInfoList.forEach(item -> item.setUser(oauthUserMapper.selectByPrimaryKey(item.getUserId())));
        return shareInfoList;
    }

    @Override
    public ShareInfo queryById(Long id) {
    return shareInfoMapper.selectByPrimaryKey(id);
    }
}
