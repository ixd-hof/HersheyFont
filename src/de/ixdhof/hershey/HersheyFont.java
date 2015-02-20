/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package de.ixdhof.hershey;


import processing.core.*;

/**
 * This is a template class and can be used to start a new processing library or tool.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own library or tool naming convention.
 * 
 * (the tag example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 * @example Hello 
 */

public class HersheyFont {
	
	// myParent is a reference to the parent sketch
	PApplet parent;
	
	public final static String VERSION = "##library.prettyVersion##";
	

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example Hello
	 * @param theParent
	 */
	
	String hershey_font[];
	int hheight = 21;
	float hfactor = 1;
	
	public HersheyFont(PApplet theParent, String fontfile) {
		parent = theParent;
		
		System.out.println("##library.name## ##library.prettyVersion## by ##author##");
		
		String [] hershey_font_org;
		
		//if (fontfile.indexOf(".jhf") != -1)
			hershey_font_org = parent.loadStrings(fontfile);

	    String hershey_font_string = "";

	    for (int i=0; i<hershey_font_org.length; i++)
	    {
	    	String line = hershey_font_org[i].trim();
	      if (line.charAt(0) >= 48 && line.charAt(0) <= 57)
	        hershey_font_string += line + "\n";
	      else
	      {
	        hershey_font_string = hershey_font_string.substring(0, hershey_font_string.length()-1) + line + "\n";
	      }
	    }
	    hershey_font = hershey_font_string.split("\n");
	}
	
	public void textSize(float size)
	  {
	    hfactor = size/hheight;
	  }

	  public PShape getShape(String s)
	  {
	    int swidth = 0;
	    for (int i=0; i<s.length (); i++)
	    {
	      swidth += get_character_width(s.charAt(i));
	    }

	    float pos_x = 0;
	    PShape sh = parent.createShape(parent.GROUP);

	    for (int ss=0; ss<s.length (); ss++)
	    {
	      PShape shc = parent.createShape();
	      char c = s.charAt(ss);
	      String h = hershey_font[c - 32 ];

	      int start_col = h.indexOf(" ");

	      int vertices_length = Integer.parseInt(h.substring(start_col+1, start_col+3).trim());

	      int h_left = hershey2coord(h.charAt(start_col+3));
	      int h_right = hershey2coord(h.charAt(start_col+4));
	      float h_width = h_right - h_left * hfactor;

	      String[] h_vertices = h.substring(start_col+5, h.length()).replaceAll(" R", " ").split(" ");

	      for (int i=0; i<h_vertices.length; i++)
	      {
	        shc.beginShape(parent.LINES);
	        for (int j=2; j<h_vertices[i].length (); j+=2)
	        {
	          float hx0 = pos_x + hershey2coord(h_vertices[i].charAt(j-2)) * hfactor;
	          float hy0 = hershey2coord(h_vertices[i].charAt(j-1)) * hfactor;
	          shc.vertex(hx0, hy0);
	          float hx1 = pos_x + hershey2coord(h_vertices[i].charAt(j)) * hfactor;
	          float hy1 = hershey2coord(h_vertices[i].charAt(j+1)) * hfactor;
	          shc.vertex(hx1, hy1);
	        }
	        shc.endShape(parent.CLOSE);
	      }
	      pos_x += h_width + 5 * hfactor;
	      sh.addChild(shc);
	    }
	    return sh;
	  }

	  public void text(String s, int x, int y)
	  {
		  parent.pushMatrix();
		  parent.translate(x, y);
	    for (int i=0; i<s.length (); i++)
	    {
	      draw_character(s.charAt(i));
	    }
	    parent.popMatrix();
	  }

	  private float get_character_width(int c)
	  {
	    String h = hershey_font[c - 32 ];

	    int start_col = h.indexOf(" ");

	    int vertices_length = Integer.parseInt(h.substring(start_col+1, start_col+3).trim());

	    int h_left = hershey2coord(h.charAt(start_col+3));
	    int h_right = hershey2coord(h.charAt(start_col+4));
	    float h_width = h_right - h_left * hfactor;

	    return h_width;
	  }

	  private void draw_character(int c)
	  {
	    int max_y = -1000;
	    int min_y = 1000;

	    String h = hershey_font[c - 32 ];

	    int start_col = h.indexOf(" ");

	    int vertices_length = Integer.parseInt(h.substring(start_col+1, start_col+3).trim());

	    int h_left = hershey2coord(h.charAt(start_col+3));
	    int h_right = hershey2coord(h.charAt(start_col+4));
	    float h_width = h_right - h_left * hfactor;

	    String[] h_vertices = h.substring(start_col+5, h.length()).replaceAll(" R", " ").split(" ");

	    for (int i=0; i<h_vertices.length; i++)
	    {
	    	parent.beginShape(parent.LINES);
	      for (int j=2; j<h_vertices[i].length (); j+=2)
	      {
	        float hx0 = hershey2coord(h_vertices[i].charAt(j-2)) * hfactor;
	        float hy0 = hershey2coord(h_vertices[i].charAt(j-1)) * hfactor;
	        parent.vertex(hx0, hy0);
	        float hx1 = hershey2coord(h_vertices[i].charAt(j)) * hfactor;
	        float hy1 = hershey2coord(h_vertices[i].charAt(j+1)) * hfactor;
	        parent.vertex(hx1, hy1);
	      }
	      parent.endShape(parent.CLOSE);
	    }
	    parent.translate(h_width + 5 * hfactor, 0);
	  }

	  private int hershey2coord(char c)
	  {
	    return c - 'R';
	  }

	  private int hershey2int(char c)
	  {
	    return c;
	  }
}

