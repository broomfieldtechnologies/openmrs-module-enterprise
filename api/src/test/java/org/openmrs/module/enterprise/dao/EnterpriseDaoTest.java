/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.enterprise.dao;

import org.junit.Test;
import org.junit.Ignore;
import org.openmrs.api.UserService;
import org.openmrs.api.context.Context;
import org.openmrs.module.enterprise.Enterprise;
import org.openmrs.module.enterprise.api.dao.EnterpriseDao;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * It is an integration test (extends BaseModuleContextSensitiveTest), which verifies DAO methods
 * against the in-memory H2 database. The database is initially loaded with data from
 * standardTestDataset.xml in openmrs-api. All test methods are executed in transactions, which are
 * rolled back by the end of each test method.
 */
public class EnterpriseDaoTest extends BaseModuleContextSensitiveTest {
	
	@Autowired
	EnterpriseDao dao;
	
	@Autowired
	UserService userService;
	
	@Test
	@Ignore("Unignore if you want to make the Enterprise class persistable, see also Enterprise and liquibase.xml")
	public void saveEnterprise_shouldSaveAllPropertiesInDb() {
		//Given
		Enterprise enterprise = new Enterprise();
		enterprise.setDescription("some description");
		enterprise.setCreator(userService.getUser(1));
		
		//When
		dao.saveEnterprise(enterprise);
		
		//Let's clean up the cache to be sure getItemByUuid fetches from DB and not from cache
		Context.flushSession();
		Context.clearSession();
		
		//Then
		Enterprise savedEnterprise = dao.getEnterpriseByUuid(enterprise.getUuid());
		
		assertThat(savedEnterprise, hasProperty("uuid", is(enterprise.getUuid())));
		assertThat(savedEnterprise, hasProperty("creator", is(enterprise.getCreator())));
		assertThat(savedEnterprise, hasProperty("description", is(enterprise.getDescription())));
	}
}
