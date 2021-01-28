package ru.fomin.wicket;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.Page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.EmailAddressValidator;

import static mx4j.log.Log.redirectTo;

public final class AddPersonPage extends WebPage {
    public  class PersonForm extends Form<Person>
    {
        @Override
        public MarkupContainer setDefaultModel(IModel<?> model) {
            return super.setDefaultModel(model);
        }

        public PersonForm(String s)
        {
            super(s, new CompoundPropertyModel(new Person()));
            add(new FeedbackPanel("feedback"));
            TextField name = new TextField("name");
          //  name.add(RequiredValidator.getInstance());
            add(name);
            TextField email = new TextField("email");
           // email.add(RequiredValidator.getInstance());
            email.add(EmailAddressValidator.getInstance());
            add(email);
        }
        @Override
        public void onSubmit()
        {
            Person person = (Person) getModelObject();
            PageParameters params = new PageParameters();
            params.add("result", person);
          //  params.put("result", person);
          //  redirectTo(new Page(NextPage.class, params));
        }
    }
    public AddPersonPage()
    {
        add(new PersonForm("form"));
    }
}
