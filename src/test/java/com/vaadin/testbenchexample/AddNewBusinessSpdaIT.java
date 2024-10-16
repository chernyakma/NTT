package com.vaadin.testbenchexample;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.screenshot.ImageFileUtil;

public class AddNewBusinessSpdaIT extends BaseLoginTest {
/*
	@Test
	public void addIllustration() throws InterruptedException {

		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		SearchComponentView getFamily = $( SearchComponentView.class ).first();
		getFamily.searchByName().sendKeys( "Mouse" );
		getFamily.searchButton().click();
		getFamily.family().getCell( "Mouse" ).click();
		NaviMenuView newBusiness = $( NaviMenuView.class ).first();
		newBusiness.getNewBusiness().click();
		NewIllustrationView addNewBusiness = $( NewIllustrationView.class ).first();
		addNewBusiness.getProductType().selectByText( "Deferred Annuity" );
		addNewBusiness.getProduct().selectByText( "Single Premium Deferred Annuity" );
		addNewBusiness.getDepositAmount().sendKeys( Keys.chord( Keys.CONTROL, "a" ), "50000" );
		addNewBusiness.getRateLockPeriod().selectByText( "Seven Years" );
		Assertions.assertEquals( "Seven Years",addNewBusiness.getRateLockPeriod().getSelectedText() );
		Assertions.assertEquals( "50,000.00",addNewBusiness.getDepositAmount().getValue() );
		Assertions.assertEquals( "Single Premium Deferred Annuity",addNewBusiness.getProduct().getSelectedText() );
		addNewBusiness.getOkButton().click();
		IllustrationView illustration = $( IllustrationView.class ).first();
		illustration.getAgentNumber().openPopup();
		illustration.getAgentNumber().sendKeys( Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN );
		illustration.getAgentNumber().sendKeys( Keys.ENTER );
		Assertions.assertEquals( "NM001 - Navy Mutual Default Agent", illustration.getAgentNumber().getSelectedText() );
//		illustration.getSaveButton().click();

	}

	@Test
	public void addApplication1() throws IOException {

		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		SearchComponentView getFamily = $( SearchComponentView.class ).first();
		getFamily.searchByName().sendKeys( "Mouse" );
		getFamily.searchButton().click();
		getFamily.family().getCell( "Mouse" ).click();
		ScenarioView getApplication = $( ScenarioView.class ).first();
		getApplication.illustrationNumber().getCell( "424000232" ).click();
		NaviMenuView getReport = $( NaviMenuView.class ).first();
		getReport.getResult().click();
		IllustrationView apply = $( IllustrationView.class ).first();
		apply.getSaveButtonResult().click();
		apply.getApplyButtonResult().click();
		Assert.assertTrue( testBench().compareScreen( ImageFileUtil.getReferenceScreenshotFile(
			"Screenshot 2024-07-09 135710.png" ) ) );
		VaadinConfirmDialogView confirm = $( VaadinConfirmDialogView.class ).first();
		confirm.getDeleteButton().click();

	}

	@Test
	public void addApplication2() throws IOException, InterruptedException {

		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		SearchComponentView getFamily = $( SearchComponentView.class ).first();
		getFamily.searchByName().sendKeys( "Mouse" );
		getFamily.searchButton().click();
		getFamily.family().getCell( "Mouse" ).click();
	//	Thread.sleep( 3_000 );
		ScenarioView getApplication = $( ScenarioView.class ).first();
		getApplication.applicationNumber().getCell( "424000230" ).click();
		ApplicationView application = $( ApplicationView.class ).first();
		application.applicationReceived().selectByText( "Yes" );
		Assertions.assertEquals( "Yes", application.applicationReceived().getSelectedText() );
		application.applicationReceivedDate().setDate( LocalDate.now() );
		application.applicationSignedDate().setDate( LocalDate.now() );
		application.applicationFundsReceived().selectByText( "Yes" );
		Assertions.assertEquals( "Yes", application.applicationFundsReceived().getSelectedText() );
		application.cashWithApplication().selectByText( "Yes" );
		Assertions.assertEquals( "Yes", application.cashWithApplication().getSelectedText() );
		application.cashWithApplicationReceivedDate().setDate( LocalDate.now() );
		NaviMenuView iGO = $( NaviMenuView.class ).first();
		iGO.checkSpdaIGO().click();
		Assert.assertTrue( testBench().compareScreen( ImageFileUtil.getReferenceScreenshotFile(
			"Screenshot 2024-05-31 162418.png" ) ) );
		ApplicationView getIssueButton = $( ApplicationView.class ).first();
		Assertions.assertFalse(getIssueButton.issueButton().isDisplayed()  );
	}

	@Test
	public void uploadDocs() throws IOException, InterruptedException {

		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		SearchComponentView getFamily = $( SearchComponentView.class ).first();
		getFamily.searchByName().sendKeys( "Mouse" );
		getFamily.searchButton().click();
		getFamily.family().getCell( "Mouse" ).click();
		ScenarioView getApplication = $( ScenarioView.class ).first();
		getApplication.applicationNumber().getCell( "424000230" ).click();
		ApplicationView application = $( ApplicationView.class ).first();
		application.threeDotsButton().click();
		WebElement noteList = findElement( By.xpath( "//*[@class='vaadin-menu-item']" ) );
		noteList.click();
		Thread.sleep( 3_000 );
		EntryDialogContent addNote = $( EntryDialogContent.class ).first();
		addNote.addNoteButton().click();
		addNote.noteText().setValue( "document 1" );
		addNote.expiresDate().setDate( LocalDate.of( 2024, 12, 12 ) );
		addNote.attachButton().click();
		addNote.attachmentType().selectByText( "Annuity Owner Questionnaire" );
		addNote.uploadFileButton().upload( new File( "C:\\Users\\MariiaCherniak\\Documents\\correspondence_CondolenceLetterDeferredAnnuity_20240524172728195.pdf" ) );
		Thread.sleep( 3_000 );
		addNote.attachButton().click();
		addNote.attachmentType().selectByText( "Final Application" );
		Thread.sleep( 3_000 );
		addNote.uploadFileButton().upload( new File( "C:\\Users\\MariiaCherniak\\Documents\\correspondence_CondolenceLetterDeferredAnnuity_20240524172728195.pdf" ) );
		addNote.attachButton().click();
		addNote.attachmentType().selectByText( "Sales Representative Disclosure" );
		addNote.uploadFileButton().upload( new File( "C:\\Users\\MariiaCherniak\\Documents\\correspondence_CondolenceLetterDeferredAnnuity_20240524172728195.pdf" ) );
		Thread.sleep( 3_000 );
		addNote.attachButton().click();
		addNote.okButton().click();
		addNote.closeButton().click();
		NaviMenuView iGO = $( NaviMenuView.class ).first();
		iGO.checkSpdaIGO().click();
		Thread.sleep( 3_000 );
		ApplicationView getIssueButton = $( ApplicationView.class ).first();
		Assertions.assertTrue(getIssueButton.issueButton().isDisplayed()  );
		Assert.assertTrue( testBench().compareScreen( ImageFileUtil.getReferenceScreenshotFile(
			"Screenshot 2024-06-17 132439.png" ) ) );
		ApplicationView note = $( ApplicationView.class ).first();
		note.threeDotsButton().doubleClick();
		WebElement noteMenu = findElement( By.xpath( "//*[@class='vaadin-menu-item']" ) );
		noteMenu.click();
		Thread.sleep( 3_000 );
		EntryDialogContent deleteNote = $( EntryDialogContent.class ).first();
		deleteNote.DeleteNoteButton().click();
		VaadinConfirmDialogView getDeleteButton = $( VaadinConfirmDialogView.class ).first();
		getDeleteButton.getSaveButton().click();
		EntryDialogContent closeNote = $( EntryDialogContent.class ).first();
		closeNote.closeButton().click();

	}

	@Test
	public void addSuspense() {

		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		SearchComponentView getFamily = $( SearchComponentView.class ).first();
		getFamily.searchByName().sendKeys( "Mouse" );
		getFamily.searchButton().click();
		getFamily.family().getCell( "Mouse" ).click();
		ScenarioView getApplication = $( ScenarioView.class ).first();
		getApplication.applicationNumber().getCell( "424000228" ).click();
		NaviMenuView addSuspense = $( NaviMenuView.class ).first();
		addSuspense.suspenseSpda().click();
		ApplicationView addSuspenseButton = $( ApplicationView.class ).first();
		addSuspenseButton.addSuspense().click();
		EntryDialogContent suspenseSource = $( EntryDialogContent.class ).first();
		suspenseSource.suspenseAmount().sendKeys( "50000" );
		Assertions.assertEquals( "50000",suspenseSource.suspenseAmount().getValue() );
		suspenseSource.suspenseSource().selectByText( "Check" );
		Assertions.assertEquals( "Check",suspenseSource.suspenseSource().getSelectedText() );
		suspenseSource.processButton().click();

	}

	@Test
	public void issuePolicy() {

		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		SearchComponentView getFamily = $( SearchComponentView.class ).first();
		getFamily.searchByName().sendKeys( "Mouse" );
		getFamily.searchButton().click();
		getFamily.family().getCell( "Mouse" ).click();
		ScenarioView getApplication = $( ScenarioView.class ).first();
		getApplication.applicationNumber().getCell( "424000228" ).click();
		NaviMenuView iGO = $( NaviMenuView.class ).first();
		iGO.checkSpdaIGO().click();
		ApplicationView issue = $( ApplicationView.class ).first();
		issue.issueButton().click();
		VaadinConfirmDialogView confirm = $( VaadinConfirmDialogView.class ).first();
		confirm.getSaveButton().click();
	}

	@Test
	public void activatePolicy() throws InterruptedException, IOException {

		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		SearchComponentView getFamily = $( SearchComponentView.class ).first();
		getFamily.searchByName().sendKeys( "Mouse" );
		getFamily.searchButton().click();
		getFamily.family().getCell( "Mouse" ).click();
		ScenarioView getPolicy = $( ScenarioView.class ).first();
		getPolicy.policyNumber().getCell( "424000228" ).click();
		ScenarioView getPolicyStatus = $(ScenarioView.class).first();
		Assertions.assertEquals( "Pending",getPolicyStatus.policyStatus().getText() );
		NaviMenuView getTransactions = $( NaviMenuView.class ).first();
		getTransactions.transactionsSPDA().click();
		ScenarioView transaction = $( ScenarioView.class ).first();
		transaction.processActivateTransactionButton().click();
		VaadinConfirmDialogView confirmButton = $( VaadinConfirmDialogView.class ).first();
		confirmButton.getSaveButton().click();
		Thread.sleep( 10_000 );
		transaction.processInitialPremiumTransactionButton().click();
		VaadinConfirmDialogView okButton = $( VaadinConfirmDialogView.class ).first();
		okButton.getSaveButton().click();
	//	ScenarioView getPolicyStatus = $(ScenarioView.class).first();
		Assertions.assertEquals( "Active",getPolicyStatus.policyStatus().getText() );
		Thread.sleep( 5_000 );
		Assert.assertTrue( testBench().compareScreen( ImageFileUtil.getReferenceScreenshotFile(
			"Screenshot 2024-06-17 140500.png" ) ) );
		transaction.reverseActivateTransactionButtonSPIA().click();
		VaadinConfirmDialogView undoButton = $( VaadinConfirmDialogView.class ).first();
		undoButton.getSaveButton().click();

	}



	@Test
	public void addNewBusiness() throws Exception {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 5 );
		SearchComponentView getFamily = $( SearchComponentView.class ).first();
		getFamily.searchByName().sendKeys( "Palmer" );
		getFamily.searchButton().click();
		getFamily.family().getCell( "Palmer" ).click();
		NaviMenuView newBusiness = $( NaviMenuView.class ).first();
		newBusiness.getNewBusiness().click();
		NewIllustrationView addNewBusiness = $( NewIllustrationView.class ).first();
		addNewBusiness.getProductType().selectByText( "Deferred Annuity" );
		addNewBusiness.getProduct().selectByText( "Single Premium Deferred Annuity" );
		addNewBusiness.getDepositAmount().sendKeys( Keys.chord( Keys.CONTROL, "a" ), "50000" );
		addNewBusiness.getRateLockPeriod().selectByText( "Seven Years" );
		addNewBusiness.getOkButton().click();
		IllustrationView illustration = $( IllustrationView.class ).first();
		illustration.getAgentNumber().openPopup();
		illustration.getAgentNumber().sendKeys( Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN );
		illustration.getAgentNumber().sendKeys( Keys.ENTER );
		Assertions.assertEquals( "NM001 - Navy Mutual Default Agent", illustration.getAgentNumber().getSelectedText() );
		illustration.getSaveButton().click();
		NaviMenuView getReport = $( NaviMenuView.class ).first();
		getReport.getResult().click();
		IllustrationView apply = $( IllustrationView.class ).first();
		apply.getSaveButtonResult().click();
		apply.getApplyButtonResult().click();
		VaadinConfirmDialogView confirm = $( VaadinConfirmDialogView.class ).first();
		confirm.getSaveButton().click();

		NaviMenuView getDocument = $( NaviMenuView.class ).first();
		getDocument.getDocumentSPDA().click();
		ApplicationView application = $( ApplicationView.class ).first();
		application.downloadButton().click();
		Thread.sleep( 3_000 );
		application.compareAndDeleteDownloadedPdfSPDA();

		NaviMenuView getApplication = $( NaviMenuView.class ).first();
		getApplication.getApplication().click();
		ApplicationView app = $( ApplicationView.class ).first();
		application.applicationReceived().selectByText( "Yes" );
		Assertions.assertEquals( "Yes", application.applicationReceived().getSelectedText() );
		application.applicationReceivedDate().setDate( LocalDate.now() );
		application.applicationSignedDate().setDate( LocalDate.now() );
		application.applicationFundsReceived().selectByText( "Yes" );
		Assertions.assertEquals( "Yes", application.applicationFundsReceived().getSelectedText() );
		application.cashWithApplication().selectByText( "Yes" );
		Assertions.assertEquals( "Yes", application.cashWithApplication().getSelectedText() );
		application.cashWithApplicationReceivedDate().setDate( LocalDate.now() );
		application.threeDotsButton().click();
		WebElement noteList = findElement( By.xpath( "//*[@class='vaadin-menu-item']" ) );
		noteList.click();
		Thread.sleep( 3_000 );
		EntryDialogContent addNote = $( EntryDialogContent.class ).first();
		addNote.addNoteButton().click();
		addNote.noteText().setValue( "document 1" );
		addNote.expiresDate().setDate( LocalDate.of( 2024, 12, 12 ) );
		addNote.attachButton().click();
		addNote.attachmentType().selectByText( "Annuity Owner Questionnaire" );
		addNote.uploadFileButton().upload( new File( "C:\\Users\\MariiaCherniak\\Downloads\\Annuity Questionnare.pdf" ) );
		Thread.sleep( 3_000 );
		addNote.attachButton().click();
		addNote.attachmentType().selectByText( "Final Application" );
		addNote.uploadFileButton().upload( new File( "C:\\Users\\MariiaCherniak\\Downloads\\Final Application.pdf" ) );
		Thread.sleep( 3_000 );
		addNote.attachButton().click();
		addNote.attachmentType().selectByText( "Sales Representative Disclosure" );
		addNote.uploadFileButton().upload( new File( "C:\\Users\\MariiaCherniak\\Downloads\\Sales Representative.pdf" ) );
		Thread.sleep( 3_000 );
		addNote.attachButton().click();
		addNote.okButton().click();
		addNote.closeButton().click();
		Thread.sleep( 3_000 );
		NaviMenuView addSuspense = $( NaviMenuView.class ).first();
		addSuspense.suspenseSpda().click();
		ApplicationView addSuspenseButton = $( ApplicationView.class ).first();
		addSuspenseButton.addSuspense().click();
		EntryDialogContent suspenseSource = $( EntryDialogContent.class ).first();
		suspenseSource.suspenseAmount().sendKeys( "50000" );
		suspenseSource.suspenseSource().selectByText( "Check" );
		suspenseSource.processButton().click();
		NaviMenuView iGO = $( NaviMenuView.class ).first();
		iGO.checkSpdaIGO().click();
		ApplicationView getIssueButton = $( ApplicationView.class ).first();
		Assertions.assertTrue( getIssueButton.issueButton().isDisplayed() );
		ApplicationView issue = $( ApplicationView.class ).first();
		issue.issueButton().click();
		VaadinConfirmDialogView confirmDialog = $( VaadinConfirmDialogView.class ).first();
		confirmDialog.getSaveButton().click();
		NaviMenuView getTransactions = $( NaviMenuView.class ).first();
		getTransactions.transactionsSPDA().click();
		ScenarioView transaction = $( ScenarioView.class ).first();
		transaction.processActivateTransactionButton().click();
		VaadinConfirmDialogView confirmButton = $( VaadinConfirmDialogView.class ).first();
		confirmButton.getSaveButton().click();
		Thread.sleep( 10_000 );
		transaction.processInitialPremiumTransactionButton().click();
		VaadinConfirmDialogView okButton = $( VaadinConfirmDialogView.class ).first();
		okButton.getSaveButton().click();
		ScenarioView getPolicyStatus = $(ScenarioView.class).first();
		Assertions.assertEquals( "Active",getPolicyStatus.policyStatus().getText() );


	}

*/
}
