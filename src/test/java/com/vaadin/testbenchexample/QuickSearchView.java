package com.vaadin.testbenchexample;

import com.vaadin.flow.component.combobox.testbench.ComboBoxElement;
import com.vaadin.flow.component.html.testbench.InputTextElement;
//import com.vaadin.flow.component.html.testbench.SelectElement;
import com.vaadin.flow.component.listbox.testbench.ListBoxElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;
import com.vaadin.flow.component.select.testbench.SelectElement; // keep this ✅








    @Element( "quick-search" )
    public class QuickSearchView extends TestBenchElement {

        protected InputTextElement searchByPolicy() {
            return $( TestBenchElement.class ).id("content").$( ComboBoxElement.class ).first().$( TextFieldElement.class ).id( "input" ).$(InputTextElement.class).first();
        }

        protected SelectElement quickType (){
            return $( TestBenchElement.class ).id("content").$(SelectElement.class).attribute("class","quick-type").first();
        }
        protected ComboBoxElement searchBySSN() {
            return $( TestBenchElement.class ).id("content").$( ComboBoxElement.class ).attribute("class", "quick-result")
                    .first();
        }
    }


