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
package com.intellij.openapi.editor.event;

public abstract class EditorMouseAdapter implements EditorMouseListener{
  public void mouseReleased(EditorMouseEvent e){
  }

  public void mousePressed(EditorMouseEvent e){
  }

  public void mouseClicked(EditorMouseEvent e){
  }

  public void mouseEntered(EditorMouseEvent e){
  }

  public void mouseExited(EditorMouseEvent e){
  }
}