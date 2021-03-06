/*
 * Copyright 2000-2015 JetBrains s.r.o.
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
package org.jetbrains.idea.maven.dom.model.presentation;

import com.intellij.ide.presentation.PresentationProvider;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.idea.maven.dom.model.MavenDomRepository;

/**
 *
 */
public class MavenDomRepositoryPresentationProvider extends PresentationProvider<MavenDomRepository> {
  @Nullable
  @Override
  public String getName(MavenDomRepository mavenDomRepository) {
    return "Repository (id=" + mavenDomRepository.getId().getStringValue()
           + ", url=" + mavenDomRepository.getUrl().getStringValue()
           + ')';
  }
}
