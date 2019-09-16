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
@Table(name="file")
public class File extends AuditDomain {

    /**
    *主键ID
    */
    @Id
    private Long id;

    /**
    *文件名
    */
    private String fileName;

    /**
    *文件大小
    */
    private java.math.BigDecimal fileSize;

    /**
    *文件类型
    */
    private String fileType;

    /**
    *文件存储路径
    */
    private String fileUrl;

    /**
    *用户ID
    */
    private Long userId;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public java.math.BigDecimal getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(java.math.BigDecimal fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
