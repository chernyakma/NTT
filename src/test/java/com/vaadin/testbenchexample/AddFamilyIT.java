package com.vaadin.testbenchexample;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.formlayout.testbench.FormLayoutElement;
import com.vaadin.flow.component.html.testbench.DivElement;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.testbench.IPAddress;
import com.vaadin.testbench.TestBenchElement;

public class AddFamilyIT extends BaseLoginTest {





	@Test

	public void addFamily() {

	//	getDriver().get( "http://localhost:8080/everlake_webui_war/familyInsured" );
		getDriver().get( "https://test.everlake.calcfocus.net/achieve/familyInsured/" );
		AddFamilyView family = $( AddFamilyView.class ).first();
		family.addFamily(  );
		family.getSuffix().selectItemByIndex( 1 );
		family.getGender().selectItemByIndex( 1 );
		family.getDateOfBirth().setDate( LocalDate.of( 1960, 10, 15 ) );
		family.getTobaccoUse().selectByText( "Tobacco" );
	    family.getMarriageStatus().selectItemByIndex( 1 );
		family.getHealthStatus().selectItemByIndex( 1 );
		family.getPhoneType1().selectItemByIndex( 1 );
		family.getPhoneType2().selectItemByIndex( 2 );
		family.getFullTimePartTime().selectItemByIndex( 0 );
		Assertions.assertEquals( "David", family.getFirstName().getValue() );
		Assertions.assertEquals( "Palmer", family.getLastName().getValue() );
		Assertions.assertEquals( "Male", family.getGender().getSelectedText() );
		Assertions.assertEquals( "10/15/1960", family.getDateOfBirth().getInputValue() );
		family.getSaveButton().click();
	}

	@Test
	public void addSpouse (){

		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 3 );
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
		SearchComponentView getFamily = $( SearchComponentView.class ).first();
		getFamily.searchBySSN().sendKeys( "511367917" );
		getFamily.searchButton().click();
		getFamily.family().getCell( "Palmer" ).click();

		ScenarioView addMember= $(ScenarioView.class).first();
		addMember.addMemberButton().click();
		AddFamilyView family = $( AddFamilyView.class ).first();
		family.getRelationship().selectByText( "Spouse" );
		family.addSpouse(  );
		family.getSuffix().selectItemByIndex( 2 );
		family.getGender().selectItemByIndex( 0 );
		family.getDateOfBirth().setDate( LocalDate.of( 1965, 01, 05 ) );
		family.getNonTobacco().doubleClick();
		family.getMarriageStatus().selectItemByIndex( 1 );
		family.getHealthStatus().selectItemByIndex( 1 );
		family.getPhoneType1().selectItemByIndex( 2 );
		family.getPhoneType2().selectItemByIndex( 1 );

