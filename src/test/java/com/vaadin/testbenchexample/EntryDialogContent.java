package com.vaadin.testbenchexample;
import com.vaadin.flow.component.checkbox.testbench.CheckboxElement;
import com.vaadin.flow.component.html.testbench.InputTextElement;
import com.vaadin.flow.component.listbox.testbench.ListBoxElement;
import com.vaadin.flow.component.radiobutton.testbench.RadioButtonGroupElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;

import com.vaadin.flow.component.button.testbench.ButtonElement;
import com.vaadin.flow.component.datepicker.testbench.DatePickerElement;
import com.vaadin.flow.component.grid.testbench.GridElement;
import com.vaadin.flow.component.select.testbench.SelectElement;
import com.vaadin.flow.component.textfield.testbench.TextAreaElement;
import com.vaadin.flow.component.textfield.testbench.TextFieldElement;
import com.vaadin.flow.component.upload.testbench.UploadElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.elementsbase.Element;

@Element( "entry-dialog-content" )

public class EntryDialogContent extends TestBenchElement {

	// MainButtons
	protected ButtonElement okButton (){

		return $(ButtonElement.class).first();
	}
	protected ButtonElement closeButton (){
		return $(ButtonElement.class).last();}
	protected ButtonElement saveAndOpenButton (){
		return $(ButtonElement.class).get(1);
	}

	protected ButtonElement processButton (){
		return $(ButtonElement.class).first();}



	// Bank
	protected TextFieldElement getFinancialInstitutionName() {

		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$( TextFieldElement.class ).id( "FinancialInstitutionName" );

	}
	protected TextFieldElement getBankCity() {

		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$( TextFieldElement.class ).id( "BankCity" );

    }
	protected SelectElement getBankState() {

		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$( SelectElement.class ).id( "BankState" );

	}
	protected TextFieldElement getAccountNumber() {

		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$( TextFieldElement.class ).id( "AccountNumberUnmasked" );

	}
	protected TextFieldElement getRoutingNumber() {

		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$( TextFieldElement.class ).id( "RoutingNumber" );

	}
	protected SelectElement getPartyType() {
		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$(SelectElement.class).id( "PartyType" );
	}
	protected SelectElement getAccountType() {
		return $( TestBenchElement.class ).id( "FinancialInstitutionInfoSection" ).$(SelectElement.class).id( "AccountType" );
	}

	// Notes

	protected ButtonElement addNoteButton(){
		return $(TestBenchElement.class).id( "mainContent" ).$( "note-list-view" ).first().$(ButtonElement.class).first();
	}
	protected ButtonElement DeleteNoteButton(){
		return $(ButtonElement.class).get( 2 );
	}
	protected TextAreaElement noteText(){
		return $(TestBenchElement.class).id( "mainContent" ).$( "note-list-view" ).first().$(TestBenchElement.class).id( "noteDetailDiv" ).$( "note-view" ).first().$(TextAreaElement.class).first();
	}
	protected ButtonElement attachButton(){
		return $(TestBenchElement.class).id( "mainContent" ).$( "note-list-view" ).first().$(TestBenchElement.class).id( "noteDetailDiv" ).$( "note-view" ).first().$(TestBenchElement.class).id( "viewContent" ).$(ButtonElement.class).id( "addButton" );
	}
	protected DatePickerElement expiresDate(){
		return $(TestBenchElement.class).id( "mainContent" ).$( "note-list-view" ).first().$(TestBenchElement.class).id( "noteDetailDiv" ).$( "note-view" ).first().$(TestBenchElement.class).id( "timesDiv" ).$(DatePickerElement.class).first();
	}
	protected SelectElement attachmentType(){
		return $(TestBenchElement.class).id( "mainContent" ).$( "note-list-view" ).first().$(TestBenchElement.class).id( "noteDetailDiv" ).$( "note-view" ).first().$(TestBenchElement.class).id( "attachmentTypeDiv" ).$(SelectElement.class).first();
	}
	protected UploadElement uploadFileButton(){
		return $(TestBenchElement.class).id( "mainContent" ).$( "note-list-view" ).first().$(TestBenchElement.class).id( "noteDetailDiv" ).$( "note-view" ).first().$(TestBenchElement.class).id( "uploadDiv" ).$(UploadElement.class).first();
	}

	// Suspense

