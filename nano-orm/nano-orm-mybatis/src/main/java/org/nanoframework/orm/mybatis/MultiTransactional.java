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
package org.nanoframework.orm.mybatis;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.mybatis.guice.transactional.Isolation;

/**
 * Any method marked with this annotation will be considered for
 * transactionality.
 * MyBatis多数据源事务处理注解<br>
 * 使用时被调用的方法必须是public的，否则无法进入拦截器
 * @author yanghe
 * @since 1.2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MultiTransactional {

    /**
     * Returns the constant indicating the myBatis executor type.
     *
     * @return the constant indicating the myBatis executor type.
     */
    ExecutorType executorType() default ExecutorType.SIMPLE;

    /**
     * Returns the constant indicating the transaction isolation level.
     *
     * @return the constant indicating the transaction isolation level.
     */
    Isolation isolation() default Isolation.DEFAULT;

    /**
     * Returns the constant indicating the transaction isolation level.
     *
     * @return the constant indicating the transaction isolation level.
     * @deprecated use {@link #isolation()} instead, setting this property has no effect.
     */
     @Deprecated
     TransactionIsolationLevel isolationLevel() default TransactionIsolationLevel.NONE;

    /**
     * Flag to indicate that myBatis has to force the transaction {@code commit().}
     *
     * @return false by default, user defined otherwise.
     */
    boolean force() default false;

    /**
     * Flag to indicate the auto commit policy.
     *
     * @return false by default, user defined otherwise.
     *
     * @deprecated Users that intend auto commit can achieve it by simply not using {@literal @Transactional}
     */
    @Deprecated
    boolean autoCommit() default false;

    /**
     * The exception re-thrown when an error occurs during the transaction.
     *
     * @return the exception re-thrown when an error occurs during the
     *         transaction.
     */
    Class<? extends Throwable> rethrowExceptionsAs() default Exception.class;

    /**
     * A custom error message when throwing the custom exception.
     *
     * It supports java.util.Formatter place holders, intercepted method
     * arguments will be used as message format arguments.
     *
     * @return a custom error message when throwing the custom exception.
     * @see java.util.Formatter#format(String, Object...)
     */
    String exceptionMessage() default "";

    /**
     * If true, the transaction will never committed but rather rolled back, useful for testing purposes.
     *
     * This parameter is false by default.
     *
     * @return if true, the transaction will never committed but rather rolled back, useful for testing purposes.
     */
    boolean rollbackOnly() default false;
    
    /** 数据源名称 */
    String[] envId() default "";

}
