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

import org.junit.Test;


import static org.junit.Assert.*;
public class FirstTest {

	@Test
	public void myFirstTest() {
		Calculator calculator = new Calculator();
		int actual = calculator.add(1, 1);
		assertEquals(1, 1);
		assertEquals("1 + 1 should equal 2", 2, actual);
		assertEquals("This test should fail", "it does");
	}

}