	protected SelectElement suspenseSource(){
		return $(TestBenchElement.class).id( "mainContent" ).$(SelectElement.class).first();
	}
	protected SelectElement depositAccount(){
		return $(TestBenchElement.class).id( "mainContent" ).$(SelectElement.class).last();
	}
	protected TextFieldElement suspenseAmount(){
		return $(TestBenchElement.class).id( "mainContent" ).$(TextFieldElement.class).first();
	}
	protected DatePickerElement effectveDate() {
		return $(TestBenchElement.class).id( "mainContent" ).$(DatePickerElement.class).first();
	}
	protected SelectElement fromAccount () {

		return $( TestBenchElement.class ).id( "mainContent" ).$( "transfer-suspense-component" ).first().$( TestBenchElement.class ).id( "fromContent" ).$( "select-transfer-financial-account-component" ).first().$( SelectElement.class ).first();
	}
	protected SelectElement toAccount (){

		return $(TestBenchElement.class).id( "mainContent" ).$("transfer-suspense-component").first().$(TestBenchElement.class).id( "toContent" ).$("select-transfer-financial-account-component").first().$(SelectElement.class).first();

	}
	protected TextFieldElement searchFamily (){

		return $(TestBenchElement.class).id( "mainContent" ).$("transfer-suspense-component").first().$(TestBenchElement.class).id( "toContent" ).$("select-transfer-financial-account-component").first().$(TestBenchElement.class).id( "searchContent" ).$(TextFieldElement.class).first();
	}
	protected GridElement family(){

		return $(TestBenchElement.class).id( "mainContent" ).$("transfer-suspense-component").first().$(TestBenchElement.class).id( "toContent" ).$("select-transfer-financial-account-component").first().$(TestBenchElement.class).id( "searchContent" ).$("search-component").first().$(GridElement.class).first();
	}
	protected ButtonElement search (){

		return $(TestBenchElement.class).id( "mainContent" ).$("transfer-suspense-component").first().$(TestBenchElement.class).id( "toContent" ).$("select-transfer-financial-account-component").first().$(TestBenchElement.class).id( "searchContent" ).$(ButtonElement.class).last();
	}
	protected TextAreaElement note (){

		return $(TestBenchElement.class).id( "mainContent" ).$("transfer-suspense-component").first().$(TestBenchElement.class).id( "inputContent" ).$(TextAreaElement.class).first();
	}
	protected TextFieldElement transferAmount(){

		return $(TestBenchElement.class).id( "mainContent" ).$("transfer-suspense-component").first().$(TestBenchElement.class).id( "inputContent" ).$(TextFieldElement.class).first();
	}
	protected DatePickerElement transferEffectveDate(){

		return $(TestBenchElement.class).id( "mainContent" ).$("transfer-suspense-component").first().$(TestBenchElement.class).id( "inputContent").$(DatePickerElement.class).first();
	}

	// Premium

	protected TextFieldElement premiumAmount (){

		return $(TestBenchElement.class).id( "PremiumSection" ).$(TextFieldElement.class).id( "AmountRequested" );
	}
	protected TextFieldElement billingMonths (){
		return $(TestBenchElement.class).id( "PremiumSection" ).$(TextFieldElement.class).id( "BillingMonths" );
	}

	// Loan
	protected TextFieldElement loanAmount (){

		return $(TestBenchElement.class).id( "InputsSection" ).$( TextFieldElement.class).id( "AmountRequested" );
	}
	protected TextFieldElement disbursedAmount (){
		return $(TestBenchElement.class).id( "InputsSection" ).$( TextFieldElement.class).id( "AmountDisbursed" );
	}
	protected SelectElement disbursementMethod (){
		return $(TestBenchElement.class).id( "InputsSection" ).$( SelectElement.class).id( "DisbursementMethod" );
	}

	// Rider

	protected SelectElement coverageName (){
		return $(TestBenchElement.class).id( "BenefitsChangeSection" ).$( SelectElement.class).id( "CoverageProductCodeBeingUpdated" );
	}
	protected TextFieldElement faceAmount(){
		return $ (TestBenchElement.class).id( "BenefitsChangeSection" ).$( TextFieldElement.class).id( "FaceAmount" );
	}
	protected CheckboxElement selectAll(){
		return $ (TestBenchElement.class).id( "ProfilesSection" ).$( CheckboxElement.class).first();
	}
	protected ButtonElement editComProfilies1(){
		return $ (TestBenchElement.class).id("ProfilesSection").$(TestBenchElement.class).id("CoverageCommissionProfileTable").$(ButtonElement.class).get(1);
	}
	protected ButtonElement editComProfilies2(){
		return $ (TestBenchElement.class).id("ProfilesSection").$(TestBenchElement.class).id("CoverageCommissionProfileTable").$(ButtonElement.class).get(4);
	}
	protected ButtonElement editComProfilies3(){
		return $ (TestBenchElement.class).id("ProfilesSection").$(TestBenchElement.class).id("CoverageCommissionProfileTable").$(ButtonElement.class).get(7);
	}
	protected SelectElement agentLevel(){
		return $ (TestBenchElement.class).id("CoverageLevelAgentManagement").$(SelectElement.class).id("AgentNumberLevel");
	}

	//owner
	protected ListBoxElement relationshipPfix(){
		return $(TestBenchElement.class).id("FldSec_1" ).$(SelectElement.class).id("RelationshipType").$(ListBoxElement.class).first();
	}
	protected SelectElement relationship(){
		return $(TestBenchElement.class).id("FldSec_1" ).$(SelectElement.class).id("RelationshipType");
	}

