package com.booklibrary.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Represents all common properties of standard domain objects with
 * - Created date
 * - Last Edited date
 *
 */
@Data
@NoArgsConstructor
public abstract class BaseDomainObject implements Serializable {

    protected Date createTimestamp = new Date(Calendar.getInstance().getTime().getTime());

    protected Date lastUpdatedTimestamp = new Date(Calendar.getInstance().getTime().getTime());;
}
