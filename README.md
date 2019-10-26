>"The Hershey fonts are a collection of vector fonts developed circa 1967 by Dr. A. V. Hershey at the Naval Weapons Laboratory.[1][2] The fonts are publicly available and have few restrictions.[3] Vector fonts are easily scaled and rotated in two or three dimensions; consequently the Hershey fonts have been widely used in computer graphics and computer-aided design programs." (https://en.wikipedia.org/wiki/Hershey_font)

We developed this Library for drawing typography on drawbots in mind. The basic problem with common typography on drawbots is the filling pattern. Otherwise only the outlines are drawn.

## HersheyFont Library Features:  
1. Drawing line fonts in Processing
2. Create PShape from string
3. Export SVG via P8gGraphicsSVG

## Usage:
1. Import library
`import de.ixdhof.hershey.*;`

2. Initialize and load font
`HersheyFont hf = new HersheyFont(this, "cursive.jhf");`

3. Set text size
`hf.textSize(100);`

4. Draw text
`hf.text("Hello", 0, 0);`

5. Create and draw PShape
`PShape ps = hf.getShape("Processing");`
`shape(ps);`

## Example:

    import de.ixdhof.hershey.*;

    HersheyFont hf;

    void setup()
    {
    size(925, 500, P3D);
    hf = new HersheyFont(this, "cursive.jhf");
    hf.textSize(100);
    }

    void draw()
    {
    background(255);

    translate(100, height/3);
    hf.text("Hello", 0, 0);
    translate(0, height/3);
    shape(hf.getShape("Processing"));
    }

The library contains all Hershey fonts provided by Jeff Epler under the original license:

    USE RESTRICTION:
    This distribution of the Hershey Fonts may be used by anyone for any purpose, commercial or otherwise, providing that:
    1. The following acknowledgements must be distributed with the font data:
    - The Hershey Fonts were originally created by Dr. A. V. Hershey while working at the U. S. National Bureau of Standards.
    - The format of the Font data in this distribution
    was originally created by James Hurt
    Cognition, Inc.
    900 Technology Park Drive
    Billerica, MA 01821
    (mit-eddie!ci-dandelion!hurt)
    2. The font data in this distribution may be converted into any other format *EXCEPT* the format distributed by the U.S. NTIS (which organization holds the rights to the distribution and use of the font data in that particular format). Not that anybody would really *want* to use their format... each point is described in eight bytes as "xxx yyy:", where xxx and yyy are the coordinate values as ASCII numbers.
