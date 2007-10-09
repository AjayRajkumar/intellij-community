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
package com.intellij.psi.util;

import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MethodSignatureHandMade extends MethodSignatureBase {
  private final String myName;
  MethodSignatureHandMade(@NotNull String name, @Nullable PsiParameterList parameterList, @Nullable PsiTypeParameterList typeParameterList, @NotNull PsiSubstitutor substitutor) {
    super(substitutor, parameterList, typeParameterList);
    myName = name;
  }

  MethodSignatureHandMade(@NotNull String name, @NotNull PsiType[] parameterTypes, @NotNull PsiTypeParameter[] typeParameters, @NotNull PsiSubstitutor substitutor) {
    super(substitutor, parameterTypes, typeParameters);
    myName = name;
  }


  @NotNull
  public String getName() {
    return myName;
  }

  public boolean isRaw() {
    for (final PsiTypeParameter typeParameter : myTypeParameters) {
      if (getSubstitutor().substitute(typeParameter) == null) return true;
    }
    return false;
  }

  public boolean isInGenericContext() {
    return !isRaw();
  }

}
