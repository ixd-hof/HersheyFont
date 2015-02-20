import org.philhosoft.p8g.svg.P8gGraphicsSVG;
P8gGraphicsSVG svg;

HersheyFont hf;

void setup()
{
  size(925, 500, P3D);
  noLoop();
  hf = new HersheyFont("futural.jhf");
  hf.textSize(100);
  
  svg = (P8gGraphicsSVG) createGraphics(width, height, P8gGraphicsSVG.SVG, "out.svg");
  beginRecord(svg);
}

void draw()
{
  g.background(255);

  svg.clear(); // Discard previous frame
  svg.beginDraw(); // And record this one
  
  translate(100, height/3);
  hf.text("HELLO", 0, 0);
  translate(0, height/3);
  shape(hf.getShape("PROCESSING"));
  svg.endRecord();
}


