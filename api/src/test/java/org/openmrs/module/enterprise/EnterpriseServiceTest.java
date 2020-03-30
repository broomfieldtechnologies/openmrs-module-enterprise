/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.enterprise.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openmrs.User;
import org.openmrs.api.UserService;
import org.openmrs.module.enterprise.Enterprise;
import org.openmrs.module.enterprise.api.dao.EnterpriseDao;
import org.openmrs.module.enterprise.api.impl.EnterpriseServiceImpl;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * This is a unit test, which verifies logic in EnterpriseService. It doesn't extend
 * BaseModuleContextSensitiveTest, thus it is run without the in-memory DB and Spring context.
 */
public class EnterpriseServiceTest {
	
	@InjectMocks
	EnterpriseServiceImpl basicModuleService;
	
	@Mock
	EnterpriseDao dao;
	
	@Mock
	UserService userService;
	
	@Before
	public void setupMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void saveItem_shouldSetOwnerIfNotSet() {
		//Given
		Enterprise enterprise = new Enterprise();
		enterprise.setDescription("some description");
		
		when(dao.saveEnterprise(enterprise)).thenReturn(enterprise);
		
		User user = new User();
		when(userService.getUser(1)).thenReturn(user);
		
		//When
		basicModuleService.saveEnterprise(enterprise);
		
		//Then
		assertThat(enterprise, hasProperty("creator", is(user)));
	}
}
