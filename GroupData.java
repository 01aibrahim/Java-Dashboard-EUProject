package dashboardcw;

/**
 *
 * @author Abdulrahman Ibrahim
 */

// This Class is the getters, which will get the data that are stored in the Database.  We have 17 different types of data. 
public class GroupData {

    private int projectRcn;
    private int projectID;
    private String projectAcronym;
    private String role;
    private int CompanyID;
    private String ComapnyName;
    private String CompanyShortName;
    private String ActivityType;
    private String endOfParticipation;
    private int ecContribution;
    private String Country;
    private String Street;
    private String City;
    private String PostCode;
    private String OrganisationURL;
    private String VatNumber;
    private String ProjectLink;

    // Constructor- Which Initilises the objects.
    public GroupData(int projectRcn, int projectID, String projectAcronym, String role, int CompanyID, String ComapnyName, String CompanyShortName, String ActivityType, String endOfParticipation,
            int ecContribution, String Country, String Street, String City, String PostCode, String OrganisationURL, String VatNumber, String ProjectLink) {
 
        this.projectRcn = projectRcn;
        this.projectID = projectID;
        this.projectAcronym = projectAcronym;
        this.role = role;
        this.CompanyID = CompanyID;
        this.ComapnyName = ComapnyName;
        this.CompanyShortName = CompanyShortName;
        this.ActivityType = ActivityType;
        this.endOfParticipation = endOfParticipation;
        this.ecContribution = ecContribution;
        this.Country = Country;
        this.Street = Street;
        this.City = City;
        this.PostCode = PostCode;
        this.OrganisationURL = OrganisationURL;
        this.VatNumber = VatNumber;
        this.ProjectLink = ProjectLink;

    }

    // Getters 
    public int getProjectRcn() {
        return projectRcn;
    }

    public int getProjectID() {
        return projectID;
    }

    public String getProjectAcronym() {
        return projectAcronym;
    }

    public String getRole() {
        return role;
    }

    public int getCompanyID() {
        return CompanyID;
    }

    public String getCompanyName() {
        return ComapnyName;
    }

    public String getCompanyShortName() {
        return CompanyShortName;
    }

    public String getActivityType() {
        return ActivityType;
    }

    public String getEndOfParticipation() {
        return endOfParticipation;
    }

    public int getecContribution() {
        return ecContribution;
    }

    public String getCountry() {
        return Country;
    }

    public String getStreet() {
        return Street;
    }

    public String getCity() {
        return City;
    }

    public String getPostcode() {
        return PostCode;
    }

    public String getOrganisationURL() {
        return OrganisationURL;
    }

    public String getVatNumber() {
        return VatNumber;
    }

    public String getProjectLink() {
        return ProjectLink;
    }
}