	//Other Roles
	protected ListBoxElement roleType(){
		return $(TestBenchElement.class).id("FldSec_1" ).$(SelectElement.class).id("RoleType").$(ListBoxElement.class).first();
	}
	protected SelectElement roleTypeAccept(){
		return $(TestBenchElement.class).id("FldSec_1" ).$(SelectElement.class).id("RoleType");
	}
	protected ListBoxElement relation(){
		return $(TestBenchElement.class).id("FldSec_1" ).$(SelectElement.class).id("RelationToPrimaryInsured").$(ListBoxElement.class).first();
	}
	protected SelectElement relationAccept(){
		return $(TestBenchElement.class).id("FldSec_1" ).$(SelectElement.class).id("RelationToPrimaryInsured");
	}
	protected DatePickerElement effectiveDate (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(DatePickerElement.class).id("EffectiveDate");
	}
	protected DatePickerElement endDate (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(DatePickerElement.class).id("EndDate");
	}


	//Beneficiary
	protected SelectElement selectBene (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(SelectElement.class).id("PartyGUID");
	}
	protected TextFieldElement firstName (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(TestBenchElement.class).id("sectionComponent").$(TextFieldElement.class).id("FirstName");
	}
	protected TextFieldElement lastName (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(TextFieldElement.class).id("LastName");
	}
	protected SelectElement gender (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(SelectElement.class).id("Gender");
	}
	protected DatePickerElement dob (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(DatePickerElement.class).id("DateOfBirth");
	}
	protected TextFieldElement ssn (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(TextFieldElement.class).id("SsnOrTaxID");
	}
	protected TextFieldElement email (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(TextFieldElement.class).id("Email");
	}
	protected TextFieldElement pnoneNumber (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(TextFieldElement.class).id("Phone1");
	}
	protected RadioButtonGroupElement defaultAddress (){
		return $(TestBenchElement.class).id("FldSec_1" ).$(RadioButtonGroupElement.class).first();
	}
	//Claims
	protected InputTextElement getClaimNumber() {

		return $( TestBenchElement.class ).id( "S0").$( TestBenchElement.class ).id( "section" ).$( TextFieldElement.class ).id( "ClaimNumber" ).$(InputTextElement.class).first();
	}

	protected SelectElement getClaimType() {

		return $( TestBenchElement.class ).id( "S0").$( TestBenchElement.class ).id( "section" ).$( SelectElement.class ).id( "Type");
	}
	protected DatePickerElement getIncurredDate() {

		return $( TestBenchElement.class ).id( "S0").$( TestBenchElement.class ).id( "section" ).$( DatePickerElement.class ).id( "IncurredDate");
	}
	protected DatePickerElement getReceivedDate() {

		return $( TestBenchElement.class ).id( "S0").$( TestBenchElement.class ).id( "section" ).$( DatePickerElement.class ).id( "ReceivedDate");
	}
	protected SelectElement getClaimCause() {

		return $( TestBenchElement.class ).id( "S1").$( SelectElement.class ).id( "CauseType");
	}
	protected SelectElement getContact() {

		return $( TestBenchElement.class ).id( "S3").$( SelectElement.class ).id( "ContactClientID");
	}
	protected SelectElement getOwner() {

		return $( TestBenchElement.class ).id( "S2").$( SelectElement.class ).id( "OwnerEmployeeGUID");
	}
	protected SelectElement getSource() {

		return $( TestBenchElement.class ).id( "S2").$( SelectElement.class ).id( "NotificationSource");
	}

	protected SelectElement getEventType() {

		return $( TestBenchElement.class ).id( "S0").$( TestBenchElement.class ).id( "section" ).$( SelectElement.class ).id( "Type");
	}
	protected SelectElement getPayee() {

		return $( TestBenchElement.class ).id( "S1").$( SelectElement.class ).id( "PayeeGUID");
	}
	protected ButtonElement editDecision (){

		return $( TestBenchElement.class ).id( "S1").$( TestBenchElement.class ).id( "PaymentLinesTable").$(ButtonElement.class).get(1);
	}
	protected SelectElement getClaimDecision() {

		return $( TestBenchElement.class ).id( "S0").$( TestBenchElement.class ).id( "section" ).$( SelectElement.class ).id( "Decision");
	}
	protected SelectElement getDenialClaimReason() {

		return $( TestBenchElement.class ).id( "S0").$( TestBenchElement.class ).id( "section" ).$( SelectElement.class ).id("DenialReason");
	}



	public void addBeneficiary (String firstName,String lastName,String ssn,String email,String phoneNumber){
		firstName().sendKeys(firstName);
		lastName().sendKeys(lastName);
		ssn().sendKeys(ssn);
		email().sendKeys(email);
		pnoneNumber().sendKeys(phoneNumber);
	}



	public void addAccount(String bankName,String city,String routingNumber,String accountNumber ){
		getFinancialInstitutionName().sendKeys( bankName );
		getBankCity().sendKeys( city );
		getRoutingNumber().sendKeys( routingNumber );
		getAccountNumber().sendKeys( accountNumber );


	}

}
