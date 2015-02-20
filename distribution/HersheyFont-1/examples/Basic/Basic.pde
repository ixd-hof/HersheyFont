import de.ixdhof.hershey.*;

HersheyFont hf;

void setup()
{
  size(925, 500, P3D);
  // Available fonts included:
  // astrology.jhf, cursive.jhf, cyrilc_1.jhf, cyrillic.jhf, futural.jhf, futuram.jhf, gothgbt.jhf, gothgrt.jhf, gothiceng.jhf, gothicger.jhf, gothicita.jhf, gothitt.jhf, greek.jhf, greekc.jhf, greeks.jhf, hershey.txt, hershey.zip, japanese.jhf, markers.jhf, mathlow.jhf, mathupp.jhf, meteorology.jhf, music.jhf, rowmand.jhf, rowmans.jhf, rowmant.jhf, scriptc.jhf, scripts.jhf, symbolic.jhf, tex-hershey.zip, timesg.jhf, timesi.jhf, timesib.jhf, timesr.jhf, timesrb.jhf
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


