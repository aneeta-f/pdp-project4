package picture.editor.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

public class ImagePanel extends JPanel implements Scrollable {
  
  /** Generated version id. */
  private static final long serialVersionUID = -7919107801874775685L;
  
  private BufferedImage image;
  private static final int maxUnitIncrement = 10;
  
  public ImagePanel() {
    image = null;
  }
  
  public void setImage(BufferedImage image) {
    this.image = image;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (image != null) {
      g.drawImage(image, 0, 0, this);
    }
  }

  @Override
  public Dimension getPreferredScrollableViewportSize() {
    if (image == null) {
      return new Dimension(500,300);
    }
    else {
      return super.getPreferredSize();
    }
  }

  @Override
  public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
    if (orientation == SwingConstants.HORIZONTAL) {
      return visibleRect.width - maxUnitIncrement;
    }
    else {
      return visibleRect.height = maxUnitIncrement;
    }
  }

  @Override
  public boolean getScrollableTracksViewportHeight() {
    return false;
  }

  @Override
  public boolean getScrollableTracksViewportWidth() {
    return false;
  }

  @Override
  public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
    //Get the current position.
    int currentPosition = 0;
    if (orientation == SwingConstants.HORIZONTAL) {
        currentPosition = visibleRect.x;
    } else {
        currentPosition = visibleRect.y;
    }

    //Return the number of pixels between currentPosition
    //and the nearest tick mark in the indicated direction.
    if (direction < 0) {
        int newPosition = currentPosition -
                         (currentPosition / maxUnitIncrement)
                          * maxUnitIncrement;
        return (newPosition == 0) ? maxUnitIncrement : newPosition;
    } else {
        return ((currentPosition / maxUnitIncrement) + 1)
               * maxUnitIncrement
               - currentPosition;
    }
  }
}
