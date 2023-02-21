package vTigerOrganizationTestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import vTiger.GenericUtlities.BaseClass;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactsPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationPage;

public class CreateContactWithorganizationTest extends BaseClass
{
		
		@Test
		public void createContactWithOrgTest() throws IOException
		{
	        //read the data
			String LASTNAME = eUtil.readDataFromExelSheet("Contacts", 7, 2);
			String ORGNAME = eUtil.readDataFromExelSheet("Contacts", 7, 3)+jUtil.getrandomNumber();
			
			//Step 5: Navigate to Organizations Link
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationLink();
			
			//Step 6: Click on Organizations look up image
			OrganizationPage op = new OrganizationPage(driver);
			op.clickOnCreateOrgLookUpImg();
			
			//Step 7: Create new organization and save
			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createNewOrganization(ORGNAME);
			
			//Step 8: Validate for Organization
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String OrgHeader = oip.getOrganizationHeader();
			if(OrgHeader.contains(ORGNAME))
			{
				System.out.println(OrgHeader+"Org created");
			}
			else
			{
				System.out.println("Org not created");
			}
			
			//Step 9: Navigate to contacts link
			hp.clickOnContactsLink();
		
			//Step 10: Click on create contact look up image
			ContactsPage cp = new ContactsPage(driver);
			cp.clickOnCreateContactLookUpImg();
			
			//Step 11: Create new Contact
			CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
			cncp.createNewContact(driver, LASTNAME, ORGNAME);
		
			//Step 12: Validate
			ContactsInfoPage cip = new ContactsInfoPage(driver);
			String ContactHeader = cip.getContactHeader();
			if(ContactHeader.contains(LASTNAME))
			{
				System.out.println(ContactHeader+"-PASS");
			}
			else
			{
				System.out.println("FAIL");
			}
		}
}
