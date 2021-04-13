package picture.editor.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import picture.editor.EnhancedImageBuilder;
import picture.editor.IEnhancedImageBuilder;
import picture.editor.command.ACommand;
import picture.editor.command.BlurCommand;
import picture.editor.view.listener.BlurListener;
import picture.editor.view.listener.UploadListener;


public class View extends JFrame {
  
  /** Generated version id */
  private static final long serialVersionUID = -1287427302456084161L;
  
  private static View SINGLE_INSTANCE;
  
  private ImagePanel imagePanel;

  private IEnhancedImageBuilder enhancedImageBuilder;

  private BlurCommand blurCommand;
  
  
  private View(String title) {
    super(title);
    
    this.enhancedImageBuilder = new EnhancedImageBuilder();
   
    setSize(500, 300);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.setLayout(new GridLayout(3,1));
    
    //JButton batchScript = new JButton("Batch Script");
   // JPanel batchFile = new JPanel(new FlowLayout(FlowLayout.RIGHT));
   // batchFile.add(batchScript);
   // this.add(batchFile, BorderLayout.WEST);
    
    // Button on the bottom right
    JButton upload = new JButton("Upload Image");
    JButton saveImage = new JButton("Save Image");
    JButton blurImage = new JButton("Blur Image");
    JButton sharpeImage = new JButton("Sharpe Image");
    JButton sepiaImage = new JButton("Sepia Image");
    JButton greyImage = new JButton("Grey Scale Image");
    JButton ditherImage2WithEssence= new JButton("Dither Image 2 Values With Essence");
    JButton ditherImage2WithoutEssence = new JButton("Dither Image 2 Values Without Essence");
    JButton ditherImage8WithEssence= new JButton("Dither Image 8 Values With Essence");
    JButton ditherImage8WithoutEssence= new JButton("Dither Image 8 Values Without Essence");
    JButton mosaicImage = new JButton("Mosaic Image");
    JButton pixelateImage = new JButton("Pixelation Image");
    JButton patternGeneration = new JButton("Pattern Generation");
   // JButton batchScript = new JButton("Batch Script");
  //  upload.addActionListener(new UploadListener(this)); // observer pattern
   // blurImage.addActionListener(new BlurListener());
    JPanel middlePanel = new JPanel (new BorderLayout());
    middlePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Display Area" ) );

    JTextArea display = new JTextArea ( 16, 58 );
    display.setEditable ( false ); // set textArea non-editable
    JScrollPane scroll = new JScrollPane ( display );
    JButton batchScript = new JButton("Batch Script");
    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

    middlePanel.add ( scroll );

    JPanel buttonPane = new JPanel(); // FlowLayout by default...
    buttonPane.add(display); // Add your buttons here...
    JPanel batchFile = new JPanel(); // FlowLayout by default...
    batchFile.add(batchScript);
    JFrame frame = new JFrame ();
    frame.add ( middlePanel );
    frame.add(buttonPane, BorderLayout.SOUTH);
    frame.add(batchFile, BorderLayout.WEST);
    frame.pack ();
   frame.setLocationRelativeTo ( null );
    frame.setVisible(true);
   JPanel bottom = new JPanel();
    JPanel filter = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JPanel colorTransformation = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JPanel floydAlgorithm = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JPanel chunkingAlgorithm = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JPanel patternGen = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    //JPanel batchFile = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    bottom.add(upload);
   bottom.add(saveImage);
   filter.add(blurImage);
    filter.add(sharpeImage);
    colorTransformation.add(sepiaImage);
    colorTransformation.add(greyImage);
    floydAlgorithm.add(ditherImage2WithEssence);
    floydAlgorithm.add(ditherImage2WithoutEssence);
    floydAlgorithm.add(ditherImage8WithEssence);
    floydAlgorithm.add(ditherImage8WithoutEssence);
    chunkingAlgorithm.add(mosaicImage);
    chunkingAlgorithm.add(pixelateImage);
    patternGen.add(patternGeneration);
  //  batchFile.add(batchScript);
    this.add(bottom, BorderLayout.NORTH);
    this.add(colorTransformation, BorderLayout.NORTH);
    this.add(filter, BorderLayout.BEFORE_FIRST_LINE);
  this.add(floydAlgorithm, BorderLayout.AFTER_LINE_ENDS);
  this.add(chunkingAlgorithm, BorderLayout.LINE_END);
  this.add(patternGen, BorderLayout.LINE_END);
  //this.add(batchFile, BorderLayout.WEST);
   
    
    imagePanel = new ImagePanel();
    this.add(imagePanel, BorderLayout.CENTER);
    imagePanel.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent event) {
        JOptionPane.showMessageDialog(null,  "Mouse Clicked: (" + event.getX() + ", " + event.getY() + ")");
      }
    });
  } 
  

  
  public IEnhancedImageBuilder getEnhancedImageBuilder() {
    return enhancedImageBuilder;
  }
  
  public void start() {
    this.setVisible(true);
  }

  public static View getInstance(final String title) {
    if(SINGLE_INSTANCE == null) {
      SINGLE_INSTANCE = new View(title);
    }
    return SINGLE_INSTANCE;
  }
 
  public static View getInstance() {
    if(SINGLE_INSTANCE == null) {
      throw new IllegalStateException("View instance is not created.");
    }
    return SINGLE_INSTANCE;
  }
}




