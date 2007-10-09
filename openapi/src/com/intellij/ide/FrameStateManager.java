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
package com.intellij.ide;

import com.intellij.openapi.application.ApplicationManager;

/**
 * Manager of listeners for notifications about activation and deactivation of the
 * IDEA window.
 *
 * @since 5.0.2
 */

public abstract class FrameStateManager {
  /**
   * Returns the global <code>FrameStateManager</code> instance.
   *
   * @return the component instance.
   */
  public static FrameStateManager getInstance() {
    return ApplicationManager.getApplication().getComponent(FrameStateManager.class);
  }

  /**
   * Adds a listener which is called when the IDEA window is activated or deactivated.
   *
   * @param listener the listener instance.
   */
  public abstract void addListener(FrameStateListener listener);

  /**
   * Removes a listener which is called when the IDEA window is activated or deactivated.
   *
   * @param listener the listener instance.
   */
  public abstract void removeListener(FrameStateListener listener);
}
