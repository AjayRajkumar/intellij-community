// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.ui.tabs.impl;

import com.intellij.ui.ColorUtil;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;
import com.intellij.ui.tabs.JBTabsPosition;
import com.intellij.util.ui.UIUtil;

import java.awt.*;

/**
 * @author Konstantin Bulenkov
 */
public abstract class JBEditorTabsPainter {
  protected Color myDefaultTabColor;
  protected final JBEditorTabs myTabs;

  protected static final Color BORDER_COLOR = JBColor.namedColor("EditorTabs.borderColor", UIUtil.CONTRAST_BORDER_COLOR);
  protected static final Color UNDERLINE_COLOR = JBColor.namedColor("EditorTabs.underlineColor", 0x439EB8);
  protected static final Color DEFAULT_TAB_COLOR = JBColor.namedColor("EditorTabs.selectedBackground", new JBColor(0xFFFFFF, 0x515658));
  protected static final Color INACTIVE_MASK_COLOR = JBColor.namedColor("EditorTabs.inactiveMaskColor",
                                                                        new JBColor(ColorUtil.withAlpha(Gray.x26, .2),
                                                                                    ColorUtil.withAlpha(Gray.x26, .5)));

  public JBEditorTabsPainter(JBEditorTabs tabs) {
    myTabs = tabs;
  }

  public abstract void doPaintInactive(Graphics2D g2d,
                       Rectangle effectiveBounds,
                       int x,
                       int y,
                       int w,
                       int h,
                       Color tabColor,
                       int row,
                       int column,
                       boolean vertical);

  public abstract void doPaintBackground(Graphics2D g, Rectangle clip, boolean vertical, Rectangle rectangle);
  public abstract void fillSelectionAndBorder(Graphics2D g, JBTabsImpl.ShapeInfo selectedShape, Color tabColor, int x, int y, int height);

  public void paintSelectionAndBorder(Graphics2D g2d,
                                      Rectangle rect,
                                      JBTabsImpl.ShapeInfo selectedShape,
                                      Insets insets,
                                      Color tabColor) {
    Insets i = selectedShape.path.transformInsets(insets);
    int _x = rect.x;
    int _y = rect.y;
    int _height = rect.height;
    final JBTabsPosition position = myTabs.getPosition();
    final boolean horizontalTabs = myTabs.isHorizontalTabs();

    if (myTabs.hasUnderlineSelection() /*&& myTabs.getTabCount() > 1*/) {
      fillSelectionAndBorder(g2d, selectedShape, tabColor, _x, _y, _height);

      //todo[kb] move to editor scheme
      g2d.setColor(hasFocus(myTabs) ? UNDERLINE_COLOR : ColorUtil.withAlpha(UNDERLINE_COLOR, 0.5));
      int thickness = 3;
      if (position == JBTabsPosition.bottom) {
        g2d.fillRect(rect.x, rect.y - 1, rect.width, thickness);
      } else if (position == JBTabsPosition.top){
        g2d.fillRect(rect.x, rect.y + rect.height - thickness + 1, rect.width, thickness);
        g2d.setColor(BORDER_COLOR);
        g2d.drawLine(Math.max(0, rect.x - 1), rect.y, rect.x + rect.width, rect.y);
      } else if (position == JBTabsPosition.left) {
        g2d.fillRect(rect.x + rect.width - thickness + 1, rect.y, thickness, rect.height);
      } else if (position == JBTabsPosition.right) {
        g2d.fillRect(rect.x, rect.y, thickness, rect.height);
      }

      return;
    }

    if (!horizontalTabs) {
      g2d.setColor(Gray._0.withAlpha(45));
      g2d.draw(
        selectedShape.labelPath.transformLine(i.left, selectedShape.labelPath.getMaxY()
                                                      - selectedShape.labelPath.deltaY(4), selectedShape.path.getMaxX(),
                                              selectedShape.labelPath.getMaxY() - selectedShape.labelPath.deltaY(4)));

      g2d.setColor(Gray._0.withAlpha(15));
      g2d.draw(
        selectedShape.labelPath.transformLine(i.left, selectedShape.labelPath.getMaxY()
                                                      - selectedShape.labelPath.deltaY(5), selectedShape.path.getMaxX(),
                                              selectedShape.labelPath.getMaxY() - selectedShape.labelPath.deltaY(5)));
    }

    fillSelectionAndBorder(g2d, selectedShape, tabColor, _x, _y, _height);

    if (!horizontalTabs) {
      // side shadow
      g2d.setColor(Gray._0.withAlpha(30));
      g2d.draw(selectedShape.labelPath
                 .transformLine(selectedShape.labelPath.getMaxX() + selectedShape.labelPath.deltaX(1), selectedShape.labelPath.getY() +
                                                                                                       selectedShape.labelPath.deltaY(1),
                                selectedShape.labelPath.getMaxX() + selectedShape.labelPath.deltaX(1), selectedShape.labelPath.getMaxY() -
                                                                                                       selectedShape.labelPath.deltaY(4)));


      g2d.draw(selectedShape.labelPath
                 .transformLine(selectedShape.labelPath.getX() - selectedShape.labelPath.deltaX(1),
                                selectedShape.labelPath.getY() +
                                selectedShape.labelPath.deltaY(1),
                                selectedShape.labelPath.getX() - selectedShape.labelPath.deltaX(1),
                                selectedShape.labelPath.getMaxY() -
                                selectedShape.labelPath.deltaY(4)));
    }

    g2d.setColor(Gray._0.withAlpha(15));
    g2d.draw(selectedShape.labelPath.transformLine(i.left, selectedShape.labelPath.getMaxY(),
                                                   selectedShape.path.getMaxX(),
                                                   selectedShape.labelPath.getMaxY()));
  }

  public static boolean hasFocus(Component component) {
    Component focusOwner = findFocusOwner(component);
    return focusOwner != null;
  }

  private static Component findFocusOwner(Component c) {
    Component focusOwner = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

    // verify focusOwner is a descendant of c
    for (Component temp = focusOwner; temp != null; temp = (temp instanceof Window) ? null : temp.getParent())
    {
      if (temp == c) {
        return focusOwner;
      }
    }

    return null;
  }

  public abstract Color getBackgroundColor();

  public Color getEmptySpaceColor() {
    return UIUtil.isUnderAquaLookAndFeel() ? Gray.xC8 : UIUtil.getPanelBackground();
  }

  public void setDefaultTabColor(Color color) {
    myDefaultTabColor = color;
  }
}
