package org.ilite.util.gui.builder.components;

import javax.swing.JLabel;

import org.ilite.util.gui.builder.IRenderer;

public class JLabelRenderer extends JLabel implements IRenderer
{
  @Override
  public <T> void render(T pValue)
  {
    setText(pValue == null ? "null" : pValue.toString());
  }

}
