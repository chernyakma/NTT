package com.vaadin.testbenchexample;
import javax.swing.*;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;

import com.vaadin.flow.component.html.testbench.SpanElement;
import com.vaadin.flow.component.icon.testbench.IconElement;
import com.vaadin.flow.component.select.testbench.SelectElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.annotations.Attribute;
import com.vaadin.testbench.elementsbase.Element;


@Element( "NAVI-MENU" )
//@Attribute(name="class",value="navi-item page-item")
public class NaviMenuView extends TestBenchElement {



	// Main


	protected TestBenchElement getAddresses() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 5 );
	}
	protected TestBenchElement getPolicy() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).first();
	}
	protected TestBenchElement getSuspense() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 25 );
	}
	protected TestBenchElement getNewBusiness() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 30 );
	}

	protected TestBenchElement getBankInformation() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 4 );
	}

	protected TestBenchElement getFamily() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).last();
	}


	// Policy

	protected TestBenchElement getApplication() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 1 );
	}
	protected TestBenchElement getDocument() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 18 );
	}
	protected TestBenchElement beneficiaries() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 21 );
	}

	protected TestBenchElement checkIGO() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 25 );
	}

	protected TestBenchElement suspense() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 33 );
	}
	protected TestBenchElement getReport() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 7 );
	}
	protected TestBenchElement getResult() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 5 );
	}

	// Transactions

	protected TestBenchElement transactionsWL() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 12 );
	}
	protected TestBenchElement transactions() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 12 );
	}
	protected TestBenchElement policyTransactions() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 15 );
	}

	// Owner

	protected TestBenchElement payorAndOwnerPfix() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 4 );
	}
	protected TestBenchElement payorAndOwner() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 16 );
	}

	// OtherRoles

	protected TestBenchElement otherRolesPfix() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$("IRON-ICON").get( 10 );
	}
	protected TestBenchElement otherRoles() {

		return $( TestBenchElement.class ).id( "navi-menu" ).$( IconElement.class ).get( 26 );
	}
}
