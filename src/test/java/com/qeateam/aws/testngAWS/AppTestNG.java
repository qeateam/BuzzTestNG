package com.qeateam.aws.testngAWS;

import org.testng.annotations.Test;
import com.qeateam.aws.testng.utils.GlobalObjects;

public class AppTestNG implements GlobalObjects {

	// #########################START: This section contains tests for Home page
	// validations#######################

	// Test Description - This validates existence and text for Home Navigation
	// Link and screen
	// Date - 29 Jun 17
	// Created By - Sumanta Roy
	@Test
	public void validateHomeNavigationLink() {
		try {
			// Launch App
			objGlobal.launchApp();
			// Verify Home Link text
			objGlobal.genericVerifyCopyText("text1", "petclinicHome", "homeLinkTextObj");
			// Click on Home to check navigation
			objGlobal.genericClick("homeLink", "petclinicHome");
			// Verify Home Welcome short and long message displayed on screen
			objGlobal.genericVerifyCopyText("text1", "petclinicHome", "welcomeMsgObj");
			objGlobal.genericVerifyCopyText("text1", "petclinicHome", "welcomeShortMsgObj");
			// TBC - Verify image

		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		} finally {
			// Tear Down method to close all the browser instances
			objGlobal.endTest();
		}
	}

	// #########################END: This section contains tests for Home page
	// validations#######################

	// #########################START: This section contains tests for Owners
	// page validations#######################

