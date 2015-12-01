package com.Dashboard.data;

import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class Dashboard_BaseData {
	public static final Random rand = new Random();
	public static final int randNumb = rand.nextInt();
	public static final String randNumber = Integer.toString(randNumb);

	// INPUTS FOR LOGIN TO DASHBOARD
	public static final String Dashboard_Login_Username_Input = "nba";
	public static final String Dashboard_Login_Password_Input = "spr1nkle!15";
	
	//INPUTS FOR HYATT SCREEN	
	
		
	
	
	
	
	
	
	
	
	
	public static String Npp_AddAccount_Name_Input = "AccName_"
			+ new DateTime(DateTimeZone.UTC).toString().replace(":", ".")
					.replace(".", "-").replace("-", "");
	public static String Npp_AddAccount_NameinFooter_Input = "NameInFooter_"
			+ new DateTime(DateTimeZone.UTC).toString().replace(":", ".")
					.replace(".", "-").replace("-", "");;
	public static String Npp_AddAccount_ContactPerson_Input = "ContactPerson_"
			+ new DateTime(DateTimeZone.UTC).toString().replace(":", ".")
					.replace(".", "-").replace("-", "");
	public static final String Npp_ContactEmail_Input = "NPP-"
			+ randNumber.substring(1, 7) + "@yahoo.com";

	public static final String Npp_ActiveSubAccountContactEmail_Input = "Active_SubAccount_"
			+ randNumber.substring(1, 7) + "@gmail.com";
	public static final String Npp_PendingSubAccountContactEmail_Input = "Pending_SubAccount_"
			+ randNumber.substring(1, 7) + "@gmail.com";
	public static final String Npp_UserEmail_Input = "User-"
			+ randNumber.substring(1, 9) + "@in.com";
	public static final String Npp_SubUserEmail_Input = "Sub-User"
			+ randNumber.substring(1, 9) + "@yahoo.com";

	public static final String Npp_User_FirstName_Input = "NewUser"
			+ randNumber.substring(1, 5);
	public static final String Npp_Account_CustomRole_Input = "New_Role"
			+ randNumber.substring(1, 8);
	public static final String Npp_User_lastName_Input = "Surname"
			+ randNumber.substring(1, 5);
	public static final String Npp_Phone_Input = randNumber.substring(1, 8);
	public static final String Npp_Address1_Input = "Ajanta Enclave"
			+ randNumber.substring(1, 5);
	public static final String Npp_Address2_Input = "Viman Nagar"
			+ randNumber.substring(1, 5);
	public static String Npp_AddAccount_City_Input = "NewCity_"
			+ new DateTime(DateTimeZone.UTC).toString().replace(":", ".")
					.replace(".", "-").replace("-", "");;
	public static String Npp_AddAccount_State_Input = "NewState_"
			+ new DateTime(DateTimeZone.UTC).toString().substring(1, 7)
					.toString().replace(":", ".").replace(".", "-")
					.replace("-", "");
	public static String Npp_AddAccount_PostalCode_Input = randNumber
			.substring(1, 8);
	public static String Npp_AddAccount_Country_Input = "NewCountry_"
			+ new DateTime(DateTimeZone.UTC).toString().replace(":", ".")
					.replace(".", "-").replace("-", "");

	// INPUTS FOR ADD USER
	public static final String Npp_FirstName_Input = "NPPUserFirstName_"
			+ randNumber.substring(1, 5);
	public static final String Npp_User_LastName_Input = "NPPUserLastName"
			+ randNumber.substring(1, 5);
	public static final String Npp_User_EmailId_Input = "NPPUserFirstName.lastName_"
			+ randNumber.substring(1, 8) + "@neustar.biz";
	public static final String NPP_User_Title_Input = "User Creation.";
	public static final String NPP_User_MobileNumber_Input = "562-756-2233";
	public static final String NPP_User_PhoneNumber_Input = "636-48018";
	public static final String NPP_User_FaxNumber_Input = "+1-212-9876543";
	public static String NPP_User_ExistingUserEmailId_Input = "shama.ugale@neustar.biz";

	// INPUT FOR TOAST MESSAGES
	// public static final String
	// Npp_Account_SubAccountDisableToastMessage_Input =
	// "Cannot create account, Sub-Accounts is disabled.";
	public static final String Npp_Account_New_SubAccountDisableToastMessage_Input = "Adding new sub-accounts to this account is not currently permitted.";
	public static final String Npp_Account_AccountDeleteToastMessage_Input = "Account deleted successfully.";
	public static final String Npp_User_UserStatusInvalid_ToastMessage_Input = "The user status(Suspended) is invalid for this operation.";

	public static final String Npp_User_MasqueradeMode_ToastMessage_Input = "MASQUERADE MODE: You are currently Masquerading as UserName for the account Acc12. When you complete your Masquerade session, please logout";

	public static final String Npp_Account_AccountCreatedToastMessage_Input = "Account created successfully.";
	public static final String NPP_User_UserCreatedToastMessage_Input = "User created successfully.";
	public static final String NPP_Services_SubAccountProductAssignedToastMessage_Input = "Subaccounts Product assigned successfully.";
	public static final String Npp_Account_AccountSuspendedToastMessage_Input = "Account suspended successfully.";
	public static final String NPP_Services_ProductCannotBeAssignedToastMessage_Input = "Product cannot be assigned to suspended account.";
	public static final String NPP_Account_AccountActivatedToastMessage_Input = "Account activated successfully.";
	public static final String NPP_Account_AccountDeletedToastMessage_Input = "Account deleted successfully.";
	public static final String NPP_User_UserAddedToastMessage_Input = "User added successfully.";
	public static final String NPP_User_DefaultAppSetToastMessage_Input = "Default Application set successfully.";
	public static final String NPP_Account_ParentAccountNotActiveToastMessage_Input = "The parent account is not active.";
	public static final String NPP_Account_AccountUpdatedToastMessage_Input = "Account updated successfully.";
	public static final String NPP_Services_ProductCannotBeAssignedToSuspendedAccountToastMessage_Input = "Product cannot be assigned to suspended account.";
	public static final String NPP_Services_CustomRolesProductAssignedToastMessage_Input = "Custom Roles Product assigned successfully.";
	public static final String NPP_Services_CustomRolesProductRemovedToastMessage_Input = "Custom Roles Product removed successfully.";
	public static final String Npp_Account_UltraDNSCredentialsCreatedToastMessage_Input = "Ultra Credentials saved successfully.";
	public static final String Npp_Account_ZoneCreatedToastMessage_Input = "Zone created successfully.";
	public static final String Npp_Account_CustomThemmeCreatedToastMessage_Input = "Custom Theme Management Product assigned successfully.";
	
	// INPUTS FOR LOGOUT
	public static final String Npp_Logout_LoggedOut_SuccessMessage = "You have logged out successfully.";

	// INPUTS FOR FILTERS
	public static String[] filterByName = { "All", "Active", "Suspended",
			"Pending" };

	public static String roleName = "RoleName_"
			+ new DateTime(DateTimeZone.UTC).toString().replace(":", ".")
					.replace(".", "-").replace("-", "").substring(1, 7);

	// INPUTS FOR ULTRA CREDENTIALS
	public static final String Bdns_UltraAccountId_Input = "01013B204882BDE3";
	public static final String Bdns_UltraUserName_Input = "pmpdemo1";
	public static final String Bdns_UltraPassword_Input = "Boone8300!!";

	// INPUTS FOR ZONE NAME
	public static final String Bdns_ZoneName_Input = "Zone-"
			+ randNumber.substring(1, 8) + ".co.in";
	public static final String Bdns_SecondZoneName_Input = "SecondZone-"
			+ randNumber.substring(1, 8) + ".co.in";
	public static final String Bdns_NameServer_Input = "";
	public static final String Bdns_TSIGName_Input = "Sample"
			+ randNumber.substring(1, 8) + ".co.in";
	public static final String Bdns_TSIGsecret_Input = "";

	// INPUTS FOR WEB FORWARDING

	public static final String Bdns_WebForwarding_HostName_Input = "Beta-"
			+ randNumber.substring(1, 8);

	public static final String Bdns_WebForwarding_Requestpage_Input = "/Index"
			+ randNumber.substring(1, 8) + ".html";

	public static final String Bdns_WebForwarding_RedirectsTo_Input = "http://www.to.test"
			+ randNumber.substring(1, 8) + ".com/beta" + ".html";

	// INPUTS FOR ADDING 'A' RECORD

	public static final String Bdns_Zone_A_Record_HostName_Input = "www."
			+ ".nte.co.in. ";
	

	// INPUTS FOR TOAST MESSAGES FOR BDNS

	public static final String Bdns_WebForwardingCreated_ToastMessage_Input = "Web Forward created successfully.";
	public static final String Bdns_ZoneCopied_ToastMessage_Input = "Zone copied successfully.";
	public static final String Bdns_ZoneCreated_ToastMessage_Input = "Zone created successfully.";
	public static final String Bdns_ZoneUploaded_ToastMessage_Input = "Zone uploaded successfully.";
	public static final String Bdns_SiteFailOverCreated_ToastMessage_Input = "Site Failover created successfully.";
	public static final String Bdns_SiteMonitorCreated_ToastMessage_Input = "Site Monitor created successfully.";

	

}
