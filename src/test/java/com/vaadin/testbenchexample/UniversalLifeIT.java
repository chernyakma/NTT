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

public class UniversalLifeIT extends BaseLoginTest {

	@Test
	public void addSuspense() throws InterruptedException {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys( "01N1191217" );
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "01N1191217" ).click();
		NaviMenuView addSuspense = $( NaviMenuView.class ).first();
		addSuspense.suspense().click();
		ScenarioView addSuspenseButton = $( ScenarioView.class ).first();
		addSuspenseButton.addSuspenceButton().click();
		EntryDialogContent suspenseSource = $( EntryDialogContent.class ).first();
		suspenseSource.suspenseAmount().sendKeys( "57" );
		Assertions.assertEquals( "57",suspenseSource.suspenseAmount().getValue() );
		suspenseSource.suspenseSource().selectByText( "Credit Card" );
		Assertions.assertEquals( "Credit Card",suspenseSource.suspenseSource().getSelectedText() );
		suspenseSource.depositAccount().selectByText( "POLICY SUSPENSE" );
		suspenseSource.processButton().click();
		NaviMenuView transactions = $(NaviMenuView.class).first();
		transactions.transactionsWL().click();
		ScenarioView deleteTransaction = $(ScenarioView.class).first();
		deleteTransaction.reverseLoanTransactionButton().click();
		Thread.sleep( 5_000 );
		VaadinConfirmDialogView ok = $(VaadinConfirmDialogView.class).first();
		ok.getSaveButton().click();
		waitUntil(driver -> !deleteTransaction.progressBar().isDisplayed(), 80);
		ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
		deleteLoanTransaction.deleteLoanTransactionButton().click();
		VaadinConfirmDialogView confirmation = $(VaadinConfirmDialogView.class).first();
		confirmation.getSaveButton().click();

		//	ScenarioView checkSuspence=$(ScenarioView.class).first();
	//	Assertions.assertEquals( "$57",checkSuspence.suspenceBalance().getText() );
/*
		checkSuspence.transferSuspenceButton().click();
		EntryDialogContent transferSuspence = $(EntryDialogContent.class).first();
		transferSuspence.fromAccount().selectByText( "General" );
	//	EntryDialogContent transferSuspenceTo = $(EntryDialogContent.class).first();
	//	transferSuspence.note().sendKeys( "123" );
		transferSuspence.toAccount().selectByText( "Family" );
		transferSuspence.searchFamily().sendKeys( "Palmer" );
		transferSuspence.search().doubleClick();
		transferSuspence.family().getCell( "Palmer" ).click();
		transferSuspence.toAccount().selectByText( "General Premium" );
		transferSuspence.transferAmount().sendKeys( "100000" );
		Assertions.assertEquals( "100000",transferSuspence.transferAmount().getValue() );
		transferSuspence.transferEffectveDate().setDate( LocalDate.now() );
		transferSuspence.note().sendKeys( "transfer to David Palmer" );
		transferSuspence.okButton().click();
		ScenarioView suspenceAmount=$(ScenarioView.class).first();
	//	Assertions.assertEquals( "$0.00",suspenceAmount.suspenceBalance().getText() );

*/
	}


	@Test
	public void addLoan() throws InterruptedException, IOException {
		VaadinSelectView getSelectButton = $( VaadinSelectView.class ).first();
		getSelectButton.getSelectItem().selectItemByIndex( 4 );
		SearchComponentView getPolicy = $( SearchComponentView.class ).first();
		getPolicy.searchByPolicy().sendKeys( "01N1172279" );
		getPolicy.searchButton().click();
		getPolicy.family().getCell( "01N1172279" ).click();
		NaviMenuView transaction = $( NaviMenuView.class ).first();
		transaction.transactionsWL().click();
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
	/*
		transactionsPage.viewLoanTransactionButton().click();
		Thread.sleep( 5_000 );
		Assert.assertTrue( testBench().compareScreen( ImageFileUtil.getReferenceScreenshotFile(
				"Screenshot 2024-05-31 165800.png" ) ) );
		TransactionViewPage transactionPage = $(TransactionViewPage.class).first();
		transactionPage.cancel().click();
		NaviMenuView policy = $(NaviMenuView.class).first();
		policy.getPolicy().click();
		ScenarioView policyPage = $(ScenarioView.class).first();
		Assertions.assertEquals( "1,000.00",policyPage.loanBalance().getValue() );
	*/
		NaviMenuView transactions = $(NaviMenuView.class).first();
		transactions.transactionsWL().click();
		ScenarioView deleteTransaction = $(ScenarioView.class).first();
		deleteTransaction.reverseLoanTransactionButton().click();
		Thread.sleep( 5_000 );
		VaadinConfirmDialogView ok = $(VaadinConfirmDialogView.class).first();
		ok.getSaveButton().click();
		waitUntil(driver -> !deleteTransaction.progressBar().isDisplayed(), 80);
        ScenarioView deleteLoanTransaction = $(ScenarioView.class).first();
		deleteLoanTransaction.deleteLoanTransactionButton().click();
		VaadinConfirmDialogView confirmation = $(VaadinConfirmDialogView.class).first();
		confirmation.getSaveButton().click();

	}
/*
	@Test
	public void payDirectBill() {
		VaadinSelectView getSelectButton = $(VaadinSelectView.class).first();
		getSelectButton.getSelectItemAccept().selectByText("Search Policy");
		SearchComponentView getPolicy = $(SearchComponentView.class).first();
		getPolicy.searchByPolicy().sendKeys("08D6267774");
		getPolicy.searchButton().click();
		getPolicy.family().getCell("08D6267774").click();
		NaviMenuView transaction = $(NaviMenuView.class).first();
		transaction.policyTransactions().click();
		ScenarioView premiumTransaction = $(ScenarioView.class).first();
		String originalDateText = premiumTransaction.policyPaidToDate().getText();
		initialPaidToDate = LocalDate.parse(originalDateText, formatter);
		premiumTransaction.addTransactionButton().click();
		TransactionPopUpPageView selectTransaction = $(TransactionPopUpPageView.class).first();
		selectTransaction.transactionType().selectByText("Premium");
		EntryDialogContent premium = $(EntryDialogContent.class).first();
		premium.premiumAmount().sendKeys(Keys.chord(Keys.CONTROL, "a"), "39");
		premium.billingMonths().sendKeys(Keys.chord(Keys.CONTROL, "a"), "3");
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

	}


*/
}