	// Test Description - This test validates existence and text for Owners
	// Link, All and Add New Links
	// Date - 29 Jun 17
	// Created By - Sumanta Roy
	@Test
	public void validateTextOwnersNavigationLinkAndSubLinks() {
		try {
			// Launch App
			objGlobal.launchApp();
			// Verify Owners Main Link text
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "ownerLinkObj");
			// Click on Owners main to check sub menus
			objGlobal.genericClick("ownerLinkObj", "petclinicOwner");
			// Verify if submenu ALL is available
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "allLinkObj");
			// Verify if submenu ADD NEW is available
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "addNewLinkObj");

		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		} finally {
			// Tear Down method to close all the browser instances
			objGlobal.endTest();
		}
	}

	// Test Description - This test validates Owners Link sub menu-
	// All
	// Date - 29 Jun 17
	// Created By - Sumanta Roy
	@Test
	public void validateOwnersALLSubmenuNavigationLinks() {
		try {
			// Launch App
			objGlobal.launchApp();
			// Click on Owners main to check sub menus
			objGlobal.genericClick("ownerLinkObj", "petclinicOwner");
			// Click on submenu ALL
			objGlobal.genericClick("ownerAllLinkObj", "petclinicOwner");
			// Verify if submenu ALL navigates to Owners page
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "ownerHeaderObj");
			// Verify Table header - Name
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "ownerTableHeaderNameObj");
			// Verify Table header - Address
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "ownerTableHeaderAddressObj");
			// Verify Table header - City
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "ownerTableHeaderCityObj");
			// Verify Table header - Telephone
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "ownerTableHeaderTelephoneObj");
			// Verify Table header - Telephone
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "ownerTableHeaderPetsObj");
			// Check Add Owner Button availability
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "addOwnerBtnObj");
			// Click on Add Owner Button
			objGlobal.genericClick("addOwnerBtnObj", "petclinicOwner");
			// Verify navigation to New Owner page
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "newOwnerHeaderObj");

		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		} finally {
			// Tear Down method to close all the browser instances
			objGlobal.endTest();
		}
	}

	// Test Description - This test validates Owners Link sub menu-
	// Add New
	// Date - 29 Jun 17
	// Created By - Sumanta Roy
	public void validateOwnersAddNewSubmenuTextLinks() {
		try {
			// Launch App
			objGlobal.launchApp();
			// Click on Owners main to check sub menus
			objGlobal.genericClick("ownerLinkObj", "petclinicOwner");
			// Click on Sub menu Add new
			objGlobal.genericClick("ownerAddNewLinkObj", "petclinicOwner");
			// Verify page header
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "newOwnerHeaderObj");
			// Verify Field & Button labels
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "newOwnerFldFNameObj");
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "newOwnerFldLNameObj");
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "newOwnerFldAddrObj");
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "newOwnerFldCityObj");
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "newOwnerFldTelephoneObj");
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "newOwnerBackBtnObj");
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "newOwnerAddOwnerBtnObj");
			// Check Back button navigation
			objGlobal.genericClick("ownerBackBtnObj", "petclinicOwner");
			// Verify navigation for back to Owners
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "ownerHeaderObj");
		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		} finally {
			// Tear Down method to close all the browser instances
			objGlobal.endTest();
		}
	}

	// TBC------------------Test Description - This test validates Owners Link
	// sub menu-
	// Add New for field validations
	// Date - 29 Jun 17
	// Created By - Sumanta Roy
	public void validateOwnersAddNewSubmenuField() {
		try {
			// Launch App
			objGlobal.launchApp();
			// Click on Owners main to check sub menus
			objGlobal.genericClick("ownerLinkObj", "petclinicOwner");
			// Click on Sub menu Add new
			objGlobal.genericClick("ownerAddNewLinkObj", "petclinicOwner");
			// Verify page header
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "newOwnerHeaderObj");
			// Field Validations for
		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		} finally {
			// Tear Down method to close all the browser instances
			objGlobal.endTest();
		}
	}

	// TBC------------------Test Description - This test validates Add new Owner
	// successfully
	// Date - 29 Jun 17
	// Created By - Sumanta Roy
	public void validateAddNewOwnerSuccessfuly() {
		try {
			// Launch App
			objGlobal.launchApp();
			// Click on Owners main to check sub menus
			objGlobal.genericClick("ownerLinkObj", "petclinicOwner");
			// Click on Sub menu Add new
			objGlobal.genericClick("ownerAddNewLinkObj", "petclinicOwner");
			// Verify page header
			objGlobal.genericVerifyCopyText("text1", "petclinicOwner", "newOwnerHeaderObj");
			// Enter First name
			objGlobal.genericEnterText("validateAddNewOwnerSuccessfuly", "FirstName", "firstNameTextObj",
					"petclinicOwner");
			// Enter Last name
			objGlobal.genericEnterText("validateAddNewOwnerSuccessfuly", "LastName", "lastNameTextObj",
					"petclinicOwner");
			// Enter Address
			objGlobal.genericEnterText("validateAddNewOwnerSuccessfuly", "Address", "addressTextObj", "petclinicOwner");
			// Enter City
			objGlobal.genericEnterText("validateAddNewOwnerSuccessfuly", "City", "cityTextObj", "petclinicOwner");
			// Enter Telephone
			objGlobal.genericEnterText("validateAddNewOwnerSuccessfuly", "Telephone", "telephoneTextObj",
					"petclinicOwner");
			// Click Add Owner
			objGlobal.genericClick("ownerAddNewLinkObj", "petclinicOwner");
			// Validate Success message
			// TBC
		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		} finally {
			// Tear Down method to close all the browser instances
			objGlobal.endTest();
		}
	}

	// #########################END: This section contains tests for Owners page
	// validations#######################

	// #########################START: This section contains tests for
	// Veterinarians page validations#######################

	// Test Description - This method validates existance and text for
	// Veterinarians Navigation Link
	// Date - 29 Jun 17
	// Created By - Shalini Singh Raghuwanshi
	@Test
	public void validateVeterinariansNavigationLink() {
		try {
			// Launch App
			objGlobal.launchApp();
			// Click on Veterinarians link
			objGlobal.genericClick("veterinariansLink", "petClinicVeterinariansPage");
			// Verify Veterinarians page elements
			objGlobal.genericVerifyCopyText("text1", "petClinicVeterinariansPage", "searchAllObj");
			objGlobal.genericVerifyCopyText("text1", "petClinicVeterinariansPage", "addNewObj");

		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		} finally {
			// Tear Down method to close all the browser instances
			objGlobal.endTest();
		}
	}

	// Test Description - This validates all the elements displayed after
	// clicking All option on Veterinarians link
	// Date - 29 Jun 17
	// Created By - Shalini Singh
	@Test
	public void clickVeterinariansAllLink() {
		try {
			objGlobal.launchApp();
			// Click on Veterinarians link
			objGlobal.genericClick("veterinariansLink", "petClinicVeterinariansPage");
			// Click on All link
			objGlobal.genericClick("veterinariansAllLink", "petClinicVeterinariansPage");
			// Verify elements on Veterinarians page when All option is clicked
			objGlobal.genericVerifyCopyText("text1", "petClinicVeterinariansPage", "veterinariansHeading");
			objGlobal.genericVerifyCopyText("text1", "petClinicVeterinariansPage", "veterinariansTableContentsName");
			objGlobal.genericVerifyCopyText("text1", "petClinicVeterinariansPage",
					"veterinariansTableContentsSpecialties");
			objGlobal.genericVerifyCopyText("text1", "petClinicVeterinariansPage", "veterinariansHomeButton");

		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		} finally {
			// Tear Down method to close all the browser instances
			objGlobal.endTest();
		}
	}

	// Test Description - This method validates whether user is redirected to
	// Home page or not after clicking Home button on clicking All option on
	// Veterinarians link
	// Date - 29 Jun 17
	// Created By - Shalini Singh
	@Test
	public void clickHomeButtonAfterAllOption() {
		try {
			objGlobal.launchApp();
			// Click on Veterinarians link
			objGlobal.genericClick("veterinariansLink", "petClinicVeterinariansPage");
			// Click on All link
			objGlobal.genericClick("veterinariansAllLink", "petClinicVeterinariansPage");
			// Click Home Button
			objGlobal.genericClick("veterinariansHomeButton", "petClinicVeterinariansPage");
			// Verify user is directed to Home page after clicking Home button
			objGlobal.genericVerifyCopyText("text1", "petClinicVeterinariansPage",
					"verifyHomeScreenOnClickingHomeButton");

		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		} finally {
			// Tear Down method to close all the browser instances
			objGlobal.endTest();
		}
	}

	// Test Description - This method validates whether user is redirected to
	// Add Vet page or not after clicking Add Vet button on clicking All option
	// on Veterinarians link
	// Date - 29 Jun 17
	// Created By - Shalini Singh
	@Test
	public void clickAddVetButtonAfterAllOption() {
		try {
			objGlobal.launchApp();
			// Click on Veterinarians link
			objGlobal.genericClick("veterinariansLink", "petClinicVeterinariansPage");
			// Click on All link
			objGlobal.genericClick("veterinariansAllLink", "petClinicVeterinariansPage");
			// Click Home Button
			objGlobal.genericClick("veterinariansaAddVetButton", "petClinicVeterinariansPage");
			// Verify user is directed to Add Vet page after clicking Add Vet
			// button
			objGlobal.genericVerifyCopyText("text1", "petClinicVeterinariansPage", "verifyAddVetScreen");

		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		} finally {
			// Tear Down method to close all the browser instances
			objGlobal.endTest();
		}
	}

	// Test Description - This method validates whether user is able to add new
	// Veterinarians details on clicking Add New option on Veterinarians link
	// Date - 29 Jun 17
	// Created By - Shalini Singh
	@Test
	public void clickVeterinariansAddNewLink() {
		try {
			objGlobal.launchApp();
			// Click on Veterinarians link
			objGlobal.genericClick("veterinariansLink", "petClinicVeterinariansPage");
			// Click on All link
			objGlobal.genericClick("veterinariansAddNewLink", "petClinicVeterinariansPage");
			// Verify user is directed to Add Vet page after clicking Add Vet
			// button
			objGlobal.genericVerifyCopyText("text1", "petClinicVeterinariansPage", "verifyAddVetScreen");
			// Tear Down method to close all the browser instances
			objGlobal.endTest();
		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		} finally {
			// Tear Down method to close all the browser instances
			objGlobal.endTest();
		}
	}

	// #########################END: This section contains tests for
	// Veterinarians page validations#######################

	// #########################START: This section contains tests for Pet Types
	// page validations#######################
	// Test Description - This method validates existance and text for
	// Veterinarians Navigation Link
	// Date - 29 Jun 17
	// Created By - Shalini Singh
	@Test
	public void validatePetTypesNavigationLink() {
		try {
			// Launch App
			objGlobal.launchApp();
			// Click on Pet Types link
			objGlobal.genericClick("petTypesLink", "petClinicPetTypesPage");
			// Verify Pet Types page elements
			objGlobal.genericVerifyCopyText("text1", "petClinicPetTypesPage", "verifyPetTypesScreen");
			objGlobal.genericVerifyCopyText("text1", "petClinicPetTypesPage", "verifyNotFoundErrorOnPetTypesScreen");

		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		} finally {
			// Tear Down method to close all the browser instances
			objGlobal.endTest();
		}
	}

	// #########################END: This section contains tests for
	// Veterinarians page validations#######################

	// #########################START: This section contains tests for Pet Types
	// page validations#######################

	// Test Description - This method validates existance and text for
	// Specialties Navigation Link
	// Date - 29 Jun 17
	// Created By - Shalini Singh
	@Test
	public void validatespecialtiesNavigationLink() {
		try {
			// Launch App
			objGlobal.launchApp();
			// Click on speciality link
			objGlobal.genericClick("clickSpecialityLink", "specialityPage");
			// Verify speciality page elements
			objGlobal.genericVerifyCopyText("text1", "specialityPage", "verifyHomeButton");
			objGlobal.genericVerifyCopyText("text1", "specialityPage", "verifyAddButton");
			objGlobal.genericVerifyCopyText("text1", "specialityPage", "verifyId");
			objGlobal.genericVerifyCopyText("text1", "specialityPage", "verifyName");
		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		}
	}

	// Test Description - This method validates nvigation to Home button from
	// Specialties Navigation Link
	// Date - 29 Jun 17
	// Created By - Shalini Singh
	@Test
	public void validateHomeScreenNavigation() {
		try {
			// Launch App
			objGlobal.launchApp();
			// Click on speciality link
			objGlobal.genericClick("clickSpecialityLink", "specialityPage");
			// Click Home Button
			objGlobal.genericClick("veterinariansHomeButton", "petClinicVeterinariansPage");
			// Verify user is directed to Home page after clicking Home button
			objGlobal.genericVerifyCopyText("text1", "petClinicVeterinariansPage",
					"verifyHomeScreenOnClickingHomeButton");

		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		}
	}

	// Test Description - This method validates nvigation to Home button from
	// Specialties Navigation Link
	// Date - 29 Jun 17
	// Created By - Shalini Singh
	@Test
	public void validateAddButtonNavigation() {
		try {
			// Launch App
			objGlobal.launchApp();
			// Click on speciality link
			objGlobal.genericClick("clickSpecialityLink", "specialityPage");
			// Click Home Button
			objGlobal.genericClick("specialityAddButton", "specialityPage");
			// Verify user is directed to Add New speciality page after clicking
			// Add button
			objGlobal.genericVerifyCopyText("text1", "specialityPage", "verifyNewAddedSpeciality");
			objGlobal.genericVerifyCopyText("text1", "specialityPage", "verifyId");
			objGlobal.genericVerifyCopyText("text1", "specialityPage", "verifyName");

		} catch (Exception e) {
			objGlobal.mainLogger.error(e);
		}
	}

	// #########################END: This section contains tests for speciality
	// page validations#######################

}