		Assertions.assertEquals( "Emma", family.getFirstName().getValue() );
		Assertions.assertEquals( "Spouse", family.getLastName().getValue() );
		Assertions.assertEquals( "Female", family.getGender().getSelectedText() );
		Assertions.assertEquals( "1/5/1965", family.getDateOfBirth().getInputValue() );
		family.getSaveButton().click();
		family.FamilyButton().click();
	//	NaviMenuView getFamilybutton = $( NaviMenuView.class ).first();
	//	getFamilybutton.getFamily().click();
		ScenarioView deleteMember= $(ScenarioView.class).first();
		deleteMember.getDeleteSpouseButton().click();
		VaadinConfirmDialogView deleteSpouse = $(VaadinConfirmDialogView.class).first();
		deleteSpouse.getSaveButton().click();

	}

	@Test
	public void addFamilyMemberFromPolicy(){
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys( "05W1E17583");
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "05W1E17583" ).click();
        ScenarioView getFamily= $ (ScenarioView.class).first();
		getFamily.getName().click();

		ScenarioView addMember= $(ScenarioView.class).first();
		addMember.addMemberButton().click();
		AddFamilyView family = $( AddFamilyView.class ).first();
		family.getRelationship().selectByText( "Spouse" );
		family.addSpouse(  );
		family.getSuffix().selectItemByIndex( 2 );
		family.getGender().selectItemByIndex( 0 );
		family.getDateOfBirth().setDate( LocalDate.of( 1970, 01, 05 ) );
		family.getNonTobacco().doubleClick();
		family.getMarriageStatus().selectItemByIndex( 1 );
		family.getHealthStatus().selectItemByIndex( 1 );
		family.getPhoneType1().selectItemByIndex( 2 );
		family.getPhoneType2().selectItemByIndex( 1 );

		Assertions.assertEquals( "Emma", family.getFirstName().getValue() );
		Assertions.assertEquals( "Spouse", family.getLastName().getValue() );
		Assertions.assertEquals( "Female", family.getGender().getSelectedText() );
		Assertions.assertEquals( "1/5/1970", family.getDateOfBirth().getInputValue() );
		family.getSaveButton().click();
		family.FamilyButton().click();
		//	NaviMenuView getFamilybutton = $( NaviMenuView.class ).first();
		//	getFamilybutton.getFamily().click();
		ScenarioView deleteMember= $(ScenarioView.class).first();
		deleteMember.getDeleteFamilyBeneButton().click();
		VaadinConfirmDialogView deleteSpouse = $(VaadinConfirmDialogView.class).first();
		deleteSpouse.getSaveButton().click();

	}

	@Test
	public void addBank() throws InterruptedException {

		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 3 );
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
		SearchComponentView getFamily = $(SearchComponentView.class).first();
		waitUntil(driver -> getFamily.isDisplayed(), 20);
		getFamily.searchBySSN().sendKeys( "511367917 " );
		getFamily.searchButton().click();
		getFamily.family().getCell( "Palmer" ).click();
		ScenarioView editMember= $(ScenarioView.class).first();
		editMember.getEditFamilyButton().click();
		NaviMenuView getBank = $( NaviMenuView.class ).first();
		getBank.getBankInformation().click();
		AddFamilyView addBankAccount = $(AddFamilyView.class).first();
		addBankAccount.addBankButton().click();
		EntryDialogContent bankAccount =$(EntryDialogContent.class).first();
		bankAccount.addAccount( "Bank of America","Norfolk","051000017","1234566789" );
        bankAccount.getAccountType().selectByText( "Checking" );
		bankAccount.getBankState().selectByText( "Virginia" );
		Assertions.assertEquals( "Bank of America",bankAccount.getFinancialInstitutionName().getValue() );
		Assertions.assertEquals( "051000017",bankAccount.getRoutingNumber().getValue() );
		Assertions.assertEquals( "Checking",bankAccount.getAccountType().getSelectedText() );
	//	Assertions.assertEquals( "****566789",bankAccount.getAccountNumber() );
		bankAccount.okButton().click();
		AddFamilyView saveButton = $ (AddFamilyView.class).first();
		saveButton.getSaveButton().click();
		addBankAccount.deleteBankButton().click();
		saveButton.getSaveButton().click();
	}

	@Test

	public void familyAddress() throws InterruptedException {
	VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
    getSelectButton.getSelectItem().selectItemByIndex( 3 );
	waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
	SearchComponentView getFamily = $( SearchComponentView.class ).first();
	getFamily.searchBySSN().sendKeys( "511367917" );
	getFamily.searchButton().click();
	getFamily.family().getCell( "Palmer" ).click();
	NaviMenuView getAddress = $(NaviMenuView.class).first();
    getAddress.getAddresses().click();
	ScenarioView addAddress = $(ScenarioView.class).first();
	addAddress.getAddButton().click();
	AddressView setAddress=$ (AddressView.class).first();
	setAddress.getCountry().selectByText( "USA" );
	setAddress.address( "74 River Street","25 Main Street","Norfolk","23503" );
	setAddress.getState().selectByText( "Virginia" );
	setAddress.getAddressType().selectItemByIndex( 2 );
	Assertions.assertEquals( "Mailing",setAddress.getAddressType().getSelectedText() );
//	setAddress.getDefaultMailing().click();
	setAddress.getDefaultBilling().click();
//	setAddress.getDefaultResidence().click();
	Assertions.assertEquals( "Virginia", setAddress.getState().getSelectedText());
	Assertions.assertEquals( "74 River Street", setAddress.getLine1().getValue());
	Assertions.assertEquals( "25 Main Street", setAddress.getLine2().getValue());
//	Assertions.assertTrue( setAddress.getDefaultMailing().isChecked() );
	Assertions.assertTrue( setAddress.getDefaultBilling().isChecked() );
//	Assertions.assertTrue( setAddress.getDefaultResidence().isChecked() );

		setAddress.getCancelButton().click();
		setAddress.getEditOkButton().click();
		ScenarioView address = $(ScenarioView.class).first();
		address.getSaveButton().click();

}
	@Test

	public void editAddress() throws InterruptedException {

		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 3 );
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
		SearchComponentView getFamily = $( SearchComponentView.class ).first();
		getFamily.searchBySSN().sendKeys( "511367917" );
		getFamily.searchButton().click();
		getFamily.family().getCell( "Palmer" ).click();
		NaviMenuView getAddress = $( NaviMenuView.class ).first();
		getAddress.getAddresses().click();
		ScenarioView edit = $( ScenarioView.class ).first();
		edit.getEditAddressButton().click();
		AddressView setAddress = $( AddressView.class ).first();
		setAddress.clearAddress();
		setAddress.address( "111 Main Street", "234 Street", "Norfolk", "23503" );
		setAddress.getState().selectByText( "Virginia" );
	//	setAddress.getDefaultBilling().click();
		setAddress.getDefaultResidence().click();
		Assertions.assertEquals( "Virginia", setAddress.getState().getSelectedText() );
		Assertions.assertEquals( "111 Main Street", setAddress.getLine1().getValue() );
		Assertions.assertEquals( "234 Street", setAddress.getLine2().getValue() );
		Assertions.assertTrue( setAddress.getDefaultResidence().isChecked() );
		Assertions.assertEquals( "23503",setAddress.getZip().getValue() );
		setAddress.getCancelButton().click();
		setAddress.getEditOkButton().click();
		edit.getSaveButton().click();

	}

	@Test
	public void addBeneficiary() throws InterruptedException {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys( "05W1038628" );
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "05W1038628" ).click();
		NaviMenuView getBeneficiaries = $( NaviMenuView.class ).first();
		getBeneficiaries.beneficiaries().click();
		Thread.sleep( 3_000 );
		ScenarioView addBeneficiary = $(ScenarioView.class).first();
		addBeneficiary.getAddBeneButton().click();
		EntryDialogContent bene = $(EntryDialogContent.class).first();
		bene.selectBene().selectByText("Add New");
		bene.okButton().click();
		Thread.sleep( 3_000 );
		EntryDialogContent newBeneficiary =$(EntryDialogContent.class).first();
		newBeneficiary.addBeneficiary("Harry","Potter","253446453","chernyakma@yahoo.com","1234567890");
		newBeneficiary.dob().setDate( LocalDate.of( 1980, 8, 25 ) );
		newBeneficiary.gender().selectByText("Male");
		Assertions.assertEquals("Potter",newBeneficiary.lastName().getValue());
		Assertions.assertEquals("8/25/1980",newBeneficiary.dob().getInputValue());
		Assertions.assertEquals("253-44-6453",newBeneficiary.ssn().getValue());
		Assertions.assertEquals("chernyakma@yahoo.com",newBeneficiary.email().getValue());
		newBeneficiary.okButton().click();
		ScenarioView beneficiary = $(ScenarioView.class).first();
		beneficiary.getSaveButton().click();
		Thread.sleep( 3_000 );
		VaadinConfirmDialogView confirm = $ (VaadinConfirmDialogView.class).first();
		confirm.getDeleteButton().click();
		NaviMenuView family = $( NaviMenuView.class ).first();
		family.getFamily().click();
		ScenarioView getBeneficiary = $(ScenarioView.class).first();
		Assertions.assertTrue(getBeneficiary.family().getCell("Potter").isDisplayed());
		getBeneficiary.policyNumber().getCell("05W1038628").click();
		family.beneficiaries().click();
		ScenarioView deleteBene =$(ScenarioView.class).first();
    	deleteBene.getDeleteBeneButton().click();
		deleteBene.getSaveButton().click();
		Thread.sleep( 3_000 );
		VaadinConfirmDialogView ok = $ (VaadinConfirmDialogView.class).first();
		ok.getDeleteButton().click();

		NaviMenuView getFamily = $( NaviMenuView.class ).first();
		getFamily.getFamily().click();
		ScenarioView deleteBeneficiary = $(ScenarioView.class).first();
		deleteBeneficiary.getDeleteFamilyBeneButton().click();
		VaadinConfirmDialogView delete = $(VaadinConfirmDialogView.class).first();
		delete.getSaveButton().click();


	}
	@Test
	public void addNewOwner() throws InterruptedException {
		VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
		getSelectButton.getSelectItem().selectByText("Search Policy");
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
		SearchComponentView getPolicy = $(SearchComponentView.class).first();
		getPolicy.searchByPolicy().sendKeys("06W1072965");
		getPolicy.searchButton().click();
		getPolicy.family().getCell("06W1072965").click();
		NaviMenuView getOwner = $(NaviMenuView.class).first();
		getOwner.payorAndOwner().click();
		Thread.sleep(3_000);
		ScenarioView newOwner = $(ScenarioView.class).first();
		newOwner.newOwner().click();
		EntryDialogContent addNewOwner = $(EntryDialogContent.class).first();
		addNewOwner.addBeneficiary("Harry", "Potter", "253446453", "chernyakma@yahoo.com", "1234567890");
		addNewOwner.dob().setDate(LocalDate.of(1980, 8, 25));
		addNewOwner.gender().selectByText("Male");
		addNewOwner.relationship().selectByText("Spouse");
		Assertions.assertEquals("Potter", addNewOwner.lastName().getValue());
		Assertions.assertEquals("8/25/1980", addNewOwner.dob().getInputValue());
		Assertions.assertEquals("253-44-6453", addNewOwner.ssn().getValue());
		Assertions.assertEquals("chernyakma@yahoo.com", addNewOwner.email().getValue());
		addNewOwner.okButton().click();
		ScenarioView owner = $(ScenarioView.class).first();
		owner.getSaveButton().click();
		Thread.sleep(3_000);
		VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
		confirm.getDeleteButton().click();
		NaviMenuView family = $(NaviMenuView.class).first();
		family.getFamily().click();
		ScenarioView checkOwner = $(ScenarioView.class).first();
		Assertions.assertTrue(checkOwner.family().getCell("Potter").isDisplayed());
		checkOwner.policyNumber().getCell("06W1072965").click();
		NaviMenuView ownerAndPayor = $(NaviMenuView.class).first();
		ownerAndPayor.payorAndOwner().click();
		ScenarioView changeOwner = $(ScenarioView.class).first();
		changeOwner.ownerGUID().selectByText("ZHKEQTVXYB CHCQWMVRVC (***-**-7565)");

		changeOwner.getSaveButton().click();
		VaadinConfirmDialogView ok = $(VaadinConfirmDialogView.class).first();
		ok.getDeleteButton().click();
		NaviMenuView removeNewOwner = $(NaviMenuView.class).first();
		removeNewOwner.getFamily().click();
		ScenarioView deleteOwner = $(ScenarioView.class).first();
		deleteOwner.getDeleteFamilyOwner().click();
		VaadinConfirmDialogView delete = $(VaadinConfirmDialogView.class).first();
		delete.getSaveButton().click();

	}

	@Test
	public void addOtherRoles() throws InterruptedException {

		VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
		getSelectButton.getSelectItem().selectByText("Search Policy");
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
		SearchComponentView getPolicy = $(SearchComponentView.class).first();
		getPolicy.searchByPolicy().sendKeys("06W1050814");
		getPolicy.searchButton().click();
		getPolicy.family().getCell("06W1050814").click();
		NaviMenuView getOther = $(NaviMenuView.class).first();
		getOther.otherRoles().click();
		Thread.sleep(3_000);
		ScenarioView addOtherRole = $(ScenarioView.class).first();
		addOtherRole.getAddOtherRolesButton().click();
		EntryDialogContent newRole = $(EntryDialogContent.class).first();
		newRole.roleTypeAccept().selectByText("Power of Attorney");
		newRole.relationAccept().selectByText("Other");
		newRole.effectiveDate().setDate( LocalDate.now() );
		newRole.okButton().click();
		Thread.sleep(3_000);
		EntryDialogContent addNewRole = $(EntryDialogContent.class).first();
		addNewRole.addBeneficiary("Harry", "Potter", "253446453", "chernyakma@yahoo.com", "1234567890");
		addNewRole.dob().setDate(LocalDate.of(1980, 8, 25));
		addNewRole.gender().selectByText("Male");
		addNewRole.relationship().selectByText("Other");
		Assertions.assertEquals("Potter", addNewRole.lastName().getValue());
//		Assertions.assertEquals("8/25/1980", addNewRole.dob().getInputValue());
		Assertions.assertEquals("253-44-6453", addNewRole.ssn().getValue());
		Assertions.assertEquals("chernyakma@yahoo.com", addNewRole.email().getValue());
		addNewRole.okButton().click();
		Thread.sleep(3_000);
		AddressView address = $(AddressView.class).first();
		address.address("4 Liberty Street", "23 Forest Street", "Norfolk", "23503");
		address.getState().selectByText("Virginia");
		address.getAddressType().selectByText("Mailing");
		Assertions.assertEquals("Mailing", address.getAddressType().getSelectedText());
		address.getOkButton().click();
		ScenarioView roles = $(ScenarioView.class).first();
		roles.getSaveButton().click();
		Thread.sleep(3_000);
		VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
		confirm.getDeleteButton().click();
		NaviMenuView family = $(NaviMenuView.class).first();
		family.getFamily().click();
		ScenarioView checkOwner = $(ScenarioView.class).first();
		Assertions.assertTrue(checkOwner.family().getCell("Potter").isDisplayed());
		checkOwner.policyNumber().getCell("06W1050814").click();
		NaviMenuView deleteOther = $(NaviMenuView.class).first();
		deleteOther.otherRoles().click();
		Thread.sleep(3_000);
		ScenarioView removeRole = $(ScenarioView.class).first();
		removeRole.getDeleteRoleButton().click();
		removeRole.getSaveButton().click();
		Thread.sleep(3_000);
		VaadinConfirmDialogView ok = $(VaadinConfirmDialogView.class).first();
		ok.getDeleteButton().click();
		NaviMenuView deleteFamilyRole = $(NaviMenuView.class).first();
		deleteFamilyRole.getFamily().click();
		ScenarioView deleteRole = $(ScenarioView.class).first();
		deleteRole.getDeleteFamilyOtherAccept().click();
		VaadinConfirmDialogView save = $(VaadinConfirmDialogView.class).first();
		save.getSaveButton().click();
		NaviMenuView deleteAddress = $(NaviMenuView.class).first();
		deleteAddress.getAddresses().click();
		ScenarioView addresses = $(ScenarioView.class).first();
		addresses.getDeleteAddressButton().click();
		addresses.getSaveButton().click();
	}



}





