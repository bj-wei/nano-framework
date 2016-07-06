/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nanoframework.commons.support.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author yanghe
 * @since 1.0
 */
public class JakartaCommonsLoggingImpl implements org.nanoframework.commons.support.logging.Logger {

    private Log log;

    private int errorCount;
    private int warnCount;
    private int infoCount;
    private int debugCount;

    /**
     * @since 0.2.1
     * @param log the log
     */
    public JakartaCommonsLoggingImpl(Log log) {
        this.log = log;
    }

    public JakartaCommonsLoggingImpl(String loggerName) {
        log = LogFactory.getLog(loggerName);
    }

    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    public void error(String s, Throwable e) {
        log.error(s, e);
        errorCount++;
    }

    public void error(String s) {
        log.error(s);
        errorCount++;
    }

    public void debug(String s) {
        debugCount++;
        log.debug(s);
    }

    public void debug(String s, Throwable e) {
        debugCount++;
        log.debug(s, e);
    }

    public void warn(String s) {
        log.warn(s);
        warnCount++;
    }

    @Override
    public void warn(String s, Throwable e) {
        log.warn(s, e);
        warnCount++;
    }

    @Override
    public int getWarnCount() {
        return warnCount;
    }

    public int getErrorCount() {
        return errorCount;
    }

    @Override
    public void resetStat() {
        errorCount = 0;
        warnCount = 0;
        infoCount = 0;
        debugCount++;
    }

    @Override
    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    @Override
    public void info(String msg) {
        log.info(msg);
        infoCount++;
    }

    @Override
    public int getInfoCount() {
        return infoCount;
    }

    @Override
    public boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }

    public int getDebugCount() {
        return debugCount;
    }

    @Override
    public void warn(String paramString, Object... paramArrayOfObject) {

    }

    @Override
    public void warn(Throwable paramThrowable) {

    }

    @Override
    public void info(String paramString, Object... paramArrayOfObject) {

    }

    @Override
    public void info(Throwable paramThrowable) {

    }

    @Override
    public void info(String paramString, Throwable paramThrowable) {

    }

    @Override
    public void debug(String paramString, Object... paramArrayOfObject) {

    }

    @Override
    public void debug(Throwable paramThrowable) {

    }

    @Override
    public void error(String paramString, Object... paramArrayOfObject) {

    }

    @Override
    public void error(Throwable paramThrowable) {

    }

}
