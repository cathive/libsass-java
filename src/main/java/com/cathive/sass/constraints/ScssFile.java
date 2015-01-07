/*
 * Copyright (C) 2014,2015 The Cat Hive Developers.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cathive.sass.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The annotated element must denote a valid SCSS file.
 * <p>Supported types are:
 * <ul>
 *     <li>{@code java.lang.String}</li>
 *     <li>{@code java.nio.file.Path}</li>
 *     <li>{@code java.io.File}</li>
 * </ul>
 * @author Benjamin P. Jung
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {
        ScssFileValidation.ScssFilePathValidator.class,
        ScssFileValidation.ScssFilePathValidator.class
})
public @interface ScssFile {

        String message() default "{com.cathive.sass.constraints.ScssFile.message}";

        Class<?>[] groups() default { };

        Class<? extends Payload>[] payload() default { };

        /**
         * Defines several {@link ScssFile} annotations on the same element.
         * @see com.cathive.sass.constraints.ScssFile
         */
        @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
        @Retention(RUNTIME)
        @Documented
        @interface List {
                ScssFile[] value();
        }

}
