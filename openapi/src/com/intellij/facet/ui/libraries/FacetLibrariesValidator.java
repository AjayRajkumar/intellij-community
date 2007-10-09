/*
 * Copyright 2000-2007 JetBrains s.r.o.
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

package com.intellij.facet.ui.libraries;

import com.intellij.facet.ui.FacetEditorValidator;
import com.intellij.facet.Facet;

/**
 * @author nik
 */
public abstract class FacetLibrariesValidator extends FacetEditorValidator {

  public abstract void setRequiredLibraries(LibraryInfo[] requiredLibraries);

  public abstract FacetLibrariesValidatorDescription getDescription();

  public abstract void onFacetInitialized(Facet facet);

}
