package modelEntity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class BaseEntity {

    @Column(name = "CREATED_BY", updatable = false)
    private String createdBy;

    @CreationTimestamp
    @Column(name = "CREATED TIME", updatable = false)
    private Timestamp createdTime;

    @Column(name = "UPDATED BY")
    private String updatedBy;

    @CreationTimestamp
    @Column(name = "UPDATED TIME")
    private Timestamp updatedTime;

}
