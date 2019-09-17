package per.san.plan.domain;

import per.san.generate.domain.AuditDomain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * description: 
 *
 * @author sanchar
 * @date 2019-09-13 08:21
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2019-09-13 08:21
 */
@Table(name="share_info")
public class ShareInfo extends AuditDomain {

    /**
    *主键ID
    */
    @Id
    private Long id;

    /**
    *用户ID
    */
    private Long userId;

    /**
    *内容
    */
    private String content;

    /**
    *地点
    */
    private String address;

    /**
    *是否展示地点
    */
    private Boolean isShowLocation;

    /**
    *权限
    */
    private String permission;

    @Transient
    private OauthUser user;

    @Transient
    private Integer page;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getShowLocation() {
        return isShowLocation;
    }

    public void setShowLocation(Boolean showLocation) {
        isShowLocation = showLocation;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public OauthUser getUser() {
        return user;
    }

    public void setUser(OauthUser user) {
        this.user = user;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
