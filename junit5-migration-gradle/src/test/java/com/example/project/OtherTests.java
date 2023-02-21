/*
 * Copyright 2015-2021 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import org.junit.jupiter.api.Test;

class OtherTests {

	@Test
	void testThisThing() throws InterruptedException {
		slowFunc();
	}

	void slowFunc() throws InterruptedException {
		Thread.sleep(1000);
	}

	@Test
	void testThisOtherThing() {
	}

}
