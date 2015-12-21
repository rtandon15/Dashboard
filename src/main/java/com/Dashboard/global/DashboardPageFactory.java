package com.Dashboard.global;

//import com.BDNS.pages.NPPCoreAccountPage;
//import com.BDNS.pages.NPPCoreCustomRolePage;
//import com.BDNS.pages.BDNSLoginPage;
import com.Dashboard.pages.*;

public class DashboardPageFactory extends Dashboard_URL {

	public GlobalCommonMethods GlobalCommonMethods() {
		return new GlobalCommonMethods();
	}

	public DashboardLoginPage DashboardLoginPage() {
		return new DashboardLoginPage();
	}

	public Dashboard_HyattPage Dashboard_HyattPage() {
		return new Dashboard_HyattPage();
	}
	
	public LaunchpadPage LaunchpadPage() {
		return new LaunchpadPage();
	}
	
	public InsightPage InsightPage() {
		return new InsightPage();
	}
	
	public AdvantagePage AdvantagePage() {
		return new AdvantagePage();
	}
	
	public ConnectPage ConnectPage() {
		return new ConnectPage();
	}
	
	public PreferencesAndOtherTabsPage PreferencesAndOtherTabsPage() {
		return new PreferencesAndOtherTabsPage();
	}

	public DashboardAlertPage DashboardAlertPage() {
		return new DashboardAlertPage();
	}

}