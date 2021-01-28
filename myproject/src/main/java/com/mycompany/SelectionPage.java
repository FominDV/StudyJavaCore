package com.mycompany;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.*;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.*;

import java.util.Arrays;
import java.util.List;

public
class SelectionPage extends WebPage
{
    private final static List COLORS = Arrays.asList(new String[]{"красный", "желтый", "зеленый"});

    public final class SelectionForm extends Form<Void>
{
    private String selectedColor = "нет";

   // public String getSelectedColor()
  //  {
  //      return selectedColor;
   // }

 //   public void setSelectedColor(String selectedColor)
  //  {
   //     this.selectedColor = selectedColor;
  //  }

    public SelectionForm(String s)
    {
        super(s);
        add(new Label("colorLabel", new PropertyModel(this, "selectedColor")));
        add(new DropDownChoice("color", new PropertyModel(this, "selectedColor"), COLORS));
        add(new Link("selectLink")
        {
            public void onClick()
            {
              //  redirectTo(new Page(NextPage.class));
            }
        });
        add(new Button("submitButton")
        {
            public void onSubmit()
            {
                //System.out.println("Selected color: " + getSelectedColor());
            }
        });
    }

}
    public SelectionPage()
    {
        add(new SelectionForm("form"));
    }
}
