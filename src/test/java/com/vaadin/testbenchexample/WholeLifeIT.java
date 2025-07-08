package com.vaadin.testbenchexample;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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



		protected LocalDate initialPaidToDate;
		protected final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);


	@Test
	public void transferSuspense() throws InterruptedException {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
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
		Thread.sleep(3_000);
		ScenarioView checkSuspence=$(ScenarioView.class).first();
				Assertions.assertEquals( "$100,000.00",checkSuspence.suspenceBalance().getText() );

		checkSuspence.transferSuspenceButton().click();
		EntryDialogContent transferSuspence = $(EntryDialogContent.class).first();
		transferSuspence.fromAccount().selectByText( "POLICY SUSPENSE" );
		transferSuspence.toAccount().selectByText( "Policy" );
		transferSuspence.searchFamily().sendKeys( "05W1E00518" );
		transferSuspence.search().doubleClick();
		transferSuspence.family().getCell( "05W1E00518" ).click();
		transferSuspence.toAccount().selectByText( "POLICY SUSPENSE" );
		transferSuspence.transferAmount().sendKeys( "100000" );
		Assertions.assertEquals( "100000",transferSuspence.transferAmount().getValue() );
		transferSuspence.transferEffectveDate().setDate( LocalDate.now() );
		transferSuspence.note().sendKeys( "transfer" );
		transferSuspence.okButton().click();
		ScenarioView suspenceAmount=$(ScenarioView.class).first();
		Assertions.assertEquals( "$0.00",suspenceAmount.suspenceBalance().getText() );
		NaviMenuView transactions = $(NaviMenuView.class).first();
		transactions.transactions().click();
		ScenarioView deleteTransaction = $(ScenarioView.class).first();
		deleteTransaction.reverseSecondTransactionButton().click();
		VaadinConfirmDialogView ok = $(VaadinConfirmDialogView.class).first();
		ok.getSaveButton().click();
		waitUntil(driver -> !deleteTransaction.progressBar().isDisplayed(), 80);
		ScenarioView removeTransaction = $(ScenarioView.class).first();
		removeTransaction.deleteFirstTransactionButton().click();
		VaadinConfirmDialogView confirmation = $(VaadinConfirmDialogView.class).first();
		confirmation.getSaveButton().click();
		ScenarioView removeSecondTransaction = $(ScenarioView.class).first();
		removeSecondTransaction.deleteFirstTransactionButton().click();
		VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
		confirm.getSaveButton().click();

	}

	@Test
	public void addLoan() throws InterruptedException, IOException {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys( "05W1E00518" );
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "05W1E00518" ).click();
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
		ScenarioView processLoanTransaction = $(ScenarioView.class).first();
		processLoanTransaction.processInitialPremiumTransactionButton().click();
		VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
		confirm.getSaveButton().click();
		ScenarioView transactionsPage = $(ScenarioView.class).first();
		waitUntil(driver -> !transactionsPage.progressBar().isDisplayed(), 80);
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
	public void addRider() throws InterruptedException, IOException {

		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys("05W1E00518" );
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "05W1E00518" ).click();
		NaviMenuView transaction = $( NaviMenuView.class ).first();
		transaction.transactions().click();
		ScenarioView loanTransaction = $(ScenarioView.class).first();
		loanTransaction.addTransactionButton().click();
		//		EntryDialogContent selectTransaction = $(EntryDialogContent.class).first();
		TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
		selectTransaction.transactionType().selectByText( "Add Rider" );
		EntryDialogContent addRider = $(EntryDialogContent.class).first();
		addRider.coverageName().selectItemByIndex( 0);
		addRider.faceAmount().sendKeys( Keys.chord( Keys.CONTROL, "a" ), "5000" );
		Assertions.assertEquals("5000",addRider.faceAmount().getValue());
	/*
		addRider.selectAll().click();
		addRider.editComProfilies1().click();
		EntryDialogContent editProfile= $(EntryDialogContent.class).last();
		editProfile.agentLevel().selectByText("Level 1");
		editProfile.okButton().click();
		EntryDialogContent profile= $(EntryDialogContent.class).first();
		profile.editComProfilies2().click();
		EntryDialogContent editProfile2= $(EntryDialogContent.class).last();
		editProfile2.agentLevel().selectByText("Servicing Agent");
		editProfile2.okButton().click();
		EntryDialogContent profile2= $(EntryDialogContent.class).first();
		profile2.editComProfilies3().click();
		EntryDialogContent editProfile3= $(EntryDialogContent.class).last();
		editProfile3.agentLevel().selectByText("Level 2");
		editProfile3.okButton().click();
*/

		TransactionPopUpPageView notes = $(TransactionPopUpPageView.class).first();
		notes.note().sendKeys( "123" );
		addRider.okButton().click();
		ScenarioView processTransaction = $(ScenarioView.class).first();
		processTransaction.processInitialPremiumTransactionButton().click();
		VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
		confirm.getSaveButton().click();
		ScenarioView transactionsPage = $(ScenarioView.class).first();
		waitUntil(driver -> !transactionsPage.progressBar().isDisplayed(), 60);

		Assertions.assertEquals( "$1,757.00",transactionsPage.modalPremium().getText() );

