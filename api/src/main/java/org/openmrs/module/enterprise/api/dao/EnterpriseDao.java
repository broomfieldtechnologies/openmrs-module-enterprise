/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.enterprise.api.dao;

import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.openmrs.module.enterprise.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("enterprise.EnterpriseDao")
public class EnterpriseDao {
	
	@Autowired
	DbSessionFactory sessionFactory;
	
	private DbSession getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Enterprise getEnterpriseByUuid(String uuid) {
		return (Enterprise) getSession().createCriteria(Enterprise.class).add(Restrictions.eq("uuid", uuid)).uniqueResult();
	}
	
	public Enterprise getEnterpriseById(Integer id) {
		return (Enterprise) getSession().createCriteria(Enterprise.class).add(Restrictions.eq("id", id)).uniqueResult();
	}
	
	public Enterprise saveEnterprise(Enterprise enterprise) {
		getSession().saveOrUpdate(enterprise);
		return enterprise;
	}
}
