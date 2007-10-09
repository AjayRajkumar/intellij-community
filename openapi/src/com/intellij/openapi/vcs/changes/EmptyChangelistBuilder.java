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

package com.intellij.openapi.vcs.changes;

import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vcs.FilePath;

/**
 * @author yole
 */
public class EmptyChangelistBuilder implements ChangelistBuilder {
  public void processChange(final Change change) {
  }

  public void processChangeInList(final Change change, @Nullable final ChangeList changeList) {
  }

  public void processChangeInList(final Change change, final String changeListName) {
  }

  public void processUnversionedFile(final VirtualFile file) {
  }

  public void processLocallyDeletedFile(final FilePath file) {
  }

  public void processModifiedWithoutCheckout(final VirtualFile file) {
  }

  public void processIgnoredFile(final VirtualFile file) {
  }

  public void processSwitchedFile(final VirtualFile file, final String branch, final boolean recursive) {
  }

  public boolean isUpdatingUnversionedFiles() {
    return true;
  }
}