/*		ScenarioView transactionsPage = $(ScenarioView.class).first();
		transactionsPage.viewLoanTransactionButton().click();
		Thread.sleep( 5_000 );
		Assert.assertTrue( testBench().compareScreen( ImageFileUtil.getReferenceScreenshotFile(
				"Screenshot 2024-05-31 165802.png" ) ) );
//		Assertions.assertEquals("Actual",processTransaction.transactionStatus().getText());
		TransactionViewPage transactionPage = $(TransactionViewPage.class).first();
		transactionPage.cancel().click();
*/
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
	@Test
	public void payDirectBill() {
		VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
		getSelectButton.getSelectItem().selectByText("Search Policy");
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
		SearchComponentView getPolicy = $(SearchComponentView.class).first();
		getPolicy.searchByPolicy().sendKeys("05W1055443");
		getPolicy.searchButton().click();
		getPolicy.family().getCell("05W1055443").click();
		NaviMenuView transaction = $(NaviMenuView.class).first();
		transaction.policyTransactions().click();
		ScenarioView premiumTransaction = $(ScenarioView.class).first();
		String originalDateText = premiumTransaction.policyPaidToDate().getText();
		initialPaidToDate = LocalDate.parse(originalDateText, formatter);
		premiumTransaction.addTransactionButton().click();
		TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
		selectTransaction.transactionType().selectByText("Premium");
		EntryDialogContent premium = $(EntryDialogContent.class).first();
//		premium.premiumAmount().sendKeys(Keys.chord(Keys.CONTROL, "a"), "39");
//		premium.billingMonths().sendKeys(Keys.chord(Keys.CONTROL, "a"), "3");
		premium.okButton().click();
		ScenarioView processPremiumTransaction = $(ScenarioView.class).first();
		processPremiumTransaction.processInitialPremiumTransactionButton().click();
		VaadinConfirmDialogView confirm = $(VaadinConfirmDialogView.class).first();
		confirm.getSaveButton().click();
		ScenarioView transactionsPage = $(ScenarioView.class).first();

		waitUntil(driver -> !transactionsPage.progressBar().isDisplayed(), 80);
		//       ScenarioView paidToDate = $(ScenarioView.class).first();
		String updatedText = transactionsPage.policyPaidToDate().getText();
		LocalDate updatedDate = LocalDate.parse(updatedText, formatter);

		Assertions.assertEquals(initialPaidToDate.plusMonths(3), updatedDate);
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
	@Test
	public void payEFT() {

		VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
		getSelectButton.getSelectItem().selectByText("Search Policy");
		waitUntil(driver -> $(SearchComponentView.class).exists(), 80);
		SearchComponentView getPolicy = $(SearchComponentView.class).first();
		getPolicy.searchByPolicy().sendKeys("06W1082879");
		getPolicy.searchButton().click();
		getPolicy.family().getCell("06W1082879").click();

		NaviMenuView transaction = $(NaviMenuView.class).first();
		transaction.policyTransactions().click();

		ScenarioView payPremium = $(ScenarioView.class).first();

		//flexible parser
		String originalDateText = payPremium.policyPaidToDate().getText();
		initialPaidToDate = parseFlexibleDate(originalDateText);

		LocalDate originalDate = parseFlexibleDate(originalDateText);
		LocalDate newDate = originalDate.plusDays(1);
		if (newDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
			newDate = newDate.plusDays(2);
		} else if (newDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
			newDate = newDate.plusDays(1);
		}
		payPremium.date().setDate(newDate);

		payPremium.cycle().click();
		VaadinConfirmDialogView cycleUp = $(VaadinConfirmDialogView.class).first();
		cycleUp.getSaveButton().click();
		waitUntil(driver -> !payPremium.progressBar().isDisplayed(), 80);
		String updatedText = payPremium.policyPaidToDate().getText();
		LocalDate updatedDate = LocalDate.parse(updatedText, formatter);

		Assertions.assertEquals(initialPaidToDate.plusMonths(1), updatedDate);

	}

	protected LocalDate parseFlexibleDate(String dateString) {
		dateString = dateString.trim(); // 🔑 trims extra spaces

		List<DateTimeFormatter> formatters = List.of(
				DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH),   // "Sep 1, 2025"
				DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH),  // "September 1, 2025"
				DateTimeFormatter.ofPattern("M/d/yyyy")                       // "4/1/2025"
		);

		for (DateTimeFormatter f : formatters) {
			try {
				return LocalDate.parse(dateString, f);
			} catch (Exception ignored) {}
		}

		throw new IllegalArgumentException("Could not parse date: " + dateString);
	}


}
