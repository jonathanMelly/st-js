/**
 *  Copyright 2011 Alexandru Craciun, Eyal Kaspi
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.stjs.testing.driver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * this is a wrapper around the configuration files stjs-test.properties.
 * 
 * @author acraciun
 * 
 */
public class DriverConfiguration {
	private static final String FILE_NAME = "stjs-test.properties";

	private static final String PROP_PORT = "stjs.test.port";

	private static final String PROP_WAIT_FOR_BROWSER = "stjs.test.wait";

	private static final String PROP_SKIP_IF_NO_BROWSER = "stjs.test.skipIfNoBrowser";

	private static final String PROP_START_BROWSER = "stjs.test.startBrowser";

	private static final String PROP_TEST_TIMEOUT = "stjs.test.testTimeout";

	private int port = 8055;
	private int waitForBrowser = 10;
	private boolean skipIfNoBrowser = false;
	private boolean startBrowser = true;
	private int testTimeout = 2;

	public DriverConfiguration() {
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_NAME);
		if (in != null) {
			Properties props = new Properties(System.getProperties());
			try {
				props.load(in);
				if (props.get(PROP_PORT) != null) {
					port = Integer.parseInt(props.getProperty(PROP_PORT));
				}
				if (props.get(PROP_WAIT_FOR_BROWSER) != null) {
					waitForBrowser = Integer.parseInt(props.getProperty(PROP_WAIT_FOR_BROWSER));
				}
				if (props.get(PROP_SKIP_IF_NO_BROWSER) != null) {
					skipIfNoBrowser = Boolean.parseBoolean(props.getProperty(PROP_SKIP_IF_NO_BROWSER));
				}
				if (props.get(PROP_START_BROWSER) != null) {
					startBrowser = Boolean.parseBoolean(props.getProperty(PROP_START_BROWSER));
				}
				if (props.get(PROP_TEST_TIMEOUT) != null) {
					testTimeout = Integer.parseInt(props.getProperty(PROP_TEST_TIMEOUT));
				}

			} catch (IOException e) {
				// silent
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						// silent
					}
				}
			}
		}
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getWaitForBrowser() {
		return waitForBrowser;
	}

	public void setWaitForBrowser(int waitForBrowser) {
		this.waitForBrowser = waitForBrowser;
	}

	public boolean isSkipIfNoBrowser() {
		return skipIfNoBrowser;
	}

	public void setSkipIfNoBrowser(boolean skipIfNoBrowser) {
		this.skipIfNoBrowser = skipIfNoBrowser;
	}

	public boolean isStartBrowser() {
		return startBrowser;
	}

	public void setStartBrowser(boolean startBrowser) {
		this.startBrowser = startBrowser;
	}

	public int getTestTimeout() {
		return testTimeout;
	}

	public void setTestTimeout(int testTimeout) {
		this.testTimeout = testTimeout;
	}

}
