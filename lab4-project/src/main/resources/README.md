## About/Overview. 
**Project 4 - Cross-Stitch Controller:** Is about building a Batch Controller which can apply enhance/edit image based on techniques such as, Filtering, Color Transformations, Reducing Color Density (using Floyd-Steinberg algorithm), Image Mosaic, Image Pixelation and Pattern Generation

Following are the techniques, which I have successfully implemented:

- **Filtering Images:** A filter has a "kernel", which is a 2D array of numbers, having odd dimensions (3x3, 5x5, etc.). Given a pixel in the image and a channel, the
result of the filter can be computed for that pixel and channel. My implementation design for filtering is flexible in a way, given that any predefine filter (as given below), application will compute corresponding pixel values.
  - Image blur 
  - Image sharpening
- **Color transformations:** Color transformation modifies the color of a pixel based on its own color. Color operations mentioned below are implemented as required.
  - Greyscale
  - Sepia tone
- **Reduce color density:** One of the ways in which we want to transform the colors in an image is to reduce the number of colors in the image. Currently, application provides easy way to generate output image either with or without essence. For the purpose of color reduction, I have implemented 'Floyd–Steinberg dithering' algorithm as it was discussed in pdf:
- **Image Mosaic:** The approach "chunking" that effect image into chunks, gives a mosaic effect.
Execution is categorized into three stages: 
- **Pre Processing:** This stage validates all inputs provided by user e.g. Validate image file path, output file location e.t.c.
- **Execute Operation:** This stage executes logic behind enhancement technique.
- **Post Processing:** This stage is responsible for any post processing steps i.e. Clamping e.t.c.  

## List of features.
Following are the features that are working perfectly in the program:
- Filtering Images
  - Image blur
  - Image sharpening
- Color transformations
  - Greyscale
  - Sepia tone
- Reducing color density using 'Floyd–Steinberg dithering' algorithm.
- Image Mosaic


## How To Run JAR File.
- Goto res/
- Open cmd 
- Run command below:
  - java -jar ImageModel.jar [Path]
  - upload birds.png
  - dither 2 essence
  - save dither_2_essence_birds.png
  - q
#### Note: q is quit.
   
   e.g. `java -jar ImageModel.jar C://aneeta/directory/birds.png`
#### Note: Please provide complete path for the image, relative path will not work!!!

## How to Use the Program.
Our program support interactive execution. Batch Controller responds to user commands. The user will give input from the keyboard and process each command one at a time in a batch file. 
Following are the ways that allow user to 
 - upload an image (Original) 
 - applying various effects (Filters) to it. 
 - save the result.  
Enclosed jar file accepts image path as parameter. Apply all the enhancement techniques (as discussed above) and generate corresponding output image files.

## Description of Examples.
Run 1 -- Filename: example1.txt:
upload birds.png
dither 2 essence
save dither_2_essence_birds.png
q

Run 2 -- Filename: example2.txt:
upload Lenna.png
applying blur effect
save blur_Lenna.png
upload Lenna.png
mosaic 6600
save mosaic_6600_Lenna.png
q

#### Note: q is quit. 

## Design/Model Changes.
Following are the changes that are made:
- Concept of Inheritance is used properly; all the operations (e.g. Filtering, Color Transformation, Color Reduce, Image Chunking and Image Pattern Generation) drive from common abstract AImageOperation.
- Create enums for:
  - Filtering type i.e. EFilterType (Blur Filter, Sharp Filter), in future if any new filter is introduce we can easily update our enum.
  - Color Transformation i.e. EColorTransformation (Grey Scale, Sepia Tone)
  - Chunking Image i.e. EChunkingStrategy (Mosaic, Pixelation)
  - Pattern Generation i.e. EPatternGenStrategy (Closest Color, Text Pattern)
- Created a separate interface for the functionality of controller i.e. IEnhancedImageBuilder.
  - EnhancedImageBuilder drives from IEnhancedImageBuilder.
  - MockEnhancedImageBuilder drives from IEnhancedImageBuilder.
  - EnhancedImageController composed from IEnhancedImageBuilder.
- Make the entire field private final.
- Created a new Abstract class ACommand; all the commands extends the common abstract class ACommand. e.g:
  - BlurCommand
  - PatternCommand
  - PixelateCommand
  - MosaicCommand
  - SaveCommand
  - LoadCommand
  - SharpCommand
  - DitherCommand
  - GreyCommand
  - SepiaCommand
- Use open close principle to avoid any modification in future and encourage extension.

## Assumptions.
- User can provide invalid image file i.e. file/path that does not exists.
- User can apply filter multiple times on same image. I have used builder pattern to address this assumption. My 'EnhancedImageBuilder' class expose functions like 'addFilter', 'addColorTransformation' e.t.c these functions return 'EnhancedImageBuilder'. This makes things easy if user want to apply same or different enhancement technique on provided image multiple times.
- Similarly, user can apply color transformation on blur image (or vice versa/ any other combination) without re-running jar file.
- All the image operations (filter, color transformation, color reduction, image mosaic, image pixelation and pattern generation) are derived from abstract class named 'AImageOperation' this makes things easy, when in future client wish to add any other operations, developer requires to implement same abstract to serve the purpose.
- For image color reduction, since user can use either 2 or 8 colors per channel so I have made this configurable (In my 'EnhancedImageBuilder' class method takes int parameter, user can pass any number of colors per channel). 
- For image color reduction, since user can generate image with/without essence so I have made this configurable (In my 'EnhancedImageBuilder' class method takes boolean parameter, user can 'true' for essence, false otherwise).
- In image processing before applying algorithm, sometimes preProcessing of images is required i.e. Remove noise etc. In future if the requirement is to implement any complex algorithm where preProcessing is required we can easily implement them, to serve the purpose. I have categorized the execution in three stages 1) PreProcessing, 2) ExceuteOperation, 3) PostProcessing.
- Like Preprocessing, sometimes post processing is required before storing image on disk. All such operations/algorithms go under 'Postprocessing' method.
- Currently I am assuming when the user runs this jar file, user will expect all the operations should be performed on the image and application writes there result in separate file. Therefore, in my driver class (Main), after getting image file path. I am performing all the operations separately for that image.
- Clamping should be performed on all the techniques; this is why I have written that method in my AImageOperation abstract class.
 

## Limitations.
Following are the limitations of this project that are not implemented.
- Image Pixelation
- Pattern Generation
  - Calculating Closest Color
  - The Pattern Specification

## Citations:
### Image 1:
**Website:** https://www.eecs.tu-berlin.de/

**Title of article name:** Computer	Graphik	I

**Url:** https://www.eecs.tu-berlin.de/fileadmin/fg144/Courses/12WS/cg1/slides/cg1-output.pptx.pdf 

Date of retrieval: 3-26-2021

### Image 2:
**Website:** https://en.wikipedia.org/wiki/Lenna#/media/File:Lenna_(test_image).png

**Url:** https://en.wikipedia.org/wiki/File:Lenna_(test_image).png

**Date of retrieval:** 3-26-2021

