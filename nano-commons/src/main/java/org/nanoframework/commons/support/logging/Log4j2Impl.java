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

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.ExtendedLogger;

/**
 *
 * @author yanghe
 * @since 1.0
 */
public class Log4j2Impl implements org.nanoframework.commons.support.logging.Logger {

    private ExtendedLogger log;

    private static final String FQCN = Log4j2Impl.class.getName();
    private int errorCount;
    private int warnCount;
    private int infoCount;
    private int debugCount;

    /**
     * @since 0.2.21
     * @param log the log
     */
    public Log4j2Impl(Logger log) {
        this.log = (ExtendedLogger) log;
    }

    public Log4j2Impl(String loggerName) {
        log = (ExtendedLogger) LogManager.getLogger(loggerName);
    }

    public Logger getLog() {
        return log;
    }

    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    public void error(String s, Throwable e) {
        errorCount++;
        log.logIfEnabled(FQCN, Level.ERROR, null, s, e);
    }

    public void error(String s) {
        errorCount++;
        log.logIfEnabled(FQCN, Level.ERROR, null, s);
    }

    public void debug(String s) {
        debugCount++;
        log.logIfEnabled(FQCN, Level.DEBUG, null, s);
    }

    public void debug(String s, Throwable e) {
        debugCount++;
        log.logIfEnabled(FQCN, Level.DEBUG, null, s, e);
    }

    public void warn(String s) {
        warnCount++;
        log.logIfEnabled(FQCN, Level.WARN, null, s);
    }

    public void warn(String s, Throwable e) {
        warnCount++;
        log.logIfEnabled(FQCN, Level.WARN, null, s, e);
    }

    public int getWarnCount() {
        return warnCount;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void resetStat() {
        errorCount = 0;
        warnCount = 0;
        infoCount = 0;
        debugCount = 0;
    }

    public int getDebugCount() {
        return debugCount;
    }

    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    public void info(String msg) {
        infoCount++;
        log.logIfEnabled(FQCN, Level.INFO, null, msg);
    }

    public boolean isWarnEnabled() {
        return log.isEnabled(Level.WARN);
    }

    public int getInfoCount() {
        return infoCount;
    }

    public String toString() {
        return log.toString();
    }

    @Override
    public void warn(String paramString, Object... paramArrayOfObject) {
        warnCount++;
        log.logIfEnabled(FQCN, Level.WARN, null, paramString, paramArrayOfObject);
    }

    @Override
    public void warn(Throwable paramThrowable) {
        warnCount++;
        log.logIfEnabled(FQCN, Level.WARN, null, "", paramThrowable);
    }

    @Override
    public void info(String paramString, Object... paramArrayOfObject) {
        infoCount++;
        log.logIfEnabled(FQCN, Level.INFO, null, paramString, paramArrayOfObject);
    }

    @Override
    public void info(Throwable paramThrowable) {
        infoCount++;
        log.logIfEnabled(FQCN, Level.INFO, null, "", paramThrowable);
    }

    @Override
    public void info(String paramString, Throwable paramThrowable) {
        infoCount++;
        log.logIfEnabled(FQCN, Level.INFO, null, paramString, paramThrowable);
    }

    @Override
    public void debug(String paramString, Object... paramArrayOfObject) {
        debugCount++;
        log.logIfEnabled(FQCN, Level.DEBUG, null, paramString, paramArrayOfObject);
    }

    @Override
    public void debug(Throwable paramThrowable) {
        debugCount++;
        log.logIfEnabled(FQCN, Level.DEBUG, null, "", paramThrowable);
    }

    @Override
    public void error(String paramString, Object... paramArrayOfObject) {
        errorCount++;
        log.logIfEnabled(FQCN, Level.ERROR, null, paramString, paramArrayOfObject);
    }

    @Override
    public void error(Throwable paramThrowable) {
        errorCount++;
        log.logIfEnabled(FQCN, Level.ERROR, null, "", paramThrowable);
    }
}
