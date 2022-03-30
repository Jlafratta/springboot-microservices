package edu.store.product.domain.model;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.Hibernate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, columnDefinition = "boolean default 1")
    private Boolean enabled;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, columnDefinition="datetime DEFAULT CURRENT_TIMESTAMP")
    private Date creationDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, columnDefinition="datetime DEFAULT CURRENT_TIMESTAMP")
    private Date modifyDate = new Date();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BaseEntity that = (BaseEntity) o;
        return new EqualsBuilder()
                .append(id, that.id)
                .append(enabled, that.enabled)
                .append(creationDate, that.creationDate)
                .append(modifyDate, that.modifyDate)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(enabled)
                .append(creationDate)
                .append(modifyDate)
                .toHashCode();
    }
}