package per.san.plan.domain;

import per.san.generate.domain.AuditDomain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * description: 
 *
 * @author sanchar
 * @date 2019-09-13 08:21
 * lastUpdateBy: sanchar
 * lastUpdateDate: 2019-09-13 08:21
 */
@Table(name="oauth_user")
public class OauthUser extends AuditDomain {

    /**
    *主键ID
    */
    @Id
    private Long id;

    /**
    *微信昵称
    */
    private String nickName;

    /**
    *性别
    */
    private Integer gender;

    /**
    *语言
    */
    private String language;

    /**
    *国家
    */
    private String country;

    /**
    *省份
    */
    private String province;

    /**
    *城市
    */
    private String city;

    /**
    *微信头像
    */
    private String avatarUrl;

    /**
    *openId
    */
    private String openId;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGender() {
        return this.gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

}
