package com.vaadin.testbenchexample;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.vaadin.testbench.Parameters;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;

import com.vaadin.testbench.screenshot.ImageFileUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WholeLifeIT extends BaseLoginTest {
/*
	@Test
	public void suspense() throws InterruptedException {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys( "05W1001538" );
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "05W1001538" ).click();
		NaviMenuView addSuspense = $( NaviMenuView.class ).first();
		addSuspense.suspense().click();
		ScenarioView addSuspenseButton = $( ScenarioView.class ).first();
		addSuspenseButton.addSuspenceButton().click();
		EntryDialogContent suspenseSource = $( EntryDialogContent.class ).first();
		suspenseSource.suspenseAmount().sendKeys( "100000" );
		Assertions.assertEquals( "100000",suspenseSource.suspenseAmount().getValue() );
		suspenseSource.suspenseSource().selectByText( "Credit Card" );
		Assertions.assertEquals( "Credit Card",suspenseSource.suspenseSource().getSelectedText() );
		suspenseSource.depositAccount().selectByText( "POLICY SUSPENSE" );
		suspenseSource.processButton().click();
		ScenarioView checkSuspence=$(ScenarioView.class).first();
//				Assertions.assertEquals( "$100,000.00",checkSuspence.suspenceBalance().getText() );

		checkSuspence.transferSuspenceButton().click();
		EntryDialogContent transferSuspence = $(EntryDialogContent.class).first();
		transferSuspence.fromAccount().selectByText( "POLICY SUSPENSE" );
		//	EntryDialogContent transferSuspenceTo = $(EntryDialogContent.class).first();
		//	transferSuspence.note().sendKeys( "123" );
		//	transferSuspence.toAccount().focus();
		transferSuspence.toAccount().selectByText( "Family" );
		transferSuspence.searchFamily().sendKeys( "Palmer" );
		transferSuspence.search().doubleClick();
		transferSuspence.family().getCell( "Palmer" ).click();
		transferSuspence.toAccount().selectByText( "Conv Suspense - Disburse" );
		transferSuspence.transferAmount().sendKeys( "100000" );
		Assertions.assertEquals( "100000",transferSuspence.transferAmount().getValue() );
		transferSuspence.transferEffectveDate().setDate( LocalDate.now() );
		transferSuspence.note().sendKeys( "transfer to David Palmer" );
		transferSuspence.okButton().click();
		ScenarioView suspenceAmount=$(ScenarioView.class).first();
//		Assertions.assertEquals( "$0.00",suspenceAmount.suspenceBalance().getText() );


	}
*/
	@Test
	public void addLoan() throws InterruptedException, IOException {
		System.err.println("Starting test: addLoan");
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys( "06W1062839" );
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "06W1062839" ).click();
		NaviMenuView transaction = $( NaviMenuView.class ).first();
		transaction.transactions().click();
		ScenarioView loanTransaction = $(ScenarioView.class).first();
		loanTransaction.addTransactionButton().click();
//		EntryDialogContent selectTransaction = $(EntryDialogContent.class).first();
		TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
		selectTransaction.transactionType().selectByText( "Loan" );
		EntryDialogContent loan = $(EntryDialogContent.class).first();
		loan.loanAmount().sendKeys( Keys.chord( Keys.CONTROL, "a" ), "1000" );
		loan.disbursementMethod().selectByText( "Check Disbursement" );
		Assertions.assertEquals( "1,000.00",loan.loanAmount().getValue() );
		loan.okButton().click();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("error-screenshots/start-of-test.png"));

		ScenarioView processLoanTransaction = $(ScenarioView.class).first();
		processLoanTransaction.processInitialPremiumTransactionButton().click();
		VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
		confirm.getSaveButton().click();
		ScenarioView transactionsPage = $(ScenarioView.class).first();
		waitUntil(driver -> !transactionsPage.progressBar().isDisplayed(), 80);
        transactionsPage.viewLoanTransactionButton().click();
		Thread.sleep( 5_000 );
		System.err.println("Screenshot Directory: " + Parameters.getScreenshotReferenceDirectory());

		try {
			System.err.println("Starting addLoan test...");
			


			File referenceScreenshot = ImageFileUtil.getReferenceScreenshotFile("Screenshot 2024-05-31 165801.png");
			System.err.println("Reference screenshot path: " + referenceScreenshot.getAbsolutePath());
			System.err.println("Reference screenshot exists: " + referenceScreenshot.exists());

			boolean comparisonResult = testBench().compareScreen(referenceScreenshot);
			System.err.println("Screenshot comparison result: " + comparisonResult);

			Assert.assertTrue("Screenshot comparison failed", comparisonResult);
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
			e.printStackTrace(System.err);

			// Create error-screenshots directory if it doesn't exist
			File errorScreenshotDir = new File("error-screenshots");
			if (!errorScreenshotDir.exists()) {
				errorScreenshotDir.mkdirs();
			}

			// Save a failure screenshot with a timestamp
			String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			File actualScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destination = new File("error-screenshots/failure-" + timestamp + "-Screenshot-2024-05-31-165801.png");
			FileUtils.copyFile(actualScreenshot, destination);
			System.err.println("Failure screenshot saved to: " + destination.getAbsolutePath());

			throw e; // Re-throw to fail the test
		}


		TransactionViewPage transactionPage = $(TransactionViewPage.class).first();
		transactionPage.cancel().click();
		NaviMenuView policy = $(NaviMenuView.class).first();
		policy.getPolicy().click();
		ScenarioView policyPage = $(ScenarioView.class).first();
		Assertions.assertEquals( "1,000.00",policyPage.loanBalance().getValue() );
		NaviMenuView transactions = $(NaviMenuView.class).first();
		transactions.transactions().click();
		ScenarioView deleteTransaction = $(ScenarioView.class).first();
		deleteTransaction.reverseLoanTransactionButton().click();
		VaadinConfirmDialogView ok = $(VaadinConfirmDialogView.class).first();
		ok.getSaveButton().click();
		waitUntil(driver -> !deleteTransaction.progressBar().isDisplayed(), 80);
		ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
		deleteLoanTransaction.deleteLoanTransactionButton().click();
		VaadinConfirmDialogView confirmation = $(VaadinConfirmDialogView.class).first();
		confirmation.getSaveButton().click();

	}
	@Test
	public void verifyScreenshotFile() {
		File referenceScreenshot = new File("/var/lib/jenkins/workspace/NTT/reference-screenshots/Screenshot 2024-05-31 165801.png");
		System.err.println("Resolved path: " + referenceScreenshot.getAbsolutePath());
		System.err.println("File exists: " + referenceScreenshot.exists());
		System.err.println("File length: " + referenceScreenshot.length());
		Assert.assertTrue("Reference screenshot file does not exist", referenceScreenshot.exists());
	}
	/*
	@Test
	public void addRider() throws InterruptedException, IOException {
/*
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys("06W1062839" );
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "06W1062839" ).click();
		NaviMenuView transaction = $( NaviMenuView.class ).first();
		transaction.transactionsWL().click();
		ScenarioView loanTransaction = $(ScenarioView.class).first();
		loanTransaction.addTransactionButton().click();
		//		EntryDialogContent selectTransaction = $(EntryDialogContent.class).first();
		TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
		selectTransaction.transactionType().selectByText( "Add Rider" );
		EntryDialogContent addRider = $(EntryDialogContent.class).first();
		addRider.coverageName().selectItemByIndex( 0);
		addRider.faceAmount().sendKeys( Keys.chord( Keys.CONTROL, "a" ), "5000" );
		Assertions.assertEquals("5000",addRider.faceAmount().getValue());
		TransactionPopUpPageView notes = $(TransactionPopUpPageView.class).first();
		notes.note().sendKeys( "123" );
		addRider.okButton().click();
		ScenarioView processTransaction = $(ScenarioView.class).first();
		processTransaction.processInitialPremiumTransactionButton().click();
		VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
		confirm.getSaveButton().click();
		ScenarioView transactionsPage = $(ScenarioView.class).first();
		waitUntil(driver -> !transactionsPage.progressBar().isDisplayed(), 60);

		Assertions.assertEquals( "$156.19",transactionsPage.modalPremium().getText() );

//		ScenarioView transactionsPage = $(ScenarioView.class).first();
		transactionsPage.viewLoanTransactionButton().click();
		Thread.sleep( 5_000 );
		Assert.assertTrue( testBench().compareScreen( ImageFileUtil.getReferenceScreenshotFile(
				"Screenshot 2024-05-31 165802.png" ) ) );
//		Assertions.assertEquals("Actual",processTransaction.transactionStatus().getText());
		TransactionViewPage transactionPage = $(TransactionViewPage.class).first();
		transactionPage.cancel().click();

		ScenarioView deleteTransaction = $(ScenarioView.class).first();
		deleteTransaction.reverseAddRiderTransactionButton().click();
		VaadinConfirmDialogView ok = $(VaadinConfirmDialogView.class).first();
		ok.getSaveButton().click();
		ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
		waitUntil(driver -> !deleteTransaction.progressBar().isDisplayed(), 80);

//		ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
		deleteLoanTransaction.deleteLoanTransactionButton().click();
		VaadinConfirmDialogView confirmation = $(VaadinConfirmDialogView.class).first();
		confirmation.getSaveButton().click();


	}
*/
}
