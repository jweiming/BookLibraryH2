package com.booklibrary.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Represents all common properties of standard domain objects with
 * - Created date
 * - Last Edited date
 *
 */
@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class BaseDomainObject implements Serializable {

    @CreationTimestamp
    protected Timestamp createTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());

    @UpdateTimestamp
    protected Timestamp lastUpdatedTimestamp;
}
